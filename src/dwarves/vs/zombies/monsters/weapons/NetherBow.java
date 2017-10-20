package dwarves.vs.zombies.monsters.weapons;

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


public class NetherBow extends Bow implements Listener {

	Player player;

	@Override
    public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.BOW);
	    ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.RED + "Nether Bow");
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
		arrow.spigot().setDamage(7);
		
	}

	@Override
	public void onHit(EntityDamageByEntityEvent event)
	{

	}
}
