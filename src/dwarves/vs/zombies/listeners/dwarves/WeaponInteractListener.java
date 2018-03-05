package dwarves.vs.zombies.listeners.dwarves;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import dwarves.vs.zombies.Core;
import dwarves.vs.zombies.dwarf.items.DebugTool;
import dwarves.vs.zombies.enums.Stage;

public class WeaponInteractListener implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent event)
	{
		if (event.getPlayer().getInventory().getItemInMainHand() != null)
			if (event.getPlayer().getInventory().getItemInMainHand().isSimilar(new DebugTool().getItem()))
				new DebugTool().interact(event);

		if (event.getHand() == EquipmentSlot.OFF_HAND || Core.getInstance().getGm().stage == Stage.LOBBY
				|| event.getPlayer().getInventory().getItemInMainHand() == null)
			return;
		if (!Core.getInstance().getGm().dwarves.containsKey(event.getPlayer().getUniqueId()))
			return;

		if (event.getPlayer().getInventory().getItemInMainHand()
				.equals(Core.getInstance().getGm().dwarves.get(event.getPlayer().getUniqueId()).getSword().getItem())
				&& (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK))
		{
			Core.getInstance().getGm().dwarves.get(event.getPlayer().getUniqueId()).getSword().rightClick(event);
		}
	}

	@EventHandler
	public void onInteract(PlayerInteractAtEntityEvent event)
	{
		if (Core.getInstance().getGm().stage == Stage.LOBBY || event.getHand() == EquipmentSlot.OFF_HAND
				|| event.getPlayer().getInventory().getItemInMainHand() == null)
			return;

		if (!Core.getInstance().getGm().dwarves.containsKey(event.getPlayer().getUniqueId()))
			return;

		if (event.getPlayer().getInventory().getItemInMainHand()
				.equals(Core.getInstance().getGm().dwarves.get(event.getPlayer().getUniqueId()).getSword().getItem()))
		{
			Core.getInstance().getGm().dwarves.get(event.getPlayer().getUniqueId()).getSword().rightClick(event);
		}
	}

}
