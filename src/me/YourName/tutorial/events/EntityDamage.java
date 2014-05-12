package me.YourName.tutorial.events;

import me.YourName.tutorial.Tutorial;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamage implements Listener {

	@EventHandler
	public void onED(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();

			if (Tutorial.spectators.contains(p.getName())) {
				e.setCancelled(true);
			}
		}
	}
}