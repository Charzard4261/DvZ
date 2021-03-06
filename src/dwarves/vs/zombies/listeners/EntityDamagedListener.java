package dwarves.vs.zombies.listeners;

import java.util.Iterator;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import dwarves.vs.zombies.Core;
import dwarves.vs.zombies.enums.Stage;

public class EntityDamagedListener implements Listener {

	@EventHandler
	public void onPlayerDamage(EntityDamageByEntityEvent event)
	{

		if (!(event.getDamager() instanceof Player) || event.isCancelled())
			return;

		if (Core.getInstance().getGm().stage == Stage.LOBBY)
		{
			event.setCancelled(true);
			return;
		}

		if (Core.getInstance().getGm().dwarves.containsKey(event.getDamager().getUniqueId()))
		{
			if (event.getEntity() instanceof Player)
				if (Core.getInstance().getGm().dwarves.containsKey(event.getEntity().getUniqueId()))
				{
					event.setCancelled(true);
					return;
				}

			if (Core.getInstance().getGm().dwarves.get(event.getDamager().getUniqueId()).isProccing())
			{
				boolean procced = true;
				Iterator<UUID> it = Core.getInstance().getGm().monsters.keySet().iterator();
				while (it.hasNext())
				{
					UUID uuid = it.next();

					if (Core.getInstance().getGm().monsters.get(uuid).getMonster().getEntity().getUniqueId().equals(event.getEntity().getUniqueId()))
					{
						if (!Core.getInstance().getGm().monsters.get(uuid).getMonster().canBeProcced())
						{
							procced = false;
							break;
						}
					}
				}

				if (procced || event.getEntity() instanceof Zombie)
					event.setDamage(999);
			}

			if (Core.getInstance().getGm().dwarves.get(event.getDamager().getUniqueId()).getSwords()
					.containsKey(((Player) event.getDamager()).getInventory().getItemInMainHand())
					&& (((LivingEntity) event.getEntity()).getHealth() - event.getDamage()) <= 0)
			{
				if (Core.getInstance().getGm().dwarves.get(event.getDamager().getUniqueId()).getSwords()
						.get(((Player) event.getDamager()).getInventory().getItemInMainHand()).rollsProcs)
					Core.getInstance().getGm().dwarves.get(event.getDamager().getUniqueId()).proc(3);
			}

			if ((((LivingEntity) event.getEntity()).getHealth() - event.getDamage()) <= 0)
				Core.getInstance().getGm().dwarves.get(event.getDamager().getUniqueId()).giveKill();

		} else if (Core.getInstance().getGm().monsters.containsKey(event.getDamager().getUniqueId()))
		{
			// TODO if Monster is attacking
			// Cancel if entity is NOT player
			// Use Weapon if TRUE
		}

	}

	@EventHandler
	public void onPlayerDamaged(EntityDamageByEntityEvent event)
	{

		if (!(event.getEntity() instanceof Player) || event.isCancelled())
			return;

		if (Core.getInstance().getGm().stage == Stage.LOBBY)
		{
			event.setCancelled(true);
			return;
		}

		if (Core.getInstance().getGm().dwarves.containsKey(event.getEntity().getUniqueId()))
		{
			if (event.getDamager() instanceof Player)
				if (Core.getInstance().getGm().dwarves.containsKey(event.getDamager().getUniqueId()))
				{
					event.setCancelled(true);
					return;
				}

			if ((((LivingEntity) event.getEntity()).getHealth() - event.getDamage()) <= 0 && Core.getInstance().getGm().stage != Stage.PRE)
			{
				for (Player player : Bukkit.getOnlinePlayers())
				{
					if (event.getDamager() instanceof Player)
						player.sendTitle(event.getDamager().getCustomName() + ChatColor.RED + " was killed!",
								ChatColor.RED + "by " + event.getDamager().getCustomName() + ChatColor.RED + "using"
										+ ((Player) event.getDamager()).getInventory().getItemInMainHand(),
								1, 3, 1);
					else
						player.sendTitle(event.getEntity().getCustomName() + ChatColor.RED + " was killed!", "", 1, 3, 1);
				}
			}
		}
	}

	@EventHandler
	public void onPlayerDamaged(EntityDamageEvent event)
	{

		if (!(event.getEntity() instanceof Player) || event.isCancelled())
			return;

		if (Core.getInstance().getGm().stage == Stage.LOBBY)
		{
			event.setCancelled(true);
			return;
		}

		if (Core.getInstance().getGm().dwarves.containsKey(event.getEntity().getUniqueId()))
		{
			if ((((LivingEntity) event.getEntity()).getHealth() - event.getDamage()) <= 0)
			{
				if (Core.getInstance().getGm().stage != Stage.PRE && event.getCause() != DamageCause.ENTITY_ATTACK)
					for (Player player : Bukkit.getOnlinePlayers())
					{
						player.sendTitle(event.getEntity().getCustomName() + ChatColor.RED + " was killed!", "", 1, 3, 1);
					}
				else
				{
					// TODO Heal and TP to spawn
				}
			}
		}

	}

}
