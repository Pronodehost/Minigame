package me.YourName.tutorial.events;

import me.YourName.tutorial.Tutorial;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageByEntity implements Listener {

	@EventHandler
	public void onEDD(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			Player p = (Player) e.getDamager();
			if (e.getEntity() instanceof LivingEntity) {
				if (Tutorial.spectators.contains(p.getName())) {
					e.setCancelled(true);
				}
			}
		}
	}
}