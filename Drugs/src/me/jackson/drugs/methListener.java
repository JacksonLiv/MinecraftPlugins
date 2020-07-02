package me.jackson.drugs;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
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
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class methListener implements Listener {

	private Plugin plugin = Main.getPlugin(Main.class);
	Main main;
	
	public methListener(Main main) {
		this.main = main;
	}
	
	public methListener() {
		
	}
	
	public void recipe() {
		
		ItemStack preMeth = new ItemStack(Material.BONE_MEAL);
		ItemMeta pmeta = preMeth.getItemMeta();
		pmeta.setDisplayName(ChatColor.DARK_PURPLE + "Uncrystalized Meth");
		List<String> plore = new ArrayList<>();
		plore.add("");
		plore.add("Right click a cauldron filled with water with this to crystalize it.");
		pmeta.setLore(plore);
		preMeth.setItemMeta(pmeta);
		
		NamespacedKey nsKey = new NamespacedKey(plugin, "methkey");
		ShapelessRecipe r = new ShapelessRecipe(nsKey, preMeth);
		
		r.addIngredient(Material.IRON_INGOT);
		r.addIngredient(Material.GOLD_INGOT);
		r.addIngredient(Material.COAL);
		r.addIngredient(Material.GLOWSTONE_DUST);
		
		plugin.getServer().addRecipe(r);
		
			
	}
	
	@EventHandler
	public void crystalize(PlayerInteractEvent e) {
		
		ItemStack meth = new ItemStack(Material.QUARTZ);
		ItemMeta meta = meth.getItemMeta();
		meta.setDisplayName(ChatColor.DARK_PURPLE + "Meth");
		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add("The good stuff.");
		meta.setLore(lore);
		meth.setItemMeta(meta);

		ItemStack preMeth = new ItemStack(Material.BONE_MEAL);
		ItemMeta pmeta = preMeth.getItemMeta();
		pmeta.setDisplayName(ChatColor.DARK_PURPLE + "Uncrystalized Meth");
		List<String> plore = new ArrayList<>();
		plore.add("");
		plore.add("Right click a cauldron filled with water with this to crystalize it.");
		pmeta.setLore(plore);
		preMeth.setItemMeta(pmeta);
		
		Player player = e.getPlayer();
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			Block b = e.getClickedBlock();
			if(b.getType() == Material.CAULDRON) {
				Levelled cauldronData = (Levelled) b.getBlockData();
				if(cauldronData.getLevel() == 3) {
					if(player.getInventory().getItemInMainHand().getItemMeta().equals(pmeta)) {
						player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
						World world = player.getWorld();
						world.dropItem(player.getLocation(), meth);
						player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "You successfuly brewed Meth");
						cauldronData.setLevel(cauldronData.getLevel() - 1);
					}
				}
			}
		}
		
	}
	
	@EventHandler
	public void use(PlayerInteractEvent e) {
		ItemStack meth = new ItemStack(Material.QUARTZ);
		ItemMeta meta = meth.getItemMeta();
		meta.setDisplayName(ChatColor.DARK_PURPLE + "Meth");
		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add("The good stuff.");
		meta.setLore(lore);
		meth.setItemMeta(meta);
		Player player = e.getPlayer();
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if(player.getInventory().getItemInMainHand().getItemMeta().equals(meta)) {
				
				for (PotionEffect effect : player.getActivePotionEffects()) {
			        player.removePotionEffect(effect.getType());
				}
				
				player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 2400, 3));
				player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 2400, 1));
				player.sendMessage("You consumed " + ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Meth.");
				
				player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
				
				main.userMeth.add(player);
				main.highMeth.add(player);
			}
		}
		
	}
	
	@EventHandler
	public void down(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		if(main.highMeth.contains(player)) {
			if(!(player.hasPotionEffect(PotionEffectType.REGENERATION))) {
				
				int count = 0;
				int length = 0;
				
				for(int i = 0; i < main.userMeth.size(); i++) {
					if(main.userMeth.get(i).equals(player)) count++;
				}
				
				for(int i = 0; i < main.highMeth.size(); i++) {
					if(main.highMeth.get(i).equals(player)) main.highMeth.remove(i);
				}
				
				length = 600 * count;
				
				player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, length, 1));
				
			}
		}
		
		
	}
}
