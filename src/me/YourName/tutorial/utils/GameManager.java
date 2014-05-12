package me.YourName.tutorial.utils;

import me.YourName.tutorial.API;
import me.YourName.tutorial.Tutorial;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class GameManager {

	public static void startGame() {

		Tutorial.gameStarted = true;

		SpawnHandler.teleportToArena();

		for (Player p : Bukkit.getOnlinePlayers()) {
			Tutorial.players.add(p.getName());
			Tutorial.points.put(p.getName(), 0);
			Tutorial.kills.put(p.getName(), 0);
			Tutorial.deaths.put(p.getName(), 0);
			Tutorial.totalAlive++;
			Tutorial.scoreboard(p);
		}

		Bukkit.broadcastMessage("§cThe game has started! First to 5 kills wins!");
	}

	@SuppressWarnings("deprecation")
	public static void endGame() {

		Tutorial.gameEnded = true;
		
		Player winner = null;
		
		for(String s : Tutorial.players){
			winner = Bukkit.getPlayer(s);
			Bukkit.broadcastMessage("§cThe game has ended! Winner: " + s);
		}
		
		if(winner != null){
			API.firework(winner);
		}
	}
}