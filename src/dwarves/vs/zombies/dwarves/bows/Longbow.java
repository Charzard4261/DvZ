package dwarves.vs.zombies.dwarves.bows;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.Bow;
import dwarves.vs.zombies.Core;

public class Longbow extends Bow {

	Player player;
	private int boost = 0;
	private BoostTimer task;
	public int timer;

	public Longbow()
	{
	}

	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 3);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA + "Ranger's Longbow");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + "Power: " + ChatColor.AQUA + "50 to 200");
		lore.add(ChatColor.YELLOW + "With this Bow, you gain a stacking damage buff");
		lore.add(ChatColor.YELLOW + "everytime you kill a Demon with it which increases");
		lore.add(ChatColor.YELLOW + "it's power by 25 for 15 seconds and can stack up to");
		lore.add(ChatColor.YELLOW + "6 times for a total of 200 power");
		meta.setLore(lore);
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
		((Arrow) event.getProjectile()).setCritical(false);
		((Arrow) event.getProjectile()).spigot().setDamage(50 + (25 * boost));
	}

	@Override
	public void onHit(EntityDamageByEntityEvent event)
	{
		if (boost < 6)
			boost += 1;

		timer = 15;
		
		if (task == null)
		{
			task = new BoostTimer();
			task.setId(Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.getInstance(), task, 0, 20));
		}

	}

	private class BoostTimer implements Runnable {

		private int id;

		@Override
		public void run()
		{
			if (timer == 0)
			{
				boost = 0;
				Bukkit.getScheduler().cancelTask(id);
			}

			timer -= 1;
		}

		public void setId(int id)
		{
			this.id = id;
		}

	}
}
