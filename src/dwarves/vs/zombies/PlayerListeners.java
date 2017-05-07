package dwarves.vs.zombies;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import dwarves.vs.zombies.util.PlayerSkinEditor;

@SuppressWarnings("deprecation")
public class PlayerListeners implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent event)
	{
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
					if (event.getPlayer().getUniqueId()
							.equals(Core.getInstance().oldMan.getUniqueId()))
						PlayerSkinEditor.applyOldMan(event.getPlayer().getUniqueId());
				Core.getInstance().getDwarf(event.getPlayer()).setPlayer();
			} else if (Core.getInstance().getMonster(event.getPlayer()) == null)
			{
				Core.getInstance().spawnDwarf(event.getPlayer());
			}
			break;
		case Game:
			if (Core.getInstance().getDwarf(event.getPlayer()) != null)
			{
				if (Core.getInstance().oldMan != null)
					if (event.getPlayer().getUniqueId()
							.equals(Core.getInstance().oldMan.getUniqueId()))
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
			event.setFormat(ChatColor.WHITE + "[!]<" + event.getPlayer().getCustomName()
					+ ChatColor.WHITE + "> "
					+ event.getMessage().substring(1, event.getMessage().length()));
			return;
		}

		event.getRecipients().clear();
		event.setFormat(ChatColor.WHITE + "<" + event.getPlayer().getCustomName() + ChatColor.WHITE
				+ "> " + event.getMessage());
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

			break;
		default:
			break;
		}
	}
}
