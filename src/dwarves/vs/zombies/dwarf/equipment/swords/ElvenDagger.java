package dwarves.vs.zombies.dwarf.equipment.swords;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
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

public class ElvenDagger extends DwarfSword {

	public ElvenDagger(Dwarf dwarf)
	{
		super(dwarf, 60, false);
	}

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.LAPIS_LAZULI);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.AQUA + "Elven Dagger");

		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + "Power: " + ChatColor.AQUA + "15");
		lore.add(ChatColor.YELLOW + "With this Dagger, you move more quickly and your");
		lore.add(ChatColor.YELLOW + "hits poison demons for 5 seconds. Right Click to");
		lore.add(ChatColor.YELLOW + "Eviserate which deals massive damage killing most");
		lore.add(ChatColor.YELLOW + "demons. This ability has a 60 second cooldown that");
		lore.add(ChatColor.YELLOW + "is reduced by 10 seconds for every bow kill.");
		meta.setLore(lore);

		item.setItemMeta(meta);
		
		item = new NMSItem(item).addAttribute("generic.attackDamage", 15).addAttribute("generic.attackSpeed", 4).addAttribute("generic.movementSpeed", 0.8).getItem();

		return item;
	}

	@Override
	protected void leftClick(PlayerInteractEvent event)
	{

	}

	@Override
	protected void onHit(EntityDamageByEntityEvent event)
	{
		LivingEntity hit = (LivingEntity) event.getDamager();
		hit.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 3, false, false), false);
	}

	@Override
	protected boolean special(PlayerInteractEvent event)
	{
		return false;
	}

	@Override
	protected boolean special(PlayerInteractAtEntityEvent event)
	{
		Entity target = (Entity) event.getRightClicked();
		
		((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 3, false, false), false);
		((LivingEntity) target).damage(140, getDwarf().getPlayer()); //not sure if this will work, if it does do you know if resistance will reduce it as a method is needed where resistance or mobtype will effect damage
		
		return false; // TODO Add Evicerate

	}

}
