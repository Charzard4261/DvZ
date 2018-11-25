package dwarves.vs.zombies.dwarf.items;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.dwarf.superclasses.DwarfItem;

public class SwordOfSanctification implements DwarfItem{

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.MAGENTA_DYE);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.AQUA + "Sword Of Sanctification");
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + 								"L-Click: Summon a powerful sword from");
		lore.add(ChatColor.YELLOW + 								"the sky to smite all nearby foes dealing");
		lore.add(ChatColor.YELLOW + 								"massive damage to all non boss demons");
		meta.setLore(lore);
		
		item.setItemMeta(meta);
		
		return item;
	}

}
