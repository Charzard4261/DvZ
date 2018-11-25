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

public class Runeblade extends DwarfSword {

	public Runeblade(Dwarf dwarf)
	{
		super(dwarf, 15, true);
	}

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.COCOA_BEANS);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.AQUA + "Greater Runeblade");

		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GOLD + "With this Blade, killing demons grants you a Powerful");
		lore.add(ChatColor.GOLD + "Rampage for 3 seconds with allows you to instantly");
		lore.add(ChatColor.GOLD + "kill most demons.");
		lore.add(ChatColor.GOLD + "Right Click to Runedash which dashes you forward");
		lore.add(ChatColor.GOLD + "making you breifly immune to damage and granting");
		lore.add(ChatColor.GOLD + "you a Powerful Rampage for 0.5 seconds.");
		meta.setLore(lore);

		item.setItemMeta(meta);

		item = new NMSItem(item).addAttribute("generic.attackDamage", 15).addAttribute("generic.attackSpeed", 4).getItem();
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
		getDwarf().getPlayer().getWorld().playSound(getDwarf().getPlayer().getLocation(), "runebladeRunedash", 4F, 1F);
		getDwarf().getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5, 3, false, false), false);
		getDwarf().getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 5, Integer.MAX_VALUE, false, false), false);
		getDwarf().getPlayer().setVelocity(getDwarf().getPlayer().getLocation().getDirection().multiply(2).setY(0.2));

		return true;
	}

	@Override
	protected boolean special(PlayerInteractAtEntityEvent event)
	{
		getDwarf().getPlayer().playSound(getDwarf().getPlayer().getLocation(), "runebladeRunedash", 4F, 1F);
		getDwarf().getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5, 3, false, false), false);
		getDwarf().getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 5, Integer.MAX_VALUE, false, false), false);
		getDwarf().getPlayer().setVelocity(getDwarf().getPlayer().getLocation().getDirection().multiply(2).setY(0.2));

		return true;
	}

}
