package dwarves.vs.zombies.command.commands;

import org.bukkit.entity.Player;

import dwarves.vs.zombies.Core;
import dwarves.vs.zombies.command.ACommand;
import dwarves.vs.zombies.enums.Stage;
import net.md_5.bungee.api.ChatColor;

public class GameCommand extends ACommand {

	public GameCommand()
	{
		super("game", "Game Master", new String[] {});
	}

	@Override
	protected void callCommand(Player p, String[] args)
	{
		if (!p.isOp())
		{
			return;
		}
		if (args.length < 1)
			p.sendMessage(ChatColor.RED + "Correct usage is /game <start/stop>");
		else
		{
			switch (args[0])
			{
			case "start":
				if (Core.getInstance().getGm().stage == Stage.LOBBY)
				{
					Core.getInstance().start();
				}
				else
					p.sendMessage(ChatColor.RED + "Game is in progress");
				break;
			case "stop":
				if (Core.getInstance().getGm().stage != Stage.LOBBY)
				{
					Core.getInstance().end();
				}
				else
					p.sendMessage(ChatColor.RED + "Game is not in progress");
				break;
			default:
				p.sendMessage(ChatColor.RED + "Correct usage is /game <start/stop>");
				break;

			}
		}

	}

}
