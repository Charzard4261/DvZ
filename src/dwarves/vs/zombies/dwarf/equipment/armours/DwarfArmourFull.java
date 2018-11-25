package dwarves.vs.zombies.dwarf.equipment.armours;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.misc.ArmourSet;
import dwarves.vs.zombies.misc.NMSItem;

public class DwarfArmourFull extends ArmourSet {

	@Override
	public ItemStack getHelmet()
	{
		ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.AQUA + "Dwarvern Helmet");
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.setUnbreakable(true);

		item.setItemMeta(meta);
		return null;
	}

	@Override
	public ItemStack getChestplate()
	{
		ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.AQUA + "Dwarvern Chestplate");
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.setUnbreakable(true);

		item.setItemMeta(meta);

		item = new NMSItem(item).addAttribute("generic.maxHealth", 20, "chest").getItem();
		
		return item;
	}

	@Override
	public ItemStack getLeggings()
	{
		ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.AQUA + "Dwarvern Leggings");
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.setUnbreakable(true);

		item.setItemMeta(meta);
		return item;
	}

	@Override
	public ItemStack getBoots()
	{
		ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.AQUA + "Dwarvern Boots");
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.setUnbreakable(true);

		item.setItemMeta(meta);
		return item;
	}

}
