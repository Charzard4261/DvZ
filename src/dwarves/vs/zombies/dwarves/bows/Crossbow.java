package dwarves.vs.zombies.dwarves.bows;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.Bow;
import dwarves.vs.zombies.Core;

public class Crossbow extends Bow {

	public Crossbow(UUID uuid)
	{
		super(uuid);
	}

	public int timer;
	public boolean usedSpecial;

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.BOW);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA + "Crossbow");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + "Power: " + ChatColor.AQUA + "50");
		lore.add(ChatColor.YELLOW + "With this Crossbow, your arrors fire at full power");
		lore.add(ChatColor.YELLOW + "without requiring you to draw a bow first allowing");
		lore.add(ChatColor.YELLOW + "You to move and shoot.");
		meta.setLore(lore);
		meta.setUnbreakable(true);
		item.setItemMeta(meta);
		return item;
	}

	public void special()
	{
		if (usedSpecial)
		{
			return;
		}
		usedSpecial = true;

		timer = 0;
		ShootTimer task = new ShootTimer();
		task.setId(Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.getInstance(), task, 0, 20));

	}

	private class ShootTimer implements Runnable {

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

	@Override
	public void onFire(EntityShootBowEvent event)
	{
		
	}

	@Override
	public void onHit(EntityDamageByEntityEvent event)
	{
		
	}
}
