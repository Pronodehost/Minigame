package me.YourName.tutorial.events;

import me.YourName.tutorial.API;
import me.YourName.tutorial.Tutorial;
import me.YourName.tutorial.utils.GameManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();

		if (Tutorial.gameStarted) {
			if(Tutorial.players.contains(p.getName())){
				API.addDeaths(p, 1);
				Tutorial.totalAlive--;
				Tutorial.players.remove(p.getName());
			}
		}

		if (Tutorial.totalAlive <= 2) {
			if (Tutorial.gameEnded) {
				GameManager.endGame();
			}
		}
	}
}