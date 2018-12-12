package dwarves.vs.zombies.dwarf.items.SquireItems;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.misc.generics.GenericItem;

public class ArmorRag implements GenericItem {

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.BONE_MEAL);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.GOLD + "Armor Rag");
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + "R-Click a fellow dwarf to shine their armor!");
		meta.setLore(lore);
		
		item.setItemMeta(meta);
		
		return item;
	}

}