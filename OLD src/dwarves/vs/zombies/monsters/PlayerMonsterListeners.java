package dwarves.vs.zombies.monsters;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import dwarves.vs.zombies.Core;

public class PlayerMonsterListeners implements Listener {
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event)
	{
		if (Core.getInstance().getMonster((Player) event.getWhoClicked()) == null)
			return;
	}
	
}
