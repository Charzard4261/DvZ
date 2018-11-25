package dwarves.vs.zombies.dwarf.items;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.dwarf.superclasses.DwarfItem;
import dwarves.vs.zombies.misc.NMSItem;

public class MightyPickaxe implements DwarfItem {

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.IRON_PICKAXE);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.AQUA + "Mighty Pickaxe");

		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + "L-Click: Mine Gold and dig tunnels");
		lore.add(ChatColor.YELLOW + "R-Click: Repair a fellow Dwarf's armour");
		meta.setLore(lore);

		meta.setUnbreakable(true);

		item.setItemMeta(meta);

		item = new NMSItem(item).addAttribute("generic.attackDamage", 4).addAttribute("generic.attackSpeed", 1.4).getItem();
		
		return item;
	}

}
