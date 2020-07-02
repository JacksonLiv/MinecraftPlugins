package me.jackson.drugs;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
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
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public class alcoholListener implements Listener {
	
	private Plugin plugin = Main.getPlugin(Main.class);
	Main main;
	
	public alcoholListener(Main main) {
		this.main = main;
	}
	
	//Drinking alcohol (all types)
	@EventHandler
	public void drink(PlayerInteractEvent e) {

		int drunkTime = 0;
		
		ItemStack alcohol = new ItemStack(Material.POTION);
		PotionMeta meta = (PotionMeta) alcohol.getItemMeta();
		meta.setBasePotionData(new PotionData(PotionType.WATER));
		meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Alcohol");
		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add("Just a chemical.");
		meta.setLore(lore);
		alcohol.setItemMeta(meta);
		
		ItemStack beer = new ItemStack(Material.POTION);
		PotionMeta bmeta = (PotionMeta) beer.getItemMeta();
		bmeta.setBasePotionData(new PotionData(PotionType.FIRE_RESISTANCE));
		bmeta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Beer");
		List<String> blore = new ArrayList<>();
		blore.add("");
		blore.add("Just one won't hurt...");
		bmeta.setLore(blore);
		beer.setItemMeta(bmeta);
		
		ItemStack wine = new ItemStack(Material.POTION);
		PotionMeta wmeta = (PotionMeta) wine.getItemMeta();
		List<String> wlore = new ArrayList<>();
		wmeta.setBasePotionData(new PotionData(PotionType.REGEN));
		wmeta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Wine");
		wlore.add("Only rich people drink this.");
		wmeta.setLore(wlore);
		wine.setItemMeta(wmeta);

		
		ItemStack whiskey = new ItemStack(Material.POTION);
		PotionMeta whmeta = (PotionMeta) whiskey.getItemMeta();
		List<String> whlore = new ArrayList<>();
		whmeta.setBasePotionData(new PotionData(PotionType.FIRE_RESISTANCE));
		whmeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Whiskey");
		whlore.add("The strong stuff...");
		whmeta.setLore(whlore);
		whiskey.setItemMeta(whmeta);
	
		ItemStack vodka = new ItemStack(Material.POTION);
		PotionMeta vmeta = (PotionMeta) vodka.getItemMeta();
		List<String> vlore = new ArrayList<>();
		vmeta.setBasePotionData(new PotionData(PotionType.INVISIBILITY));
		vmeta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Vodka");
		vlore.add("Stronger than the stronger stuff...");
		vmeta.setLore(vlore);
		vodka.setItemMeta(vmeta);
		
		ItemStack corona = new ItemStack(Material.POTION);
		PotionMeta cmeta = (PotionMeta) corona.getItemMeta();
		List<String> clore = new ArrayList<>();
		cmeta.setBasePotionData(new PotionData(PotionType.FIRE_RESISTANCE));
		cmeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Corona");
		clore.add("Definetly nothing to do with the Coronavirus...");
		cmeta.setLore(clore);
		corona.setItemMeta(cmeta);
		
		ItemStack champ = new ItemStack(Material.POTION);
		PotionMeta chmeta = (PotionMeta) champ.getItemMeta();
		List<String> chlore = new ArrayList<>();
		chmeta.setBasePotionData(new PotionData(PotionType.FIRE_RESISTANCE));
		chmeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Champagne");
		chlore.add("Only the richest drink this...");
		chmeta.setLore(chlore);
		champ.setItemMeta(chmeta);
		
		Player player = e.getPlayer();
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			
			//If Statements for alcohol
			if(player.getInventory().getItemInMainHand().equals(alcohol)) {
				
				player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "You start to feel a little nauseaus.");
				player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
				player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 600, 0));
				
			}
			
			if(player.getInventory().getItemInMainHand().equals(beer)) {
				//Beer
				for (PotionEffect effect : player.getActivePotionEffects()) {
			        player.removePotionEffect(effect.getType());
				}
				main.beer.add(player);
				player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
				player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "You consumed beer!");
				for(int i = 0; i < main.beer.size(); i++) {
					if(main.beer.get(i).equals(player)) drunkTime++;
				}
				for(int i = 0; i < main.wine.size(); i++) {
					if(main.wine.get(i).equals(player)) drunkTime++;
				}
				for(int i = 0; i < main.champ.size(); i++) {
					if(main.champ.get(i).equals(player)) drunkTime++;
				}
				for(int i = 0; i < main.whiskey.size(); i++) {
					if(main.whiskey.get(i).equals(player)) drunkTime++;
				}
				for(int i = 0; i < main.vodka.size(); i++) {
					if(main.vodka.get(i).equals(player)) drunkTime++;
				}
				drunkTime = 600 * drunkTime;
				if(!(main.drunk.contains(player))) main.drunk.add(player);	
				player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, drunkTime, 1));	
			}else if(player.getInventory().getItemInMainHand().equals(wine)) {
				//Wine
				for (PotionEffect effect : player.getActivePotionEffects()) {
			        player.removePotionEffect(effect.getType());
				}
				main.wine.add(player);
				player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
				player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "You consumed Wine!");
				for(int i = 0; i < main.beer.size(); i++) {
					if(main.beer.get(i).equals(player)) drunkTime++;
				}
				for(int i = 0; i < main.wine.size(); i++) {
					if(main.wine.get(i).equals(player)) drunkTime++;
				}
				for(int i = 0; i < main.champ.size(); i++) {
					if(main.champ.get(i).equals(player)) drunkTime++;
				}
				for(int i = 0; i < main.whiskey.size(); i++) {
					if(main.whiskey.get(i).equals(player)) drunkTime++;
				}
				for(int i = 0; i < main.vodka.size(); i++) {
					if(main.vodka.get(i).equals(player)) drunkTime++;
				}
				drunkTime = 600 * drunkTime;
				if(!(main.drunk.contains(player))) main.drunk.add(player);
				player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, drunkTime, 2));	
			}else if(player.getInventory().getItemInMainHand().equals(whiskey)) {
				//Whiskey
				for (PotionEffect effect : player.getActivePotionEffects()) {
			        player.removePotionEffect(effect.getType());
				}
				main.whiskey.add(player);
				player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
				player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "You consumed Whiskey!");
				for(int i = 0; i < main.beer.size(); i++) {
					if(main.beer.get(i).equals(player)) drunkTime++;
				}
				for(int i = 0; i < main.wine.size(); i++) {
					if(main.wine.get(i).equals(player)) drunkTime++;
				}
				for(int i = 0; i < main.champ.size(); i++) {
					if(main.champ.get(i).equals(player)) drunkTime++;
				}
				for(int i = 0; i < main.whiskey.size(); i++) {
					if(main.whiskey.get(i).equals(player)) drunkTime++;
				}
				for(int i = 0; i < main.vodka.size(); i++) {
					if(main.vodka.get(i).equals(player)) drunkTime++;
				}
				drunkTime = 600 * drunkTime;
				if(!(main.drunk.contains(player))) main.drunk.add(player);
				player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, drunkTime, 3));	
			}else if(player.getInventory().getItemInMainHand().equals(vodka)) {
				//Vodka
				for (PotionEffect effect : player.getActivePotionEffects()) {
			        player.removePotionEffect(effect.getType());
				}
				main.vodka.add(player);
				player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
				player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "You consumed Vodka!");
				for(int i = 0; i < main.beer.size(); i++) {
					if(main.beer.get(i).equals(player)) drunkTime++;
				}
				for(int i = 0; i < main.wine.size(); i++) {
					if(main.wine.get(i).equals(player)) drunkTime++;
				}
				for(int i = 0; i < main.champ.size(); i++) {
					if(main.champ.get(i).equals(player)) drunkTime++;
				}
				for(int i = 0; i < main.whiskey.size(); i++) {
					if(main.whiskey.get(i).equals(player)) drunkTime++;
				}
				for(int i = 0; i < main.vodka.size(); i++) {
					if(main.vodka.get(i).equals(player)) drunkTime++;
				}
				drunkTime = 600 * drunkTime;
				if(!(main.drunk.contains(player))) main.drunk.add(player);
				player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, drunkTime, 4));	
			}else if(player.getInventory().getItemInMainHand().equals(champ)) {
				//Champagne
				for (PotionEffect effect : player.getActivePotionEffects()) {
			        player.removePotionEffect(effect.getType());
				}
				main.champ.add(player);
				player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
				player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "You consumed Champagne!");
				for(int i = 0; i < main.beer.size(); i++) {
					if(main.beer.get(i).equals(player)) drunkTime++;
				}
				for(int i = 0; i < main.wine.size(); i++) {
					if(main.wine.get(i).equals(player)) drunkTime++;
				}
				for(int i = 0; i < main.champ.size(); i++) {
					if(main.champ.get(i).equals(player)) drunkTime++;
				}
				for(int i = 0; i < main.whiskey.size(); i++) {
					if(main.whiskey.get(i).equals(player)) drunkTime++;
				}
				for(int i = 0; i < main.vodka.size(); i++) {
					if(main.vodka.get(i).equals(player)) drunkTime++;
				}
				drunkTime = 600 * drunkTime;
				if(!(main.drunk.contains(player))) main.drunk.add(player);
				player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, drunkTime, 2));	
			}else if(player.getInventory().getItemInMainHand().equals(corona)) {
				main.corona.add(player);
				for (PotionEffect effect : player.getActivePotionEffects()) {
			        player.removePotionEffect(effect.getType());
				}
				player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
				player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "You consumed Corona");
				player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 1200, 9));
				player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1200, 9));
				for (Player p : Bukkit.getOnlinePlayers()) {
				    p.sendMessage(ChatColor.RED + player.getDisplayName() + " has caught the Coronavirus!!!");
				}
			}
		}			
	}
	//END CONSUME LISTENER
	
	public void sleep(PlayerBedEnterEvent e) {
		
		int drunkTime = 0;
		int time = 0;
		
		Player player = e.getPlayer();
		
		
			if(main.drunk.contains(player)) {	
				for (PotionEffect effect : player.getActivePotionEffects()) {
			        player.removePotionEffect(effect.getType());
				}
				
				player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 9));
				player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 9));
				
				for(int i = 0; i < main.beer.size(); i++) {
					if(main.beer.get(i).equals(player)) drunkTime++;
				}
				for(int i = 0; i < main.wine.size(); i++) {
					if(main.wine.get(i).equals(player)) drunkTime++;
				}
				for(int i = 0; i < main.champ.size(); i++) {
					if(main.champ.get(i).equals(player)) drunkTime++;
				}
				for(int i = 0; i < main.whiskey.size(); i++) {
					if(main.whiskey.get(i).equals(player)) drunkTime++;
				}
				for(int i = 0; i < main.vodka.size(); i++) {
					if(main.vodka.get(i).equals(player)) drunkTime++;
				}
				
				for(int i = main.beer.size() - 1; i >= 0; i--) {
					if(main.beer.get(i).equals(player)) main.beer.remove(i);
				}
				for(int i = main.wine.size() - 1; i >= 0; i--) {
					if(main.wine.get(i).equals(player)) main.wine.remove(i);
				}
				for(int i = main.champ.size() - 1; i >= 0; i--) {
					if(main.champ.get(i).equals(player)) main.champ.remove(i);
				}
				for(int i = main.whiskey.size() - 1; i >= 0; i--) {
					if(main.whiskey.get(i).equals(player)) main.whiskey.remove(i);
				}
				for(int i = main.beer.size() - 1; i >= 0; i--) {
					if(main.vodka.get(i).equals(player)) main.vodka.remove(i);
				}
				
				time = (600 * drunkTime) / 2;
				
				player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, time, 1));
				player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, time, 1));

				player.sendMessage(ChatColor.GRAY + "You slept the night off but now comes the Hangover!");
				for(int i = 0; i < main.drunk.size(); i++){
					if(main.drunk.get(i).equals(player)) main.drunk.remove(i);
				}
			}
			}
		
	//Creating alcohol chemical
	@EventHandler
	public void onAlcohol(PlayerInteractEvent e) {
		
		Player player = e.getPlayer();
		ItemStack alcohol = new ItemStack(Material.POTION);
		PotionMeta meta = (PotionMeta) alcohol.getItemMeta();
		meta.setBasePotionData(new PotionData(PotionType.WATER));
		meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Alcohol");
		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add("Just a chemical.");
		meta.setLore(lore);
		alcohol.setItemMeta(meta);
		
		World world = player.getWorld();
		
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			Block b = e.getClickedBlock();
			if(b.getType() == Material.CAULDRON) {
				Levelled cauldronData = (Levelled) b.getBlockData();
				if(cauldronData.getLevel() == 3) {
					if(player.getInventory().getItemInMainHand().equals(new ItemStack(Material.HAY_BLOCK))) {
					
						player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "You successfully brewed Alcohol!");
						player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
						world.dropItem(player.getLocation(), alcohol);
						
					}
				}
			}
		}		
		
		
	}
	
	//Recipe: Berries -> Grape Extract
	public void grapeRecipe() {
		
		ItemStack grape = new ItemStack(Material.PURPLE_DYE);
		ItemMeta meta = grape.getItemMeta();
		meta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Grape Extract");
		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add("The extract of grapes.");
		meta.setLore(lore);
		grape.setItemMeta(meta);
		
		NamespacedKey nsKey = new NamespacedKey(plugin, "grape");
		ShapelessRecipe r = new ShapelessRecipe(nsKey, grape);
		
		r.addIngredient(Material.SWEET_BERRIES);
		r.addIngredient(Material.SWEET_BERRIES);
		r.addIngredient(Material.SWEET_BERRIES);
		r.addIngredient(Material.SWEET_BERRIES);
		
		plugin.getServer().addRecipe(r);
		
		
		}
	
	//Crafting Alcohol
	@EventHandler
	public void onCraft(CraftItemEvent e) {
		

		ItemStack alcohol = new ItemStack(Material.POTION);
		PotionMeta meta = (PotionMeta) alcohol.getItemMeta();
		meta.setBasePotionData(new PotionData(PotionType.WATER));
		meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Alcohol");
		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add("Just a chemical.");
		meta.setLore(lore);
		alcohol.setItemMeta(meta);

		ItemStack beer = new ItemStack(Material.POTION);
		PotionMeta bmeta = (PotionMeta) beer.getItemMeta();
		bmeta.setBasePotionData(new PotionData(PotionType.FIRE_RESISTANCE));
		bmeta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Beer");
		List<String> blore = new ArrayList<>();
		blore.add("");
		blore.add("Just one won't hurt...");
		bmeta.setLore(blore);
		beer.setItemMeta(bmeta);
		
		ItemStack grape = new ItemStack(Material.PURPLE_DYE);
		ItemMeta gmeta = grape.getItemMeta();
		gmeta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Grape Extract");
		List<String> glore = new ArrayList<>();
		glore.add("");
		glore.add("The extract of grapes.");
		gmeta.setLore(glore);
		grape.setItemMeta(gmeta);
		
		ItemStack wine = new ItemStack(Material.POTION);
		PotionMeta wmeta = (PotionMeta) wine.getItemMeta();
		List<String> wlore = new ArrayList<>();
		wmeta.setBasePotionData(new PotionData(PotionType.REGEN));
		wmeta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Wine");
		wlore.add("Only rich people drink this.");
		wmeta.setLore(wlore);
		wine.setItemMeta(wmeta);
		
		ItemStack champ = new ItemStack(Material.POTION);
		PotionMeta chmeta = (PotionMeta) champ.getItemMeta();
		List<String> chlore = new ArrayList<>();
		chmeta.setBasePotionData(new PotionData(PotionType.FIRE_RESISTANCE));
		chmeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Champagne");
		chlore.add("Only the richest drink this...");
		chmeta.setLore(chlore);
		champ.setItemMeta(chmeta);
		
		ItemStack whiskey = new ItemStack(Material.POTION);
		PotionMeta whmeta = (PotionMeta) whiskey.getItemMeta();
		List<String> whlore = new ArrayList<>();
		whmeta.setBasePotionData(new PotionData(PotionType.FIRE_RESISTANCE));
		whmeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Whiskey");
		whlore.add("The strong stuff...");
		whmeta.setLore(whlore);
		whiskey.setItemMeta(whmeta);
		
		ItemStack vodka = new ItemStack(Material.POTION);
		PotionMeta vmeta = (PotionMeta) vodka.getItemMeta();
		List<String> vlore = new ArrayList<>();
		vmeta.setBasePotionData(new PotionData(PotionType.INVISIBILITY));
		vmeta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Vodka");
		vlore.add("Stronger than the stronger stuff...");
		vmeta.setLore(vlore);
		vodka.setItemMeta(vmeta);
		
		ItemStack corona = new ItemStack(Material.POTION);
		PotionMeta cmeta = (PotionMeta) corona.getItemMeta();
		List<String> clore = new ArrayList<>();
		cmeta.setBasePotionData(new PotionData(PotionType.FIRE_RESISTANCE));
		cmeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Corona");
		clore.add("Definetly nothing to do with the Coronavirus...");
		cmeta.setLore(clore);
		corona.setItemMeta(cmeta);
		
		//Wine
		if(e.getInventory().contains(wine)) {
			if( !(e.getInventory().contains(grape)) || !(e.getInventory().contains(alcohol))   ) {
				e.setCancelled(true);
			}
		}
		
		//Champagne
		if(e.getInventory().contains(champ)) {
			if( !(e.getInventory().contains(grape)) || !(e.getInventory().contains(alcohol))   ) {
				e.setCancelled(true);
			}
		}
		
		//Whiskey
		if(e.getInventory().contains(whiskey)) {
			if(!(e.getInventory().contains(alcohol))) {
				e.setCancelled(true);
			}
		}
		
		//Vodka
		if(e.getInventory().contains(vodka)) {
			if(!(e.getInventory().contains(alcohol))) {
				e.setCancelled(true);
			}
		}
				
		//Corona
		if(e.getInventory().contains(corona)) {
			if(!(e.getInventory().contains(alcohol))) {
				e.setCancelled(true);
			}
		}
		
		//Beer
		if(e.getInventory().contains(beer)) {
			if(!(e.getInventory().contains(alcohol))) {
				e.setCancelled(true);
			}
		}
		
		
	}
	
	//Recipe: Alcohol, Grape Extract -> 2 wine
	public void wineRecipe() {
		
		ItemStack wine = new ItemStack(Material.POTION);
		PotionMeta wmeta = (PotionMeta) wine.getItemMeta();
		List<String> wlore = new ArrayList<>();
		wmeta.setBasePotionData(new PotionData(PotionType.REGEN));
		wmeta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Wine");
		wlore.add("Only rich people drink this.");
		wmeta.setLore(wlore);
		wine.setItemMeta(wmeta);
		
		NamespacedKey nsKey = new NamespacedKey(plugin, "wine");
		ShapelessRecipe r = new ShapelessRecipe(nsKey, wine);
		
		
		
		r.addIngredient(Material.PURPLE_DYE);
		r.addIngredient(Material.PURPLE_DYE);
		r.addIngredient(Material.POTION);
		
		plugin.getServer().addRecipe(r);
		
	}
	
	//Recipe: alcohol, 3 grape -> champagne
	public void champRecipe() {
	
		ItemStack champ = new ItemStack(Material.POTION);
		PotionMeta chmeta = (PotionMeta) champ.getItemMeta();
		List<String> chlore = new ArrayList<>();
		chmeta.setBasePotionData(new PotionData(PotionType.FIRE_RESISTANCE));
		chmeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Champagne");
		chlore.add("Only the richest drink this...");
		chmeta.setLore(chlore);
		champ.setItemMeta(chmeta);
		
		NamespacedKey nsKey = new NamespacedKey(plugin, "champ");
		ShapelessRecipe r = new ShapelessRecipe(nsKey, champ);
		
		
		
		r.addIngredient(Material.PURPLE_DYE);
		r.addIngredient(Material.PURPLE_DYE);
		r.addIngredient(Material.PURPLE_DYE);
		r.addIngredient(Material.POTION);
		
		plugin.getServer().addRecipe(r);
		
		
		
	}
	
	//Recipe: alcohol, 2 wheat -> beer
	public void whiskeyRecipe() {
		
		ItemStack whiskey = new ItemStack(Material.POTION);
		PotionMeta whmeta = (PotionMeta) whiskey.getItemMeta();
		List<String> whlore = new ArrayList<>();
		whmeta.setBasePotionData(new PotionData(PotionType.FIRE_RESISTANCE));
		whmeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Whiskey");
		whlore.add("The strong stuff...");
		whmeta.setLore(whlore);
		whiskey.setItemMeta(whmeta);
		
		NamespacedKey nsKey = new NamespacedKey(plugin, "whiskey");
		ShapelessRecipe r = new ShapelessRecipe(nsKey, whiskey);
		
		r.addIngredient(Material.POTION);
		r.addIngredient(Material.WHEAT);
	
		plugin.getServer().addRecipe(r);
		
	}

	//Recipe: alcohol, Potato -> Vodka
	public void vodkaRecipe() {
		
		ItemStack vodka = new ItemStack(Material.POTION);
		PotionMeta vmeta = (PotionMeta) vodka.getItemMeta();
		List<String> vlore = new ArrayList<>();
		vmeta.setBasePotionData(new PotionData(PotionType.INVISIBILITY));
		vmeta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Vodka");
		vlore.add("Stronger than the stronger stuff...");
		vmeta.setLore(vlore);
		vodka.setItemMeta(vmeta);
		
		NamespacedKey nsKey = new NamespacedKey(plugin, "vodka");
		ShapelessRecipe r = new ShapelessRecipe(nsKey, vodka);
		
		r.addIngredient(Material.POTION);
		r.addIngredient(Material.POTATO);
	
		plugin.getServer().addRecipe(r);
		
	}
	
	//Recipe: alcohol, gold_ingot -> Corona
	public void coronaRecipe() {
		
		ItemStack corona = new ItemStack(Material.POTION);
		PotionMeta cmeta = (PotionMeta) corona.getItemMeta();
		List<String> clore = new ArrayList<>();
		cmeta.setBasePotionData(new PotionData(PotionType.FIRE_RESISTANCE));
		cmeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Corona");
		clore.add("Definetly nothing to do with the Coronavirus...");
		cmeta.setLore(clore);
		corona.setItemMeta(cmeta);
		
		NamespacedKey nsKey = new NamespacedKey(plugin, "corona");
		ShapelessRecipe r = new ShapelessRecipe(nsKey, corona);
		
		r.addIngredient(Material.POTION);
		r.addIngredient(Material.ROTTEN_FLESH);
	
		plugin.getServer().addRecipe(r);
		
	}
	
	public void beerRecipe() {
		
		ItemStack beer = new ItemStack(Material.POTION);
		PotionMeta bmeta = (PotionMeta) beer.getItemMeta();
		bmeta.setBasePotionData(new PotionData(PotionType.FIRE_RESISTANCE));
		bmeta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Beer");
		List<String> blore = new ArrayList<>();
		blore.add("");
		blore.add("Just one won't hurt...");
		bmeta.setLore(blore);
		beer.setItemMeta(bmeta);
		
		NamespacedKey nsKey = new NamespacedKey(plugin, "beer");
		ShapelessRecipe r = new ShapelessRecipe(nsKey, beer);
		
		r.addIngredient(Material.POTION);
		r.addIngredient(Material.WHEAT);
		r.addIngredient(Material.WHEAT);
	
		plugin.getServer().addRecipe(r);
		
	}
	
}

