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

public class DragonskinBow extends DwarfBow {

	public DragonskinBow(Dwarf dwarf)
	{
		super(dwarf, 30);
	}

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.BOW);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA + "Dragonskin Bow");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + "Power: " + ChatColor.AQUA + "50");
		lore.add(ChatColor.YELLOW + "With this Bow, kills grant you a Powerful Rampage");
		lore.add(ChatColor.YELLOW + "for 2 seconds, which allows you to instantly kill");
		lore.add(ChatColor.YELLOW + "most demons.");
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
		if (!(event.getEntity() instanceof LivingEntity))
			return false;
		if ((((LivingEntity) event.getEntity()).getHealth() - event.getDamage()) > 0)
			return false;
		getDwarf().proc(2);
		System.out.println("Dragonskin Proc");
		return true;
	}
}
