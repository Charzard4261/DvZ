package dwarves.vs.zombies.dwarf.items;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.dwarf.superclasses.DwarfItem;
import dwarves.vs.zombies.misc.Utils;

public class DebugTool implements DwarfItem {

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.STICK);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.AQUA + "Debug Stick");

		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + "R-Click: Use the RIGHT CLICK debug function");
		lore.add(ChatColor.YELLOW + "L-Click: Use the LEFT CLICK debug function");
		lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_PURPLE + "I made this because nessie was having such");
		lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_PURPLE + "a hard time figuring out the Maths that I-");
		lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_PURPLE + "What's Math? Well, err...");
		lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_PURPLE + "... Just don't worry about it, Jimmy.");
		lore.add(ChatColor.GOLD + "- Charzard");
		meta.setLore(lore);

		meta.setUnbreakable(true);

		item.setItemMeta(meta);

		return item;
	}

	public void interact(PlayerInteractEvent event)
	{
		if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK)
			leftClick(event);
		if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
			rightClick(event);
	}

	public void rightClick(PlayerInteractEvent event)
	{
		event.getPlayer().sendMessage("" + Utils.yawToFace(event.getPlayer().getEyeLocation().getYaw(), false));
	}

	public void leftClick(PlayerInteractEvent event)
	{

	}

}
