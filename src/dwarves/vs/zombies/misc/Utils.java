package dwarves.vs.zombies.misc;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

public class Utils {

	public static List<Block> getBlocks(Block start, int xradius, int yradius, int zradius)
	{
		int xiterations = (xradius * 2) + 1;
		int yiterations = (yradius * 2) + 1;
		int ziterations = (zradius * 2) + 1;
		List<Block> blocks = new ArrayList<Block>(xiterations * yiterations * ziterations);
		for (int x = -xradius; x <= xradius; x++)
		{
			for (int y = -yradius; y <= yradius; y++)
			{
				for (int z = -zradius; z <= zradius; z++)
				{
					blocks.add(start.getRelative(x, y, z));
				}
			}
		}
		return blocks;
	}

	public static BlockFace yawToFace(float yaw, boolean useSubCardinalDirections)
	{
		if (useSubCardinalDirections)
			return radial[Math.round(yaw / 45f) & 0x7].getOppositeFace();

		return axis[Math.round(yaw / 90f) & 0x3]/*.getOppositeFace()*/;
	}

	private static final BlockFace[] axis =
	{ BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST };
	private static final BlockFace[] radial =
	{ BlockFace.NORTH, BlockFace.NORTH_EAST, BlockFace.EAST, BlockFace.SOUTH_EAST, BlockFace.SOUTH,
			BlockFace.SOUTH_WEST, BlockFace.WEST, BlockFace.NORTH_WEST };
}
