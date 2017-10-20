package dwarves.vs.zombies.monsters.weapons;

import java.util.ArrayList;

import net.minecraft.server.v1_11_R1.NBTTagCompound;
import net.minecraft.server.v1_11_R1.NBTTagInt;
import net.minecraft.server.v1_11_R1.NBTTagList;
import net.minecraft.server.v1_11_R1.NBTTagString;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_11_R1.inventory.CraftItemStack;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.Bow;


public class BoneToothBow extends Bow implements Listener {

	Player player;
	public int timer;
	public boolean usedSpecial;

	@Override
    public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.BOW);
	    ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.RED + "BoneTooth Bow");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.RED + "Made from the bones of dead dwarves");
		meta.setLore(lore);
		meta.setUnbreakable(true);
		item.setItemMeta(meta);
		return item;
	}

	@Override
	public void setPlayer(Player player)
	{
		this.player = player;
	}

	@Override
	public void onFire(EntityShootBowEvent event)
	{
		Arrow arrow = (Arrow) event.getProjectile();
		arrow.setFireTicks(100);
		arrow.setVelocity(arrow.getVelocity().multiply(1));
		arrow.setKnockbackStrength(1);
		arrow.setCritical(false);
		arrow.spigot().setDamage(5); // Damage not sure this is the right amount but the wiki said it
		
		// add volley
	}

	@Override
	public void onHit(EntityDamageByEntityEvent event)
	{

	}
}
