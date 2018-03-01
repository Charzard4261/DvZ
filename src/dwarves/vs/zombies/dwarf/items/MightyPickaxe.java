package dwarves.vs.zombies.dwarf.items;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.dwarf.superclasses.DwarfItem;
import net.minecraft.server.v1_12_R1.NBTTagCompound;
import net.minecraft.server.v1_12_R1.NBTTagDouble;
import net.minecraft.server.v1_12_R1.NBTTagInt;
import net.minecraft.server.v1_12_R1.NBTTagList;
import net.minecraft.server.v1_12_R1.NBTTagString;

public class MightyPickaxe extends DwarfItem{

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

		net.minecraft.server.v1_12_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
		NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();
		NBTTagList modifiers = new NBTTagList();

		NBTTagCompound attackDamage = new NBTTagCompound();
		attackDamage.set("AttributeName", new NBTTagString("generic.attackDamage"));
		attackDamage.set("Name", new NBTTagString("generic.attackDamage"));
		attackDamage.set("Amount", new NBTTagInt(4));
		attackDamage.set("Operation", new NBTTagInt(0));
		attackDamage.set("UUIDLeast", new NBTTagInt(894654));
		attackDamage.set("UUIDMost", new NBTTagInt(2872));
		attackDamage.set("Slot", new NBTTagString("mainhand"));
		
		NBTTagCompound attackSpeed = new NBTTagCompound();
		attackSpeed.set("AttributeName", new NBTTagString("generic.attackSpeed"));
		attackSpeed.set("Name", new NBTTagString("generic.attackSpeed"));
		attackSpeed.set("Amount", new NBTTagDouble(1.4));
		attackSpeed.set("Operation", new NBTTagInt(0));
		attackSpeed.set("UUIDLeast", new NBTTagInt(894654));
		attackSpeed.set("UUIDMost", new NBTTagInt(2872));
		attackSpeed.set("Slot", new NBTTagString("mainhand"));

		modifiers.add(attackDamage);
		modifiers.add(attackSpeed);
		compound.set("AttributeModifiers", modifiers);
		nmsStack.setTag(compound);
		
		item = CraftItemStack.asBukkitCopy(nmsStack);
		
		return item;
	}

}
