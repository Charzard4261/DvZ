package dwarves.vs.zombies.command.commands;

import org.bukkit.entity.Player;

import dwarves.vs.zombies.command.ACommand;
import dwarves.vs.zombies.dwarf.items.ArmorDiamond;
import dwarves.vs.zombies.dwarf.items.DebugTool;
import dwarves.vs.zombies.dwarf.items.EnchantedLamp;
import dwarves.vs.zombies.dwarf.items.Mortar;
import dwarves.vs.zombies.dwarf.items.ScrollOfMagicStone;
import dwarves.vs.zombies.dwarf.items.SwordOfSanctification;
import dwarves.vs.zombies.dwarf.items.WigglyWrench;
import dwarves.vs.zombies.dwarf.items.WizardMortar;

public class AdminCommand extends ACommand {

	public AdminCommand()
	{
		super("admin", "OPERATOR", new String[] {});
	}

	@Override
	protected void callCommand(Player p, String[] args)
	{
		if (!p.isOp())
		{
			return;
		}

		p.getInventory().addItem(new DebugTool().getItem());
		p.getInventory().addItem(new ArmorDiamond().getItem());
		p.getInventory().addItem(new Mortar().getItem());
		p.getInventory().addItem(new WizardMortar().getItem());
		p.getInventory().addItem(new ScrollOfMagicStone().getItem());
		p.getInventory().addItem(new SwordOfSanctification().getItem());
		p.getInventory().addItem(new WigglyWrench().getItem());
		p.getInventory().addItem(new EnchantedLamp().getItem());

	}

}
