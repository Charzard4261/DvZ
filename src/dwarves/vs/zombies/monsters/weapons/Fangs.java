package dwarves.vs.zombies.monsters.weapons;

import net.minecraft.server.v1_11_R1.NBTTagCompound;
import net.minecraft.server.v1_11_R1.NBTTagInt;
import net.minecraft.server.v1_11_R1.NBTTagList;
import net.minecraft.server.v1_11_R1.NBTTagString;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_11_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import dwarves.vs.zombies.Weapon;

public class Fangs extends Weapon {

	public Fangs(Player player)
	{
		super(player, false, false);
	}

	@Override
	public ItemStack getItem()
	{

		ItemStack item = new ItemStack(Material.SUGAR, 1, (short) 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.RED + "Wolf Fangs");
		item.setItemMeta(meta);

		net.minecraft.server.v1_11_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
		NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();
		NBTTagList modifiers = new NBTTagList();
		NBTTagCompound damage = new NBTTagCompound();
		damage.set("AttributeName", new NBTTagString("generic.attackDamage"));
		damage.set("Name", new NBTTagString("generic.attackDamage"));
		damage.set("Amount", new NBTTagInt(16));
		damage.set("Operation", new NBTTagInt(0));
		damage.set("UUIDLeast", new NBTTagInt(894654));
		damage.set("UUIDMost", new NBTTagInt(2872));
		damage.set("Slot", new NBTTagString("mainhand"));
		modifiers.add(damage);

		NBTTagCompound attackSpeed = new NBTTagCompound();
		attackSpeed.set("AttributeName", new NBTTagString("generic.attackSpeed"));
		attackSpeed.set("Name", new NBTTagString("generic.attackSpeed"));
		attackSpeed.set("Amount", new NBTTagInt(4));
		attackSpeed.set("Operation", new NBTTagInt(0));
		attackSpeed.set("UUIDLeast", new NBTTagInt(894654));
		attackSpeed.set("UUIDMost", new NBTTagInt(2872));
		attackSpeed.set("Slot", new NBTTagString("mainhand"));
		modifiers.add(attackSpeed);

		compound.set("AttributeModifiers", modifiers);

		nmsStack.setTag(compound);

		item = CraftItemStack.asBukkitCopy(nmsStack);

		return null;
	}

	@Override
	public void normal()
	{
		// THIS FIRES WHEN THE PLAYER PUNCHES NESSIE LOOK AT THESE TWO METHODS

	}

	@Override
	public void special()
	{
		// THIS IS USE SPECIAL, AKA LEAP
		
	}

	@Override
	public void damage(EntityDamageByEntityEvent event)
	{   
		// At this point, 'player' doesn't exist as a variable
		Player player = (Player) event.getDamager(); //CRITICAL but for this event it's   does sound need to be imported from anywhere? (bet nothing i put here is good)
                player.playSound(player.getLocation(), "ENTITY_WOLF_GROWL", 4F, 1F);                          // plays growl sound
		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5, 1, false, false), false);  // gives the speed
		player.setHealth(player.getHealth() + 2);
		
		if(player.getWorld().getTime() > 23850) 
		{
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 8, 1, false, false), false);
			player.setHealth(player.getHealth() + 4);
		}
			
	}

}
