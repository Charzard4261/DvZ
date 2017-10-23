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
import dwarves.vs.zombies.monsters.weapons.Club;

public class Ogre extends MonsterClass {

	public Ogre(UUID uuid)
	{
		super(uuid);
		weapons.add(new Club(uuid));
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

			NBTTagCompound health = new NBTTagCompound();
			health.set("AttributeName", new NBTTagString("generic.maxHealth"));
			health.set("Name", new NBTTagString("generic.maxHealth"));
			health.set("Amount", new NBTTagDouble(100));
			health.set("Operation", new NBTTagInt(0));
			health.set("UUIDLeast", new NBTTagInt(894654));
			health.set("UUIDMost", new NBTTagInt(2872));
			modifiers.add(health);
			
			NBTTagCompound kb = new NBTTagCompound();
			kb.set("AttributeName", new NBTTagString("generic.knockbackResistance"));
			kb.set("Name", new NBTTagString("generic.knockbackResistance"));
			kb.set("Amount", new NBTTagInt(1));
			kb.set("Operation", new NBTTagInt(0));
			kb.set("UUIDLeast", new NBTTagInt(894654));
			kb.set("UUIDMost", new NBTTagInt(2872));
			modifiers.add(kb);

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
