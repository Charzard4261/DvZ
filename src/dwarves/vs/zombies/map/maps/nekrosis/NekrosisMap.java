package dwarves.vs.zombies.map.maps.nekrosis;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import dwarves.vs.zombies.map.Map;
import dwarves.vs.zombies.map.Shrine;

public class NekrosisMap extends Map {
	
	private static Shrine s1 = new Shrine("", new Location(Bukkit.getWorld("nekrosis"), 0, 0, 0), 1, 1, new Location(Bukkit.getWorld("nekrosis"), 87.5, 78, 94.5, 135, 0));
	private static Shrine s2 = new Shrine("", new Location(Bukkit.getWorld("nekrosis"), 0, 0, 0), 1, 1, new Location(Bukkit.getWorld("nekrosis"), 0, 0, 0));
	
	public NekrosisMap()
	{
		super("nekrosis", 14, 65.81250, -17, 0f, 0f, new Shrine[] { 
				s1, s2
				});
	}

}
