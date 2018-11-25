package dwarves.vs.zombies.dwarf.equipment.swords;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import dwarves.vs.zombies.dwarf.Dwarf;
import dwarves.vs.zombies.dwarf.superclasses.DwarfSword;
import dwarves.vs.zombies.misc.NMSItem;

public class Excaliju extends DwarfSword {

	public Excaliju(Dwarf dwarf)
	{
		super(dwarf, 10, true);
	}

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.INK_SAC);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.GOLD + "Excaliju");

		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Broken and reforged over a thousand times, a");
		lore.add("sword made of gold is said to be weaker than");
		lore.add("typical runebaldes, but the Old Man claims he");
		lore.add("just wants to give the monsters a better chance.");
		lore.add("Personally, I think he's straight bonkers.");
		lore.add(ChatColor.GOLD + "- Deadbones");
		meta.setLore(lore);
		
		meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 10, true);

		item.setItemMeta(meta);

		item = new NMSItem(item).addAttribute("generic.attackDamage", 30).addAttribute("generic.attackSpeed", 4).addAttribute("generic.knockbackResistance", 1).getItem();


//		NBTTagList ench = new NBTTagList();
//		NBTTagCompound enchant = new NBTTagCompound();
//		enchant.set("id", new NBTTagInt(34));
//		enchant.set("lvl", new NBTTagInt(10));
//		ench.add(enchant);
//		compound.set("ench", ench);

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
