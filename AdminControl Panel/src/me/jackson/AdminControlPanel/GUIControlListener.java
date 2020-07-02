package me.jackson.AdminControlPanel;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.util.Vector;

public class GUIControlListener implements Listener {

	//Freeze
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		if(Main.getFrozen().contains(player)) {
		e.setCancelled(true);	
		}
	}
	
	
	@EventHandler
	public void onClickPlayer(InventoryClickEvent e) {
		
		
		Player admin = (Player) e.getWhoClicked();
		ItemStack item = e.getCurrentItem();
		Inventory inv = e.getClickedInventory();
		
		@SuppressWarnings("deprecation")
		Player player = Bukkit.getPlayer(((SkullMeta) inv.getItem(4).getItemMeta()).getOwner());
		
		if(item != null && item.getType() != null && e.getView().getTitle().contains("Player: ")) {
			if(e.getRawSlot() == 10 && item.getType().equals(Material.COMPASS)) {
				admin.teleport(player.getLocation());
				admin.closeInventory();
			}else if(e.getRawSlot() == 19 && item.getType().equals(Material.BEACON)) {
				player.teleport(admin.getLocation());
				admin.closeInventory();
			}else if(e.getRawSlot() == 12 && item.getType().equals(Material.CHEST)) {
				admin.openInventory(player.getInventory());
			}else if(e.getRawSlot() == 21 && item.getType().equals(Material.ICE)) {
				Main.getFrozen().add(player);
				admin.closeInventory();
			}else if(e.getRawSlot() == 21 && item.getType().equals(Material.FIRE_CHARGE)) {
				for(int i = 0; i < Main.getFrozen().size(); i++) {
					if(Main.getFrozen().get(i).equals(player)) {
						Main.getFrozen().remove(i);
					}
				}
				admin.closeInventory();
			}else if(e.getRawSlot() == 25 && item.getType().equals(Material.IRON_SWORD)) {
				player.setHealth(0.0);
			}else if(e.getRawSlot() == 14 && item.getType().equals(Material.REDSTONE_BLOCK)) {
				GUI.banPlayer(player, admin);
			}else if(e.getRawSlot() == 23 && item.getType().equals(Material.FEATHER)) {
				player.setVelocity(new Vector(0, 30, 0));
			}else if(e.getRawSlot() == 16 && item.getType().equals(Material.REDSTONE_TORCH)) {
				player.kickPlayer("You have been kicked from the server.");
			}
			e.setCancelled(true);
		}
		
	}
	
}
