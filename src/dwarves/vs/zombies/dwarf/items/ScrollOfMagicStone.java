package dwarves.vs.zombies.dwarf.items;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.dwarf.superclasses.DwarfItem;

public class ScrollOfMagicStone extends DwarfItem{

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.CLAY_BRICK);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.AQUA + "Scroll of Magic Stone.");
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + 								"L-Click: To instantly make a wall of Magicstone");
		lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_PURPLE + 	"Trademarks expire?,");
		lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_PURPLE + 	"No! My slab business!");
		lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_PURPLE + 	"Noooooooooooooooooooooo!");
		lore.add(ChatColor.GOLD + 									"- Deadbones");
		meta.setLore(lore);
		
		meta.setUnbreakable(true);
		
		item.setItemMeta(meta);
		
		return item;
	}

}
