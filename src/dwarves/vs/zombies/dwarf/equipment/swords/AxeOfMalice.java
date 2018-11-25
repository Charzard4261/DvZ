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

public class AxeOfMalice extends DwarfSword {

	public AxeOfMalice(Dwarf dwarf)
	{
		super(dwarf, 60, true);
	}

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.ROSE_RED);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.AQUA + "Axe Of Malice");

		ArrayList<String> lore = new ArrayList<String>();

		lore.add(ChatColor.YELLOW + "Power: " + ChatColor.AQUA + "20");
		lore.add(ChatColor.YELLOW + "With this Axe, you can Right Click to grant yourself a");
		lore.add(ChatColor.YELLOW + "Powerful Rampage for 8 seconds. Additional kills while");
		lore.add(ChatColor.YELLOW + "on a rampage will allow you to extend the duration.");
		lore.add(ChatColor.YELLOW + "This ability has a 60 second cooldown that is reduced");
		lore.add(ChatColor.YELLOW + "by 1 second for every kill or 4 seconds for bow kills.");

		meta.setLore(lore);

		item.setItemMeta(meta);

		item = new NMSItem(item).addAttribute("generic.attackDamage", 20).addAttribute("generic.attackSpeed", 4).getItem();

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
		getDwarf().getPlayer().getWorld().playSound(getDwarf().getPlayer().getLocation(), "maliceUse", 4F, 1F);
		getDwarf().proc(8);
		return true;
	}

	@Override
	protected boolean special(PlayerInteractAtEntityEvent event)
	{
		return false;

	}

}
