package dwarves.vs.zombies.dwarf.equipment.bows;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.dwarf.Dwarf;
import dwarves.vs.zombies.dwarf.superclasses.DwarfBow;

public class Crossbow extends DwarfBow {

	public Crossbow(Dwarf dwarf)
	{
		super(dwarf, 30);
	}

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

	@Override
	protected void onFire(EntityShootBowEvent event)
	{

	}

	@Override
	protected boolean onHit(EntityDamageByEntityEvent event)
	{
		return false;

	}
}
