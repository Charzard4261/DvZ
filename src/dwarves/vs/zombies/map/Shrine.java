package dwarves.vs.zombies.map;

import org.bukkit.Location;

public class Shrine {

	private int radius;
	private Location shrineloc, monsterspawn;
	
	public Shrine (Location shrineloc, int radius, Location monsterspawn)
	{
		this.shrineloc = shrineloc;
		this.radius = radius;
		this.monsterspawn = monsterspawn;
	}
	
	public Location getShrineLocation()
	{
		return shrineloc;
	}

	public Location getMonsterspawn()
	{
		return monsterspawn;
	}
	
	public int getRadius()
	{
		return radius;
	}
	
}
