package me.YourName.tutorial.events;

import me.YourName.tutorial.API;
import me.YourName.tutorial.Tutorial;
import me.YourName.tutorial.utils.GameManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityDeath implements Listener {

	@EventHandler
	public void onDeath(EntityDeathEvent e) {
		if (e.getEntity() instanceof Player) {
			Player victim = (Player) e.getEntity();
			if (victim.getKiller() instanceof Player) {
				Player killer = (Player) victim.getKiller();

				API.addDeaths(victim, 1);
				API.addKills(killer, 1);
				API.addPoints(killer, 5);

				Tutorial.scoreboard(killer);
				Tutorial.scoreboard(victim);

				if (!Tutorial.gameEnded) {
					if (API.getKills(killer) >= 5) {
						GameManager.endGame();
					}
				}
			}
		}
	}
}