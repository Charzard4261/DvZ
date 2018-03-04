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

public class RegrowthStar extends DwarfAle {

	public RegrowthStar(Dwarf dwarf)
	{
		super(dwarf, true);
	}

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.NETHER_STAR);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.AQUA + "Star Trinket");

		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + "Passive: Heals you when you lose 5 hearts for 100 mana");
		lore.add(ChatColor.YELLOW + "R-Click: Heal the dwarf you are looking at for 100 mana,");
		lore.add(ChatColor.YELLOW + "         regenerating 5% of their armor and giving heroes 10 mana");
		lore.add(ChatColor.YELLOW + "L-Click: Instantly restore all your mana, Cooldown is 120 seconds");
		lore.add(ChatColor.YELLOW + "		  Cooldown is reduced by 5 seconds for each ally you heal");
		meta.setLore(lore);

		item.setItemMeta(meta);

		return item;
	}

	@Override
	public void onLeftClick(PlayerInteractEvent event)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onRightClick(PlayerInteractEvent event)
	{
		// TODO Auto-generated method stub

	}
	
		@Override
	public void onAuto()
	{
		if (getDwarf().modifyMana(-50))
		{
			getDwarf().getPlayer().playSound(getDwarf().getPlayer().getLocation(), "", 0.4f, 1f);
			getDwarf().getPlayer().setHealth(getDwarf().getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
		}
	}

}