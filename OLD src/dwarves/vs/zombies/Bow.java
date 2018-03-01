package dwarves.vs.zombies;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;

public abstract class Bow extends Weapon {

	public Bow(UUID uuid)
	{
		super(uuid, false, false);
	}

	public ArrayList<Entity> shotprojectiledata = new ArrayList<Entity>();

	public abstract ItemStack getItem();

	public abstract void onFire(EntityShootBowEvent event);

	public abstract void onHit(EntityDamageByEntityEvent event);

	@Override
	public void normal()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void special()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void damage(EntityDamageByEntityEvent event)
	{
		// TODO Auto-generated method stub
		
	}

}
