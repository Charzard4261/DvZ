package dwarves.vs.zombies.dwarves.weapons;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import dwarves.vs.zombies.Core;
import dwarves.vs.zombies.Weapon;

public class GreaterRuneblade extends Weapon {

	Player player;
	boolean usedSpecial = false;
	int timer = 0;

	public GreaterRuneblade(Player player)
	{
		super(true, true);
		this.player = player;
	}

	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 3);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA + "Greater Runeblade");
		item.setItemMeta(meta);

		return item;
	}

	@Override
	public void setPlayer(Player player)
	{
		this.player = player;
	}

	@Override
	public void normal()
	{
		
	}

	@Override
	public void special()
	{
		if (usedSpecial)
		{
			player.sendMessage(ChatColor.DARK_AQUA + "Spell is on cooldown: "
					+ timer + " seconds remaining.");
			return;
		}
		usedSpecial = true;
		
		player.playSound(player.getLocation(), "runebladeRunedash", 4F, 1F);
		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5, 3, false, false), false);
		player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 5, 255, false, false), false);
		player.setVelocity(player.getLocation().getDirection().multiply(2));
		
		timer = 20;
		dashTimer task = new dashTimer();
		task.setId(Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.getInstance(), task, 0, 20));
		
	}

	private class dashTimer implements Runnable {
		
		private int id;

		@Override
		public void run()
		{
			if (timer == 0)
			{
				usedSpecial = false;
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
