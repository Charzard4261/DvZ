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

import dwarves.vs.zombies.monsters.MonsterClass;
import dwarves.vs.zombies.monsters.weapons.MakeshiftPickaxe;

public class Zombie extends MonsterClass {

	/**
	 * THIS CLASS IS UNIQUE AND SHOULD NOT BE COPIED
	 **/

	private MakeshiftPickaxe weapon;

	public Zombie(UUID uuid)
	{
		super(uuid);
		weapons.add(weapon);
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
			ArrayList<String> lore = new ArrayList<String>();
		        lore.add(ChatColor.RED + "Made from the bones of dead dwarves");
		        meta.setLore(lore);

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
			getPlayer().getInventory().addItem(weapon.getItem());
		}
	}

}
