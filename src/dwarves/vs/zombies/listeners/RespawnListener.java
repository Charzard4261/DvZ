package dwarves.vs.zombies.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import dwarves.vs.zombies.Core;

public class RespawnListener implements Listener {

	@EventHandler
	public void onRespawn(PlayerRespawnEvent event)
	{
		switch (Core.getInstance().getGm().stage)
		{
		case LOBBY:
			event.setRespawnLocation(Core.getInstance().getGm().lobby);
			break;
		case PRE:
			event.setRespawnLocation(Core.getInstance().getGm().map.getPlayerSpawn());
			break;
		case IN:
			if (Core.getInstance().getGm().dwarves.containsKey(event.getPlayer().getUniqueId()))
			{
				Core.getInstance().getGm().dwarves.get(event.getPlayer().getUniqueId()).killDwarf();
				event.setRespawnLocation(Core.getInstance().getGm().map.getMonsterSpawn());
			} else if (Core.getInstance().getGm().monsters.containsKey(event.getPlayer().getUniqueId()))
			{
				event.setRespawnLocation(Core.getInstance().getGm().lobby);
			}
			break;
		case POST:
			break;
		default:
			break;
		}
	}

}
