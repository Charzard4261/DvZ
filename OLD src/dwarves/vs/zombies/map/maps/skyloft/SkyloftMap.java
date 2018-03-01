package dwarves.vs.zombies.map.maps.skyloft;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import dwarves.vs.zombies.map.Map;
import dwarves.vs.zombies.map.Shrine;

public class SkyloftMap extends Map {

	public SkyloftMap()
	{
		super("skyloft", -1185.5, 110, -1380.5, 0f, 0f, new Shrine[] {
				new Shrine("", new Location(Bukkit.getWorld("skyloft"), 0, 0, 0), 1, 1, new Location(
						Bukkit.getWorld("skyloft"), 0, 0, 0)),
				new Shrine("", new Location(Bukkit.getWorld("skyloft"), 0, 0, 0), 1, 1, new Location(
						Bukkit.getWorld("skyloft"), 0, 0, 0)) });
	}

}
