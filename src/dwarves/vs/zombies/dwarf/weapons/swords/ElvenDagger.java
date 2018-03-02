package dwarves.vs.zombies.dwarf.weapons.swords;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import dwarves.vs.zombies.dwarf.Dwarf;
import dwarves.vs.zombies.dwarf.superclasses.DwarfSword;
import net.minecraft.server.v1_12_R1.NBTTagCompound;
import net.minecraft.server.v1_12_R1.NBTTagInt;
import net.minecraft.server.v1_12_R1.NBTTagList;
import net.minecraft.server.v1_12_R1.NBTTagString;

public class ElvenDagger extends DwarfSword {

	public ElvenDagger(Dwarf dwarf)
	{
		super(dwarf, 15, true, false);
	}

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 4);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.AQUA + "Elven Dagger");

		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + "Power: " + ChatColor.AQUA + "15");
		lore.add(ChatColor.YELLOW + "With this Dagger, you move more quickly and your");
		lore.add(ChatColor.YELLOW + "hits poison demons for 5 seconds. Right Click to");
		lore.add(ChatColor.YELLOW + "Eviserate which deals massive damage killing most");
		lore.add(ChatColor.YELLOW + "demons. This ability has a 60 second cooldown that");
		lore.add(ChatColor.YELLOW + "is reduced by 10 seconds for every bow kill.");
		meta.setLore(lore);

		item.setItemMeta(meta);

		net.minecraft.server.v1_12_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
		NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();
		NBTTagList modifiers = new NBTTagList();
		NBTTagCompound damage = new NBTTagCompound();
		damage.set("AttributeName", new NBTTagString("generic.attackDamage"));
		damage.set("Name", new NBTTagString("generic.attackDamage"));
		damage.set("Amount", new NBTTagInt(15));
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
    
    NBTTagCompound speed = new NBTTagCompound();
		speed.set("AttributeName", new NBTTagString("generic.movementSpeed"));
		speed.set("Name", new NBTTagString("generic.movementSpeed"));
		speed.set("Amount", new NBTTagDouble(0.8));
		speed.set("Operation", new NBTTagInt(0));
		speed.set("UUIDLeast", new NBTTagInt(894654));
		speed.set("UUIDMost", new NBTTagInt(2872));
		modifiers.add(speed);

		compound.set("AttributeModifiers", modifiers);

		nmsStack.setTag(compound);

		item = CraftItemStack.asBukkitCopy(nmsStack);

		return item;
	}

	@Override
	protected void leftClick(PlayerInteractEvent event)
	{

	}

	@Override
	protected void onHit(EntityDamageByEntityEvent event)
	{
    Player hit = (Player) event.getDamager();
		hit.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 6, 3, false, false), false);
	}

	@Override
	protected void special(PlayerInteractEvent event)
	{

	}

	@Override
	protected boolean special(PlayerInteractAtEntityEvent event)
	{

	}

}
