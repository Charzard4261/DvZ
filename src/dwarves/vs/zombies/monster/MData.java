package dwarves.vs.zombies.monster;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import dwarves.vs.zombies.misc.PlayerType;

public class MData extends PlayerType {

	private UUID uuid;

	private int mana = 0;

	private Monster monster;

	public MData(UUID uuid)
	{
		this.uuid = uuid;
	}

	public void modifyMana(int amount, boolean add)
	{
		if (add)
		{
			mana += amount;
		} else
			mana -= amount;

		getPlayer().setLevel(mana);
		getPlayer().setExp(mana / 10);
	}

	public Player getPlayer()
	{
		return Bukkit.getPlayer(uuid);
	}

	public Monster getMonster()
	{
		return monster;
	}
	
	public void spawnSpectator()
	{
		
	}
	
	public void spawnMonster()
	{
		
	}
}
