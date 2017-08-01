package dwarves.vs.zombies.dwarves;

import java.util.ArrayList;

import dwarves.vs.zombies.Weapon;
import dwarves.vs.zombies.dwarves.weapons.AxeOfMalice;
import dwarves.vs.zombies.dwarves.weapons.ElvenDagger;
import dwarves.vs.zombies.dwarves.weapons.Excaliju;
import dwarves.vs.zombies.dwarves.weapons.GreaterRuneblade;
import dwarves.vs.zombies.dwarves.weapons.Tombmaker;

public class WeaponsRegistry {

	public ArrayList<Weapon> weapons = new ArrayList<Weapon>();

	public WeaponsRegistry()
	{
		addWeapon(new AxeOfMalice());
		addWeapon(new ElvenDagger());
		addWeapon(new Excaliju());
		addWeapon(new GreaterRuneblade());
		addWeapon(new Tombmaker());
	}

	public void addWeapon(Weapon weapon)
	{
		weapons.add(weapon);
	}

	public ArrayList<Weapon> getWeapons()
	{
		return weapons;
	}

}
