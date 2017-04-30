package dwarves.vs.zombies.map;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import dwarves.vs.zombies.Core;
import dwarves.vs.zombies.map.maps.skyloft.SkyloftMap;

public class MapManager {

	private ArrayList<Map> maps = new ArrayList<Map>();

	private Map currentMap;
	private World currentWorld;

	public MapManager()
	{
		maps.add(new SkyloftMap());
	}

	public void chooseMap()
	{
		int rnd = new Random().nextInt(maps.size());
		currentMap = maps.get(rnd);
		currentWorld = Core.getInstance().copy(currentMap.getWorld());
		currentMap.getSpawn().getChunk().load();
		// WorldCreator creator = new WorldCreator("voidworld");
		// creator.type(WorldType.FLAT);
		// creator.generatorSettings("2;0;1;");
		// Bukkit.getPlayer("Charzard4261").teleport(currentWorld.getSpawnLocation());
	}

	public Map getMap()
	{
		return currentMap;
	}

	public World getWorld()
	{
		return currentWorld;
	}

	public Location getLobby()
	{
		return new Location(Bukkit.getWorld("lobby"), 0, 40, 0);
	}

}
