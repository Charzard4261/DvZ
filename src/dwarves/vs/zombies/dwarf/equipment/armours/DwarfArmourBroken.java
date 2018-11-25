package dwarves.vs.zombies.dwarf.equipment.armours;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.misc.ArmourSet;
import dwarves.vs.zombies.misc.NMSItem;

public class DwarfArmourBroken extends ArmourSet {

	@Override
	public ItemStack getHelmet()
	{
		return null;
	}

	@Override
	public ItemStack getChestplate()
	{
		ItemStack item = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.AQUA + "Broken Dwarvern Chestplate");
		meta.setUnbreakable(true);
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Your armor is broken and you are");
		lore.add("taking additional damage");
		lore.add("Get someone to R-Click you with");
		lore.add("a pickaxe to repair it.");
		meta.setLore(lore);

		item.setItemMeta(meta);

		item = new NMSItem(item).addAttribute("generic.maxHealth", 20, "chest").getItem();
		
		return item;
	}
	
	@Override
	public ItemStack getLeggings()
	{
		ItemStack item = new ItemStack(Material.CHAINMAIL_LEGGINGS);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.AQUA + "Broken Dwarvern Leggings");
		meta.setUnbreakable(true);
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Your armor is broken and you are");
		lore.add("taking additional damage");
		lore.add("Get someone to R-Click you with");
		lore.add("a pickaxe to repair it.");
		lore.add("to repair it.");
		meta.setLore(lore);


		item.setItemMeta(meta);
		return item;
	}

	@Override
	public ItemStack getBoots()
	{
		ItemStack item = new ItemStack(Material.CHAINMAIL_BOOTS);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.AQUA + "Broken Dwarvern Boots");
		meta.setUnbreakable(true);
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Your armor is broken and you are");
		lore.add("taking additional damage");
		lore.add("Get someone to R-Click you with");
		lore.add("a pickaxe to repair it.");
		lore.add("to repair it.");
		meta.setLore(lore);


		item.setItemMeta(meta);
		return item;
	}

}
