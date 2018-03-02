package dwarves.vs.zombies.misc;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_12_R1.PacketPlayOutPlayerInfo;
import net.minecraft.server.v1_12_R1.PacketPlayOutPlayerInfo.EnumPlayerInfoAction;

public class ChangePlayerTag {

	public static void changeTag(Player playerToChange, String newName)
	{
		for (Player player : Bukkit.getOnlinePlayers())
		{
			if (player != playerToChange)
			{
				PacketPlayOutPlayerInfo info = new PacketPlayOutPlayerInfo(EnumPlayerInfoAction.UPDATE_DISPLAY_NAME,
						((CraftPlayer) playerToChange).getHandle());
				((CraftPlayer) player).getHandle().playerConnection.sendPacket(info);
			}
			// PacketPlayOutPlayerInfo info = new
			// PacketPlayOutPlayerInfo(EnumPlayerInfoAction.REMOVE_PLAYER, ((CraftPlayer)
			// playerToChange).getHandle());
			// PacketPlayOutPlayerInfo info = new
			// PacketPlayOutPlayerInfo(EnumPlayerInfoAction.ADD_PLAYER, ((CraftPlayer)
			// playerToChange).getHandle());
		}
	}

}
