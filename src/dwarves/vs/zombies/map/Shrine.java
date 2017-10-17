package dwarves.vs.zombies.map;

import org.bukkit.Location;

public class Shrine {

	private String name;
	private Location location;
	private Location monsterSpawn;
	public int destroy;
	public int prot;
	
	public Shrine(String name, Location location, int destroyRadius, int shrineProtRadius, Location monsterSpawn)
	{
		this.name = name;
		this.location = location;
		this.destroy = destroyRadius;
		this.prot = shrineProtRadius;
		this.monsterSpawn = monsterSpawn;
	}
	
	public String getName()
	{
		return name;
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
