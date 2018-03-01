package dwarves.vs.zombies.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ItemDropListener implements Listener {

	@EventHandler
	public void onItemDrop(PlayerDropItemEvent event)
	{

		switch (event.getItemDrop().getItemStack().getType())
		{
		case COBBLESTONE:
		case TORCH:
		case IRON_PICKAXE:
		case IRON_AXE:
		case IRON_SPADE:
		case DIAMOND:
		break;
		default:
			event.setCancelled(true);
			break;
		}

	}

}
