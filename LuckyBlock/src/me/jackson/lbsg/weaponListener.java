package me.jackson.lbsg;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class weaponListener implements Listener {

	Main main;
	
	public weaponListener(Main main) {
		this.main = main;
	}
	
	//All On Attack
	@EventHandler
	public void onRecievedDamage(EntityDamageByEntityEvent e) {
		//Checking if both people involved are players
		if(e.getDamager() instanceof Player) {
			if(e.getEntity() instanceof Player) {
			
				//Num for self attacking sword
				int num2 = 0;
				
				//Creating player objects for attacker and defender
				Player attacker = (Player) e.getDamager();
				Player defendee = (Player) e.getEntity();
				
				if(attacker.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Vomit Bagel")) {
					//Vomit Bagel
					defendee.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 5000, 1));
				}else if(attacker.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Stick Of Truth")) {
					//Stick of Truth
					attacker.sendMessage(ChatColor.GRAY + "The Truth has been revealed. His real name is: " + ChatColor.GOLD + defendee.getDisplayName());
				}else if(attacker.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Self Attacking Sword")) {
					//Self Attacking Sword
					attacker.damage(4.0);
					//attacker.setHealth(attacker.getHealth() - num);
					attacker.sendMessage(ChatColor.RED + "Stop hitting yourself. Stop hitting yourself.");
				}else if(attacker.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Axe Of Prune")){
					Location loc = defendee.getLocation();
					World world = defendee.getWorld();
					world.strikeLightningEffect(loc);
				}else if(attacker.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Corrupter Carrot")) {
					Inventory inv = defendee.getInventory();
					num2 = (int)(Math.random() * 9);
					inv.setItem(num2, new ItemStack(Material.CARROT));
					attacker.getInventory().remove(Material.CARROT);
				}
			}else if(e.getEntity() instanceof LivingEntity) {
				//Num for self attacking sword
				
				//Creating player objects for attacker and defender
				Player attacker = (Player) e.getDamager();
				LivingEntity defendee = (LivingEntity) e.getEntity();
				
				if(attacker.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Vomit Bagel")) {
					//Vomit Bagel
					defendee.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 5000, 1));
				}else if(attacker.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Stick Of Truth")) {
					//Stick of Truth
					attacker.sendMessage(ChatColor.GRAY + "The Truth has been revealed. His real name is: " + ChatColor.GOLD + defendee.getType());
				}else if(attacker.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Self Attacking Sword")) {
					//Self Attacking Sword
					attacker.damage(4.0);
					//attacker.setHealth(attacker.getHealth() - num);
					attacker.sendMessage(ChatColor.RED + "Stop hitting yourself. Stop hitting yourself.");
				}else if(attacker.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Axe Of Prune")){
					Location loc = defendee.getLocation();
					World world = defendee.getWorld();
					world.strikeLightningEffect(loc);
				}
			}
		}
	}
	
	//Explosive bow
	@EventHandler
	public void onExplosiveBow(ProjectileHitEvent e) {
		Entity entity = e.getEntity();
		if(entity instanceof Arrow) {
			Arrow arrow = (Arrow) entity;
			Entity shooter = (Entity) arrow.getShooter();
			if(shooter instanceof Player) {
				Player player = (Player) shooter;
				if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Explosive Bow")) {
					player.getWorld().createExplosion(arrow.getLocation(), 0.0F);
				}
			}
		}
		
		if(entity instanceof Snowball) {
			Snowball s = (Snowball) entity;
			s.getWorld().createExplosion(s.getLocation(), 0.0F);
			for(Entity en : s.getNearbyEntities(5, 30, 5)) {
				if(en instanceof Player) {
					Player player = (Player) en;
					player.setHealth(player.getHealth() - 4.0);
				}
			}
			
			
		}
		
		
		
	}
	
	//Right click for shotgun
	@EventHandler
	public void onRightClick(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR))
			if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Shotgun")) {
				Snowball s = e.getPlayer().launchProjectile(Snowball.class);
				s.getWorld().playEffect(e.getPlayer().getLocation(), Effect.SMOKE, 10);
			}
		
	}
	
}
