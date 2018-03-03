package dwarves.vs.zombies.dwarf.superclasses;

import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import dwarves.vs.zombies.dwarf.Dwarf;

public abstract class DwarfAle {

	private Dwarf dwarf;
	private boolean auto;

	public DwarfAle(Dwarf dwarf, boolean auto)
	{
		this.dwarf = dwarf;
		this.auto = auto;
	}

	public Dwarf getDwarf()
	{
		return dwarf;
	}

	public boolean isAuto()
	{
		return auto;
	}

	public abstract ItemStack getItem();

	public abstract void onLeftClick(PlayerInteractEvent event);

	public abstract void onRightClick(PlayerInteractEvent event);

	public void onAuto()
	{
		
	}

}
