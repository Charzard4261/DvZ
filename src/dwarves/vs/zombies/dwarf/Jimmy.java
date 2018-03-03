package dwarves.vs.zombies.dwarf;

import java.util.UUID;

import dwarves.vs.zombies.dwarf.equipment.ales.JimmyJuice;
import dwarves.vs.zombies.dwarf.equipment.bows.DragonskinBow;
import dwarves.vs.zombies.dwarf.equipment.swords.Runeblade;
import dwarves.vs.zombies.dwarf.superclasses.DwarfAle;
import dwarves.vs.zombies.dwarf.superclasses.DwarfBow;
import dwarves.vs.zombies.dwarf.superclasses.DwarfSpecial;
import dwarves.vs.zombies.dwarf.superclasses.DwarfSword;
import dwarves.vs.zombies.misc.ArmourSet;
import net.md_5.bungee.api.ChatColor;

public class Jimmy extends Dwarf {

	private DwarfSword sword = new Runeblade(this);
	private DwarfBow bow = new DragonskinBow(this);
	private DwarfAle ale = new JimmyJuice(this);
	
	public Jimmy(UUID uuid)
	{
		super(uuid);
	}

	public Jimmy(UUID uuid, String title)
	{
		super(uuid);
		getPlayer().setCustomName(ChatColor.AQUA + title + " " + getPlayer().getDisplayName());
		getPlayer().setPlayerListName(ChatColor.AQUA + title + " " + getPlayer().getDisplayName());
	}
	
	@Override
	public DwarfSword getSword()
	{
		return sword;
	}

	@Override
	public DwarfBow getBow()
	{
		return bow;
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
