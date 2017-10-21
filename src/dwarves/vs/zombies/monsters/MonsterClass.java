package dwarves.vs.zombies.monsters;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

public abstract class MonsterClass {

	public UUID uuid;

	public MonsterClass(UUID uuid)
	{
		this.uuid = uuid;
	}

	public Player getPlayer()
	{
		return Bukkit.getPlayer(uuid);
	}

	public abstract void equipItems();
	
	public abstract void onLeftClick(PlayerInteractEvent event);

	public abstract void onRightClick(PlayerInteractEvent event);
	
}
