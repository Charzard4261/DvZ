package dwarves.vs.zombies.dwarf.items;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.dwarf.superclasses.DwarfItem;

public class EnchantedLamp extends DwarfItem{

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.INK_SACK, 1, (byte) 9);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.AQUA + "Mortar");
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + 								"R-Click: Use to place a unbreakable lamp that");
		lore.add(ChatColor.YELLOW + 								"         lasts for 60 seconds");
		lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_PURPLE + 	"Fight along side this Lamp young warrior.");
		lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_PURPLE + 	"It shall be your light in the darkness");
		lore.add(ChatColor.GOLD + 									"- Lance Willakers");
		meta.setLore(lore);
		
		item.setItemMeta(meta);
		
		return item;
	}

}
