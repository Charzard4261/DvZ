package dwarves.vs.zombies;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public abstract class Weapon {

//	public Player player;
	public UUID uuid;
	boolean proc = false;
	boolean rolls = false;
	
	public Weapon(Player player, boolean canProc, boolean rollsProc)
	{
		this.uuid = player.getUniqueId();
		this.proc = canProc;
		this.rolls = rollsProc;
	}
	
	public Player getPlayer()
	{
		return Bukkit.getPlayer(uuid);
	}
	
	public abstract ItemStack getItem();
	
	public abstract void normal();
	
	public abstract void special();
	
	public abstract void damage(EntityDamageByEntityEvent event);
	
}
