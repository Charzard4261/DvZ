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
	private Player player;
	private Weapon weapon;
	private Bow bow;
	private int proccing = 0;
	public boolean usedSpecial = false;
	public int specialTimer = 0;

	public Dwarf(UUID uuid)
	{
		this.uuid = uuid;
		this.player = Bukkit.getPlayer(uuid);
		this.weapon = new GreaterRuneblade();
		this.bow = new DragonskinBow();
		setPlayer();
	}

	public void setPlayer()
	{
		this.player = Bukkit.getPlayer(uuid);
		this.bow.setPlayer(player);
	}

	public Player getPlayer()
	{
		return player;
	}

	public Weapon getWeapon()
	{
		return weapon;
	}

	public void setWeapon(Weapon weapon)
	{
		this.weapon = null;
		this.weapon = weapon;
		setPlayer();
	}

	public Bow getBow()
	{
		return bow;
	}

	public void setBow(Bow bow)
	{
		this.bow = null;
		this.bow = bow;
		setPlayer();
	}

	public boolean isProccing()
	{
		if (proccing > 0)
			return true;
		return false;
	}

	public void giveProc()
	{
		proccing = 3;
	}

	public void giveProc(int i)
	{
		proccing = i;
	}

}
