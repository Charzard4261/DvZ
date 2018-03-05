package dwarves.vs.zombies.dwarf.items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.Core;
import dwarves.vs.zombies.dwarf.superclasses.DwarfItem;
import dwarves.vs.zombies.misc.Utils;

public class ScrollOfMagicStone extends DwarfItem {

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.CLAY_BRICK);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.AQUA + "Scroll of Magic Stone.");

		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + "L-Click: To instantly make a wall of Magicstone");
		lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_PURPLE + "Trademarks expire?,");
		lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_PURPLE + "No! My slab business!");
		lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_PURPLE + "Noooooooooooooooooooooo!");
		lore.add(ChatColor.GOLD + "- Deadbones");
		meta.setLore(lore);

		meta.setUnbreakable(true);

		item.setItemMeta(meta);

		return item;
	}

	public void slab(Player player, Block center)
	{
		
		List<Block> radius = new ArrayList<Block>();
		if (Utils.yawToFace(player.getEyeLocation().getYaw(), false) == BlockFace.NORTH)
			radius = Utils.getBlocks(player.getLocation().add(0, 1, -5).getBlock(), 4, 2, 2);
		else if (Utils.yawToFace(player.getEyeLocation().getYaw(), false) == BlockFace.SOUTH)
			radius = Utils.getBlocks(player.getLocation().add(0, 1, 5).getBlock(), 4, 2, 2);
		if (Utils.yawToFace(player.getEyeLocation().getYaw(), false) == BlockFace.EAST)
			radius = Utils.getBlocks(player.getLocation().add(5, 1, 0).getBlock(), 2, 2, 4);
		else if (Utils.yawToFace(player.getEyeLocation().getYaw(), false) == BlockFace.WEST)
			radius = Utils.getBlocks(player.getLocation().add(-5, 1, 0).getBlock(), 2, 2, 4);
		for (Block block : radius)
		{
			switch (block.getType())
			{
			case AIR:
				block.setType(Material.LAPIS_ORE);
				break;
			default:
				break;
			}
		}
		
		Core.getInstance().getGm().dwarves.get(player.getUniqueId()).slabt = 1;
	}

}
