package dwarves.vs.zombies.dwarf.items;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.dwarf.superclasses.DwarfItem;

public class WoodenPlank implements DwarfItem{

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.FEATHER);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.AQUA + "Wooden Plank");
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + 								"R-Click: Use on a Sawmill to turn into sticks");
		lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_PURPLE + 	"Cut the planks in the buzz saw to make sticks!");
		lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_PURPLE + 	"Just make sure to watch your hands!");
		lore.add(ChatColor.DARK_AQUA + 								"- Jimmy");
		meta.setLore(lore);
		
		meta.setUnbreakable(true);
		
		item.setItemMeta(meta);
		
		return item;
	}

}
