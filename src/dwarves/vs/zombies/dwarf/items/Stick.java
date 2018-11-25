package dwarves.vs.zombies.dwarf.items;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.dwarf.superclasses.DwarfItem;

public class Stick implements DwarfItem{

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.STICK);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.AQUA + "Stick");
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + 								"R-Click: Use on a Sawmill to turn into bowls");
		lore.add(ChatColor.YELLOW + 								"R-Click: Use on oil to make torches");
		lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_PURPLE + 	"You can cut sticks into bowls or dip them in");
		lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_PURPLE + 	"oil to make torches! How do you cut sticks into");
		lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_PURPLE + 	"bowls? Huh... I never really thought about that...");
		lore.add(ChatColor.GOLD + 									"- Deadbones");
		meta.setLore(lore);
		
		meta.setUnbreakable(true);
		
		item.setItemMeta(meta);
		
		return item;
	}

}
