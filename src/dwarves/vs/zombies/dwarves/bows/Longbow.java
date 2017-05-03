package dwarves.vs.zombies.dwarves.weapons;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import dwarves.vs.zombies.Core;
import dwarves.vs.zombies.Weapon;

public class Longbow extends Weapon implements Listener {

	private static String DISPLAY_BOW_NAME = ChatColor.AQUA + "Ranger's Longbow";
	
	public ItemStack getItem()
	{
		ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 3);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA + "Ranger's Longbow");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(Chatcolor.YELLOW + "Power: " Chatcolor.Aqua + "50 to 200"
		lore.add(ChatColor.YELLOW + "With this Bow, you gain a stacking damage buff");
		lore.add(ChatColor.YELLOW + "everytime you kill a Demon with it which increases");
		lore.add(ChatColor.YELLOW + "it's power by 25 for 15 seconds and can stack up to");
		lore.add(ChatColor.YELLOW + "6 times for a total of 200 power");
		meta.setLore(lore);
	        meta.setUnbreakable(true);
		item.setItemMeta(meta);

	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
	}

	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
	public void onShoot(EntityShootBowEvent event) {
		if (event.getEntity() instanceof Player && event.getProjectile() instanceof Arrow && event.getBow().hasItemMeta()) {

			ItemMeta m = event.getBow().getItemMeta();

			if (m.hasDisplayName() && DISPLAY_BOW_NAME.equals(m.getDisplayName())) {

				Player shooter = (Player) event.getEntity();

				Arrow arrow = (Arrow) event.getProjectile();

				arrow.setFireTicks(0);
				arrow.setVelocity(arrow.getVelocity().multiply(1));
				arrow.setKnockbackStrength(1);
				arrow.setCritical(false);
				arrow.spigot().setDamage(50);

			}

		}
	}
