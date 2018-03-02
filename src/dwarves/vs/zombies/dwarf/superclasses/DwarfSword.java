package dwarves.vs.zombies.dwarf.superclasses;

import org.bukkit.ChatColor;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import dwarves.vs.zombies.dwarf.Dwarf;

public abstract class DwarfSword {

	private Dwarf dwarf;
	private int timer;
	
	public boolean rollsProcs;

	public DwarfSword(Dwarf dwarf, int timer, boolean rollsProcs)
	{
		this.dwarf = dwarf;
		this.timer = timer;
		this.rollsProcs = rollsProcs;
	}

	public Dwarf getDwarf()
	{
		return dwarf;
	}

	public void rightClick(PlayerInteractEvent event)
	{

		if (dwarf.sword)
		{
			getDwarf().getPlayer()
					.sendMessage(ChatColor.DARK_AQUA + "You must wait " + dwarf.swordt + " more seconds to do that.");
			return;
		}

		if (special(event))
			dwarf.useSword(timer);
	}

	public void rightClick(PlayerInteractAtEntityEvent event)
	{

		if (dwarf.sword)
		{
			getDwarf().getPlayer()
					.sendMessage(ChatColor.DARK_AQUA + "You must wait " + dwarf.swordt + " more seconds to do that.");
			return;
		}

		if (special(event))
			dwarf.useSword(timer);

	}

	public abstract ItemStack getItem();

	protected abstract void leftClick(PlayerInteractEvent event);

	protected abstract void onHit(EntityDamageByEntityEvent event);

	protected abstract boolean special(PlayerInteractEvent event);

	protected abstract boolean special(PlayerInteractAtEntityEvent event);
}
