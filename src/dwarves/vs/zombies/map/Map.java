package dwarves.vs.zombies.map;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Map {

	String world;
	double spawnX;
	double spawnY;
	double spawnZ;
	float spawnPitch;
	float spawnYaw;
	public Shrine[] shrines;

	public Map(String world, double spawnX, double spawnY, double spawnZ, float spawnPitch, float spawnYaw, Shrine[] shrines)
	{
		this.world = world;
		this.spawnX = spawnX;
		this.spawnY = spawnY;
		this.spawnZ = spawnZ;
		this.spawnPitch = spawnPitch;
		this.spawnYaw = spawnYaw;
		this.shrines = shrines;
	}

	public String getWorld()
	{
		return world;
	}

	public Location getSpawn()
	{
		return new Location(Bukkit.getWorld(world), spawnX, spawnY, spawnZ, spawnPitch, spawnYaw);
	}

}
