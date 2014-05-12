package me.YourName.tutorial.events;

import me.YourName.tutorial.Tutorial;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PlayerPickupItem implements Listener {

	@EventHandler
	public void onDrop(PlayerPickupItemEvent e) {
		Player p = e.getPlayer();

		if (Tutorial.spectators.contains(p.getName())) {
			e.setCancelled(true);
		}
	}
}