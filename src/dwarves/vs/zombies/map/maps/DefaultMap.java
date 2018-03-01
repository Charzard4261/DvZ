package dwarves.vs.zombies.map.maps;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import dwarves.vs.zombies.map.Map;
import dwarves.vs.zombies.map.Shrine;

public class DefaultMap extends Map {

	public DefaultMap()
	{
		super("Default");
		// TODO Auto-generated constructor stub
	}

	@Override
	public Location getPlayerSpawn()
	{
		return new Location(Bukkit.getWorld("world"), -55.5, 94, 302.5, 0f, 0f);
	}

	@Override
	public Shrine[] getShrines()
	{
		return null;
	}

}
