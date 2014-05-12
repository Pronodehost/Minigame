package me.YourName.tutorial.utils;

import java.util.ArrayList;

import me.YourName.tutorial.Tutorial;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class SpawnHandler {

	public static void teleportToArena() {

		int counter = 0;

		for (Player p : Bukkit.getOnlinePlayers()) {
			p.teleport(Tutorial.arenaSpawns.get(counter++));
		}
	}
	
	public static void loadSpawns(String arenaName){
		ArrayList<Location> temp = new ArrayList<>();
		
		int amount = Tutorial.config.getInt("Spawns." + arenaName + ".amount");
		
		World world = Bukkit.getWorld(Tutorial.config.getString("Spawns." + arenaName + ".world"));
		
		for(int i = 1; i <= amount; i++){
			double x = Tutorial.config.getDouble("Spawns." + arenaName + "." + i + ".x");
			double y = Tutorial.config.getDouble("Spawns." + arenaName + "." + i + ".y");
			double z = Tutorial.config.getDouble("Spawns." + arenaName + "." + i + ".z");
			
			temp.add(new Location(world, x, y, z));
		}
		
		Tutorial.arenaSpawns = temp;
	}
	
	public static void setSpawn(Player p, String arenaName){
		int amount = Tutorial.config.getInt("Spawns." + arenaName + ".amount");
		
		int next = amount + 1;
		
		World world = p.getWorld();
		
		Tutorial.config.set("Spawns." + arenaName + "amount", next);
		Tutorial.config.set("Spawns." + arenaName + "." + next + ".world", world);

		Location loc = p.getLocation();
		
		double x = loc.getX();
		double y = loc.getY();
		double z = loc.getZ();
		
		Tutorial.config.set("Spawns." + arenaName + "." + next + ".x", x);
		Tutorial.config.set("Spawns." + arenaName + "." + next + ".y", y);
		Tutorial.config.set("Spawns." + arenaName + "." + next + ".z", z);
		
		Tutorial.plugin.saveConfig();
	}
}