package dwarves.vs.zombies.command.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import dwarves.vs.zombies.Core;
import dwarves.vs.zombies.command.ACommand;

public class OnlineCommand extends ACommand {

	public OnlineCommand()
	{
		super("online", "Online", new String[] {"who", "list"});
	}

	@Override
	protected void callCommand(Player p, String[] args)
	{
		p.sendMessage(" ");
		p.sendMessage(ChatColor.YELLOW + "PLAYERS ONLINE " + Bukkit.getOnlinePlayers().size() + ":");
		if (Core.getInstance().dwarves.size() != 0) {
		p.sendMessage(ChatColor.AQUA + " Dwarves (" + Core.getInstance().dwarves.size() + "");
		p.sendMessage("");
		
		}
		p.sendMessage(" ");
	}

}
