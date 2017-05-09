package dwarves.vs.zombies.dwarves;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import dwarves.vs.zombies.Core;

public class PlayerDwarfListeners implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent event)
	{
		if (Core.getInstance().getDwarf(event.getPlayer()) == null)
			return;

		/**
		 * Left clicking (air or a block) with their weapon.
		 **/
		if ((event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK)
				&& event.getPlayer()
						.getInventory()
						.getItemInHand()
						.equals(Core.getInstance().getDwarf(event.getPlayer())
								.getWeapon().getItem())) {
			Core.getInstance().getDwarf(event.getPlayer()).getWeapon().normal();
		}
		/**
		 * Right clicking (air or a block) with their weapon.
		 **/
		else if ((event.getAction() == Action.RIGHT_CLICK_AIR || event
				.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& event.getPlayer()
						.getInventory()
						.getItemInHand()
						.equals(Core.getInstance().getDwarf(event.getPlayer())
								.getWeapon().getItem())) {
			Core.getInstance().getDwarf(event.getPlayer()).getWeapon()
					.special();
		}
		/**
		 * Right clicking a block with an empty hand.
		 **/
		else if (event.getAction() == Action.RIGHT_CLICK_BLOCK
				&& event.getPlayer().getInventory().getItemInHand().getType() == Material.AIR) {
			if (event.getClickedBlock().getType() == Material.DETECTOR_RAIL
					&& !(event.getPlayer().getInventory().contains(Core
							.getInstance().getDwarf(event.getPlayer()).getBow()
							.getItem())))
				event.getPlayer()
						.getInventory()
						.addItem(
								Core.getInstance().getDwarf(event.getPlayer())
										.getBow().getItem());
		}
	}

	@EventHandler(ignoreCancelled = true)
	public void onAttack(EntityDamageByEntityEvent event)
	{
		if (event.getEntity().isDead())
			return;
		
		if (!(event.getDamager() instanceof Player))
			return;
		
		if (Core.getInstance().getDwarf((Player) event.getDamager()) == null)
			return;
		
		Dwarf dwarf = Core.getInstance().getDwarf((Player) event.getDamager());
		
		//TODO Add check for monster class, I.E. Dire Wolves, Mob Heroes
		
		if (Core.getInstance().oldMan != null)
			if (Core.getInstance().oldMan.equals(event.getDamager()))
			{
				if (dwarf.isProccing()) {
					if (event.getEntity() instanceof EnderDragon)
						return;
					((LivingEntity) event.getEntity()).damage(99999, event.getDamager());
					dwarf.giveProc();
						
				}
			}
		
		if (dwarf.isProccing()) {
			if (event.getEntity() instanceof PigZombie || event.getEntity() instanceof IronGolem)
				return;
			else {
				((LivingEntity) event.getEntity()).damage(99999, event.getDamager());
				dwarf.giveProc();
			}
		}
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event)
	{
		if (Core.getInstance().getDwarf((Player) event.getWhoClicked()) == null)
			return;
	}

	@EventHandler
	public void onShoot(EntityShootBowEvent event)
	{
		if (event.getEntityType() != EntityType.PLAYER)
			return;

		if (Core.getInstance().getDwarf((Player) event.getEntity()) == null)
			return;

		Dwarf dwarf = Core.getInstance().getDwarf((Player) event.getEntity());

		if (dwarf.getBow().getItem().equals(event.getBow())) {
			dwarf.getBow().shotprojectiledata.add(event.getProjectile());
			dwarf.getBow().onFire(event);
		}

	}

	@EventHandler(ignoreCancelled = true)
	public void onProjectileHit(EntityDamageByEntityEvent event)
	{

		if (!(event.getDamager() instanceof Arrow))
			return;

		final Arrow arrow = (Arrow) event.getDamager();

		if (Core.getInstance().getDwarf((Player) arrow.getShooter()) == null)
			return;

		Dwarf dwarf = Core.getInstance().getDwarf((Player) arrow.getShooter());

		if (dwarf.getBow().shotprojectiledata.contains(arrow)) {
			dwarf.getBow().shotprojectiledata.remove(event.getEntity());
			dwarf.getBow().onHit(event);
		}
	}

}
