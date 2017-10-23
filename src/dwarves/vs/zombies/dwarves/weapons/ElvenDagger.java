package dwarves.vs.zombies.dwarves.weapons;

import java.util.ArrayList;
import java.util.UUID;

import net.minecraft.server.v1_11_R1.NBTTagCompound;
import net.minecraft.server.v1_11_R1.NBTTagDouble;
import net.minecraft.server.v1_11_R1.NBTTagInt;
import net.minecraft.server.v1_11_R1.NBTTagList;
import net.minecraft.server.v1_11_R1.NBTTagString;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_11_R1.inventory.CraftItemStack;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.Core;
import dwarves.vs.zombies.Weapon;

public class ElvenDagger extends Weapon {

	boolean usedSpecial = false;
	int timer = 0;

	public ElvenDagger(UUID uuid)
	{
		super(uuid, true, true);
	}

	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 4);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA + "Elven Dagger");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + "Power: " + ChatColor.AQUA + "15");
		lore.add(ChatColor.YELLOW + "With this Dagger, you move more quickly and your");
		lore.add(ChatColor.YELLOW + "hits poison demons for 5 seconds. Right Click to");
		lore.add(ChatColor.YELLOW + "Eviserate which deals massive damage killing most");
		lore.add(ChatColor.YELLOW + "demons. This ability has a 60 second cooldown that");
		lore.add(ChatColor.YELLOW + "is reduced by 10 seconds for every bow kill.");
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
		modifiers.add(damage);

		NBTTagCompound speed = new NBTTagCompound();
		speed.set("AttributeName", new NBTTagString("generic.movementSpeed"));
		speed.set("Name", new NBTTagString("generic.movementSpeed"));
		speed.set("Amount", new NBTTagDouble(0.8));
		speed.set("Operation", new NBTTagInt(0));
		speed.set("UUIDLeast", new NBTTagInt(894654));
		speed.set("UUIDMost", new NBTTagInt(2872));
		modifiers.add(speed);
		
		NBTTagCompound attackSpeed = new NBTTagCompound();
		attackSpeed.set("AttributeName", new NBTTagString("generic.attackSpeed"));
		attackSpeed.set("Name", new NBTTagString("generic.attackSpeed"));
		attackSpeed.set("Amount", new NBTTagInt(8));
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
	public void normal()
	{

	}

	@Override
	public void special()
	{
		if (usedSpecial)
		{
			getPlayer().sendMessage(ChatColor.DARK_AQUA + "You must wait " + timer
					+ " more seconds to do that.");
			return;
		}
		usedSpecial = true;

		getPlayer().playSound(getPlayer().getLocation(), "runebladeRunedash", 4F, 1F);

		timer = 60;
		EviserateTimer task = new EviserateTimer();
		task.setId(Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.getInstance(), task, 0, 20));

	}

	private class EviserateTimer implements Runnable {

		private int id;

		@Override
		public void run()
		{
			if (timer == 0)
			{
				usedSpecial = false;
				Bukkit.getScheduler().cancelTask(id);
			}

			timer -= 1;
		}

		public void setId(int id)
		{
			this.id = id;
		}

	}

	@Override
	public void damage(EntityDamageByEntityEvent event)
	{   
		Player hit = (Player) event.getEntity();
		hit.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 6, 3, false, false), false); //not sure if this is the right amount
	}

}
