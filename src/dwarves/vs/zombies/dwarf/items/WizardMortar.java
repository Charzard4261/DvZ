package dwarves.vs.zombies.dwarf.items;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.dwarf.superclasses.DwarfItem;

public class WizardMortar extends DwarfItem{

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.INK_SACK, 1, (byte) 9);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.AQUA + "Wizzard Mortar");
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + 								"L-Click: Use on any walls to repair them into magic stone!");
		lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_PURPLE + 	"use this carefully Jimmy. I don't have a lot of it and it's");
		lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_PURPLE + 	"strong enough to hold anything together");
		lore.add(ChatColor.GOLD + 									"- Bruce Willakers");
		meta.setLore(lore);
		
		item.setItemMeta(meta);
		
		return item;
	}

}
