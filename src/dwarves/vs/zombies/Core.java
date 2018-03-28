package dwarves.vs.zombies;

import java.util.Iterator;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.DisplaySlot;

import dwarves.vs.zombies.command.CommandFactory;
import dwarves.vs.zombies.command.commands.AdminCommand;
import dwarves.vs.zombies.command.commands.GameCommand;
import dwarves.vs.zombies.dwarf.Dwarf;
import dwarves.vs.zombies.enums.Stage;
import dwarves.vs.zombies.listeners.BowListener;
import dwarves.vs.zombies.listeners.ChatListener;
import dwarves.vs.zombies.listeners.EntityDamagedListener;
import dwarves.vs.zombies.listeners.HandSwapListener;
import dwarves.vs.zombies.listeners.ItemDropListener;
import dwarves.vs.zombies.listeners.JoinListener;
import dwarves.vs.zombies.listeners.RespawnListener;
import dwarves.vs.zombies.listeners.dwarves.BreakBlockListener;
import dwarves.vs.zombies.listeners.dwarves.ClickBlockListener;
import dwarves.vs.zombies.listeners.dwarves.WeaponInteractListener;
import dwarves.vs.zombies.misc.ChangePlayerTag;

public class Core extends JavaPlugin {

	private static Core core;
	private GameManager gm;
	private CommandFactory cf;

	int timer;

	@Override
	public void onEnable()
	{
		core = this;
		gm = new GameManager();
		cf = new CommandFactory();

		getServer().getPluginManager().registerEvents(new BreakBlockListener(), this);
		getServer().getPluginManager().registerEvents(new ClickBlockListener(), this);
		getServer().getPluginManager().registerEvents(new WeaponInteractListener(), this);
		getServer().getPluginManager().registerEvents(new BowListener(), this);
		getServer().getPluginManager().registerEvents(new ChatListener(), this);
		getServer().getPluginManager().registerEvents(new EntityDamagedListener(), this);
		getServer().getPluginManager().registerEvents(new HandSwapListener(), this);
		getServer().getPluginManager().registerEvents(new ItemDropListener(), this);
		getServer().getPluginManager().registerEvents(new JoinListener(), this);
		getServer().getPluginManager().registerEvents(new RespawnListener(), this);

		cf.registerCommand(new GameCommand());
		cf.registerCommand(new AdminCommand());
	}

	@Override
	public void onDisable()
	{

		gm = null;
		cf = null;
		core = null;
	}

	public static Core getInstance()
	{
		return core;
	}

	public void start()
	{
		gm.stage = Stage.PRE;

		gm.chooseMap();
		Bukkit.broadcastMessage(gm.map.world);

		String path = getDataFolder().getAbsolutePath().substring(0, getDataFolder().getAbsolutePath().length() - 11);

		Bukkit.broadcastMessage(path);

		// File srcDir = new File(path + "");
		//
		// File destDir = new File("");

		gm.board = Bukkit.getScoreboardManager().getNewScoreboard();
		gm.objective = gm.board.registerNewObjective(ChatColor.AQUA + "Dwarves", "dummy");
		gm.objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		gm.vaultS = gm.objective.getScore(ChatColor.GOLD + "Vault");
		gm.vaultS.setScore(0);
		gm.remainingS = gm.objective.getScore(ChatColor.GREEN + "Remaining");

		for (Player player : Bukkit.getOnlinePlayers())
		{
			gm.spawnDwarf(player);
		}

		gm.remainingS.setScore(gm.dwarves.size());

		gm.map.getPlayerSpawn().getWorld().setTime(23000);

		timer = Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.getInstance(), new Runnable() {

			float dwarfmanatimer = 0;

			@Override
			public void run()
			{
				boolean manatimer = false;
				if (dwarfmanatimer == 0)
				{
					manatimer = true;
					dwarfmanatimer = 5; // DON'T TOUCH THIS - It starts at 5 and immediately decreases to 4
					//^Why is this a float value? Would it not make more sense to an integer. I cannot
					// find anywhere in this specific document where this is used past a regular timer.
					// Are you using this value for another function? In which case, you should still keep
					// the integer and type cast.

				}

				for (Dwarf dwarf : gm.dwarves.values())
				{
					if (dwarf.getPlayer() == null)
						continue;
					
					if (manatimer)
					{

						if (dwarf.getPlayer().getInventory().getArmorContents()[0] != null)
						{
							if (dwarf.getPlayer().getInventory().getArmorContents()[0]
									.getType() == Material.DIAMOND_BOOTS)
								dwarf.modifyMana(25);
						}
					}
					
					if (dwarf.slabt > 0)
						dwarf.slabt--;

					if (dwarf.isProccing())
						dwarf.proc--;

					if ((!dwarf.getPlayer().hasPotionEffect(PotionEffectType.NIGHT_VISION))
							&& (dwarf.getPlayer().getInventory().getItemInMainHand().getType() != Material.TORCH
									&& dwarf.getPlayer().getInventory().getItemInOffHand().getType() != Material.TORCH)
							&& dwarf.getPlayer().getLocation().getBlock().getLightLevel() <= 4
							&& (!(gm.map.getPlayerSpawn().getWorld().getTime() < 13800
									|| gm.map.getPlayerSpawn().getWorld().getTime() > 23000)
									|| dwarf.getPlayer().getLocation().getBlock().getLightFromSky() < 6))
					{
						dwarf.getPlayer().addPotionEffect(
								new PotionEffect(PotionEffectType.BLINDNESS, 30, 0, false, false), true);
					}
				}

				dwarfmanatimer -= 0.5;

				if (gm.released)
				{
					if (gm.doomtimer == 0)
					{
						gm.doom();
					} else if (gm.doomtimer < 0)
					{
					} else
						gm.doomtimer -= 0.5;
					gm.doomS.setScore((int) gm.doomtimer);
				}
			}
		}, 0, 10);

	}

	public void releaseMonsters()
	{
		gm.doomS = gm.objective.getScore(ChatColor.DARK_RED + "Doom Clock");
		gm.doomS.setScore(1300);
	}

	public void end()
	{
		gm.stage = Stage.LOBBY;

		Bukkit.getScheduler().cancelTask(timer);

		Bukkit.broadcastMessage(ChatColor.DARK_RED + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		Bukkit.broadcastMessage(ChatColor.DARK_RED + "  THE FINAL DWARVERN SHRINE HAS FALLEN");
		Bukkit.broadcastMessage(ChatColor.DARK_RED + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

		Iterator<UUID> it = gm.dwarves.keySet().iterator();
		while (it.hasNext())
		{
			UUID uuid = it.next();

			gm.dwarves.get(uuid).getPlayer().getInventory().clear();
			gm.dwarves.get(uuid).getPlayer().setDisplayName(gm.dwarves.get(uuid).getPlayer().getCustomName());
			gm.dwarves.get(uuid).getPlayer().setPlayerListName(gm.dwarves.get(uuid).getPlayer().getCustomName());
			gm.dwarves.get(uuid).getPlayer().setLevel(0);
			gm.dwarves.get(uuid).getPlayer().setExp(0f);
			gm.dwarves.get(uuid).getPlayer().setHealth(20);
			gm.dwarves.get(uuid).getPlayer().setFoodLevel(20);
			for (PotionEffect effect : gm.dwarves.get(uuid).getPlayer().getActivePotionEffects())
				gm.dwarves.get(uuid).getPlayer().removePotionEffect(effect.getType());
			gm.dwarves.get(uuid).getPlayer().teleport(gm.lobby);

			it.remove();
		}

		for (Player player : Bukkit.getOnlinePlayers())
		{
			player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
		}

		gm.reset();
	}

	public GameManager getGm()
	{
		return gm;
	}

	public void spawnSpectator(Player player)
	{
		player.getInventory().clear();
		if (player.getCustomName() == null)
			player.getPlayer().setCustomName(player.getName());
		ChangePlayerTag.changeTag(player, player.getCustomName());
		player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
		player.teleport(gm.lobby);
	}

}
