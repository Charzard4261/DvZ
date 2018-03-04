package dwarves.vs.zombies.misc;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;

import dwarves.vs.zombies.Core;
import net.minecraft.server.v1_12_R1.EntityPlayer;
import net.minecraft.server.v1_12_R1.PacketPlayOutPlayerInfo;
import net.minecraft.server.v1_12_R1.PacketPlayOutPlayerInfo.EnumPlayerInfoAction;
import net.minecraft.server.v1_12_R1.PacketPlayOutRespawn;

public class PlayerSkinEditor {

	public static void applyOldMan(UUID uuid)
	{
		// (OldManWillakers) Skin #10576 generated on April 20, 2017 12:26:44 PM via
		// MineSkin.org
		Player player = Bukkit.getPlayer(uuid);
		EntityPlayer ep = ((CraftPlayer) player).getHandle();
		GameProfile gp = ep.getProfile();
		PropertyMap pm = gp.getProperties();
		Property property = pm.get("textures").iterator().next();
		pm.remove("textures", property);
		pm.put("textures", new Property("textures",
				"eyJ0aW1lc3RhbXAiOjE0OTI2ODc2MDQyNzEsInByb2ZpbGVJZCI6IjkzNzY1YmEyYjg3MzQ1MTM5NzIwYmYyNzI5YWI4NTdkIiwicHJvZmlsZU5hbWUiOiJPbGRNYW5XaWxsYWtlcnMiLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzUwMjE2NTljYzM4MTgyNjllMWI3ODhjNmI3NGIwN2E4N2QxNDJlMjc1OGQzYmY1ZWFhYzk5NjE3ZjY1NCJ9fX0=",
				"ThYdOTVoQOgmthUcmi1O0TWocv7GYwMI4gK9UoNKoAi6nAHwtl7hy2wOY5D04Bf1a0fWBsCet7xQTlCRsLFuZ5zl4f3qUfsiu8lKb73Vvb+LFjJfbzB5nWdHSICyT3hs/gPFSrIxT06j556inp45F8dYsmBr5zkvgF3yPw6nRFcpLKyef2Kw4ZGC7EyzJOqokZBa9vNg2QuVFvIrBjtIzcPn/Q6OkZq9d0cUpeij9mV8oYmAxpFv0frLi6Zd810JTiAlo6Dakb/l3yPGeowvxLuWuV46QUwgdnsQOr/AS0N4OGF9LqVCpFIqhU7kcve1xfMBxKH/1Vt6aYqSDLTejvdkI4FQ/qHlWRFreKJNQspBq7dMF0DRMxY7C+/5HNnc6dQxSmlha8mTN7kNwR+vJjlhTM3qS3YrUX/ACUR5ihuyL78Iw83bdv21GckWO58cvarXRwu0E4MFwwQNckZaaShKedBkKHh9pX5JqslCMYhSrxSP2b77ZA+QiRzdVA1W7Y1v0qOaUcmd0rLTWn00Qa82W3ppcoG0aUFmCvLbd+rcA4l7NsmFGwzJM6Hjmz38NHDZpr7YB+6A2JhAHBYes6gOmBJ6aS9BbB9Sb3+6PlvBLe1R7GHDPKHuVInWKqoC4LSizGM9HMh4fjlCHWyJNqY3IXBOdVpl4Gsvt7Z3jo0="));

		ChangePlayerTag.changeTag(player, ChatColor.GOLD + "Bruce");
		
		reloadSkinForSelf(player);
	}

	private static final void reloadSkinForSelf(Player player)
	{
		final EntityPlayer ep = ((CraftPlayer) player).getHandle();
		final PacketPlayOutPlayerInfo removeInfo = new PacketPlayOutPlayerInfo(EnumPlayerInfoAction.REMOVE_PLAYER, ep);
		final PacketPlayOutPlayerInfo addInfo = new PacketPlayOutPlayerInfo(EnumPlayerInfoAction.ADD_PLAYER, ep);
		final Location loc = player.getLocation().clone();
		ep.playerConnection.sendPacket(removeInfo);
		ep.playerConnection.sendPacket(addInfo);
		player.getWorld().getBlockAt(new Location(player.getWorld(), 10000, 99, 10000)).setType(Material.BARRIER);
		player.teleport(new Location(player.getWorld(), 10000, 100, 10000));
		new BukkitRunnable() {
			@Override
			public void run()
			{
				ep.playerConnection.sendPacket(new PacketPlayOutRespawn(ep.dimension, ep.getWorld().getDifficulty(),
						ep.getWorld().getWorldData().getType(), ep.playerInteractManager.getGameMode()));
				player.teleport(loc);
				player.updateInventory();
			}
		}.runTaskLater(Core.getInstance(), 4L);
	}

	public static void swapSkins(UUID uuid, String value, String signature)
	{
		OfflinePlayer player = Bukkit.getOfflinePlayer(uuid);

		EntityPlayer ep = ((CraftPlayer) player).getHandle();
		GameProfile gp = ep.getProfile();
		PropertyMap pm = gp.getProperties();
		Property pr = pm.get("textures").iterator().next();

		pm.remove("textures", pr);
		pm.put("textures", new Property("textures", value, signature));

		for (Player p : Bukkit.getOnlinePlayers())
		{
			p.hidePlayer(Core.getInstance(), player.getPlayer());
			p.showPlayer(Core.getInstance(), player.getPlayer());
		}

		reloadSkinForSelf(player.getPlayer());
	}
}
