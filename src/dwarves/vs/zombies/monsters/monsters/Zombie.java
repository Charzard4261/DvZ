package dwarves.vs.zombies.monsters.monsters;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import dwarves.vs.zombies.monsters.Monster;

public class Zombie extends Monster {

	UUID uuid;
	private ArrayList<ItemStack> items;
	
	public Zombie(UUID uuid)
	{
		super(uuid);
		this.uuid = uuid;
		items = new ArrayList<ItemStack>();
		ItemStack item1 = new ItemStack(Material.WOOD_PICKAXE); //Placeholder
		items.add(item1);
	}

	@Override
	public void equipArmour()
	{
		ItemStack item = new ItemStack(Material.SLIME_BALL);
		//TODO add attributes
		ItemStack air = new ItemStack(Material.AIR);
		
		Bukkit.getPlayer(uuid).getInventory().setArmorContents(new ItemStack[]{air, item, air, air});
	}

	@Override
	public ArrayList<ItemStack> getItems()
	{
		return items;
	}

	@Override
	public void onLeftClick(PlayerInteractEvent event)
	{
		//Check if player is holding an item
	}

	@Override
	public void onRightClick(PlayerInteractEvent event)
	{
		//Check if player is holding an item
	}

}
