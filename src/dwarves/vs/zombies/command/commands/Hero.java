package dwarves.vs.zombies.command.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import dwarves.vs.zombies.command.ACommand;

public class Hero extends ACommand {

	public Hero()
	{
		super("hero", "HeroHandler", new String[]{});
	}

	@Override
	protected void callCommand(Player p, String[] args)
	{
		if (args.length == 0)
		{
			p.sendMessage(ChatColor.RED + "Invalid Command Arguments: /hero <Player> <Hero>");
		} else if (args.length == 1)
		{
			p.sendMessage("Juuust right");
		}
	}

}
