package dwarves.vs.zombies.dwarf.equipment.bows;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.dwarf.Dwarf;
import dwarves.vs.zombies.dwarf.superclasses.DwarfBow;

public class Virendra extends DwarfBow {

	public Virendra(Dwarf dwarf)
	{
		super(dwarf, 30);
	}

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.BOW);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.GOLD + "Virendra");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("The men tell me that ever since I started using it");
		lore.add("my shots have become more accurate, more powerful.");
		lore.add("But the truth is that when I draw this bow.");
		lore.add("When I hold her in my hands.");
		lore.add("All I can feel is her love for me and my hate for myself.");
		lore.add(ChatColor.GOLD + "- Bruce Willakers");
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
		arrow.setKnockbackStrength(100);
		arrow.setCritical(false);
		arrow.spigot().setDamage(350); // Damage, also 350 is the actual damage the bow does
	}

	@Override
	protected boolean onHit(EntityDamageByEntityEvent event)
	{
		if (!(event.getEntity() instanceof LivingEntity))
			return false;
		if ((((LivingEntity) event.getEntity()).getHealth() - event.getDamage()) > 0)
			return false;
		getDwarf().proc();
		System.out.println("Dragonskin Proc");
		return true;
	}
}
