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
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import dwarves.vs.zombies.Core;
import dwarves.vs.zombies.Weapon;

public class AxeOfMalice extends Weapon {

	Player player;
	boolean usedSpecial = false;
	int timer = 0;

	public AxeOfMalice(Player player)
	{
		super(true, true);
		this.player = player;
	}

	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 3);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA + "Axe Of Malice");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + "Power: " + ChatColor.AQUA + "20");
		lore.add(ChatColor.YELLOW + "With this Axe, you can Right Click to grant yourself a");
		lore.add(ChatColor.YELLOW + "Powerful Rampage for 8 seconds. Additional kills while");
		lore.add(ChatColor.YELLOW + "on a rampage will allow you to extend the duration.");
		lore.add(ChatColor.YELLOW + "This ability has a 60 second cooldown that is reduced");
		lore.add(ChatColor.YELLOW + "by 1 for every kill or 4 seconds for bow kills.");
		meta.setLore(lore);
		item.setItemMeta(meta);

		net.minecraft.server.v1_11_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
		NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();
		NBTTagList modifiers = new NBTTagList();
		NBTTagCompound damage = new NBTTagCompound();
		damage.set("AttributeName", new NBTTagString("generic.attackDamage"));
		damage.set("Name", new NBTTagString("generic.attackDamage"));
		damage.set("Amount", new NBTTagInt(20));
		damage.set("Operation", new NBTTagInt(0));
		damage.set("UUIDLeast", new NBTTagInt(894654));
		damage.set("UUIDMost", new NBTTagInt(2872));
		modifiers.add(damage);
		nmsStack.setTag(compound);
		
		NBTTagCompound attackSpeed = new NBTTagCompound();
		attackSpeed.set("AttributeName", new NBTTagString("generic.attackSpeed"));
		attackSpeed.set("Name", new NBTTagString("generic.attackSpeed"));
		attackSpeed.set("Amount", new NBTTagInt(4));
		attackSpeed.set("Operation", new NBTTagInt(0));
		attackSpeed.set("UUIDLeast", new NBTTagInt(894654));
		attackSpeed.set("UUIDMost", new NBTTagInt(2872));
		attackSpeed.set("Slot", new NBTTagString("mainhand"));
		modifiers.add(attackSpeed);

		item = CraftItemStack.asBukkitCopy(nmsStack);

		return item;
	}

	@Override
	public void setPlayer(Player player)
	{
		this.player = player;
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
			player.sendMessage(ChatColor.DARK_RED + "YOU MUST WAIT " + timer
					+ " SECONDS BEFORE YOU USE MY POWER.");
			return;
		}

		usedSpecial = true;

		player.playSound(player.getLocation(), "maliceUse", 4F, 1F);
		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 160, 2, false, false),
				false);
		player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 160, 0, false,
				false), false);

		timer = 60;

		axeofmaliceTimer task = new axeofmaliceTimer();
		task.setId(Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.getInstance(), task, 0, 20));

	}

	private class axeofmaliceTimer implements Runnable {

		private int id;

		@Override
		public void run()
		{
			timer -= 1;

			if (timer == 0)
			{
				usedSpecial = false;
				Bukkit.getScheduler().cancelTask(id);
			}
		}

		public void setId(int id)
		{
			this.id = id;
		}

	}

}
