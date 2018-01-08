package dwarves.vs.zombies.dwarves;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import dwarves.vs.zombies.Bow;
import dwarves.vs.zombies.Weapon;
import dwarves.vs.zombies.dwarves.bows.DragonskinBow;
import dwarves.vs.zombies.dwarves.weapons.GreaterRuneblade;

public class Dwarf {

	private UUID uuid;
	private Weapon weapon;
	private Bow bow;
	protected int proccing = 0;

	public Dwarf(UUID uuid)
	{
		this.uuid = uuid;
		this.weapon = new GreaterRuneblade(uuid);
		this.bow = new DragonskinBow(uuid);
	}

	public Player getPlayer()
	{
		return Bukkit.getPlayer(uuid);
	}

	public Weapon getWeapon()
	{
		return weapon;
	}

	public void setWeapon(Weapon weapon)
	{
		this.weapon = null;
		this.weapon = weapon;
	}

	public Bow getBow()
	{
		return bow;
	}

	public void setBow(Bow bow)
	{
		this.bow = null;
		this.bow = bow;
	}

	public boolean isProccing()
	{
		if (proccing > 0)
			return true;
		return false;
	}

	public void giveBruceProc()
	{
		proccing = 5;
	}
	
	public void giveMaliceProc() //also can be used for horn
	{
		proccing = 8;
	}
	
	public void giveDragonskinProc()
	{
		proccing = 2;
	}
	
	public void giveProc()
	{
		proccing = 3;
	}

}
