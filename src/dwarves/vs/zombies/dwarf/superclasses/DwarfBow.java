package dwarves.vs.zombies.dwarf.superclasses;

import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;

import dwarves.vs.zombies.dwarf.Dwarf;

public abstract class DwarfBow {

	private Dwarf dwarf;
	private int timer;

	public DwarfBow(Dwarf dwarf, int timer)
	{
		this.dwarf = dwarf;
		this.timer = timer;
	}

	public Dwarf getDwarf()
	{
		return dwarf;
	}

	public void shootBowEvent(EntityShootBowEvent event)
	{
		onFire(event);
	}

	public void entityHitEvent(EntityDamageByEntityEvent event)
	{
		if (!dwarf.bow)
		{
			dwarf.useBow(timer, onHit(event));
		}
	}

	public abstract ItemStack getItem();

	protected abstract void onFire(EntityShootBowEvent event);

	protected abstract boolean onHit(EntityDamageByEntityEvent event);
}
