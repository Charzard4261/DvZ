package dwarves.vs.zombies.dwarves.bows;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dwarves.vs.zombies.Bow;
import dwarves.vs.zombies.Core;

public class DragonskinBow extends Bow{

	Player player;
	public int timer;
	public boolean usedSpecial;

	@Override
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.BOW);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.GOLD + "Virendra");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + "The men tell me that ever since I started using it");
		lore.add(ChatColor.YELLOW + "my shots have become more accurate, more powerful.");
		lore.add(ChatColor.YELLOW + "But the truth is that when I draw this bow.");
		lore.add(ChatColor.YELLOW + "When I hold her in my hands.");
		lore.add(ChatColor.YELLOW + "All I can feel is her love for me and my hate for myself.");
		lore.add(ChatColor.GOLD + "- Bruce Willakers"
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
		Core.getInstance().getDwarf(player).giveProc();
	}
}
