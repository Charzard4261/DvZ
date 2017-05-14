package dwarves.vs.zombies.map.maps.skyloft;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import dwarves.vs.zombies.map.Map;
import dwarves.vs.zombies.map.Shrine;

public class SkyloftMap extends Map {
	
	private static Shrine s1 = new Shrine(new Location(Bukkit.getWorld("skyloft"), 0, 0, 0), 1, 1, new Location(Bukkit.getWorld("skyloft"), 0, 0, 0));
	private static Shrine s2 = new Shrine(new Location(Bukkit.getWorld("skyloft"), 0, 0, 0), 1, 1, new Location(Bukkit.getWorld("skyloft"), 0, 0, 0));
	
	public SkyloftMap()
	{
		super("skyloft", -1186.5, 111.0, -1378.5, 0f, 0f, new Shrine[] { 
				s1, s2
				});
	}

}
