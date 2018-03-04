package dwarves.vs.zombies.dwarf.equipment.ales;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import dwarves.vs.zombies.dwarf.Dwarf;
import dwarves.vs.zombies.dwarf.superclasses.DwarfAle;

public class HolyAle extends DwarfAle {

	public HolyAle(Dwarf dwarf)
	{
		super(dwarf, false);
	}

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.POTION, 1, (byte) 8267);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.AQUA + "Holy Ale");

		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + "L-Click: Heal yourself and gain 6 absorption");
		lore.add(ChatColor.YELLOW + "         hearts for 100 mana");
		meta.setLore(lore);

		item.setItemMeta(meta);

		return item;
	}

	@Override
	public void onLeftClick(PlayerInteractEvent event)
	{
		if (getDwarf().modifyMana(-200))
		{
			getDwarf().getPlayer().playSound(getDwarf().getPlayer().getLocation(), "", 0.4f, 1f);
			getDwarf().getPlayer().setHealth(getDwarf().getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue()); //could just use a instant health potion
			
			getDwarf().getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, Integer.MAX_VALUE, 2, false, false), false); //20 abssorb hearts
			getDwarf().getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, Integer.MAX_VALUE, 3, false, false), false); //regen 4
		}
	}

	@Override
	public void onRightClick(PlayerInteractEvent event)
	{
		// TODO
	}

}
