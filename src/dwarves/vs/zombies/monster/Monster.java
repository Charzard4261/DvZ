package dwarves.vs.zombies.monster;

import org.bukkit.entity.LivingEntity;

public abstract class Monster {

	private LivingEntity entity;
	private boolean canBeProcced;
	
	public Monster (LivingEntity entity, boolean canBeProcced)
	{
		this.entity = entity;
		this.canBeProcced = canBeProcced;
	}

	public LivingEntity getEntity()
	{
		return entity;
	}

	public boolean canBeProcced()
	{
		return canBeProcced;
	}

}
