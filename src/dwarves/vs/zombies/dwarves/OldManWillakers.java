package dwarves.vs.zombies.dwarves;

import org.bukkit.entity.Player;

import dwarves.vs.zombies.dwarves.weapons.Excaliju;

public class OldManWillakers extends Dwarf {

	public OldManWillakers(Player player)
	{
		super(player);
		setWeapon(new Excaliju(player));
	}

}
