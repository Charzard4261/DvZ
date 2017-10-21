package dwarves.vs.zombies.monsters;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import dwarves.vs.zombies.Weapon;

public abstract class MonsterClass {

	public UUID uuid;
	public ArrayList<Weapon> weapons = new ArrayList<Weapon>();

	public MonsterClass(UUID uuid)
	{
		this.uuid = uuid;
	}

	public Player getPlayer()
	{
		return Bukkit.getPlayer(uuid);
	}

	public abstract void equipItems();
	
	// If these are needed, copy & paste with @Override before them to override these methods
	
	public void onLeftClick(PlayerInteractEvent event)
	{
		for (Weapon w : weapons)
			if (event.getItem() == w.getItem())
				w.normal();
	}

	public void onRightClick(PlayerInteractEvent event)
	{                                        
		for (Weapon w : weapons)
			if (event.getItem() == w.getItem())
				w.special();
	}
	
}
