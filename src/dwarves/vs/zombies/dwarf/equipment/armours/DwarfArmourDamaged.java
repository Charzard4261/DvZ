package dwarves.vs.zombies.dwarf.equipment.armours;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.misc.ArmourSet;
import dwarves.vs.zombies.misc.NMSItem;

public class DwarfArmourDamaged extends ArmourSet {

	@Override
	public ItemStack getHelmet()
	{
		// TODO Auto-generated method stub		
		return null;
	}

	@Override
	public ItemStack getChestplate()
	{
		ItemStack item = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.AQUA + "Damaged Dwarvern Chestplate");
		meta.setUnbreakable(true);
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Your armor is damaged, get someone");
		lore.add("to R-Click you with a pickaxe");
		lore.add("to repair it.");
		meta.setLore(lore);

		item.setItemMeta(meta);

		item = new NMSItem(item).addAttribute("generic.maxHealth", 20, "chest").getItem();
		
		return item;
	}
	
	@Override
	public ItemStack getLeggings()
	{
		ItemStack item = new ItemStack(Material.IRON_LEGGINGS);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.AQUA + "Damaged Dwarvern Leggings");
		meta.setUnbreakable(true);
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Your armor is damaged, get someone");
		lore.add("to R-Click you with a pickaxe");
		lore.add("to repair it.");
		meta.setLore(lore);

		item.setItemMeta(meta);
		return item;
	}

	@Override
	public ItemStack getBoots()
	{
		ItemStack item = new ItemStack(Material.IRON_BOOTS);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.AQUA + "Damaged Dwarvern Boots");
		meta.setUnbreakable(true);
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Your armor is damaged, get someone");
		lore.add("to R-Click you with a pickaxe");
		lore.add("to repair it.");
		meta.setLore(lore);

		item.setItemMeta(meta);
		return item;
	}

}
