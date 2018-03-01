package dwarves.vs.zombies.misc;

import dwarves.vs.zombies.enums.ProjectileType;

public class ProjectileData {

	public PlayerType type;
	public ProjectileType projectileType;

	public ProjectileData(PlayerType type, ProjectileType projectileType)
	{
		this.type = type;
		this.projectileType = projectileType;
	}
}
