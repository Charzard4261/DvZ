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

public class TombMaker extends DwarfSword {

	public TombMaker(Dwarf dwarf)
	{
		super(dwarf, 15, true, false);
	}

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.DIAMOND_SPADE);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.AQUA + "Tomb Maker");

		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + "Power: " + ChatColor.AQUA + "4");
		lore.add(ChatColor.YELLOW + "With this Shovel, you gain a Powerful Rampage for 5");
		lore.add(ChatColor.YELLOW + "seconds when shoveling gravel. Additional kills while");
		lore.add(ChatColor.YELLOW + "on a rampage will allow you to extend the duration.");
		lore.add(ChatColor.YELLOW + "Right Click to gain a haste buff to both dig and craft");
		lore.add(ChatColor.YELLOW + "faster as well as put an additional resource item you");
		lore.add(ChatColor.YELLOW + "gather into the Shared Recource Chest");
		meta.setLore(lore);

		item.setItemMeta(meta);

		net.minecraft.server.v1_12_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
		NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();
		NBTTagList modifiers = new NBTTagList();
		NBTTagCompound damage = new NBTTagCompound();
		damage.set("AttributeName", new NBTTagString("generic.attackDamage"));
		damage.set("Name", new NBTTagString("generic.attackDamage"));
		damage.set("Amount", new NBTTagInt(4));
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

		return item;
	}

	@Override
	protected void leftClick(PlayerInteractEvent event)
	{

	}

	@Override
	protected void onHit(EntityDamageByEntityEvent event)
	{

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
