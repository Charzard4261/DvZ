package dwarves.vs.zombies.dwarf;

import java.util.UUID;

import org.bukkit.ChatColor;

import dwarves.vs.zombies.dwarf.equipment.ales.JimmyJuice;
import dwarves.vs.zombies.dwarf.equipment.bows.DragonskinBow;
import dwarves.vs.zombies.dwarf.equipment.swords.Runeblade;
import dwarves.vs.zombies.dwarf.superclasses.DwarfAle;
import dwarves.vs.zombies.dwarf.superclasses.DwarfBow;
import dwarves.vs.zombies.dwarf.superclasses.DwarfSpecial;
import dwarves.vs.zombies.dwarf.superclasses.DwarfSword;
import dwarves.vs.zombies.misc.ArmourSet;

public class Jimmy extends Dwarf {

	private DwarfAle ale = new JimmyJuice(this);

	public Jimmy(UUID uuid)
	{
		super(uuid);

		DwarfSword sword = new Runeblade(this);
		meleeWeapons.put(sword.getItem(), sword);
		DwarfBow bow = new DragonskinBow(this);
		bowWeapons.put(bow.getItem(), bow);
	}

	public void setTitle(String title)
	{
		getPlayer().setCustomName(ChatColor.AQUA + title + " " + getPlayer().getDisplayName());
		getPlayer().setPlayerListName(ChatColor.AQUA + title + " " + getPlayer().getDisplayName());
	}

	@Override
	public DwarfAle getAle()
	{
		return ale;
	}

	@Override
	public DwarfSpecial getSpecial()
	{
		return null;
	}

	@Override
	public ArmourSet getArmour()
	{
		return null;
	}

}
