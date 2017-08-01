package dwarves.vs.zombies.dwarves;

import org.bukkit.Bukkit;

public class DwarfSpecialTimer implements Runnable {

	private int id;
	private Dwarf dwarf;

	@Override
	public void run()
	{
		dwarf.specialTimer -= 1;

		if (dwarf.specialTimer == 0)
		{
			dwarf.usedSpecial = false;
			Bukkit.getScheduler().cancelTask(id);
		}
	}

	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setDwarf(Dwarf dwarf)
	{
		this.dwarf = dwarf;
	}

}