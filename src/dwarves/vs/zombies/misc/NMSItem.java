package dwarves.vs.zombies.misc;

import org.bukkit.craftbukkit.v1_13_R2.inventory.CraftItemStack;

import net.minecraft.server.v1_13_R2.ItemStack;
import net.minecraft.server.v1_13_R2.NBTTagCompound;
import net.minecraft.server.v1_13_R2.NBTTagDouble;
import net.minecraft.server.v1_13_R2.NBTTagInt;
import net.minecraft.server.v1_13_R2.NBTTagList;
import net.minecraft.server.v1_13_R2.NBTTagString;

public class NMSItem {

	private ItemStack item;
	
	public NMSItem(org.bukkit.inventory.ItemStack item)
	{
		this.item = CraftItemStack.asNMSCopy(item);
	}
	
	public org.bukkit.inventory.ItemStack getItem()
	{
		return CraftItemStack.asBukkitCopy(item);
	}
	
	/**
	 * Adds an attribute to the item. Defaults the slot to the main hand. See also {@link #addAttribute(String id, double amount)} and {@link #addAttribute(id, amount, slot)}
	 * @param id The AttributeName
	 * @param amount The Amount
	 * @return Returns this for chaining
	 */
	public NMSItem addAttribute(String id, int amount)
	{
		NBTTagCompound compound = (item.hasTag()) ? item.getTag() : new NBTTagCompound();
		NBTTagList modifiers = compound.hasKey("AttributeModifiers") ? (NBTTagList) compound.get("AttributeModifiers"): new NBTTagList();
		NBTTagCompound attribute = new NBTTagCompound();
		attribute.set("AttributeName", new NBTTagString(id));
		attribute.set("Name", new NBTTagString(id));
		attribute.set("Amount", new NBTTagInt(amount));
		attribute.set("Operation", new NBTTagInt(0));
		attribute.set("UUIDLeast", new NBTTagInt(894654));
		attribute.set("UUIDMost", new NBTTagInt(2872));
		attribute.set("Slot", new NBTTagString("mainhand"));
		modifiers.add(attribute);
		compound.set("AttributeModifiers", modifiers);
		item.setTag(compound);
		return this;
	}

	/**
	 * Adds an attribute to the item on specified slot. See also {@link #addAttribute(id, amount)}
	 * @param id The AttributeName
	 * @param amount The Amount
	 * @param slot The Slot
	 * @return Returns this for chaining
	 */
	public NMSItem addAttribute(String id, int amount, String slot)
	{
		NBTTagCompound compound = (item.hasTag()) ? item.getTag() : new NBTTagCompound();
		NBTTagList modifiers = compound.hasKey("AttributeModifiers") ? (NBTTagList) compound.get("AttributeModifiers"): new NBTTagList();
		NBTTagCompound attribute = new NBTTagCompound();
		attribute.set("AttributeName", new NBTTagString(id));
		attribute.set("Name", new NBTTagString(id));
		attribute.set("Amount", new NBTTagInt(amount));
		attribute.set("Operation", new NBTTagInt(0));
		attribute.set("UUIDLeast", new NBTTagInt(894654));
		attribute.set("UUIDMost", new NBTTagInt(2872));
		attribute.set("Slot", new NBTTagString(slot));
		modifiers.add(attribute);
		compound.set("AttributeModifiers", modifiers);
		item.setTag(compound);
		return this;
	}
	
	/**
	 * 
	 * Adds an attribute to the item. Defaults the slot to the main hand. See also {@link #addAttribute(String id, double amount, String slot)}
	 * @param id The AttributeName
	 * @param amount The Amount
	 * @return Returns this for chaining
	 */
	public NMSItem addAttribute(String id, double amount)
	{
		NBTTagCompound compound = (item.hasTag()) ? item.getTag() : new NBTTagCompound();
		NBTTagList modifiers = compound.hasKey("AttributeModifiers") ? (NBTTagList) compound.get("AttributeModifiers"): new NBTTagList();
		NBTTagCompound attribute = new NBTTagCompound();
		attribute.set("AttributeName", new NBTTagString(id));
		attribute.set("Name", new NBTTagString(id));
		attribute.set("Amount", new NBTTagDouble(amount));
		attribute.set("Operation", new NBTTagInt(0));
		attribute.set("UUIDLeast", new NBTTagInt(894654));
		attribute.set("UUIDMost", new NBTTagInt(2872));
		attribute.set("Slot", new NBTTagString("mainhand"));
		modifiers.add(attribute);
		compound.set("AttributeModifiers", modifiers);
		item.setTag(compound);
		return this;
	}
	
	/**
	 * Adds an attribute to the item on specified slot. See also {@link #addAttribute(String id, double amount)}
	 * @param id The AttributeName
	 * @param amount The Amount
	 * @param slot The Slot
	 * @return Returns this for chaining
	 */
	public NMSItem addAttribute(String id, double amount, String slot)
	{
		NBTTagCompound compound = (item.hasTag()) ? item.getTag() : new NBTTagCompound();
		NBTTagList modifiers = compound.hasKey("AttributeModifiers") ? (NBTTagList) compound.get("AttributeModifiers"): new NBTTagList();
		NBTTagCompound attribute = new NBTTagCompound();
		attribute.set("AttributeName", new NBTTagString(id));
		attribute.set("Name", new NBTTagString(id));
		attribute.set("Amount", new NBTTagDouble(amount));
		attribute.set("Operation", new NBTTagInt(0));
		attribute.set("UUIDLeast", new NBTTagInt(894654));
		attribute.set("UUIDMost", new NBTTagInt(2872));
		attribute.set("Slot", new NBTTagString(slot));
		modifiers.add(attribute);
		compound.set("AttributeModifiers", modifiers);
		item.setTag(compound);
		return this;
	}
	
}
