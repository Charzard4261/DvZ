package dwarves.vs.zombies.listeners.dwarves;

import org.bukkit.Material;
import org.bukkit.Sound;
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
import dwarves.vs.zombies.dwarf.items.Stick;
import dwarves.vs.zombies.dwarf.items.Torch;
import dwarves.vs.zombies.dwarf.items.WoodenPlank;
import dwarves.vs.zombies.enums.Stage;

public class ClickBlockListener implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent event)
	{
		if (event.getHand() == EquipmentSlot.OFF_HAND)
			event.setCancelled(true);
		if (event.getHand() == EquipmentSlot.OFF_HAND || Core.getInstance().getGm().stage == Stage.LOBBY)
			return;

		if (event.getAction() == Action.LEFT_CLICK_BLOCK)
		{
		} else if (event.getAction() == Action.RIGHT_CLICK_BLOCK)
		{
			if (Core.getInstance().getGm().dwarves.containsKey(event.getPlayer().getUniqueId()))
				if (event.getPlayer().getInventory().getItemInMainHand() != null)
					if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.AIR)
						switch (event.getClickedBlock().getType())
						{
						// ----------------------------------------------------------------------
						case RAILS: // AXE
							event.getPlayer().getInventory().addItem(new LumberjackAxe().getItem());
							event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), "activateshield", 0.4f, 1f);
							break;
						case ACTIVATOR_RAIL: // PICAXE
							event.getPlayer().getInventory().addItem(new MightyPickaxe().getItem());
							event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), "activateshield", 0.4f, 1f);
							break;
						case POWERED_RAIL: // SHOVEL
							event.getPlayer().getInventory().addItem(new DwarvernShovel().getItem());
							event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), "activateshield", 0.4f, 1f);
							break;
						case DETECTOR_RAIL: // BOW
							if (!event.getPlayer().getInventory().contains(Core.getInstance().getGm().dwarves
									.get(event.getPlayer().getUniqueId()).getBow().getItem()))
							{
								event.getPlayer().getInventory().addItem(Core.getInstance().getGm().dwarves
										.get(event.getPlayer().getUniqueId()).getBow().getItem());
								event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), "activatebow", 0.4f, 1f);
							}
							break;
						case LADDER: // SWORD
							if (!event.getPlayer().getInventory().contains(Core.getInstance().getGm().dwarves
									.get(event.getPlayer().getUniqueId()).getSword().getItem()))
							{
								event.getPlayer().getInventory().addItem(Core.getInstance().getGm().dwarves
										.get(event.getPlayer().getUniqueId()).getSword().getItem());
								event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), "activatesword", 0.4f, 1f);
							}
							break;
						case REDSTONE_TORCH_ON: // ALE

							break;
						default:
							break;
						}
					else
						switch (event.getClickedBlock().getType())
						{
						// ----------------------------------------------------------------------
						case LOG:
						case LOG_2:
							if (event.getPlayer().getInventory().getItemInMainHand()
									.equals(new LumberjackAxe().getItem()))
							{
								event.getPlayer().getWorld().playSound(event.getClickedBlock().getLocation(), "toolaxehit", 0.4f,
										1f);
								event.getPlayer().getInventory().addItem(new Log().getItem());
							}
							break;
						case IRON_FENCE:
							if (event.getPlayer().getInventory().getItemInMainHand().isSimilar(new Log().getItem()))
							{
								event.getPlayer().getInventory().getItemInMainHand().setAmount(
										event.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);
								event.getPlayer().getWorld().playSound(event.getClickedBlock().getLocation(), "toolwoodchop", 0.4f,
										1f);
								ItemStack s = new WoodenPlank().getItem();
								s.setAmount(2);
								event.getPlayer().getInventory().addItem(s);
							} else if (event.getPlayer().getInventory().getItemInMainHand()
									.isSimilar(new WoodenPlank().getItem()))
							{
								event.getPlayer().getInventory().getItemInMainHand().setAmount(
										event.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);
								event.getPlayer().getWorld().playSound(event.getClickedBlock().getLocation(), "toolwoodchop", 0.4f,
										1f);
								ItemStack s = new Stick().getItem();
								s.setAmount(2);
								event.getPlayer().getInventory().addItem(s);
							} else if (event.getPlayer().getInventory().getItemInMainHand()
									.isSimilar(new Stick().getItem()))
							{
								event.getPlayer().getInventory().getItemInMainHand().setAmount(
										event.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);
								event.getPlayer().getWorld().playSound(event.getClickedBlock().getLocation(), "toolwoodchop", 0.4f,
										1f);
								ItemStack s = new Bowl().getItem();
								s.setAmount(4);
								event.getPlayer().getInventory().addItem(s);
							}
							break;
						case SPONGE:
							if (event.getPlayer().getInventory().getItemInMainHand().isSimilar(new Stick().getItem()))
							{
								event.getPlayer().getInventory().getItemInMainHand().setAmount(
										event.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);
								event.getPlayer().getWorld().playSound(event.getClickedBlock().getLocation(),
										Sound.ENTITY_SLIME_JUMP, 0.4f, 0.5f);
								event.getPlayer().getInventory().addItem(new Torch().getItem());
							} else if (event.getPlayer().getInventory().getItemInMainHand()
									.isSimilar(new Bowl().getItem()))
							{
								event.getPlayer().getInventory().getItemInMainHand().setAmount(
										event.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);
								event.getPlayer().getWorld().playSound(event.getClickedBlock().getLocation(),
										Sound.ENTITY_SLIME_JUMP, 0.4f, 0.5f);
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
