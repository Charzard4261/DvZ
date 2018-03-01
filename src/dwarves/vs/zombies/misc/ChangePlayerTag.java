package dwarves.vs.zombies.misc;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_12_R1.util.CraftChatMessage;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_12_R1.PacketPlayOutPlayerInfo;
import net.minecraft.server.v1_12_R1.PacketPlayOutPlayerInfo.EnumPlayerInfoAction;

// BROKEN CODE
public class ChangePlayerTag {

	public static void changeTag(Player playerToChange, String newName)
	{
		for (Player player : Bukkit.getOnlinePlayers())
		{
			PacketPlayOutPlayerInfo info = new PacketPlayOutPlayerInfo();
			info.(info, EnumPlayerInfoAction.ADD_PLAYER, info.new PlayerInfoData(((CraftPlayer) player).getProfile(), entity.ping,
					entity.playerInteractManager.getGameMode(), CraftChatMessage.fromString(name)[0]));
			setInfo(info, EnumPlayerInfoAction.ADD_PLAYER, info.new PlayerInfoData(((CraftPlayer) player).getProfile(), entity.ping,
					entity.playerInteractManager.getGameMode(), CraftChatMessage.fromString(name)[0]));
		}
	}

}
