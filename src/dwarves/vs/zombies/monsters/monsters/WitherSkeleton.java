package dwarves.vs.zombies.monsters.monsters;

import java.util.UUID;

import net.minecraft.server.v1_11_R1.NBTTagCompound;
import net.minecraft.server.v1_11_R1.NBTTagDouble;
import net.minecraft.server.v1_11_R1.NBTTagInt;
import net.minecraft.server.v1_11_R1.NBTTagList;
import net.minecraft.server.v1_11_R1.NBTTagString;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_11_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

import dwarves.vs.zombies.Weapon;
import dwarves.vs.zombies.monsters.MonsterClass;
import dwarves.vs.zombies.monsters.weapons.NetherBow;

public class WitherSkeleton extends MonsterClass {

	public WitherSkeleton(UUID uuid)
	{
		super(uuid);
		weapons.add(new NetherBow(uuid)); 
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

			NBTTagCompound health = new NBTTagCompound();
			health.set("AttributeName", new NBTTagString("generic.maxHealth"));
			health.set("Name", new NBTTagString("generic.maxHealth"));
			health.set("Amount", new NBTTagDouble(20));
			health.set("Operation", new NBTTagInt(0));
			health.set("UUIDLeast", new NBTTagInt(894654));
			health.set("UUIDMost", new NBTTagInt(2872));
			modifiers.add(health);

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

}