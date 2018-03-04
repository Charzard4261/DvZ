package dwarves.vs.zombies.listeners;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.mojang.authlib.GameProfile;

import dwarves.vs.zombies.Core;
import net.minecraft.server.v1_12_R1.EntityPlayer;

public class JoinListener implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent event)
	{
		switch (Core.getInstance().getGm().stage)
		{
		case LOBBY:
			Core.getInstance().spawnSpectator(event.getPlayer());
			break;
		case PRE:
			if (!(Core.getInstance().getGm().dwarves.containsKey(event.getPlayer().getUniqueId())))
				Core.getInstance().getGm().spawnDwarf(event.getPlayer());
			break;
		case IN:
			if (Core.getInstance().getGm().dwarves.containsKey(event.getPlayer().getUniqueId()))
					Core.getInstance().getGm().killDwarf(Core.getInstance().getGm().dwarves.get(event.getPlayer().getUniqueId()));
			Core.getInstance().getGm().spawnMonster(event.getPlayer());
			break;
		case POST:
			break;
		default:
			break;
		}
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent event)
	{
		if (event.getPlayer().getName() != event.getPlayer().getCustomName())
		{
			EntityPlayer ep = ((CraftPlayer) event.getPlayer()).getHandle();
			GameProfile gp = ep.getProfile();
			
			try
			{
				Field profileField = gp.getClass().getDeclaredField("name");
				profileField.setAccessible(true);
				profileField.set(gp, event.getPlayer().getCustomName());
				Bukkit.broadcastMessage("Resetting Player's Name");
			} catch (Exception e)
			{
				Bukkit.broadcastMessage("Not Work!");
			}
		}
		
		switch (Core.getInstance().getGm().stage)
		{
		case LOBBY:
			break;
		case PRE:
			break;
		case IN:
			break;
		case POST:
			break;
		default:
			break;

		}
	}

}
