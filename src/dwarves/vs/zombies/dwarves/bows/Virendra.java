package dwarves.vs.zombies.dwarves.bows;

import java.util.ArrayList;
import java.util.UUID;

import net.minecraft.server.v1_11_R1.NBTTagCompound;
import net.minecraft.server.v1_11_R1.NBTTagInt;
import net.minecraft.server.v1_11_R1.NBTTagList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_11_R1.inventory.CraftItemStack;
import org.bukkit.entity.Arrow;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.Bow;
import dwarves.vs.zombies.Core;

public class Virendra extends Bow {

	public Virendra(UUID uuid)
	{
		super(uuid);
	}

	public int timer;
	public boolean usedSpecial;

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.BOW);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.GOLD + "Virendra");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("The men tell me that ever since I started using it");
		lore.add("my shots have become more accurate, more powerful.");
		lore.add("But the truth is that when I draw this bow.");
		lore.add("When I hold her in my hands.");
		lore.add("All I can feel is her love for me and my hate for myself.");
		lore.add(ChatColor.GOLD + "- Bruce Willakers");
		meta.setLore(lore);
		meta.setUnbreakable(true);
		item.setItemMeta(meta);
		
		net.minecraft.server.v1_11_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
		NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();

		NBTTagList ench = new NBTTagList();
		NBTTagCompound enchant = new NBTTagCompound();
		enchant.set("id", new NBTTagInt(34));
		enchant.set("lvl", new NBTTagInt(10));
		ench.add(enchant);
		compound.set("ench", ench);

		nmsStack.setTag(compound);

		item = CraftItemStack.asBukkitCopy(nmsStack);

		return item;
	}

	@Override
	public void onFire(EntityShootBowEvent event)
	{
		Arrow arrow = (Arrow) event.getProjectile();
		arrow.setFireTicks(0);
		arrow.setVelocity(arrow.getVelocity().multiply(1));
		arrow.setKnockbackStrength(100);
		arrow.setCritical(false);
		arrow.spigot().setDamage(1000); // Damage
	}

	@Override
	public void onHit(EntityDamageByEntityEvent event)
	{
		if (!(event.getEntity().isDead()))
			return;
		Core.getInstance().getDwarf(getPlayer()).giveProc();
		
        if (event.getDamager() instanceof Arrow)
        {
            Arrow a = (Arrow) event.getDamager();
            if (a.getShooter() instanceof Player)
            {
                Player p = (Player) a.getShooter();
                Player p2 = (Player) event.getEntity();
                Location loc = event.getEntity().getLocation();
                Location loc2 = event.getDamager().getLocation();
               
                if (loc.distance(loc2) >= 5) {
                    p2.damage(200);
                }
               
            }
	}
}
