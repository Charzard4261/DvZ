package dwarves.vs.zombies;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import dwarves.vs.zombies.command.CommandFactory;
import dwarves.vs.zombies.command.commands.GameCommand;
import dwarves.vs.zombies.command.commands.ItemCommand;
import dwarves.vs.zombies.dwarves.Dwarf;
import dwarves.vs.zombies.dwarves.OldManWillakers;
import dwarves.vs.zombies.dwarves.PlayerDwarfListeners;
import dwarves.vs.zombies.dwarves.WeaponsRegistry;
import dwarves.vs.zombies.map.MapManager;
import dwarves.vs.zombies.monsters.Monster;
import dwarves.vs.zombies.monsters.PlayerMonsterListeners;
import dwarves.vs.zombies.util.PlayerSkinEditor;

public class Core extends JavaPlugin {

	public static Core instance; // Instance: Workaround for "Static" BS
	private CommandFactory cm; // Commands, eg cm new is adding a command

	public GameState gs = GameState.Lobby; // What phase the game is in
	public MapManager mm;
	public WeaponsRegistry wr;
	public ArrayList<Dwarf> dwarves = new ArrayList<Dwarf>(); // A list of the dwarves
	public ArrayList<Monster> monsters = new ArrayList<Monster>(); // A list of the monsters
	public boolean monstersReleased = false; // Monsters released true/false

	public Player oldMan;
	String omV;
	String omS;
	Player roamin;
	String rV;
	String rS;
	Player nisovin;
	String nV;
	String nS;

	@Override
	public void onEnable()
	{
		instance = this;
		cm = new CommandFactory();
		mm = new MapManager();
		wr = new WeaponsRegistry();

		Bukkit.getServer().getPluginManager().registerEvents(new PlayerListeners(), this); // Adding event listeners (Almost everything has an event)
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerDwarfListeners(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerMonsterListeners(), this);

		cm.registerCommand(new GameCommand()); // Add a command (The command class goes inside brackets) control + click on -> ExampleCommand
		cm.registerCommand(new ItemCommand());
	}

	@Override
	public void onDisable()
	{
		if (gs != GameState.Lobby)
			endGame();

		cm = null;
		mm = null;
		wr = null;
		instance = null;
	}

	public enum GameState {
		Lobby, Startup, Build_Phase, Game;
	}

	public static Core getInstance()
	{
		return instance;
	}

	public WeaponsRegistry getWR()
	{
		return wr;
	}

	public void startGame()
	{
		gs = GameState.Build_Phase;
		dwarves = null;
		dwarves = new ArrayList<Dwarf>();

		mm.chooseMap();

		int max = Bukkit.getOnlinePlayers().size();
		int oldManint = 1 + (int) (Math.random() * max);
		int i = 0;

		for (Player p : Bukkit.getOnlinePlayers())
		{
			i++;
			p.setCustomName(ChatColor.DARK_AQUA + p.getDisplayName());
			p.setPlayerListName(p.getCustomName());
			if (i == oldManint)
			{
				oldMan = p;
			} else
			{
				spawnDwarf(p);
			}

			if (i == max)
			{
				if (oldMan != null)
				{
					omV = ((CraftPlayer) oldMan).getHandle().getProfile().getProperties()
							.get("textures").iterator().next().getValue();
					omS = ((CraftPlayer) oldMan).getHandle().getProfile().getProperties()
							.get("textures").iterator().next().getSignature();
					Bukkit.broadcastMessage(oldMan.getCustomName() + ChatColor.LIGHT_PURPLE
							+ " has become the Dwarvern Hero " + ChatColor.GOLD + "Bruce Willakers");
					oldMan.setCustomName(ChatColor.GOLD + "BruceWillakers");
					oldMan.setPlayerListName(oldMan.getCustomName());
					PlayerSkinEditor.applyOldMan(oldMan.getUniqueId());
					spawnOldMan(oldMan);
					oldMan.sendTitle(ChatColor.AQUA + "It's time to play!", ChatColor.DARK_AQUA
							+ "Dwarves" + ChatColor.GOLD + " Vs " + ChatColor.DARK_RED + "Zombies",
							0, 100, 20);
				}
			}
		}
	}

	public void postWarmup()
	{
		gs = GameState.Game;
	}

	public void releaseMonsters()
	{
		monstersReleased = true;
	}

	public void endGame()
	{
		Bukkit.broadcastMessage(ChatColor.DARK_RED + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		Bukkit.broadcastMessage(ChatColor.DARK_RED + "THE FINAL SHRINE HAS FALLEN!");
		Bukkit.broadcastMessage(ChatColor.DARK_RED + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		gs = GameState.Lobby;
		dwarves.clear();
		monsters.clear();

		for (Player p : Bukkit.getOnlinePlayers())
		{
			p.setCustomName(p.getDisplayName());
			p.setPlayerListName(p.getDisplayName());

			p.getInventory().clear();
			p.teleport(mm.getLobby());
		}

		if (oldMan != null)
		{
			UUID oldManUUID = oldMan.getUniqueId();
			PlayerSkinEditor.swapSkins(oldManUUID, omV, omS);
			oldMan = null;
		}
		roamin = null;
		nisovin = null;
		delete(mm.getMap().getWorld());
	}

	public void spawnOldMan(Player player)
	{
		dwarves.add(new OldManWillakers(player));
		player.playSound(mm.getMap().getSpawn(), "bruceIntro", 10F, 1F);

		player.getInventory().clear();

		ItemStack item = getDwarf(player).getWeapon().getItem();
		player.getInventory().addItem(item);

	}

	public void spawnDwarf(Player player)
	{
		dwarves.add(new Dwarf(player.getUniqueId()));
		player.teleport(mm.getMap().getSpawn());
		player.sendTitle(ChatColor.AQUA + "It's time to play!", ChatColor.DARK_AQUA + "Dwarves"
				+ ChatColor.GOLD + " Vs " + ChatColor.DARK_RED + "Zombies", 0, 100, 20);
		player.playSound(player.getLocation(), "bruceIntro", 10F, 1F);

		player.getInventory().clear();

		ItemStack item = getDwarf(player).getWeapon().getItem();
		player.getInventory().addItem(item);
	}

	public void spawnMonster(Player player)
	{

	}

	public Dwarf getDwarf(Player player)
	{
		for (Dwarf dw : dwarves)
		{
			if (dw.getPlayer().getUniqueId().equals(player.getUniqueId()))
				return dw;
		}
		return null;
	}

	public Monster getMonster(Player player)
	{
		for (Monster mon : monsters)
		{
			if (mon.getPlayer().getUniqueId().equals(player.getUniqueId()))
				return mon;
		}
		return null;
	}

	public World copy(String name)
	{
		File dataFolder = new File(this.getServer().getWorldContainer().getAbsolutePath());
		String strData = dataFolder.toString();
		strData = strData.substring(0, strData.length() - 1);

		File srcDir = new File(strData + "backup");
		if (!srcDir.exists())
		{
			Bukkit.getLogger().warning("Backup does not exist!");
			return null;
		}

		File destDir = new File(strData);
		try
		{
			FileUtils.copyDirectory(srcDir, destDir);
		} catch (IOException ex)
		{
			ex.printStackTrace();
		}
		return Bukkit.getServer().createWorld(new WorldCreator(name));
	}

	public void delete(String name)
	{
		Bukkit.getServer().unloadWorld(name, false);

		File dataFolder = new File(this.getServer().getWorldContainer().getAbsolutePath());
		String strData = dataFolder.toString();
		strData = strData.substring(0, strData.length() - 1);

		File dir = new File(strData + mm.getMap().getWorld());
		try
		{
			FileUtils.deleteDirectory(dir);
		} catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}

}
