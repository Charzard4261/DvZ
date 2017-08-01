package dwarves.vs.zombies;

import org.bukkit.inventory.ItemStack;

import dwarves.vs.zombies.dwarves.Dwarf;

public abstract class Weapon {

	boolean proc = false;
	boolean rolls = false;
	
	public Weapon(boolean canProc, boolean rollsProc)
	{
		this.proc = canProc;
		this.rolls = rollsProc;
	}
	
	public abstract ItemStack getItem();
	
	public abstract void normal(Dwarf dwarf);
	
	public abstract void special(Dwarf dwarf);
	
}
