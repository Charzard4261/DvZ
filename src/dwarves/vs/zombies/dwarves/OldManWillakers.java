package dwarves.vs.zombies.dwarves;

import java.util.UUID;

import dwarves.vs.zombies.dwarves.bows.Virendra;
import dwarves.vs.zombies.dwarves.weapons.Excaliju;

public class OldManWillakers extends Dwarf {

	public OldManWillakers(UUID uuid)
	{
		super(uuid);
		setWeapon(new Excaliju(uuid));
		setBow(new Virendra(uuid));
	}

	@Override
	public void giveProc()
	{
		this.proccing = 5;
	}

}
