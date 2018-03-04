package dwarves.vs.zombies.dwarf.items.SquireItems;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.dwarf.superclasses.DwarfItem;

public class TrainingAxe extends DwarfItem{

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.IRON_SWORD);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.GOLD + "Training Axe");
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + "R-Click: Use on a wall until it breaks!");
		meta.setLore(lore);
		
		item.setItemMeta(meta);
		
		return item;
	}

}