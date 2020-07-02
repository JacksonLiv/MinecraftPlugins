package me.jackson.drugs;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class fentListener implements Listener {

	@EventHandler
	public void consume(PlayerInteractEvent e) {
		
		ItemStack fent = new ItemStack(Material.SUGAR);
		ItemMeta meta = fent.getItemMeta();
		meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Fentanyl");
		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add("Bye.");
		meta.setLore(lore);
		fent.setItemMeta(meta);
		
		Player player = e.getPlayer();
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if(player.getInventory().getItemInMainHand().getItemMeta().equals(meta)) {
				player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Bye.");
				for (Player p : Bukkit.getOnlinePlayers()) {
				    p.sendMessage(ChatColor.RED + player.getDisplayName() + " overdosed on Fentanyl!");
				}
				player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
				player.setHealth(0.0);
			}
		}
		
	}
	
}
