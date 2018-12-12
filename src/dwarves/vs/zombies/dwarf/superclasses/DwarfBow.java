package dwarves.vs.zombies.dwarf.superclasses;

import org.bukkit.Bukkit;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;

import dwarves.vs.zombies.Core;
import dwarves.vs.zombies.dwarf.Dwarf;
import dwarves.vs.zombies.misc.Utils;
import dwarves.vs.zombies.misc.generics.GenericProjectileLauncher;
import dwarves.vs.zombies.misc.generics.GenericTimer;

public abstract class DwarfBow implements GenericProjectileLauncher {

	private Dwarf dwarf;
	private int timerMax;
	public boolean canUse = true;

	public DwarfBow(Dwarf dwarf, int timer)
	{
		this.dwarf = dwarf;
		this.timerMax = timer;
	}

	public Dwarf getDwarf()
	{
		return dwarf;
	}

	public void shootBowEvent(EntityShootBowEvent event)
	{
		onFire(event);
	}

	@Override
	public void entityHitEvent(EntityDamageByEntityEvent event)
	{
		if (canUse)
		{
			GenericTimer task = new GenericTimer(timerMax) {

				@Override
				public void onTimerComplete()
				{
					canUse = true;
					dwarf.getPlayer().sendMessage(Utils.getMessageFormatCanUse(""));
				}

				@Override
				public void onTimerDecrease()
				{
				}
			};
			task.setId(Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.getInstance(), task, 0, 20));
		}
	}

	public abstract ItemStack getItem();

	protected abstract void onFire(EntityShootBowEvent event);

	protected abstract boolean onHit(EntityDamageByEntityEvent event);
}
