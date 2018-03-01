package dwarves.vs.zombies.listeners.dwarves;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import dwarves.vs.zombies.Core;
import dwarves.vs.zombies.dwarf.items.MightyPickaxe;
import dwarves.vs.zombies.enums.Stage;

public class BreakBlockListener implements Listener {

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event)
	{
		if (event.getPlayer().getGameMode() == GameMode.CREATIVE)
			return;

		if (Core.getInstance().getGm().stage == Stage.LOBBY)
			event.setCancelled(true);

		if (event.isCancelled())
			return;

		event.setDropItems(false);

		if (Core.getInstance().getGm().dwarves.containsKey(event.getPlayer().getUniqueId()))
		{
			switch (event.getBlock().getType())
			{
			case ACTIVATOR_RAIL:
			case BEACON:
			case DETECTOR_RAIL:
			case ENCHANTMENT_TABLE:
			case IRON_FENCE:
			case LOG:
			case LOG_2:
			case LADDER:
			case OBSIDIAN:
			case PISTON_BASE:
			case PISTON_EXTENSION:
			case PISTON_MOVING_PIECE:
			case PISTON_STICKY_BASE:
			case POWERED_RAIL:
			case RAILS:
			case REDSTONE:
			case REDSTONE_BLOCK:
			case REDSTONE_TORCH_ON:
			case REDSTONE_TORCH_OFF:
			case SPONGE:
			case QUARTZ_BLOCK:
			case QUARTZ_STAIRS:
				event.setCancelled(true);
				break;
			case GOLD_ORE:
				event.setExpToDrop(0);
				if (event.getPlayer().getInventory().getItemInMainHand().equals(new MightyPickaxe().getItem()))
					Core.getInstance().getGm().addGold(1);
				break;
			case GRAVEL:
				event.getPlayer().playSound(event.getBlock().getLocation(), Sound.BLOCK_ANVIL_PLACE, 0.4f, 1f);
				event.getPlayer().getInventory().addItem(new ItemStack(Material.COBBLESTONE, 2));
				break;
			default:
				break;
			}
		} else if (Core.getInstance().getGm().monsters.containsKey(event.getPlayer().getUniqueId()))
		{
		}
	}

}
