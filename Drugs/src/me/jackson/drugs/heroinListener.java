package me.jackson.drugs;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class heroinListener implements Listener {

	private Plugin plugin = Main.getPlugin(Main.class);
	private int count = 0;
	Main main;

	//Constructor
	public heroinListener(Main main) {
		this.main = main;
	}
	//Constructor
	public heroinListener() {
		
	}
	
	//player.sendMessage("You consumed " + ChatColor.GRAY + "" + ChatColor.BOLD + "Heroin.");
	//player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 6000, 3));
	//player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 6000, 3));
	
	/*
	 * ItemStack heroin = new ItemStack(Material.COAL);
		ItemMeta meta = heroin.getItemMeta();
		meta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Heroin");
		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add("Be careful with this one...");
		meta.setLore(lore);
		heroin.setItemMeta(meta);
	 */

	//Consume
	@EventHandler
	public void consume(PlayerInteractEvent e) {
		
		Player player = e.getPlayer();
		
		ItemStack heroin = new ItemStack(Material.COAL);
		ItemMeta meta = heroin.getItemMeta();
		meta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Heroin");
		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add("Be careful with this one...");
		meta.setLore(lore);
		heroin.setItemMeta(meta);
		
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if(player.getInventory().getItemInMainHand().getItemMeta().equals(meta)) {
		if(!(main.highHeroin.contains(player)) && !(main.overdoseHeroin.contains(player))) {
			
			player.sendMessage("You consumed " + ChatColor.GRAY + "" + ChatColor.BOLD + "Heroin.");
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 6000, 3));
			player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 6000, 3));
			player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
			main.highHeroin.add(player);
			main.usersHeroin.add(player);
			
		}else if(main.highHeroin.contains(player) && !(main.overdoseHeroin.contains(player))) {
			
			for (Player p : Bukkit.getOnlinePlayers()) {
			    p.sendMessage(ChatColor.RED + player.getDisplayName() + " is overdosing on Heroin!");
			}
			player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
			player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1200, 9));
			player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1200, 9));
			main.overdoseHeroin.add(player);
		}else if(main.overdoseHeroin.contains(player)) {
			player.sendMessage(ChatColor.RED + "You can not consume " + ChatColor.DARK_GRAY + "Heroin" + ChatColor.RED + " while overdosing.");
		}
		
		}
		
		}
		
	}

	//Overdose
	@EventHandler
	public void overdose(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		if(main.overdoseHeroin.contains(player)) {
			if(!(player.hasPotionEffect(PotionEffectType.SLOW))) {
			player.setHealth(0);
			for(int i = 0; i < main.overdoseHeroin.size(); i++) {
				if(main.overdoseHeroin.get(i).equals(player)) {
					main.overdoseHeroin.remove(i);
				}
			}
			for (Player p : Bukkit.getOnlinePlayers()) {
			    p.sendMessage(ChatColor.RED + player.getDisplayName() + " died of a Heroin Overdose");
			}
			for(int i = 0; i < main.highHeroin.size(); i++) {
				if(main.highHeroin.get(i).equals(player)) {
					main.highHeroin.remove(i);
				}
			}
			}
		}
	}
	
	
	@EventHandler
	public void down(PlayerMoveEvent e) {
		
		Player player = (Player) e.getPlayer();
		if(main.highHeroin.contains(player) && !(main.overdoseHeroin.contains(player))) {
			
			if( !(player.hasPotionEffect(PotionEffectType.SPEED))) {
				
				for(int i = 0; i < main.highHeroin.size(); i++) {
					if(main.highHeroin.get(i).equals(player)) {
						main.highHeroin.remove(i);
					}
				}
				
				for(int i = 0; i < main.usersHeroin.size(); i++) {
					if(main.usersHeroin.get(i).equals(player)) count++;
				}
				
				int length = 600 * count;
				
				player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, length, 1));
				player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, length, 1));
			}	
		}
	}
	//Recipe
	public void recipe() {
		
		ItemStack heroin = new ItemStack(Material.COAL);
		ItemMeta meta = heroin.getItemMeta();
		meta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Heroin");
		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add("Be careful with this one...");
		meta.setLore(lore);
		heroin.setItemMeta(meta);
		
		NamespacedKey nsKey = new NamespacedKey(plugin, "unique_key_here");
		ShapelessRecipe r = new ShapelessRecipe(nsKey, heroin);
		
		r.addIngredient(Material.POPPY);
		r.addIngredient(Material.GOLDEN_APPLE);
		
		plugin.getServer().addRecipe(r);
		
		
		}
		
	}
	
