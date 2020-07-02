package me.jackson.drugs;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public class narcanListener implements Listener {

	Main main;
	
	public narcanListener(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void brew(InventoryCloseEvent e) {
		
		ItemStack narcan = new ItemStack(Material.POTION);
		PotionMeta meta = (PotionMeta) narcan.getItemMeta();
		meta.setBasePotionData(new PotionData(PotionType.WATER));
		meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Narcan");
		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add("Use this to stop a Heroin Overdose!");
		meta.setLore(lore);
		narcan.setItemMeta(meta);
		
		ItemStack check = new ItemStack(Material.POTION);
		PotionMeta checkMeta = (PotionMeta) check.getItemMeta();
		checkMeta.setBasePotionData(new PotionData(PotionType.WATER));
		checkMeta.setDisplayName("Narcan");
		check.setItemMeta(checkMeta);
		
		HumanEntity player = e.getPlayer();
		Inventory inv = e.getInventory();
		if(inv instanceof AnvilInventory) {
			if(player instanceof Player) {
			
				if(player.getInventory().contains(check)) {
					player.getInventory().addItem(narcan);
					player.getInventory().remove(check);
				}
				
			}
		}
		
	}
	
	@EventHandler
	public void heal(PlayerInteractEvent e) {
		
		ItemStack narcan = new ItemStack(Material.POTION);
		PotionMeta meta = (PotionMeta) narcan.getItemMeta();
		meta.setBasePotionData(new PotionData(PotionType.WATER));
		meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Narcan");
		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add("Use this to stop a Heroin Overdose!");
		meta.setLore(lore);
		narcan.setItemMeta(meta);
		
		Player player = e.getPlayer();
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if(player.getInventory().getItemInMainHand().getItemMeta().equals(meta)) {
				
				if(main.overdoseHeroin.contains(player)) {
				for(int i = 0; i < main.highHeroin.size(); i++) {
					if(main.highHeroin.get(i).equals(player)) {
						main.highHeroin.remove(i);
					}
				}
				
				for(int i = 0; i < main.overdoseHeroin.size(); i++) {
					if(main.overdoseHeroin.get(i).equals(player)) {
						main.overdoseHeroin.remove(i);
					}
				}
				
				for (Player p : Bukkit.getOnlinePlayers()) {
				    p.sendMessage(ChatColor.RED + player.getDisplayName() + " was saved from a Heroin Overdose with Narcan!");
				}
				
				for (PotionEffect effect : player.getActivePotionEffects()) {
			        player.removePotionEffect(effect.getType());
				}
				
				player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 600, 3));
				
				player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
				
				}else {
					player.sendMessage(ChatColor.GRAY + "You do not need Narcan.");
				}
			}
		}
	}
	
	@EventHandler
	public void healOther(PlayerInteractEntityEvent e) {
		ItemStack narcan = new ItemStack(Material.POTION);
		PotionMeta meta = (PotionMeta) narcan.getItemMeta();
		meta.setBasePotionData(new PotionData(PotionType.WATER));
		meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Narcan");
		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add("Use this to stop a Heroin Overdose!");
		meta.setLore(lore);
		narcan.setItemMeta(meta);
		Player healer = e.getPlayer();
		if(e.getRightClicked() instanceof Player) {
			Player healed = (Player) e.getRightClicked();
			
				if(healer.getInventory().getItemInMainHand().getItemMeta().equals(meta)) {
				
				if(main.overdoseHeroin.contains(healed)) {
				for(int i = 0; i < main.highHeroin.size(); i++) {
					if(main.highHeroin.get(i).equals(healed)) {
						main.highHeroin.remove(i);
					}
				}
				
				for(int i = 0; i < main.overdoseHeroin.size(); i++) {
					if(main.overdoseHeroin.get(i).equals(healed)) {
						main.overdoseHeroin.remove(i);
					}
				}
				
				for (Player p : Bukkit.getOnlinePlayers()) {
				    p.sendMessage(ChatColor.RED + healer.getDisplayName() + " saved " + healed.getDisplayName() + " from a Heroin Overdose with Narcan!");
				}
				
				for (PotionEffect effect : healed.getActivePotionEffects()) {
			        healed.removePotionEffect(effect.getType());
				}
				
				healed.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 600, 3));
				
				healer.getInventory().getItemInMainHand().setAmount(healer.getInventory().getItemInMainHand().getAmount() - 1);
				
				}else {
					healer.sendMessage(ChatColor.GRAY + healed.getDisplayName() + " is not in need of Narcan.");
				}
			}
			
			
		}
	}
	
}
