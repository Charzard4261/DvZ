package dwarves.vs.zombies.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import dwarves.vs.zombies.Core;
import dwarves.vs.zombies.dwarf.Dwarf;
import dwarves.vs.zombies.enums.Stage;
import dwarves.vs.zombies.monster.MData;
import net.md_5.bungee.api.ChatColor;

public class ChatListener implements Listener {

	@EventHandler
	public void onChat(AsyncPlayerChatEvent event)
	{
		if (event.getMessage().startsWith("!"))
			event.setFormat("[!]<" + "%s" + ChatColor.WHITE + "> " + "%s");
		else
		{
			event.setFormat("<" + "%s" + ChatColor.WHITE + "> " + "%s");
			if (Core.getInstance().getGm().stage != Stage.LOBBY)
			{
				event.getRecipients().clear();
				if (Core.getInstance().getGm().dwarves.containsKey(event.getPlayer().getUniqueId()))
					for (Dwarf dwarf : Core.getInstance().getGm().dwarves.values())
					{
						event.getRecipients().add(dwarf.getPlayer());
					}
				else if (Core.getInstance().getGm().monsters.containsKey(event.getPlayer().getUniqueId()))
					for (MData monster : Core.getInstance().getGm().monsters.values())
					{
						event.getRecipients().add(monster.getPlayer());
					}
			}
		}
	}

}
