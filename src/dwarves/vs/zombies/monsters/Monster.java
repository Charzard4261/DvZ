package dwarves.vs.zombies.monsters;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import dwarves.vs.zombies.monsters.monsters.Zombie;

public class Monster {

	public UUID uuid;
		
	public Zombie zombie;
	
	private MonsterClass mc;

	public Monster(UUID uuid)
	{
		this.uuid = uuid;
	}

	public Player getPlayer()
	{
		return Bukkit.getPlayer(uuid);
	}
	
	public MonsterClass getMonster()
	{
		return mc;
	}

}
