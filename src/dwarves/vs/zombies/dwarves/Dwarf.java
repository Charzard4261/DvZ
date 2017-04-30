package dwarves.vs.zombies.dwarves;

import org.bukkit.entity.Player;

import dwarves.vs.zombies.Weapon;
import dwarves.vs.zombies.dwarves.weapons.GreaterRuneblade;

public class Dwarf {

	private Player player;
	private Weapon weapon;
	private boolean proccing = false;

	public Dwarf(Player player)
	{
		this.player = player;
		this.weapon = new GreaterRuneblade(player);
	}

	public Player getPlayer()
	{
		return player;
	}

	public Weapon getWeapon()
	{
		return weapon;
	}

	public boolean isProccing()
	{
		return proccing;
	}
	
	public void setWeapon(Weapon weapon)
	{
		this.weapon = weapon;
	}

}
