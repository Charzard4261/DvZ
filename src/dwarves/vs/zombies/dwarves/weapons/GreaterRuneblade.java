package dwarves.vs.zombies.dwarves.weapons;

import java.util.ArrayList;

import net.minecraft.server.v1_11_R1.NBTTagCompound;
import net.minecraft.server.v1_11_R1.NBTTagInt;
import net.minecraft.server.v1_11_R1.NBTTagList;
import net.minecraft.server.v1_11_R1.NBTTagString;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_11_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import dwarves.vs.zombies.Core;
import dwarves.vs.zombies.Weapon;
import dwarves.vs.zombies.dwarves.Dwarf;
import dwarves.vs.zombies.dwarves.DwarfSpecialTimer;

public class GreaterRuneblade extends Weapon {

	public GreaterRuneblade()
	{
		super(true, true);
	}

	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 3);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA + "Greater Runeblade");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GOLD + "With this Blade, killing demons grants you a Powerful");
		lore.add(ChatColor.GOLD + "Rampage for 3 seconds with allows you to instantly");
		lore.add(ChatColor.GOLD + "kill most demons. Right Click to Runedash which dashes");
		lore.add(ChatColor.GOLD + "you forward making you breifly immune to damage and");
		lore.add(ChatColor.GOLD + "granting you a Powerfull Rampage for 0.5 seconds.");
		meta.setLore(lore);
		item.setItemMeta(meta);

		net.minecraft.server.v1_11_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
		NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();
		NBTTagList modifiers = new NBTTagList();
		NBTTagCompound damage = new NBTTagCompound();
		damage.set("AttributeName", new NBTTagString("generic.attackDamage"));
		damage.set("Name", new NBTTagString("generic.attackDamage"));
		damage.set("Amount", new NBTTagInt(15));
		damage.set("Operation", new NBTTagInt(0));
		damage.set("UUIDLeast", new NBTTagInt(894654));
		damage.set("UUIDMost", new NBTTagInt(2872));
		damage.set("Slot", new NBTTagString("mainhand"));
		modifiers.add(damage);
		
		NBTTagCompound attackSpeed = new NBTTagCompound();
		attackSpeed.set("AttributeName", new NBTTagString("generic.attackSpeed"));
		attackSpeed.set("Name", new NBTTagString("generic.attackSpeed"));
		attackSpeed.set("Amount", new NBTTagInt(4));
		attackSpeed.set("Operation", new NBTTagInt(0));
		attackSpeed.set("UUIDLeast", new NBTTagInt(894654));
		attackSpeed.set("UUIDMost", new NBTTagInt(2872));
		attackSpeed.set("Slot", new NBTTagString("mainhand"));
		modifiers.add(attackSpeed);
		
		compound.set("AttributeModifiers", modifiers);

		nmsStack.setTag(compound);

		item = CraftItemStack.asBukkitCopy(nmsStack);

		return item;
	}

	@Override
	public void normal(Dwarf dwarf)
	{

	}

	@Override
	public void special(Dwarf dwarf)
	{
		if (dwarf.usedSpecial)
		{
			dwarf.getPlayer().sendMessage(ChatColor.DARK_AQUA + "You must wait " + dwarf.specialTimer
					+ " more seconds to do that.");
			return;
		}
		dwarf.usedSpecial = true;

		dwarf.getPlayer().playSound(dwarf.getPlayer().getLocation(), "runebladeRunedash", 4F, 1F);
		dwarf.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5, 3, false, false), false);
		dwarf.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 5, 255, false,
				false), false);
		dwarf.getPlayer().setVelocity(dwarf.getPlayer().getLocation().getDirection().multiply(2));

		dwarf.specialTimer = 15;
		
		DwarfSpecialTimer task = new DwarfSpecialTimer();
		task.setDwarf(dwarf);
		task.setId(Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.getInstance(), task, 0, 20));

	}

}
