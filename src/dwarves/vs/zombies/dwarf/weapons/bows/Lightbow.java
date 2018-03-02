package dwarves.vs.zombies.dwarf.weapons.bows;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.dwarf.Dwarf;
import dwarves.vs.zombies.dwarf.superclasses.DwarfBow;

public class Lightbow extends DwarfBow {

	public Lightbow(Dwarf dwarf)
	{
		super(dwarf, 30);
	}

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
	protected void onFire(EntityShootBowEvent event)
	{
		Arrow arrow = (Arrow) event.getProjectile();
		arrow.setFireTicks(0);
		arrow.setVelocity(arrow.getVelocity().multiply(1));
		arrow.setKnockbackStrength(1);
		arrow.setCritical(false);
		arrow.spigot().setDamage(50); // Damage
	}

	@Override
	protected boolean onHit(EntityDamageByEntityEvent event)
	{
		return false;

	}
}
