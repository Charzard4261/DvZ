package dwarves.vs.zombies.command.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import dwarves.vs.zombies.Core;
import dwarves.vs.zombies.Core.GameState;
import dwarves.vs.zombies.command.ACommand;

public class GameCmd extends ACommand {

	public GameCmd()
	{
		super("game", "GameMaster", new String[] {});
	}

	@Override
	protected void callCommand(Player p, String[] args)
	{
		if (!(p.isOp()))
			return;

		if (args.length == 0 || args.length > 1)
		{
			p.sendMessage(ChatColor.RED + "Invalid Command Arguments: /game <Start/Stop>");
		} else if (args.length == 1)
		{
			if (args[0].equalsIgnoreCase("start"))
			{
				if (Core.getInstance().gs == GameState.Lobby)
					Core.getInstance().startGame();
				else 
					p.sendMessage("A game is already in progress!");
			} else if (args[0].equalsIgnoreCase("stop"))
			{
				if (Core.getInstance().gs == GameState.Lobby)
					p.sendMessage("A game is not in progress!");
				else 
					Core.getInstance().endGame();
			} else
			{
				p.sendMessage(ChatColor.RED + "Invalid Command Arguments: /game <Start/Stop>");
				p.sendMessage(ChatColor.RED + args[0]);
			}
		}
	}

}
