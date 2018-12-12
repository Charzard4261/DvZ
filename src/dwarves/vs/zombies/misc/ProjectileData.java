package dwarves.vs.zombies.misc;

import dwarves.vs.zombies.enums.ProjectileType;
import dwarves.vs.zombies.misc.generics.GenericProjectileLauncher;

public class ProjectileData {

	public PlayerType type;
	public ProjectileType projectileType;
	public GenericProjectileLauncher launcher;

	public ProjectileData(PlayerType type, ProjectileType projectileType, GenericProjectileLauncher launcher)
	{
		this.type = type;
		this.projectileType = projectileType;
		this.launcher = launcher;
	}
}
