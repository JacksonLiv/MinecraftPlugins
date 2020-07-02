package me.jackson.drugs;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.Levelled;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class cocaineListener implements Listener {

	private int count = 0;
	Main main;
	
	public cocaineListener(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void consume(PlayerInteractEvent e) {
		
		ItemStack coke = new ItemStack(Material.SUGAR);
		ItemMeta meta = coke.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Cocaine");
		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add("This stuff makes you go zoom!");
		meta.setLore(lore);
		coke.setItemMeta(meta);
		
		Player player = (Player) e.getPlayer();
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
			if(player.getInventory().getItemInMainHand().getItemMeta().equals(meta)){
				for (PotionEffect effect : player.getActivePotionEffects()) {
			        player.removePotionEffect(effect.getType());
				}
				main.usersCocaine.add(player);
				main.highCocaine.add(player);
				player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2400, 1));
				player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 2400, 1));

				for (int i = 0; i < 35; i++){
				    if(player.getInventory().getItem(i).getItemMeta().equals(meta)) {
				    	player.getInventory().getItem(i).setAmount(player.getInventory().getItem(i).getAmount() - 1);
				    	break;
				    }
				}
				player.updateInventory();
				
				player.sendMessage("You consumed " + ChatColor.AQUA + "" + ChatColor.BOLD + "Cocaine.");
			}
		}
	}
	
	@EventHandler
	public void down(PlayerMoveEvent e) {
		
		Player player = (Player) e.getPlayer();
		if(main.highCocaine.contains(player)) {
			if( !(player.hasPotionEffect(PotionEffectType.SPEED)) && !(player.hasPotionEffect(PotionEffectType.FAST_DIGGING))) {
			
				for(int i = 0; i < main.highCocaine.size(); i++) {
					if(main.highCocaine.get(i).equals(player)) {
						main.highCocaine.remove(i);
					}
				}
				
				for(int i = 0; i < main.usersCocaine.size(); i++) {
					if(main.usersCocaine.get(i).equals(player)) count++;
				}
				
				int length = 600 * count;
				
				player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, length, 1));
				player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, length, 1));
				
			}	
		}
	}
	
	
	
	@EventHandler
	public void brewed(PlayerInteractEvent e) {
		
	ItemStack leaves = new ItemStack(Material.KELP);
	ItemMeta leavesMeta = leaves.getItemMeta();
	leavesMeta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Gasoline Soaked Cocoa Leaves");
	List<String> leavesLore = new ArrayList<>();
	leavesLore.add("");
	leavesLore.add("Use a campfire to dry the leaves.");
	leavesMeta.setLore(leavesLore);
	leaves.setItemMeta(leavesMeta);
	
	ItemStack dried = new ItemStack(Material.DRIED_KELP);
	ItemMeta driedMeta = dried.getItemMeta();
	driedMeta.setDisplayName(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Dried Cocoa Leaves");
	List<String> driedLore = new ArrayList<>();
	driedLore.add("");
	driedLore.add("Dissolve in a cauldron of gasoline (water) to get Cocaine.");
	driedMeta.setLore(driedLore);
	dried.setItemMeta(driedMeta);
	
	ItemStack coke = new ItemStack(Material.SUGAR);
	ItemMeta meta = coke.getItemMeta();
	meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Cocaine");
	List<String> lore = new ArrayList<>();
	lore.add("");
	lore.add("This stuff makes you go zoom!");
	meta.setLore(lore);
	coke.setItemMeta(meta);
	
	
		
		Player player = e.getPlayer();
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			Block b = e.getClickedBlock();
			if(b.getType() == Material.CAULDRON) {
				Levelled cauldronData = (Levelled) b.getBlockData();
				if(cauldronData.getLevel() == 3) {
					if(player.getInventory().getItemInMainHand().equals(new ItemStack(Material.COCOA_BEANS))) {
						player.getInventory().addItem(leaves);
						player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "You soaked Cocoa Leaves in gasoline.");
						player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
						cauldronData.setLevel(cauldronData.getLevel() - 1);
					}else if(player.getInventory().getItemInMainHand().getItemMeta().equals(driedMeta)) {
						player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "You successfully brewed Cocaine!");
						player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
						World world = player.getWorld();
						world.dropItem(player.getLocation(), coke);
						
					}
				}
			}else if(b.getType() == Material.CAMPFIRE) {
				if(player.getInventory().getItemInMainHand().getItemMeta().equals(leavesMeta)) {
					player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "You dried out Cocoa Leaves.");
					player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
					player.getInventory().addItem(dried);
				}
			}
			
		}
	
		
	}
	
}
