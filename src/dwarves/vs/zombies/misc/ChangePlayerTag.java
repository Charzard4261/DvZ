package dwarves.vs.zombies.misc;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_13_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.bukkit.scoreboard.Team.Option;
import org.bukkit.scoreboard.Team.OptionStatus;

import com.mojang.authlib.GameProfile;

import dwarves.vs.zombies.Core;
import net.minecraft.server.v1_13_R2.EntityPlayer;

public class ChangePlayerTag {

	public static void changeTag(Player playerToChange, String newName)
	{
		EntityPlayer ep = ((CraftPlayer) playerToChange).getHandle();
		GameProfile gp = ep.getProfile();
		
		try
		{
			Field profileField = gp.getClass().getDeclaredField("name");
			profileField.setAccessible(true);
			profileField.set(gp, newName);
		} catch (Exception e)
		{
			Bukkit.broadcastMessage("Change player tag did not work! " + playerToChange + " " + newName);
		}

		for (Player p : Bukkit.getOnlinePlayers())
		{
			if (p != playerToChange)
			{
				p.hidePlayer(Core.getInstance(), playerToChange);
				p.showPlayer(Core.getInstance(), playerToChange);
			}
		}
	}
	
	// CODE AFTER HERE WAS MADE BY SPIGOT USER lim_bo56 FOUND AT https://www.spigotmc.org/threads/change-players-name-tag.191025/
    private static Team team;
    private static Scoreboard scoreboard;
 
    public static void changePlayerName(Player player, String prefix, String suffix, TeamAction action) {
        if (player.getScoreboard() == null || prefix == null || suffix == null || action == null) {
            return;
        }
 
        scoreboard = player.getScoreboard();
 
        if (scoreboard.getTeam(player.getName()) == null) {
            scoreboard.registerNewTeam(player.getName());
        }
 
        team = scoreboard.getTeam(player.getName());
        team.setPrefix(Color(prefix));
        team.setSuffix(Color(suffix));
        team.setOption(Option.NAME_TAG_VISIBILITY, OptionStatus.ALWAYS);
 
        switch (action) {
            case CREATE:
                team.addEntry(player.getName());
                break;
            case UPDATE:
                team.unregister();
                scoreboard.registerNewTeam(player.getName());
                team = scoreboard.getTeam(player.getName());
                team.setPrefix(Color(prefix));
                team.setSuffix(Color(suffix));
                team.setOption(Option.NAME_TAG_VISIBILITY, OptionStatus.ALWAYS);
                team.addEntry(player.getName());
                break;
            case DESTROY:
                team.unregister();
                break;
        }
    }
 
    private static String Color(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }
    
    public enum TeamAction {
        CREATE, DESTROY, UPDATE
    }

}
