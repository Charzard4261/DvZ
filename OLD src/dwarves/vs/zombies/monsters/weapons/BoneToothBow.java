package dwarves.vs.zombies.monsters.weapons;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.Bow;


public class BoneToothBow extends Bow implements Listener {


	public BoneToothBow(UUID uuid)
	{
		super(uuid);
	}

	@Override
    public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.BOW);
	    ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.RED + "BoneTooth Bow");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.AQUA + "A powerful bow crafted from the bones");
		lore.add(ChatColor.AQUA + "of dead Dwarves");
		meta.setLore(lore);
		meta.setUnbreakable(true);
		item.setItemMeta(meta);
		return item;
	}

	@Override
	public void onFire(EntityShootBowEvent event)
	{
		Arrow arrow = (Arrow) event.getProjectile();
		arrow.setFireTicks(100);
		arrow.setVelocity(arrow.getVelocity().multiply(1));
		arrow.setKnockbackStrength(1);
		arrow.setCritical(false);
		arrow.spigot().setDamage(5); // Damage not sure this is the right amount but the wiki said it
		
		// add volley
	}

	@Override
	public void onHit(EntityDamageByEntityEvent event)
	{

	}
}
