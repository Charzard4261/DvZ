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
import dwarves.vs.zombies.misc.Utils;
import dwarves.vs.zombies.misc.generics.GenericItem;

public class ScrollOfMagicStone implements GenericItem {

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.BRICK);
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
			radius = Utils.getBlocks(player.getLocation().add(0, 2, -6).getBlock(), 5, 2, 3);
		else if (Utils.yawToFace(player.getEyeLocation().getYaw(), false) == BlockFace.SOUTH)
			radius = Utils.getBlocks(player.getLocation().add(0, 2, 6).getBlock(), 5, 2, 3);
		else if (Utils.yawToFace(player.getEyeLocation().getYaw(), false) == BlockFace.EAST)
			radius = Utils.getBlocks(player.getLocation().add(6, 2, 0).getBlock(), 3, 2, 5);
		else if (Utils.yawToFace(player.getEyeLocation().getYaw(), false) == BlockFace.WEST)
			radius = Utils.getBlocks(player.getLocation().add(-6, 2, 0).getBlock(), 3, 2, 5);
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

		Core.getInstance().getGm().dwarves.get(player.getUniqueId()).slabt = 2;
	}

}
