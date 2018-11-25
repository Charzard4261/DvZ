package dwarves.vs.zombies.dwarf.equipment.swords;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.dwarf.Dwarf;
import dwarves.vs.zombies.dwarf.superclasses.DwarfSword;
import dwarves.vs.zombies.misc.NMSItem;

public class Warhammer extends DwarfSword {

	public Warhammer(Dwarf dwarf)
	{
		super(dwarf, 0, false);
	}

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.STONE_SWORD);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.AQUA + "Warhammer");
    
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + "Power: " + ChatColor.AQUA + "10 to 21");
		lore.add(ChatColor.YELLOW + "With this Warhammer, your attacks cleave dealing");
		lore.add(ChatColor.YELLOW + "damage to nearby monsters and bonus damage to");
		lore.add(ChatColor.YELLOW + "lesser demons. Every 100 demons slain, increases");
		lore.add(ChatColor.YELLOW + "the power of this weapon. Right click to channel");
		lore.add(ChatColor.YELLOW + "your Warhammer which solwly restores mana and");
		lore.add(ChatColor.YELLOW + "repairs your armor without a gold cost.");
		meta.setLore(lore);

		item.setItemMeta(meta);

		item = new NMSItem(item).addAttribute("generic.attackDamage", 10).addAttribute("generic.attackSpeed", 4).getItem();

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
		return false;
	}

	@Override
	protected boolean special(PlayerInteractAtEntityEvent event)
	{
		return false;

	}

}
