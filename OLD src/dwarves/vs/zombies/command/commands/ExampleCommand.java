package dwarves.vs.zombies.command.commands;

import org.bukkit.entity.Player;

import dwarves.vs.zombies.command.ACommand;

public class ExampleCommand extends ACommand {

	public ExampleCommand()
	{
		super("ExampleCommand", "Random Bull", new String[]{});
		// "Name", "Some random lul", new String[]{"Can also be used to call command", "Another way to call command"}
	}

	@Override
	protected void callCommand(Player p, String[] args)
	{
		//Command goes in here
	}

}
