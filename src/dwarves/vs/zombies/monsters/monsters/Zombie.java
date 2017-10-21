package dwarves.vs.zombies.monsters.monsters;

import java.util.UUID;

import net.minecraft.server.v1_11_R1.NBTTagCompound;
import net.minecraft.server.v1_11_R1.NBTTagDouble;
import net.minecraft.server.v1_11_R1.NBTTagInt;
import net.minecraft.server.v1_11_R1.NBTTagList;
import net.minecraft.server.v1_11_R1.NBTTagString;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_11_R1.inventory.CraftItemStack;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import dwarves.vs.zombies.Weapon;
import dwarves.vs.zombies.monsters.MonsterClass;

public class Zombie extends MonsterClass {

	private Weapon[] weapons = new Weapon[] {};

	public Zombie(UUID uuid)
	{
		super(uuid);
	}

	@Override
	public void equipItems()
	{
		//
		//
		// Armour
		//
		//
		{
			ItemStack item = new ItemStack(Material.SLIME_BALL);

			net.minecraft.server.v1_11_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
			NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();
			NBTTagList modifiers = new NBTTagList();

			NBTTagCompound speed = new NBTTagCompound();
			speed.set("AttributeName", new NBTTagString("generic.movementSpeed"));
			speed.set("Name", new NBTTagString("generic.movementSpeed"));
			speed.set("Amount", new NBTTagDouble(0.8));
			speed.set("Operation", new NBTTagInt(0));
			speed.set("UUIDLeast", new NBTTagInt(894654));
			speed.set("UUIDMost", new NBTTagInt(2872));
			modifiers.add(speed);

			compound.set("AttributeModifiers", modifiers);
			nmsStack.setTag(compound);
			item = CraftItemStack.asBukkitCopy(nmsStack);

			ItemStack air = new ItemStack(Material.AIR);

			getPlayer().getInventory().setArmorContents(new ItemStack[] { air, item, air, air });
		}
		//
		//
		// Weapons
		//
		//
		{
			for (Weapon w : weapons)
				getPlayer().getInventory().addItem(w.getItem());
		}
	}

	@Override
	public void onLeftClick(PlayerInteractEvent event)
	{
		for (Weapon w : weapons)
			if (event.getItem() == w.getItem())
			{

			}
	}

	@Override
	public void onRightClick(PlayerInteractEvent event)
	{
		for (Weapon w : weapons)
			if (event.getItem() == w.getItem())
			{

			}
	}

}
