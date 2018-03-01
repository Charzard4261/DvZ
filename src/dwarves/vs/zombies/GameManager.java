package dwarves.vs.zombies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import dwarves.vs.zombies.dwarf.Dwarf;
import dwarves.vs.zombies.dwarf.Jimmy;
import dwarves.vs.zombies.enums.Stage;
import dwarves.vs.zombies.map.Map;
import dwarves.vs.zombies.map.maps.DefaultMap;
import dwarves.vs.zombies.misc.ProjectileData;
import dwarves.vs.zombies.monster.MData;

public class GameManager {

	public Stage stage;

	private ArrayList<Map> maps;
	public Map map;
	public Location lobby;

	Scoreboard board;
	Objective objective;
	Score doomS, vaultS, goldS, remainingS, killsS;
	public HashMap<UUID, Dwarf> dwarves;
	public HashMap<UUID, MData> monsters;

	public boolean released = false;

	public float doomtimer = 500;
	private int vault = 0, gold = 0, kills = 0;

	public HashMap<UUID, ProjectileData> projectiles;

	public GameManager()
	{

		stage = Stage.LOBBY;

		maps = new ArrayList<Map>();
		maps.add(new DefaultMap());
		lobby = new Location(Bukkit.getWorld("world"), -24.5, 83, 255.5);

		dwarves = new HashMap<UUID, Dwarf>();
		monsters = new HashMap<UUID, MData>();
		projectiles = new HashMap<UUID, ProjectileData>();

	}

	// --------------------------------------MAPS----------------------------------------------------------------------------

	public void chooseMap()
	{
		int randomNum = ThreadLocalRandom.current().nextInt(0, maps.size());
		map = maps.get(randomNum);
	}

	// --------------------------------------PLAYER
	// STATES-------------------------------------------------------------------

	public void spawnDwarf(Player player)
	{
		player.getInventory().clear();
		player.setDisplayName(ChatColor.DARK_AQUA + player.getCustomName());
		player.setPlayerListName(player.getDisplayName());
		dwarves.put(player.getUniqueId(), new Jimmy(player.getUniqueId()));
		player.teleport(map.getPlayerSpawn());
	}

	public void spawnHero(String type, Player player)
	{

	}

	public void killDwarf(Dwarf dwarf)
	{
		dwarf.killDwarf();
	}

	public void spawnMonster(Player player)
	{
		player.getInventory().clear();
	}

	// ----------------------------------------------------------------------------------------------------------------------

	public void doom()
	{
		// TODO Auto-generated method stub

	}

	public void addGold(int amount)
	{
		if (stage == Stage.PRE)
		{
			vault++;
			vaultS.setScore(vault);
		} else
		{
			gold++;
			goldS.setScore(gold);
		}

	}

	public int getVault()
	{
		return vault;
	}

	public int getGold()
	{
		return gold;
	}

	public void reset()
	{
		released = false;

		doomS = null;
		vaultS = null;
		goldS = null;
		remainingS = null;
		killsS = null;
		objective = null;
		board = null;

		doomtimer = 500;
		vault = 0;
		gold = 0;
		kills = 0;

		dwarves.clear();
		monsters.clear();

		Iterator<UUID> it = projectiles.keySet().iterator();
		while (it.hasNext())
		{
			UUID uuid = it.next();

			if (Bukkit.getEntity(uuid) != null)
				Bukkit.getEntity(uuid).remove();
			it.remove();
		}
	}

	public void addKill()
	{
		if (killsS == null)
			return;
		kills++;
		killsS.setScore(kills);
	}

}
