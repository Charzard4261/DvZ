package dwarves.vs.zombies.dwarf.equipment.swords;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import dwarves.vs.zombies.dwarf.Dwarf;
import dwarves.vs.zombies.dwarf.superclasses.DwarfSword;
import dwarves.vs.zombies.misc.NMSItem;

public class TombMaker extends DwarfSword {

	public TombMaker(Dwarf dwarf)
	{
		super(dwarf, 15, true);
	}

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.DIAMOND_SHOVEL);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.AQUA + "Tomb Maker");

		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + "Power: " + ChatColor.AQUA + "4");
		lore.add(ChatColor.YELLOW + "With this Shovel, you gain a Powerful Rampage for 5");
		lore.add(ChatColor.YELLOW + "seconds when shoveling gravel. Additional kills while");
		lore.add(ChatColor.YELLOW + "on a rampage will allow you to extend the duration.");
		lore.add(ChatColor.YELLOW + "Right Click to gain a haste buff to both dig and craft");
		lore.add(ChatColor.YELLOW + "faster as well as put an additional resource item you");
		lore.add(ChatColor.YELLOW + "gather into the Shared Recource Chest");
		meta.setLore(lore);

		item.setItemMeta(meta);

		item = new NMSItem(item).addAttribute("generic.attackDamage", 4).addAttribute("generic.attackSpeed", 4).getItem();

		return item;
	}

	@Override
	protected void leftClick(PlayerInteractEvent event)
	{

	}

	@Override
	protected void onHit(EntityDamageByEntityEvent event)
	{

	}

	@Override
	protected boolean special(PlayerInteractEvent event)
	{
	    getDwarf().getPlayer().playSound(getDwarf().getPlayer().getLocation(), "SOMETHING", 4F, 1F);
	    getDwarf().getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 200, 2, false, false), false);
	    return true;
	}

	@Override
	protected boolean special(PlayerInteractAtEntityEvent event)
	{
		getDwarf().getPlayer().playSound(getDwarf().getPlayer().getLocation(), "SOMETHING", 4F, 1F);
		getDwarf().getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 200, 2, false, false), false);
		return true;
	}

}
