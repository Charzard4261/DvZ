package dwarves.vs.zombies.command.commands;

import org.bukkit.entity.Player;

import dwarves.vs.zombies.Core;
import dwarves.vs.zombies.command.ACommand;
import dwarves.vs.zombies.dwarves.weapons.AxeOfMalice;
import dwarves.vs.zombies.dwarves.weapons.ElvenDagger;
import dwarves.vs.zombies.dwarves.weapons.Excaliju;
import dwarves.vs.zombies.dwarves.weapons.GreaterRuneblade;

public class ItemCommand extends ACommand {

	public ItemCommand()
	{
		super("item", "ItemSwapper", new String[] {});
	}

	@Override
	protected void callCommand(Player p, String[] args)
	{
		if (args == null)
			return;
		
		if (args.length != 2)
			return;
		
		if (!p.isOp())
			return;

		if (Core.getInstance().getDwarf(p) == null)
			return;

		if (args[0].equalsIgnoreCase("Axe"))
			Core.getInstance().getDwarf(p).setWeapon(new AxeOfMalice());
		
		if (args[0].equalsIgnoreCase("Dagger"))
			Core.getInstance().getDwarf(p).setWeapon(new ElvenDagger());
		
		if (args[0].equalsIgnoreCase("Runeblade"))
			Core.getInstance().getDwarf(p).setWeapon(new GreaterRuneblade());

		if (args[0].equalsIgnoreCase("Excaliju"))
			Core.getInstance().getDwarf(p).setWeapon(new Excaliju());

		p.getInventory().addItem(Core.getInstance().getDwarf(p).getWeapon().getItem());

	}

}
