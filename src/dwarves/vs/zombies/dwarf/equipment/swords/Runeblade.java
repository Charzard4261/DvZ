package dwarves.vs.zombies.dwarf.equipment.swords;

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

public class Runeblade extends DwarfSword {

	public Runeblade(Dwarf dwarf)
	{
		super(dwarf, 15, true);
	}

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 3);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.AQUA + "Greater Runeblade");

		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GOLD + "With this Blade, killing demons grants you a Powerful");
		lore.add(ChatColor.GOLD + "Rampage for 3 seconds with allows you to instantly");
		lore.add(ChatColor.GOLD + "kill most demons.");
		lore.add(ChatColor.GOLD + "Right Click to Runedash which dashes you forward");
		lore.add(ChatColor.GOLD + "making you breifly immune to damage and granting");
		lore.add(ChatColor.GOLD + "you a Powerful Rampage for 0.5 seconds.");
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
	protected boolean special(PlayerInteractEvent event)
	{
		getDwarf().getPlayer().getWorld().playSound(getDwarf().getPlayer().getLocation(), "runebladeRunedash", 4F, 1F);
		getDwarf().getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5, 3, false, false), false);
		getDwarf().getPlayer().addPotionEffect(
				new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 5, Integer.MAX_VALUE, false, false), false);
		getDwarf().getPlayer().setVelocity(getDwarf().getPlayer().getLocation().getDirection().multiply(2).setY(0.2));
		
		return true;
	}

	@Override
	protected boolean special(PlayerInteractAtEntityEvent event)
	{
		getDwarf().getPlayer().playSound(getDwarf().getPlayer().getLocation(), "runebladeRunedash", 4F, 1F);
		getDwarf().getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5, 3, false, false), false);
		getDwarf().getPlayer().addPotionEffect(
				new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 5, Integer.MAX_VALUE, false, false), false);
		getDwarf().getPlayer().setVelocity(getDwarf().getPlayer().getLocation().getDirection().multiply(2).setY(0.2));

		return true;
	}

}
