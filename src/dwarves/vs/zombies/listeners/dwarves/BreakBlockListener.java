package dwarves.vs.zombies.listeners.dwarves;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import dwarves.vs.zombies.Core;
import dwarves.vs.zombies.dwarf.items.ArmorDiamond;
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
			case ENCHANTING_TABLE:
			case IRON_BARS:
			case ACACIA_LOG:
			case BIRCH_LOG:
			case DARK_OAK_LOG:
			case JUNGLE_LOG:
			case OAK_LOG:
			case SPRUCE_LOG:
			case LADDER:
			case OBSIDIAN:
			case PISTON:
			case PISTON_HEAD:
			case STICKY_PISTON:
			case POWERED_RAIL:
			case RAIL:
			case REDSTONE:
			case REDSTONE_BLOCK:
			case REDSTONE_TORCH:
			case REDSTONE_WALL_TORCH:
			case SPONGE:
			case QUARTZ_BLOCK:
			case QUARTZ_STAIRS:
			case JACK_O_LANTERN:
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
				//if (event.getPlayer().getInventory().getItemInMainHand().equals(new TombMaker().getItem)))
					//((Dwarf) event.getPlayer()).proc(5);
				break;
			case GOLD_BLOCK:
				event.getPlayer().getInventory().addItem(new ArmorDiamond().getItem());
			default:
				break;
			}
		} else if (Core.getInstance().getGm().monsters.containsKey(event.getPlayer().getUniqueId()))
		{
		}
	}

}
