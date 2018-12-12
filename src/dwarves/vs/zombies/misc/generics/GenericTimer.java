package dwarves.vs.zombies.misc.generics;

import org.bukkit.Bukkit;

public abstract class GenericTimer implements Runnable {

	private int id;
	public int timer;

	public GenericTimer(int timer)
	{
		this.timer = timer;
	}

	@Override
	public void run()
	{
		if (timer <= 0)
		{
			onTimerComplete();
			Bukkit.getScheduler().cancelTask(id);
		}
		timer--;
	}

	public abstract void onTimerDecrease();
	public abstract void onTimerComplete();

	public void setId(int id)
	{
		this.id = id;
	}
}