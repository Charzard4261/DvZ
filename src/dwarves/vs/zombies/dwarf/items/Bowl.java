package dwarves.vs.zombies.dwarf.items;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.dwarf.superclasses.DwarfItem;

public class Bowl implements DwarfItem{

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.BOWL);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.AQUA + "Bowl");
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + 								"R-Click: Use on oil to make Mortar");
		lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_PURPLE + 	"Use these on the oil, Jimmy. We are gonna");
		lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_PURPLE + 	"need mortar for these walls.");
		lore.add(ChatColor.GOLD + 									"- Bruce Willakers");
		meta.setLore(lore);
		
		meta.setUnbreakable(true);
		
		item.setItemMeta(meta);
		
		return item;
	}

}
