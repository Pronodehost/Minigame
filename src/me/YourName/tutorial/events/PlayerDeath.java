package me.YourName.tutorial.events;

import java.lang.reflect.InvocationTargetException;

import me.YourName.tutorial.API;
import me.YourName.tutorial.Tutorial;
import me.YourName.tutorial.utils.ParticleUtils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath implements Listener {

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = (Player) e.getEntity();

		API.addDeaths(p, 1);

		if (API.getDeaths(p) == 5) {
			API.setSpectator(p);
		}

		for (Player pl : Bukkit.getOnlinePlayers()) {
			try {
				ParticleUtils.spawnParticles(p.getLocation(), pl, "flame", 80);
			} catch (ClassNotFoundException | IllegalAccessException
					| InstantiationException | NoSuchMethodException
					| NoSuchFieldException | IllegalArgumentException
					| InvocationTargetException e1) {
				e1.printStackTrace();
			}
		}

		Tutorial.scoreboard(p);

		p.setHealth(20D);
		p.teleport(Tutorial.arenaSpawns.get(1));
	}
}