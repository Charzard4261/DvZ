package dwarves.vs.zombies.dwarf.items.SquireItems;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.misc.generics.GenericItem;

public class SmallStick implements GenericItem {

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.STICK);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.AQUA + "Small Stick");
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + "R-Click: Use on oil to make torches!");
		meta.setLore(lore);
		
		item.setItemMeta(meta);
		
		return item;
	}

}