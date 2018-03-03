package dwarves.vs.zombies.dwarf.items;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.dwarf.superclasses.DwarfItem;

public class StarTrinket extends DwarfItem{

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.EMERALD);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.AQUA + "Star Trinket");
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + 								"L-Click: To gain 20 absorption hearts for 200 mana");
		lore.add(ChatColor.YELLOW + 								"Passive: Regenerate 3.33 hearts a second");
		//lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_PURPLE + 	"Fill in the cracks, Jimmy. Once we lose the wall,");
		//lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_PURPLE + 	"we are as good as dead. Fill in the cracks.");
		//lore.add(ChatColor.GOLD + 									"- Bruce Willakers");
		meta.setLore(lore);
		
		item.setItemMeta(meta);
		
		return item;
	}

}