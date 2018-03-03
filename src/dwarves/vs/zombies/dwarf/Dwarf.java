package dwarves.vs.zombies.dwarf;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import dwarves.vs.zombies.Core;
import dwarves.vs.zombies.dwarf.superclasses.DwarfAle;
import dwarves.vs.zombies.dwarf.superclasses.DwarfBow;
import dwarves.vs.zombies.dwarf.superclasses.DwarfSpecial;
import dwarves.vs.zombies.dwarf.superclasses.DwarfSword;
import dwarves.vs.zombies.misc.ArmourSet;
import dwarves.vs.zombies.misc.PlayerType;
import dwarves.vs.zombies.monster.MData;

public abstract class Dwarf extends PlayerType {

	private UUID uuid;

	public boolean dcd = false;
	public int proc = 0;

	public boolean sword = false, bow = false, ale = false, special = false;
	public int swordt = 0, bowt = 0, alet = 0, specialt = 0;

	public int mana = 1000;

	public Dwarf(UUID uuid)
	{
		this.uuid = uuid;
	}

	public Player getPlayer()
	{
		return Bukkit.getPlayer(uuid);
	}

	public boolean modifyMana(int amount)
	{
		if (mana + amount > 0)
			return false;
		
		if (mana + amount <= 1000)
		{
			mana += amount;
			getPlayer().setLevel(mana);
			getPlayer().setExp(mana / 1000);
		} else
			mana = 1000;
		
		return true;

	}

	public abstract DwarfSword getSword();

	public abstract DwarfBow getBow();

	public abstract DwarfAle getAle();

	public abstract DwarfSpecial getSpecial();

	public abstract ArmourSet getArmour();

	public void useSword(int timer)
	{
		sword = true;
		swordt = timer;

		SwordTimer task = new SwordTimer();
		task.setId(Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.getInstance(), task, 0, 20));
	}

	public class SwordTimer implements Runnable {

		private int id;

		@Override
		public void run()
		{
			if (swordt <= 0)
			{
				sword = false;
				Bukkit.getScheduler().cancelTask(id);
			}

			swordt--;
		}

		public void setId(int id)
		{
			this.id = id;
		}
	}

	public void useBow(int timer, boolean activate)
	{
		if (!activate)
			return;

		bow = true;
		bowt = timer;

		BowTimer task = new BowTimer();
		task.setId(Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.getInstance(), task, 0, 20));
	}

	public class BowTimer implements Runnable {

		private int id;

		@Override
		public void run()
		{
			System.out.println("" + bowt);
			if (bowt <= 0)
			{
				bow = false;
				Bukkit.getScheduler().cancelTask(id);
			}

			bowt--;
		}

		public void setId(int id)
		{
			this.id = id;
		}
	}

	public void proc()
	{
		getPlayer().getWorld().playSound(getPlayer().getLocation(), "wpnproc", 4f, 1f);
		proc = 3;
		getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 60, 255, false, false), true);
		getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 2, false, false), true);
	}

	public void proc(int time)
	{
		getPlayer().getWorld().playSound(getPlayer().getLocation(), "wpnproc", 4f, 1f);
		proc = time;
		getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, time * 20, 0, false, false),
				true);
		getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, time * 20, 2, false, false), true);
	}

	public boolean isProccing()
	{
		return proc > 0;
	}

	public void giveKill()
	{
		Core.getInstance().getGm().addKill();
	}

	public void killDwarf()
	{
		swordt = 0;
		bowt = 0;
		alet = 0;
		specialt = 0;

		getPlayer().getInventory().clear();
		getPlayer().setDisplayName(ChatColor.DARK_RED + getPlayer().getCustomName());
		getPlayer().setPlayerListName(ChatColor.DARK_RED + getPlayer().getDisplayName());

		Core.getInstance().getGm().dwarves.remove(getPlayer().getUniqueId());
		Core.getInstance().getGm().monsters.put(uuid, new MData(uuid));

		if (Core.getInstance().getGm().dwarves.size() <= 0)
			Core.getInstance().end();
	}
}
