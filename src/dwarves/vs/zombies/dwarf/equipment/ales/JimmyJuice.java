package dwarves.vs.zombies.dwarf.equipment.ales;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.dwarf.Dwarf;
import dwarves.vs.zombies.dwarf.superclasses.DwarfAle;

public class JimmyJuice extends DwarfAle {

	public JimmyJuice(Dwarf dwarf)
	{
		super(dwarf, true);
	}

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.POTION, 1, (byte) 8197);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.AQUA + "Jimmy Juice");

		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + "Passive: Heals you when you lose 5 hearts");
		lore.add(ChatColor.YELLOW + "         for 50 mana");
		meta.setLore(lore);

		item.setItemMeta(meta);

		return item;
	}

	@Override
	public void onLeftClick(PlayerInteractEvent event)
	{
		// TODO
	}

	@Override
	public void onRightClick(PlayerInteractEvent event)
	{
		// TODO
	}

	@Override
	public void onAuto()
	{
		if (getDwarf().modifyMana(-50))
		{
			getDwarf().getPlayer().playSound(getDwarf().getPlayer().getLocation(), "", 0.4f, 1f);
			getDwarf().getPlayer().setHealth(getDwarf().getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
		}
	}

}
