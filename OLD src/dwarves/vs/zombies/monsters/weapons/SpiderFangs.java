package dwarves.vs.zombies.monsters.weapons;

import java.util.ArrayList;
import java.util.UUID;

import net.minecraft.server.v1_11_R1.NBTTagCompound;
import net.minecraft.server.v1_11_R1.NBTTagInt;
import net.minecraft.server.v1_11_R1.NBTTagList;
import net.minecraft.server.v1_11_R1.NBTTagString;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_11_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import dwarves.vs.zombies.Weapon;

public class SpiderFangs extends Weapon {

	public SpiderFangs(UUID uuid)
	{
		super(uuid, false, false);
	}

	@Override
	public ItemStack getItem()
	{

		ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 2);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.RED + "Spider Fangs");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.AQUA + "Left click to poison nearby Dwarves");
		lore.add(ChatColor.AQUA + "and right click to spraw poison that");
		lore.add(ChatColor.AQUA + "corrodes walls it touches.");
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

		return null;
	}

	@Override
	public void normal()
	{
		// THIS FIRES WHEN THE PLAYER PUNCHES

	}

	@Override
	public void special()
	{
		// THIS IS USE SPECIAL, AKA LEAP

	}

	@Override
	public void damage(EntityDamageByEntityEvent event)
	{
		Player hit = (Player) event.getEntity();
		hit.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 6, 2, false, false), false);
	}

}
