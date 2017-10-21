package dwarves.vs.zombies;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import dwarves.vs.zombies.Core.GameState;
import dwarves.vs.zombies.util.PlayerSkinEditor;

@SuppressWarnings("deprecation")
public class PlayerListeners implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent event)
	{
		Core.getInstance().bb.addPlayer(event.getPlayer());
		switch (Core.getInstance().gs)
		{
		case Lobby:
			event.getPlayer().setCustomName(event.getPlayer().getDisplayName());
			event.getPlayer().setPlayerListName(event.getPlayer().getDisplayName());
			event.getPlayer().teleport(Core.getInstance().mm.getLobby());
			break;
		case Build_Phase:
			if (Core.getInstance().getDwarf(event.getPlayer()) != null)
			{
				if (Core.getInstance().oldMan != null)
					if (event.getPlayer().getUniqueId().equals(Core.getInstance().oldMan.getUniqueId()))
						PlayerSkinEditor.applyOldMan(event.getPlayer().getUniqueId());
			} else if (Core.getInstance().getMonster(event.getPlayer()) == null)
			{
				Core.getInstance().spawnDwarf(event.getPlayer());
			}
			break;
		case Game:
			if (Core.getInstance().getDwarf(event.getPlayer()) != null)
			{
				if (Core.getInstance().oldMan != null)
					if (event.getPlayer().getUniqueId().equals(Core.getInstance().oldMan.getUniqueId()))
						PlayerSkinEditor.applyOldMan(event.getPlayer().getUniqueId());

			} else if (Core.getInstance().getMonster(event.getPlayer()) == null)
			{
				Core.getInstance().spawnMonster(event.getPlayer());
			}
			break;
		default:
			break;

		}
	}

	@EventHandler
	public void onTalk(PlayerChatEvent event)
	{
		if (event.getMessage().startsWith("!"))
		{
			event.setFormat(ChatColor.WHITE + "[!]<" + event.getPlayer().getCustomName() + ChatColor.WHITE + "> "
					+ event.getMessage().substring(1, event.getMessage().length()));
			return;
		}

		event.getRecipients().clear();
		event.setFormat(ChatColor.WHITE + "<" + event.getPlayer().getCustomName() + ChatColor.WHITE + "> "
				+ event.getMessage());
		if (Core.getInstance().getDwarf(event.getPlayer()) != null)
		{
			for (Player p : Bukkit.getOnlinePlayers())
			{
				if (Core.getInstance().getDwarf(p) != null)
					event.getRecipients().add(p);
			}
		} else if (Core.getInstance().getMonster(event.getPlayer()) != null)
		{
			for (Player p : Bukkit.getOnlinePlayers())
			{
				if (Core.getInstance().getMonster(p) != null)
					event.getRecipients().add(p);
			}
		} else
		{
			for (Player p : Bukkit.getOnlinePlayers())
			{
				event.getRecipients().add(p);
			}
		}
	}

	@EventHandler
	public void onRespawn(PlayerRespawnEvent event)
	{
		switch (Core.getInstance().gs)
		{
		case Lobby:
			event.setRespawnLocation(Core.getInstance().mm.getLobby());
			break;
		case Startup:
			event.setRespawnLocation(Core.getInstance().mm.getLobby());
			break;
		case Build_Phase:
			event.setRespawnLocation(Core.getInstance().mm.getMap().getSpawn());
		case Game:
			event.setRespawnLocation(Core.getInstance().mm.getCurrentShrine().getMonsterSpawn());
			break;
		default:
			break;
		}
	}

	@EventHandler
	public void onMove(PlayerMoveEvent event)
	{
		if (Core.getInstance().gs != GameState.Game)
			return;
		// Shrine Protection
		{
			int radius = Core.getInstance().mm.getCurrentShrine().prot;

			double radiusSquared = radius * radius;

			Collection<Entity> entities = Core.getInstance().mm.getWorld().getNearbyEntities(
					Core.getInstance().mm.getCurrentShrine().getLocation(), radius, radius, radius); // All
																										// entities
																										// within
																										// a
																										// box
			for (Entity entity : entities)
			{

				if (entity.getLocation().distanceSquared(Core.getInstance().mm.getCurrentShrine().getLocation()) > radiusSquared)
					continue; // All entities within a sphere

				if (entity instanceof Player)
				{
					if (Core.getInstance().getDwarf(event.getPlayer()) != null)
					{
					} else if (Core.getInstance().getMonster(event.getPlayer()) != null)
					{
						// TODO Check if can go past mob protection
						event.getPlayer().damage(9999);
						event.getPlayer().sendMessage(
								ChatColor.DARK_RED + "You were killed because you were too close to the next shrine!");
						event.getPlayer().sendMessage(ChatColor.DARK_RED + "Destroy the current one first!");
					}
				}

			}
		}
		// Shrine Protection

		// Shrine Destroy
		{
			int radius = Core.getInstance().mm.getCurrentShrine().destroy;

			double radiusSquared = radius * radius;

			Collection<Entity> entities = Core.getInstance().mm.getWorld().getNearbyEntities(
					Core.getInstance().mm.getCurrentShrine().getLocation(), radius, radius, radius); // All entities within a box
			for (Entity entity : entities)
			{

				if (entity.getLocation().distanceSquared(Core.getInstance().mm.getCurrentShrine().getLocation()) > radiusSquared)
					continue; // All entities within a sphere

				if (entity instanceof Player)
				{
					// TODO Deal damage to the shrine
				}

			}
		}
		// Shrine Destroy
	}

	@EventHandler
	public void onLeave(PlayerQuitEvent event)
	{
		Core.getInstance().bb.removePlayer(event.getPlayer());
	}

}
