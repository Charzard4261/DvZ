package dwarves.vs.zombies.dwarf.equipment.ales;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.dwarf.Dwarf;
import dwarves.vs.zombies.dwarf.superclasses.DwarfAle;

public class StarTrinket extends DwarfAle {

	public StarTrinket(Dwarf dwarf)
	{
		super(dwarf, false);
	}

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.EMERALD);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.AQUA + "Star Trinket");

		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + "Passive: Regenerate 3.33 hearts a second");
		lore.add(ChatColor.YELLOW + "L-Click: You gain 20 absorption hearts for 200 mana");
		meta.setLore(lore);

		item.setItemMeta(meta);

		return item;
	}

	@Override
	public void onLeftClick(PlayerInteractEvent event)
	{
		if (getDwarf().modifyMana(-100))
		{
			getDwarf().getPlayer().playSound(getDwarf().getPlayer().getLocation(), "", 0.4f, 1f);
			getDwarf().getPlayer().setHealth(getDwarf().getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
			
			getDwarf().getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, Integer.MAX_VALUE, 9, false, false), false); //20 abssorb hearts
		}

	}

	@Override
	public void onRightClick(PlayerInteractEvent event)
	{
		// TODO Auto-generated method stub

	}

}