package dwarves.vs.zombies.listeners.dwarves;

import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import dwarves.vs.zombies.Core;
import dwarves.vs.zombies.dwarf.items.Bowl;
import dwarves.vs.zombies.dwarf.items.DwarvernShovel;
import dwarves.vs.zombies.dwarf.items.Log;
import dwarves.vs.zombies.dwarf.items.LumberjackAxe;
import dwarves.vs.zombies.dwarf.items.MightyPickaxe;
import dwarves.vs.zombies.dwarf.items.Mortar;
import dwarves.vs.zombies.dwarf.items.ScrollOfMagicStone;
import dwarves.vs.zombies.dwarf.items.Stick;
import dwarves.vs.zombies.dwarf.items.Torch;
import dwarves.vs.zombies.dwarf.items.WizardMortar;
import dwarves.vs.zombies.dwarf.items.WoodenPlank;
import dwarves.vs.zombies.enums.Stage;
import dwarves.vs.zombies.misc.Utils;

public class ClickBlockListener implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent event)
	{
		if (!Core.getInstance().getGm().dwarves.containsKey(event.getPlayer().getUniqueId()))
			return;
		if (event.getHand() == EquipmentSlot.OFF_HAND)
			event.setCancelled(true);
		if (event.getHand() == EquipmentSlot.OFF_HAND || Core.getInstance().getGm().stage == Stage.LOBBY)
			return;

		if (event.getAction() == Action.LEFT_CLICK_BLOCK)
		{
			if (event.getPlayer().getInventory().getItemInMainHand() != null)
				if (event.getPlayer().getInventory().getItemInMainHand().isSimilar(new Mortar().getItem())
						|| event.getPlayer().getInventory().getItemInMainHand().isSimilar(new WizardMortar().getItem()))
				{
					if (event.getPlayer().getGameMode() != GameMode.CREATIVE)
						event.getPlayer().getInventory().getItemInMainHand()
								.setAmount(event.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);
					event.getPlayer().playSound(event.getClickedBlock().getLocation(), Sound.BLOCK_SLIME_BLOCK_PLACE, 0.4f, 1f);
					List<Block> radius = Utils.getBlocks(event.getClickedBlock(), 3, 3, 3);
					for (Block block : radius)
					{
						switch (block.getType())
						{
						case COBBLESTONE:
						case MOSSY_COBBLESTONE:
						case STONE_BRICKS:
							if (Core.getInstance().getGm().stage == Stage.PRE
									|| event.getPlayer().getInventory().getItemInMainHand().isSimilar(new WizardMortar().getItem()))
								block.setType(Material.LAPIS_ORE);
							else
								block.setType(Material.STONE_BRICKS);
							break;
						default:
							break;
						}
					}
				}

		}

		if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK)
		{
			if (event.getPlayer().getInventory().getItemInMainHand() != null)
				if (event.getPlayer().getInventory().getItemInMainHand().isSimilar(new ScrollOfMagicStone().getItem()))
				{
					if (Core.getInstance().getGm().dwarves.get(event.getPlayer().getUniqueId()).slabt > 0)
						return;

					if (event.getPlayer().getGameMode() != GameMode.CREATIVE)
						event.getPlayer().getInventory().getItemInMainHand()
								.setAmount(event.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);
					event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ANVIL_PLACE, 1f, 1f);
					event.getPlayer().getWorld().spawnParticle(Particle.EXPLOSION_HUGE, event.getPlayer().getLocation(), 1);
					new ScrollOfMagicStone().slab(event.getPlayer(), event.getPlayer().getLocation().getBlock());
				}
		}

		// ----------------------------------------------------------------------

		if (event.getAction() == Action.RIGHT_CLICK_BLOCK)
		{
			if (event.getPlayer().getInventory().getItemInMainHand() != null)
				if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.AIR)
					switch (event.getClickedBlock().getType())
					{
					// ----------------------------------------------------------------------
					case RAIL: // AXE
						event.getPlayer().getInventory().addItem(new LumberjackAxe().getItem());
						event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), "activateshield", 0.4f, 1f);
						break;
					case ACTIVATOR_RAIL: // PICKAXE
						event.getPlayer().getInventory().addItem(new MightyPickaxe().getItem());
						event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), "activateshield", 0.4f, 1f);
						break;
					case POWERED_RAIL: // SHOVEL
						event.getPlayer().getInventory().addItem(new DwarvernShovel().getItem());
						event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), "activateshield", 0.4f, 1f);
						break;
					case DETECTOR_RAIL: // BOW
						for (ItemStack item : Core.getInstance().getGm().dwarves.get(event.getPlayer().getUniqueId()).getBows().keySet())
							if (!event.getPlayer().getInventory().contains(item))
							{
								event.getPlayer().getInventory().addItem(item);
								event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), "activatebow", 0.4f, 1f);
								break;
							}
						break;
					case LADDER: // SWORD
						for (ItemStack item : Core.getInstance().getGm().dwarves.get(event.getPlayer().getUniqueId()).getSwords().keySet())
							if (!event.getPlayer().getInventory().contains(item))
							{
								event.getPlayer().getInventory().addItem(item);
								event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), "activatesword", 0.4f, 1f);
								break;
							}
						break;
					case REDSTONE_TORCH: // ALE
					case REDSTONE_WALL_TORCH:

						break;
					default:
						break;
					}
				else
					switch (event.getClickedBlock().getType())
					{
					// ----------------------------------------------------------------------
					case ACACIA_LOG:
					case BIRCH_LOG:
					case DARK_OAK_LOG:
					case JUNGLE_LOG:
					case OAK_LOG:
					case SPRUCE_LOG:
						if (event.getPlayer().getInventory().getItemInMainHand().equals(new LumberjackAxe().getItem()))
						{
							event.getPlayer().getWorld().playSound(event.getClickedBlock().getLocation(), "toolaxehit", 0.4f, 1f);
							event.getPlayer().getInventory().addItem(new Log().getItem());
						}
						break;
					case IRON_BARS:
						if (event.getPlayer().getInventory().getItemInMainHand().isSimilar(new Log().getItem()))
						{
							event.getPlayer().getInventory().getItemInMainHand()
									.setAmount(event.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);
							event.getPlayer().getWorld().playSound(event.getClickedBlock().getLocation(), "toolwoodchop", 0.4f, 1f);
							ItemStack s = new WoodenPlank().getItem();
							s.setAmount(2);
							event.getPlayer().getInventory().addItem(s);
						} else if (event.getPlayer().getInventory().getItemInMainHand().isSimilar(new WoodenPlank().getItem()))
						{
							event.getPlayer().getInventory().getItemInMainHand()
									.setAmount(event.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);
							event.getPlayer().getWorld().playSound(event.getClickedBlock().getLocation(), "toolwoodchop", 0.4f, 1f);
							ItemStack s = new Stick().getItem();
							s.setAmount(2);
							event.getPlayer().getInventory().addItem(s);
						} else if (event.getPlayer().getInventory().getItemInMainHand().isSimilar(new Stick().getItem()))
						{
							event.getPlayer().getInventory().getItemInMainHand()
									.setAmount(event.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);
							event.getPlayer().getWorld().playSound(event.getClickedBlock().getLocation(), "toolwoodchop", 0.4f, 1f);
							ItemStack s = new Bowl().getItem();
							s.setAmount(4);
							event.getPlayer().getInventory().addItem(s);
						}
						break;
					case SPONGE:
						if (event.getPlayer().getInventory().getItemInMainHand().isSimilar(new Stick().getItem()))
						{
							event.getPlayer().getInventory().getItemInMainHand()
									.setAmount(event.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);
							event.getPlayer().getWorld().playSound(event.getClickedBlock().getLocation(), Sound.ENTITY_SLIME_JUMP, 0.4f, 0.5f);
							event.getPlayer().getInventory().addItem(new Torch().getItem());
						} else if (event.getPlayer().getInventory().getItemInMainHand().isSimilar(new Bowl().getItem()))
						{
							event.getPlayer().getInventory().getItemInMainHand()
									.setAmount(event.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);
							event.getPlayer().getWorld().playSound(event.getClickedBlock().getLocation(), Sound.ENTITY_SLIME_JUMP, 0.4f, 0.5f);
							event.getPlayer().getInventory().addItem(new Mortar().getItem());
						}
						break;
					// ----------------------------------------------------------------------
					default:
						break;
					}
		}
	}

}
