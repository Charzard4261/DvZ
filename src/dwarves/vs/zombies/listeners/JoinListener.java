package dwarves.vs.zombies.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import dwarves.vs.zombies.Core;

public class JoinListener implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent event)
	{
		switch (Core.getInstance().getGm().stage)
		{
		case LOBBY:
			Core.getInstance().spawnSpectator(event.getPlayer());
			break;
		case PRE:
			if (!(Core.getInstance().getGm().dwarves.containsKey(event.getPlayer().getUniqueId())))
				Core.getInstance().getGm().spawnDwarf(event.getPlayer());
			break;
		case IN:
			if (Core.getInstance().getGm().dwarves.containsKey(event.getPlayer().getUniqueId()))
					Core.getInstance().getGm().killDwarf(Core.getInstance().getGm().dwarves.get(event.getPlayer().getUniqueId()));
			Core.getInstance().getGm().spawnMonster(event.getPlayer());
			break;
		case POST:
			break;
		default:
			break;
		}
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent event)
	{
		switch (Core.getInstance().getGm().stage)
		{
		case LOBBY:
			break;
		case PRE:
			break;
		case IN:
			break;
		case POST:
			break;
		default:
			break;

		}
	}

}
