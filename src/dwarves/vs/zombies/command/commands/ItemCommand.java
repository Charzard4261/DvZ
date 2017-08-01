package dwarves.vs.zombies.command.commands;

import org.bukkit.entity.Player;

import dwarves.vs.zombies.Core;
import dwarves.vs.zombies.command.ACommand;
import dwarves.vs.zombies.dwarves.weapons.AxeOfMalice;
import dwarves.vs.zombies.dwarves.weapons.ElvenDagger;
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
		
		if (!p.isOp())
			return;

		if (Core.getInstance().getDwarf(p) == null)
			return;

		p.getInventory().remove(Core.getInstance().getDwarf(p).getWeapon().getItem());

		if (args[0].equalsIgnoreCase("Runeblade"))
			Core.getInstance().getDwarf(p).setWeapon(new GreaterRuneblade(p));
		
		if (args[0].equalsIgnoreCase("Axe"))
			Core.getInstance().getDwarf(p).setWeapon(new AxeOfMalice(p));
		
		if (args[0].equalsIgnoreCase("Dagger"))
			Core.getInstance().getDwarf(p).setWeapon(new ElvenDagger(p));

		p.getInventory().addItem(Core.getInstance().getDwarf(p).getWeapon().getItem());

	}

}
