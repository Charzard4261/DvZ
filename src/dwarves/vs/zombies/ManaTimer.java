package dwarves.vs.zombies;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import dwarves.vs.zombies.dwarves.OldManWillakers;

public class ManaTimer implements Runnable {

	public void run()
	{
		for (Player player : Bukkit.getOnlinePlayers())
		{
			if (Core.getInstance().getDwarf(player) != null)
			{
				if (Core.getInstance().getDwarf(player) instanceof OldManWillakers)
				{

				} else
				{
					if (player.getFoodLevel() >= 10)
					{
						if (player.getLevel() > 975)
							player.setLevel(1000);
						else
							player.giveExpLevels(25);
					} else if (player.getFoodLevel() >= 4)
						if (player.getLevel() > 980)
							player.setLevel(1000);
						else
							player.giveExpLevels(15);
					else if (player.getFoodLevel() >= 0)
						if (player.getLevel() > 985)
							player.setLevel(1000);
						else
							player.giveExpLevels(10);
					else if (player.getFoodLevel() >= 4)
						if (player.getLevel() > 995)
							player.setLevel(1000);
						else
							player.giveExpLevels(5);
					else if (player.getFoodLevel() == 0)
						if (player.getLevel() > 998)
							player.setLevel(1000);
						else
							player.giveExpLevels(2);
				}
			} else if (Core.getInstance().getMonster(player) != null)
			{
				if (player.getLevel() > 997)
					player.setLevel(1000);
				else
					player.giveExp(3);
			}

		}
	}
}
