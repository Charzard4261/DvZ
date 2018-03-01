package dwarves.vs.zombies.listeners;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import dwarves.vs.zombies.Core;
import dwarves.vs.zombies.enums.Stage;

public class HandSwapListener implements Listener {

	@EventHandler
	public void onHandSwap(PlayerSwapHandItemsEvent event)
	{
		switch (event.getOffHandItem().getType())
		{
		case AIR:
			break;
		case TORCH:
			break;
		case SHIELD:
			break;
		default:
			event.setCancelled(true);
			break;
		}
	}

	@EventHandler
	public void handItemChange(PlayerItemHeldEvent event)
	{
		if (event.getPlayer().getInventory().getItem(event.getNewSlot()) == null || Core.getInstance().getGm().stage == Stage.LOBBY)
			return;
		if (event.getPlayer().getInventory().getItem(event.getNewSlot()).getType() == Material.TORCH)
		{
			if (event.getPlayer().hasPotionEffect(PotionEffectType.BLINDNESS))
				event.getPlayer().addPotionEffect(
						new PotionEffect(PotionEffectType.BLINDNESS, 20, 0, false, false), true);
			event.getPlayer().playSound(event.getPlayer().getLocation(), "activatetorch", 0.4f, 1f);
			event.getPlayer().getWorld().spawnParticle(Particle.FLAME, event.getPlayer().getLocation().add(0, 1.5, 0),  10, 0.01, 0.01, 0.01, 0.05);
		}
	}
	
}
