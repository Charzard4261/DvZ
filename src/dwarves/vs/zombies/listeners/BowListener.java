package dwarves.vs.zombies.listeners;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

import dwarves.vs.zombies.Core;
import dwarves.vs.zombies.dwarf.Dwarf;
import dwarves.vs.zombies.enums.ProjectileType;
import dwarves.vs.zombies.misc.ProjectileData;

public class BowListener implements Listener {

	@EventHandler
	public void fireBowEvent(EntityShootBowEvent event)
	{
		if (!(event.getEntity() instanceof Player))
			return;

		if (Core.getInstance().getGm().dwarves.containsKey(((Player) event.getEntity()).getUniqueId()))
		{
			if (event.getBow().equals(Core.getInstance().getGm().dwarves.get(((Player) event.getEntity()).getUniqueId())
					.getBow().getItem()))
			{
				Core.getInstance().getGm().projectiles.put(event.getProjectile().getUniqueId(),
						new ProjectileData(
								Core.getInstance().getGm().dwarves.get(((Player) event.getEntity()).getUniqueId()),
								ProjectileType.BOW));
				Core.getInstance().getGm().dwarves.get(((Player) event.getEntity()).getUniqueId()).getBow()
						.shootBowEvent(event);
			}
		} else if (Core.getInstance().getGm().monsters.containsKey(((Player) event.getEntity()).getUniqueId()))
		{

		}
	}

	@EventHandler
	public void onEntityHitByArrow(EntityDamageByEntityEvent event)
	{
		if (!(event.getDamager() instanceof Arrow))
			return;

		if (Core.getInstance().getGm().projectiles.containsKey(event.getDamager().getUniqueId()))
		{
			if (Core.getInstance().getGm().projectiles.get(event.getDamager().getUniqueId()).type instanceof Dwarf)
			{
				if (Core.getInstance().getGm().projectiles
						.get(event.getDamager().getUniqueId()).projectileType == ProjectileType.BOW)
				{
					((Dwarf) Core.getInstance().getGm().projectiles.get(event.getDamager().getUniqueId()).type).getBow()
							.entityHitEvent(event);
					Core.getInstance().getGm().projectiles.remove(event.getDamager().getUniqueId());
				}
			}
		}
	}

	@EventHandler
	public void onProjectileLand(ProjectileHitEvent event)
	{
		if (Core.getInstance().getGm().projectiles.containsKey(event.getEntity().getUniqueId()))
		{
			if (event.getHitEntity() == null)
			{
				event.getEntity().remove();
			}
		} else
			event.getEntity().remove();
	}
}
