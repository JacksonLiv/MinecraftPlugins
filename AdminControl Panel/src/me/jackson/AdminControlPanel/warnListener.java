package me.jackson.AdminControlPanel;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class warnListener implements Listener {

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
	ItemStack item = e.getCurrentItem();
	
	if(item != null && item.getType() != null & e.getView().getTitle().contains("Infraction Warning")) {
		e.setCancelled(true);
	}
	
	}
	
}
