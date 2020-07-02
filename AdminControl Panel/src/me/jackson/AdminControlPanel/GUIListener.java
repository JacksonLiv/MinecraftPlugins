package me.jackson.AdminControlPanel;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class GUIListener implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClickOnlinePlayers(InventoryClickEvent e) {	
		Player player = (Player) e.getWhoClicked();
		ItemStack item = e.getCurrentItem();
		Inventory inv = e.getClickedInventory();
		
		if(item != null && item.getType() != null && e.getView().getTitle().contains("Online Players | Page - ")) {
			int page = Integer.parseInt(inv.getItem(0).getItemMeta().getLocalizedName());
			
			if(e.getRawSlot() == 0 && item.getType().equals(Material.LIME_STAINED_GLASS_PANE)) {
				GUI.showOnlinePlayers(player, page - 1);
			}else if(e.getRawSlot() == 8 && item.getType().equals(Material.LIME_STAINED_GLASS_PANE)) {
				GUI.showOnlinePlayers(player, page + 1);
			}else if(item.getType().equals(Material.PLAYER_HEAD)) {
				if(player.hasPermission("admincontrol.gui.player.open")) {
					
					Player clickedPlayer = Bukkit.getPlayer(((SkullMeta) item.getItemMeta()).getOwner());
					GUI.showPlayer(clickedPlayer, player);
					
				}else {
					player.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD + "You do not have permission to run this command.");
				}
			}
			
			e.setCancelled(true);
			
		}		
	}
}
