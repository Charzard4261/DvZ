package dwarves.vs.zombies.dwarf.equipment.ales;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.dwarf.Dwarf;
import dwarves.vs.zombies.dwarf.superclasses.DwarfAle;

public class HolyAle extends DwarfAle {

	public HolyAle(Dwarf dwarf)
	{
		super(dwarf, false);
	}

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.POTION, 1, (byte) 8267);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.AQUA + "Holy Ale");

		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + "L-Click: Heal yourself and gain 6 absorption");
		lore.add(ChatColor.YELLOW + "         hearts for 100 mana");
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

}
