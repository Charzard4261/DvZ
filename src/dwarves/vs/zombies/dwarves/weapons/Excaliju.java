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

public class Excaliju extends Weapon {

	Player player;
	boolean usedSpecial = false;
	int timer = 0;

	public Excaliju(Player player)
	{
		super(true, true);
		this.player = player;
	}

	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 2);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.GOLD + "Excaliju");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Broken and reforged over a thousand times, a");
		lore.add("sword made of gold is said to be weaker than");
		lore.add("typical runebaldes, but the Old Man claims he");
		lore.add("just wants to give the monsters a better chance.");
		lore.add("Personally, I think he's straight bonkers.");
		lore.add(ChatColor.GOLD + "- Deadbones");
		meta.setLore(lore);
		item.setItemMeta(meta);

		net.minecraft.server.v1_11_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
		NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();

		NBTTagList modifiers = new NBTTagList();
		{
			NBTTagCompound damage = new NBTTagCompound();
			damage.set("AttributeName", new NBTTagString("generic.attackDamage"));
			damage.set("Name", new NBTTagString("generic.attackDamage"));
			damage.set("Amount", new NBTTagInt(25));
			damage.set("Operation", new NBTTagInt(0));
			damage.set("UUIDLeast", new NBTTagInt(894654));
			damage.set("UUIDMost", new NBTTagInt(2872));
			damage.set("Slot", new NBTTagString("mainhand"));
			modifiers.add(damage);

			NBTTagCompound kb = new NBTTagCompound();
			kb.set("AttributeName", new NBTTagString("generic.knockbackResistance"));
			kb.set("Name", new NBTTagString("generic.knockbackResistance"));
			kb.set("Amount", new NBTTagInt(1));
			kb.set("Operation", new NBTTagInt(0));
			kb.set("UUIDLeast", new NBTTagInt(894654));
			kb.set("UUIDMost", new NBTTagInt(2872));
			kb.set("Slot", new NBTTagString("mainhand"));
			modifiers.add(kb);
		}
		
		compound.set("AttributeModifiers", modifiers);

		NBTTagList ench = new NBTTagList();
		NBTTagCompound enchant = new NBTTagCompound();
		enchant.set("id", new NBTTagInt(34));
		enchant.set("lvl", new NBTTagInt(10));
		ench.add(enchant);
		compound.set("ench", ench);

		nmsStack.setTag(compound);

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
			player.sendMessage(ChatColor.DARK_AQUA + "Spell is on cooldown: " + timer
					+ " seconds remaining.");
			return;
		}

		usedSpecial = true;

		player.playSound(player.getLocation(), "runebladeRunedash", 4F, 1F);
		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5, 3, false, false), false);
		player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 5, 255, false,
				false), false);
		player.setVelocity(player.getLocation().getDirection().multiply(2));

		timer = 15;

		dashTimer task = new dashTimer();
		task.setId(Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.getInstance(), task, 0, 20));

	}

	private class dashTimer implements Runnable {

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