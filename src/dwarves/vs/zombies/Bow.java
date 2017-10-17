package dwarves.vs.zombies;

import java.util.ArrayList;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;

public abstract class Bow {

	public ArrayList<Entity> shotprojectiledata = new ArrayList<Entity>();

	public abstract ItemStack getItem();

	public abstract void setPlayer(Player player);

	public abstract void onFire(EntityShootBowEvent event);

	public abstract void onHit(EntityDamageByEntityEvent event);

}
