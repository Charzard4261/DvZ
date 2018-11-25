package dwarves.vs.zombies.dwarf;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
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
	private int proc = 0;
	private ProcTimer proctimer;

	public boolean sword = false, bow = false, ale = false, special = false;
	public int swordt = 0, bowt = 0, alet = 0, specialt = 0, slabt = 0;

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

	public abstract HashMap<ItemStack, DwarfSword> getSwords();

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
		getPlayer().getWorld().spawnParticle(Particle.VILLAGER_HAPPY, getPlayer().getEyeLocation(), 50, 0.3, 0.6, 0.3,
				1);
		proc = 3;
		getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 40, 0, false, false), true);
		getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 40, 2, false, false), true);

		if (proctimer == null)
		{
			proctimer = new ProcTimer();
			proctimer.setId(Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.getInstance(), proctimer, 0, 20));
		}

	}

	public void proc(int time)
	{
		getPlayer().getWorld().playSound(getPlayer().getLocation(), "wpnproc", 4f, 1f);
		getPlayer().getWorld().spawnParticle(Particle.VILLAGER_HAPPY, getPlayer().getEyeLocation(), 50, 0.3, 0.6, 0.3,
				1);
		proc = time;
		getPlayer().addPotionEffect(
				new PotionEffect(PotionEffectType.INCREASE_DAMAGE, (time - 1) * 20, 0, false, false), true);
		getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, (time - 1) * 20, 2, false, false), true);
		
		if (proctimer == null)
		{
			proctimer = new ProcTimer();
			proctimer.setId(Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.getInstance(), proctimer, 0, 20));
		}
	}

	public class ProcTimer implements Runnable {

		private int id;

		@Override
		public void run()
		{
			if (proc <= 0)
			{
				Bukkit.getScheduler().cancelTask(id);
			}

			proc--;
		}

		public void setId(int id)
		{
			this.id = id;
		}
	}

	public boolean isProccing()
	{
		return proc > 0;
	}

	public void giveKill()
	{
		Core.getInstance().getGm().addKill();
	}

	public void replaceDwarf(Dwarf dwarf)
	{
		proc = 0;
		bowt = 0;
		alet = 0;
		specialt = 0;

		getPlayer().getInventory().clear();

		Core.getInstance().getGm().dwarves.replace(uuid, dwarf);
	}

	public void killDwarf()
	{
		swordt = 0;
		bowt = 0;
		alet = 0;
		specialt = 0;

		getPlayer().getInventory().clear();
		getPlayer().setDisplayName(ChatColor.GRAY + getPlayer().getCustomName());
		getPlayer().setPlayerListName(ChatColor.GRAY + getPlayer().getDisplayName());

		Core.getInstance().getGm().dwarves.remove(getPlayer().getUniqueId());
		Core.getInstance().getGm().monsters.put(uuid, new MData(uuid));

		if (Core.getInstance().getGm().dwarves.size() <= 0)
			Core.getInstance().end();
	}
}
