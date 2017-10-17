package dwarves.vs.zombies.dwarves.bows;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.Bow;
import dwarves.vs.zombies.Core;

public class Lightbow extends Bow implements Listener {

	Player player;
	public int timer;
	public boolean usedSpecial;

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.BOW);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA + "Lightbow");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + "Power: " + ChatColor.AQUA + "50");
		lore.add(ChatColor.YELLOW + "With this Bow, arrows that do not hit a monster will");
		lore.add(ChatColor.YELLOW + "spawn an Enchanted Lamp that lasts for 5 seconds.");
		lore.add(ChatColor.YELLOW + "You are also now immune to Darkness.");
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
		Arrow arrow = (Arrow) event.getProjectile();
		arrow.setFireTicks(0);
		arrow.setVelocity(arrow.getVelocity().multiply(1));
		arrow.setKnockbackStrength(1);
		arrow.setCritical(false);
		arrow.spigot().setDamage(50); // Damage
	}

	@Override
	public void onHit(EntityDamageByEntityEvent event)
	{
		if (!(event.getEntity().isDead()))
			return;
		Core.getInstance().getDwarf(player).giveProc();
	}
}
