package dwarves.vs.zombies.command;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

public abstract class ACommand extends BukkitCommand {

	String name;
	String command_host;

	public ACommand(String name, String command_host, String... alias)
	{
		super(name);
		this.name = name;
		this.command_host = command_host;
		for (String ali : alias)
		{
			this.getAliases().add(ali);
		}
	}

	@Override
	public final boolean execute(CommandSender sender, String command,
			String[] args)
	{
		if (!(sender instanceof Player))
		{
			sender.sendMessage(ChatColor.RED
					+ "The Console Command Sender cannot send this command!");
			return true;
		}
		Player pl = (Player) sender;

		this.callCommand(pl, args);

		return true;
	}

	protected abstract void callCommand(Player p, String[] args);

	public String getName()
	{
		return name;
	}

	public String getHost()
	{
		return command_host;
	}

}
