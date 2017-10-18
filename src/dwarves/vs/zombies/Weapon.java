package dwarves.vs.zombies;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public abstract class Weapon {

	boolean proc = false;
	boolean rolls = false;
	
	public Weapon(boolean canProc, boolean rollsProc)
	{
		this.proc = canProc;
		this.rolls = rollsProc;
	}
	
	public abstract ItemStack getItem();
	
	public abstract void setPlayer(Player player);
	
	public abstract void normal();
	
	public abstract void special();
	
	public abstract void damage(EntityDamageByEntityEvent event);
	
}
