package dwarves.vs.zombies.monsters;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public abstract class Monster {
	
	private UUID uuid;
	
	public Monster (UUID uuid)
	{
		this.uuid = uuid;
	}
	
	public Player getPlayer()
	{
		return Bukkit.getPlayer(uuid);
	}
	
	public abstract void equipArmour();
	
	public abstract ArrayList<ItemStack> getItems();
	
	public abstract void onLeftClick(PlayerInteractEvent event);
	
	public abstract void onRightClick(PlayerInteractEvent event);
	
}
