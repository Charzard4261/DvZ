package dwarves.vs.zombies.dwarf.items;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.dwarf.superclasses.DwarfItem;

public class HolyAle extends DwarfItem{

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.POTION, 1, (byte) 8267);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.AQUA + "Holy Ale");
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + 								"L-Click: To heal yourself and gain 6 absorption");
		lore.add(ChatColor.YELLOW + 								"hearts for 100 mana");
		//lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_PURPLE + 	"Fill in the cracks, Jimmy. Once we lose the wall,");
		//lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_PURPLE + 	"we are as good as dead. Fill in the cracks.");
		//lore.add(ChatColor.GOLD + 									"- Bruce Willakers");
		meta.setLore(lore);
		
		item.setItemMeta(meta);
		
		return item;
	}

}
