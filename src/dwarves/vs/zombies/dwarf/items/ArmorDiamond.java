package dwarves.vs.zombies.dwarf.items;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.misc.generics.GenericItem;

public class ArmorDiamond implements GenericItem {

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.DIAMOND);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.AQUA + "Dwarven Armor");
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GOLD + 									"L-Click: Use on a Dwarf to give them armor");
		lore.add(ChatColor.GOLD + 									"         You will need someone else to put");
		lore.add(ChatColor.GOLD + 									"         on your own");
		lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_PURPLE + 	"How do you put it on? Thats a good question.");
		lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_PURPLE + 	"I just always get some other jimmy to help me.");
		lore.add(ChatColor.GOLD + 									"- Lance Willakers");
		meta.setLore(lore);
		
		meta.setUnbreakable(true);
		
		item.setItemMeta(meta);
		
		return item;
	}

}
