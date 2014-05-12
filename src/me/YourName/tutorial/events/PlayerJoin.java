package me.YourName.tutorial.events;

import me.YourName.tutorial.API;
import me.YourName.tutorial.Tutorial;
import me.YourName.tutorial.utils.GameManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		if (!Tutorial.gameStarted) {
			if (Bukkit.getOnlinePlayers().length >= 2) {
				GameManager.startGame();
			}
		}
		
		API.json(p, "§fWelcome to §6Top 5 ", "§bClick Here", "hoverEvent", "show_text", "§cClick to see stats", "run_command", "/stats");
	}
}