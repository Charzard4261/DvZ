package dwarves.vs.zombies.command.commands;

import org.bukkit.entity.Player;

import dwarves.vs.zombies.Core;
import dwarves.vs.zombies.command.ACommand;
import dwarves.vs.zombies.dwarves.weapons.AxeOfMalice;
import dwarves.vs.zombies.dwarves.weapons.ElvenDagger;
import dwarves.vs.zombies.dwarves.weapons.Excaliju;
import dwarves.vs.zombies.dwarves.weapons.GreaterRuneblade;
import dwarves.vs.zombies.dwarves.weapons.Warhammer;

public class ItemCommand extends ACommand {

	public ItemCommand()
	{
		super("item", "ItemSwapper", new String[] {});
	}

	@Override
	protected void callCommand(Player p, String[] args)
	{
		if (!p.isOp())
			return;

		if (args == null)
			return;

		if (Core.getInstance().getDwarf(p) == null)
			return;

		p.getInventory().remove(Core.getInstance().getDwarf(p).getWeapon().getItem());

		if (args[0].equalsIgnoreCase("Dagger"))
			Core.getInstance().getDwarf(p).setWeapon(new ElvenDagger(p.getUniqueId()));

		if (args[0].equalsIgnoreCase("Excaliju"))
			Core.getInstance().getDwarf(p).setWeapon(new Excaliju(p.getUniqueId()));

		if (args[0].equalsIgnoreCase("Malice"))
			Core.getInstance().getDwarf(p).setWeapon(new AxeOfMalice(p.getUniqueId()));

		if (args[0].equalsIgnoreCase("Runeblade"))
			Core.getInstance().getDwarf(p).setWeapon(new GreaterRuneblade(p.getUniqueId()));

		if (args[0].equalsIgnoreCase("Hammer"))
			Core.getInstance().getDwarf(p).setWeapon(new Warhammer(p.getUniqueId()));

		p.getInventory().addItem(Core.getInstance().getDwarf(p).getWeapon().getItem());

	}

}
