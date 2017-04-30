package dwarves.vs.zombies.command;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.SimplePluginManager;

public class CommandFactory {
	CommandMap commandMap = null;
	public CommandFactory()
	{
        try{
            Field field = SimplePluginManager.class.getDeclaredField("commandMap");
            field.setAccessible(true);
            commandMap = (CommandMap)(field.get(Bukkit.getServer().getPluginManager()));
        }catch(NoSuchFieldException e){
            System.out.println("CommandFactory ERROR>> Failed to hook into Bukkit Command Map. Commands cannot be registered");
        }
        catch(IllegalAccessException e){
            System.out.println("CommandFactory ERROR>> Failed to hook into Bukkit Command Map. Commands cannot be registered");
        }
	}
	
	public void registerCommand(ACommand c)
	{
		if(commandMap == null) return;
		System.out.println("Command Factory>> Command " + c.getLabel() + " has been registered");
		commandMap.register(c.getHost(), c);
	}
}
