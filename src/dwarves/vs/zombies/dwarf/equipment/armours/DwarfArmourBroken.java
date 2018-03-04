package dwarves.vs.zombies.dwarf.equipment.armours;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.misc.ArmourSet;
import net.minecraft.server.v1_12_R1.NBTTagCompound;
import net.minecraft.server.v1_12_R1.NBTTagInt;
import net.minecraft.server.v1_12_R1.NBTTagList;
import net.minecraft.server.v1_12_R1.NBTTagString;

public class DwarfArmourBroken extends ArmourSet {

	@Override
	public ItemStack getHelmet()
	{
		// TODO Auto-generated method stub
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
