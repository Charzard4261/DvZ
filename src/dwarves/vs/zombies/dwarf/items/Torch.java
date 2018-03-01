package dwarves.vs.zombies.dwarf.items;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.dwarf.superclasses.DwarfItem;

public class Torch extends DwarfItem{

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.TORCH);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.AQUA + "Torch");
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + 								"R-Click: Place a torch to prevent the darkness effects");
		lore.add(ChatColor.YELLOW + 								"Passive: Hold to be immune to the Darkness");
		lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_PURPLE + 	"You can hold a torch while running as well to see");
		lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_PURPLE + 	"in the darkness, young warrior. Don't forget that.");
		lore.add(ChatColor.GOLD + 									"- Lance Willakers");
		meta.setLore(lore);
		
		meta.setUnbreakable(true);
		
		item.setItemMeta(meta);
		
		return item;
	}

}
