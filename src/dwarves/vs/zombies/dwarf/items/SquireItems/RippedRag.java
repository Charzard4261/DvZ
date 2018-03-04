package dwarves.vs.zombies.dwarf.items.SquireItems;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.dwarf.superclasses.DwarfItem;

public class RippedRag extends DwarfItem{

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.INK_SACK, 1, (byte) 15);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.GOLD + "Ripped Rag");
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + "That should do it!");
		meta.setLore(lore);
		
		item.setItemMeta(meta);
		
		return item;
	}

}