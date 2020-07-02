package me.jackson.drugs;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
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

public class shroomListener implements Listener {

	private Plugin plugin = Main.getPlugin(Main.class);
	Main main;
	
	//Constructor
	public shroomListener() {
		
	}
	
	//Constructor
	public shroomListener(Main main) {
		this.main = main;
	}
	
	//Consume
	@EventHandler
	public void consume(PlayerInteractEvent e) {
		
		Player player = e.getPlayer();
		
		ItemStack shroom = new ItemStack(Material.RED_MUSHROOM);
		ItemMeta meta = shroom.getItemMeta();
		meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Shrooms");
		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add("Make your world more magical.");
		meta.setLore(lore);
		shroom.setItemMeta(meta);
		
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
			if(player.getInventory().getItemInMainHand().getItemMeta().equals(meta)) {
				if(!(main.highShroom.contains(player))) {
				main.highShroom.add(player);
				}
				player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 300, 1));
				player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 1200, 1));
				player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1200, 9));
				player.sendMessage(ChatColor.AQUA + "You consumed " + ChatColor.RED + "" + ChatColor.BOLD + "Shrooms.");
				player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
			}
		}
		
	}
	
	//high
	@SuppressWarnings("deprecation")
	@EventHandler
	public void high(PlayerMoveEvent e) {
		
		Player player = e.getPlayer();
		double y = player.getLocation().getY() - 5;
		double x = player.getLocation().getX() - 7;
		double z = player.getLocation().getZ() - 7;
		
	if(main.highShroom.contains(player) && player.hasPotionEffect(PotionEffectType.WEAKNESS)) {
		//i=y, j=x, k=z
		for(int i = (int) y; i < 255; i++) {
			for(int j = (int) x; j <= x+14; j++) {
				for(int k = (int) z; k < z+14; k++) {
					
					Block target = player.getWorld().getBlockAt(new Location(player.getWorld(), j, i, k));
					
					if(!(target.getType().equals(Material.AIR))) {
					int num = (int) ((Math.random() * 10) + 1);
					
					if(num == 1) {
						player.sendBlockChange(new Location(player.getWorld(), j, i, k), Material.PINK_WOOL, (byte) 6);
					}else if(num == 2) {
						player.sendBlockChange(new Location(player.getWorld(), j, i, k), Material.ORANGE_WOOL, (byte) 1);
					}else if(num == 3) {
						player.sendBlockChange(new Location(player.getWorld(), j, i, k), Material.MAGENTA_WOOL, (byte) 2);
					}else if(num == 4) {
						player.sendBlockChange(new Location(player.getWorld(), j, i, k), Material.LIGHT_BLUE_WOOL, (byte) 3);
					}else if(num == 5) {
						player.sendBlockChange(new Location(player.getWorld(), j, i, k), Material.YELLOW_WOOL, (byte) 4);
					}else if(num == 6) {
						player.sendBlockChange(new Location(player.getWorld(), j, i, k), Material.LIME_WOOL, (byte) 5);
					}else if(num == 7) {
						player.sendBlockChange(new Location(player.getWorld(), j, i, k), Material.PINK_WOOL, (byte) 6);
					}else if(num == 8) {
						player.sendBlockChange(new Location(player.getWorld(), j, i, k), Material.RED_WOOL, (byte) 14);
						}
					}
				}
			}
		}
	}
		
	}
	
	@EventHandler
	public void down(PlayerMoveEvent e) {
		
		Player player = e.getPlayer();
		
		if(main.highShroom.contains(player) && !(player.hasPotionEffect(PotionEffectType.WEAKNESS))){
			
			for(int i = 0; i < main.highShroom.size(); i++) {
				if(main.highShroom.get(i).equals(player)) {
					main.highShroom.remove(i);
				}
			}
			
			player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "Your world seems to have returned to normal.");
			
		}
		
	}

	public void recipe() {
		
		ItemStack shroom = new ItemStack(Material.RED_MUSHROOM);
		ItemMeta meta = shroom.getItemMeta();
		meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Shrooms");
		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add("Make your world more magical.");
		meta.setLore(lore);
		shroom.setItemMeta(meta);
		
		NamespacedKey nsKey = new NamespacedKey(plugin, "shroom");
		ShapelessRecipe r = new ShapelessRecipe(nsKey, shroom);
		
		r.addIngredient(Material.RED_MUSHROOM);
		r.addIngredient(Material.RED_MUSHROOM);
		r.addIngredient(Material.BROWN_MUSHROOM);
		r.addIngredient(Material.BROWN_MUSHROOM);
		
		plugin.getServer().addRecipe(r);
		
		
	}
	
	
}
