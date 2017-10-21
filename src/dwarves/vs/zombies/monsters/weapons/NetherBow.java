package dwarves.vs.zombies.monsters.weapons;

import java.util.UUID;

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

	public NetherBow(UUID uuid)
	{
		super(uuid);
	}

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
		Player player = (Player) event.getDamager();
		
		player.setHealth(player.getHealth() + 20); //heals 10 full hearts per shot that hits a target
	}
}
