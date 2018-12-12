package dwarves.vs.zombies.dwarf.items;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.misc.NMSItem;
import dwarves.vs.zombies.misc.generics.GenericItem;

public class DwarvernShovel implements GenericItem {

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.IRON_SHOVEL);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.AQUA + "Dwarvern Shovel");

		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + "L-Click: Shovel Gravel to accquire Stone");
		meta.setLore(lore);

		meta.setUnbreakable(true);

		item.setItemMeta(meta);

		item = new NMSItem(item).addAttribute("generic.attackDamage", 5).addAttribute("generic.attackSpeed", 1.6).getItem();

		return item;
	}

}
