package me.jackson.lbsg;

import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Slime;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import net.md_5.bungee.api.ChatColor;

public class CrazyListener implements Listener {

	//Splitter Slime
	@EventHandler
	public void onKill(EntityDeathEvent e) {
		
		Entity ent = e.getEntity();
		World world = ent.getWorld();
		
		if(ent.getCustomName().contains("Splitter Slime")) {
			if(ent.getType().equals(EntityType.SLIME)) {
				for(int i = 0; i < 2; i++) {
				Slime newSlime = (Slime) world.spawnEntity(ent.getLocation(), EntityType.SLIME);
				newSlime.setCustomName(ChatColor.GREEN.toString() + ChatColor.BOLD + "Splitter Slime");
				newSlime.setCustomNameVisible(true);
				newSlime.setSize(2);
				}
			}
		}
	}
	
}
