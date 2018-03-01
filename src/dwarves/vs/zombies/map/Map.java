package dwarves.vs.zombies.map;

import org.bukkit.Location;

public abstract class Map {

	public String world;
	public int shrine = 0;
	
	public Map(String world)
	{
		this.world = world;
	}
	
	public abstract Location getPlayerSpawn();
	public abstract Shrine[] getShrines();

	public Location getMonsterSpawn()
	{
		return getShrines()[shrine].getMonsterspawn();
	}
	
}
