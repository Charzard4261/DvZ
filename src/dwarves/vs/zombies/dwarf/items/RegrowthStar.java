package dwarves.vs.zombies.dwarf.items;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.dwarf.superclasses.DwarfItem;

public class RegrowthStar extends DwarfItem{

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.NETHER_STAR);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.AQUA + "Star Trinket");
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + 								"Passive: Heals you when you lose 5 hearts for 100 mana.");
		lore.add(ChatColor.YELLOW + 								"R-Click Heal the dwarf you are looking at for 100 mana");
		lore.add(ChatColor.YELLOW + 								"regenerating 5% of their armor and giving heroes 10 mana");
		lore.add(ChatColor.YELLOW + 								"L-Click Instantly restore all your mana every 120 seconds,");
		lore.add(ChatColor.YELLOW + 								"each time you heal a dwarf this goes down by 5 seconds");
		//lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_PURPLE + 	"Fill in the cracks, Jimmy. Once we lose the wall,");
		//lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_PURPLE + 	"we are as good as dead. Fill in the cracks.");
		//lore.add(ChatColor.GOLD + 									"- Bruce Willakers");
		meta.setLore(lore);
		
		item.setItemMeta(meta);
		
		return item;
	}

}