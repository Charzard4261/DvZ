package dwarves.vs.zombies.monsters;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import dwarves.vs.zombies.Weapon;

public abstract class Monster {

	private UUID uuid;
	private Weapon weapon;

	public Monster(UUID uuid)
	{
		this.uuid = uuid;
	}

	public Player getPlayer()
	{
		return Bukkit.getPlayer(uuid);
	}

	public void setWeapon(Weapon weapon)
	{
		this.weapon = weapon;
	}

	public Weapon getWeapon()
	{
		return weapon;
	}

	public abstract void equipArmour();

	public abstract ArrayList<ItemStack> getItems();

	public abstract void onLeftClick(PlayerInteractEvent event);

	public abstract void onRightClick(PlayerInteractEvent event);

}
