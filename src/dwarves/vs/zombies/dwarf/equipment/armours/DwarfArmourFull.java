package dwarves.vs.zombies.dwarf.equipment.armours;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.misc.ArmourSet;
import net.minecraft.server.v1_12_R1.NBTTagCompound;
import net.minecraft.server.v1_12_R1.NBTTagInt;
import net.minecraft.server.v1_12_R1.NBTTagList;
import net.minecraft.server.v1_12_R1.NBTTagString;

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
		
		net.minecraft.server.v1_12_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
		NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();
		NBTTagList modifiers = new NBTTagList();
		NBTTagCompound health = new NBTTagCompound();
		health.set("AttributeName", new NBTTagString("generic.maxHealth"));
		health.set("Name", new NBTTagString("generic.maxHealth"));
		health.set("Amount", new NBTTagInt(20));
		health.set("Operation", new NBTTagInt(0));
		health.set("UUIDLeast", new NBTTagInt(894654));
		health.set("UUIDMost", new NBTTagInt(2872));
		health.set("Slot", new NBTTagString("chest"));
		modifiers.add(health);

		compound.set("AttributeModifiers", modifiers);

		nmsStack.setTag(compound);

		item = CraftItemStack.asBukkitCopy(nmsStack);
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
