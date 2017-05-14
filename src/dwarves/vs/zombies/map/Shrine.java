package dwarves.vs.zombies.map;

import org.bukkit.Location;

public class Shrine {

	private Location location;
	private Location monsterSpawn;
	public int destroy;
	public int prot;
	
	public Shrine(Location location, int destroyRadius, int shrineProtRadius, Location monsterSpawn)
	{
		this.location = location;
		this.destroy = destroyRadius;
		this.prot = shrineProtRadius;
		this.monsterSpawn = monsterSpawn;
	}
	
	public Location getLocation()
	{
		return location;
	}

	public Location getMonsterSpawn()
	{
		return monsterSpawn;
	}

}
