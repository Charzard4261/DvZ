package dwarves.vs.zombies.dwarves;

import java.util.UUID;

import dwarves.vs.zombies.dwarves.weapons.RighteousFury;

public class Roamin extends Dwarf{

	public Roamin(UUID uuid)
	{
		super(uuid);
		setWeapon(new RighteousFury(uuid));
		//setBow(new HolyPurifier(uuid));
	}

}
