package dwarves.vs.zombies.dwarves.bows;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.Bow;
import dwarves.vs.zombies.Core;

public class DragonskinBow extends Bow implements Listener {

	Player player;
	public int timer;
	public boolean usedSpecial;

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.BOW);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA + "Dragonskin Bow");
		meta.setUnbreakable(true);
		item.setItemMeta(meta);
		return item;
	}

	@Override
	public void setPlayer(Player player)
	{
		this.player = player;
	}

	@Override
	public void onFire(EntityShootBowEvent event)
	{
		Arrow arrow = (Arrow) event.getProjectile();
		arrow.setFireTicks(0);
		arrow.setVelocity(arrow.getVelocity().multiply(1));
		arrow.setKnockbackStrength(1);
		arrow.setCritical(false);
		arrow.spigot().setDamage(20); // Damage
	}

	@Override
	public void onHit()
	{
		if (usedSpecial)
			return;
		
		usedSpecial = true;
		
		timer = 30;

		Timer task = new Timer();
		task.setId(Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.getInstance(), task, 0, 20));

		Core.getInstance().getDwarf(player).giveProc();
	}

	private class Timer implements Runnable {

		private int id;

		@Override
		public void run()
		{
			timer -= 1;

			if (timer == 0)
			{
				usedSpecial = false;
				Bukkit.getScheduler().cancelTask(id);
			}
		}

		public void setId(int id)
		{
			this.id = id;
		}

	}
}
