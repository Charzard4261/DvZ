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
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA + "sword");
		item.setItemMeta(meta);

		net.minecraft.server.v1_11_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(item1);
		NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();
		NBTTagList modifiers = new NBTTagList();
		NBTTagCompound damage = new NBTTagCompound();
		damage.set("AttributeName", new NBTTagString("generic.attackDamage"));
		damage.set("Name", new NBTTagString("generic.attackDamage"));
		damage.set("Amount", new NBTTagInt(10));
		damage.set("Operation", new NBTTagInt(0));
		damage.set("UUIDLeast", new NBTTagInt(894654));
		damage.set("UUIDMost", new NBTTagInt(2872));
		damage.set("Slot", new NBTTagString("mainhand"));
		modifiers.add(damage);
		
		compound.set("AttributeModifiers", modifiers);

		nmsStack.setTag(compound);

		item1 = CraftItemStack.asBukkitCopy(nmsStack);

		return item1;
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
