package dwarves.vs.zombies.map;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;

import dwarves.vs.zombies.Core;
import dwarves.vs.zombies.map.maps.skyloft.SkyloftMap;

public class MapManager {

	private ArrayList<Map> maps = new ArrayList<Map>();

	private Map currentMap;
	private World currentWorld;
	private int shrine = 0;
	private Shrine currentShrine;
	private int vault = 0;
	private int shrineGold = 0;

	public MapManager() {
		maps.add(new SkyloftMap());
		// maps.add(new NekrosisMap());
	}

	public void chooseMap() {
		int rnd = new Random().nextInt(maps.size());
		currentMap = maps.get(rnd);
		currentWorld = Core.getInstance().copy(currentMap.getWorld());
		currentMap.getSpawn().getChunk().load();
		currentShrine = currentMap.shrines[shrine];
		Core.getInstance().bb.setTitle(currentShrine.getName() + " (" + (shrine + 1) + "/" + currentMap.shrines.length + ")");
	}

	public Map getMap() {
		return currentMap;
	}

	public World getWorld() {
		return currentWorld;
	}

	public Location getLobby() {
		return new Location(Bukkit.getWorld("lobby"), 0.5, 40, 0.5);
	}

	public Shrine getCurrentShrine() {
		return currentShrine;
	}

	public void nextShrine() {
		shrine++;
		if (shrine == currentMap.shrines.length) {
			Core.getInstance().endGame();
			return;
		}
		currentShrine = currentMap.shrines[shrine];
		Core.getInstance().bb.setTitle(currentShrine.getName() + " (" + shrine + "/" + currentMap.shrines.length + ")");
		Bukkit.broadcastMessage(ChatColor.YELLOW + "-=-=-=-=-=-=-=-=-=-=-=-=-");
		Bukkit.broadcastMessage(ChatColor.YELLOW + "THE SHRINE HAS FALLEN!");
		Bukkit.broadcastMessage(ChatColor.YELLOW + "-=-=-=-=-=-=-=-=-=-=-=-=-");
		shrineGold = shrineGold + (vault / shrine);
		vault -= shrineGold;
	}

	public void activateGold() {
		shrineGold = shrineGold + (vault / shrine);
		vault -= shrineGold;
	}

	public boolean useGold(int amount) {
		if (shrineGold >= amount) {
			shrineGold -= amount;
			return true;
		} else
			return false;
	}

	public void addGold(int amount) {
		if (Core.getInstance().monstersReleased)
			shrineGold += amount;
		else
			vault += amount;
	}

}
