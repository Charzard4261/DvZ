package dwarves.vs.zombies.dwarves;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import dwarves.vs.zombies.Core;

public class PlayerDwarfListeners implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent event)
	{
		if (Core.getInstance().getDwarf(event.getPlayer()) == null)
			return;
		if ((event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK)
				&& event.getPlayer().getInventory().getItemInHand().equals(Core
						.getInstance().getDwarf(event.getPlayer()).getWeapon()
						.getItem()))
		{
			Core.getInstance().getDwarf(event.getPlayer()).getWeapon().normal();
		} else if ((event.getAction() == Action.RIGHT_CLICK_AIR || event
				.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& event.getPlayer().getInventory().getItemInHand().equals(Core
						.getInstance().getDwarf(event.getPlayer()).getWeapon()
						.getItem()))
		{
			Core.getInstance().getDwarf(event.getPlayer()).getWeapon()
					.special();
		}
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event)
	{
		if (Core.getInstance().getDwarf((Player) event.getWhoClicked()) == null)
			return;
	}

}
