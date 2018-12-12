package dwarves.vs.zombies.dwarf.superclasses;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import dwarves.vs.zombies.Core;
import dwarves.vs.zombies.dwarf.Dwarf;
import dwarves.vs.zombies.misc.Utils;
import dwarves.vs.zombies.misc.generics.GenericTimer;

public abstract class DwarfSword {

	private Dwarf dwarf;
	private int timerMax, currentTime = 0;
	public boolean canUse = true;

	public boolean rollsProcs;

	public DwarfSword(Dwarf dwarf, int timer, boolean rollsProcs)
	{
		this.dwarf = dwarf;
		this.timerMax = timer;
		this.rollsProcs = rollsProcs;
	}

	public Dwarf getDwarf()
	{
		return dwarf;
	}

	public void rightClick(PlayerInteractEvent event)
	{
		if (!canUse)
		{
			getDwarf().getPlayer().sendMessage(ChatColor.DARK_AQUA + "You must wait " + currentTime + " more seconds to do that.");
			return;
		}

		if (special(event))
		{
			currentTime = timerMax;
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
					currentTime--;
				}
			};
			task.setId(Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.getInstance(), task, 0, 20));
		}
	}

	public void rightClick(PlayerInteractAtEntityEvent event)
	{
		if (!canUse)
		{
			getDwarf().getPlayer().sendMessage(ChatColor.DARK_AQUA + "You must wait " + currentTime + " more seconds to do that.");
			return;
		}

		if (special(event))
		{
			currentTime = timerMax;
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
					currentTime--;
				}
			};
			task.setId(Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.getInstance(), task, 0, 20));
		}
	}

	public abstract ItemStack getItem();

	protected abstract void leftClick(PlayerInteractEvent event);

	protected abstract void onHit(EntityDamageByEntityEvent event);

	protected abstract boolean special(PlayerInteractEvent event);

	protected abstract boolean special(PlayerInteractAtEntityEvent event);
}
