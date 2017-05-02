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

public class DragonskinBow extends Weapon implements Listener {

	private static String DISPLAY_BOW_NAME = ChatColor.AQUA + "Dragonskin Bow";

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
				arrow.spigot().setDamage(20);

			}

		}
	}
