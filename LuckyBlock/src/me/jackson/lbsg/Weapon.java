package me.jackson.lbsg;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Weapon implements Listener {

	Main main;
	
	//Constructor
	public Weapon(Main main) {
	this.main = main;	
	}
	
	public void random(Player player, Location loc) {
		int num = (int) (Math.random() * 19);
		System.out.println(num);
		if(num == 0) getTheStick(player, loc);
		if(num == 1) getShotgun(player, loc);
		if(num == 2) getCarrotCorrupter(player, loc);
		if(num == 3) getStickOfTruth(player, loc);
		if(num == 4) getExcalibur(player, loc);
		if(num == 5) getRegularBow(player, loc);
		if(num == 6) getPowerPunchBow(player, loc);
		if(num == 7) getSnowballs(player, loc);
		if(num == 8) getIronSword(player, loc);
		if(num == 9) getSlimeBall(player, loc);
		if(num == 10) getWoodenSword(player, loc);
		if(num == 11) getExplosiveBow(player, loc);
		if(num == 12) getTheSpoon(player, loc);
		if(num == 13) getSwordElDorado(player, loc);
		if(num == 14) getVomitBagel(player, loc);
		if(num == 15) getHappyTree(player, loc);
		if(num == 16) getFish(player, loc);
		if(num == 17) getSelfSword(player, loc);
		if(num == 18) getPrune(player, loc);
		}	
	//The Stick
	public void getTheStick(Player player, Location loc) {
		
	ItemStack theStick = new ItemStack(Material.STICK);
	ItemMeta meta = theStick.getItemMeta();
	
	meta.setDisplayName(ChatColor.LIGHT_PURPLE + "The Stick");
	List<String> lore = new ArrayList<String>();
	lore.add("");
	lore.add(ChatColor.GRAY + "It's just a stick.");
	meta.setLore(lore);
	theStick.setItemMeta(meta);
	theStick.addUnsafeEnchantment(Enchantment.KNOCKBACK, 4);
	
	World world = player.getWorld();
	
	player.sendMessage(ChatColor.GRAY + "You have been given " + ChatColor.GOLD + 
			"" + ChatColor.BOLD + "The Stick!");
	
	world.dropItem(loc, theStick);
	}
	//Shotgun
	public void getShotgun(Player player, Location loc) {
			
		ItemStack shotgun = new ItemStack(Material.COMPARATOR);
		ItemMeta meta = shotgun.getItemMeta();
		
		meta.setDisplayName(ChatColor.RED + "Shotgun");
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.GRAY + "Shotgun goes pew pew.");
		meta.setLore(lore);
		shotgun.setItemMeta(meta);
		
		World world = player.getWorld();
		
		player.sendMessage(ChatColor.GRAY + "You have been given " + ChatColor.GOLD + 
				"" + ChatColor.BOLD + "a Shotgun!");
		
		world.dropItem(loc, shotgun);
		}
	//The Carrot Corrupter
	public void getCarrotCorrupter(Player player, Location loc) {

			
		ItemStack CarrotCorrupter = new ItemStack(Material.CARROT);
		ItemMeta meta = CarrotCorrupter.getItemMeta();
		
		meta.setDisplayName(ChatColor.YELLOW + "Carrot Corrupter");
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.GRAY + "Turns one item on the enemies hotbar");
		lore.add(ChatColor.GRAY + "into a carrot!");
		meta.setLore(lore);
		CarrotCorrupter.setItemMeta(meta);
		
		World world = player.getWorld();
		
		player.sendMessage(ChatColor.GRAY + "You have been given " + ChatColor.GOLD + 
				"" + ChatColor.BOLD + "The Carrot Corrupter");
		
		world.dropItem(loc, CarrotCorrupter);
	}
	//Stick of Truth
	public void getStickOfTruth(Player player, Location loc) {
		
		ItemStack StickOfTruth = new ItemStack(Material.STICK);
		ItemMeta meta = StickOfTruth.getItemMeta();
		
		meta.setDisplayName(ChatColor.AQUA + "Stick Of Truth");
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.GRAY + "Reveals nicked players.");
		meta.setLore(lore);
		StickOfTruth.setItemMeta(meta);
		
		World world = player.getWorld();
		
		player.sendMessage(ChatColor.GRAY + "You have been given " + ChatColor.GOLD + 
				"" + ChatColor.BOLD + "The Stick Of Truth!");
		
		world.dropItem(loc, StickOfTruth);
	}
	//Excalibur - A Holy Sword
	public void getExcalibur(Player player, Location loc) {
		
		ItemStack Excalibur = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta meta = Excalibur.getItemMeta();
		
		meta.setDisplayName(ChatColor.BLUE + "Excalibur - The Holy Sword");
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.GRAY + "Just a very holy sword.");
		meta.setLore(lore);
		Excalibur.setItemMeta(meta);
		
		World world = player.getWorld();
		
		player.sendMessage(ChatColor.GRAY + "You have been given " + ChatColor.GOLD + 
				"" + ChatColor.BOLD + "Excalibur - The Holy Sword!");
		
		world.dropItem(loc, Excalibur);
	}
	//Regular Bow
	public void getRegularBow(Player player, Location loc) {
		
		ItemStack bow = new ItemStack(Material.BOW);
		ItemMeta meta = bow.getItemMeta();
		
		meta.setDisplayName(ChatColor.WHITE + "Regular Bow");
		bow.setItemMeta(meta);
		
		World world = player.getWorld();
		
		player.sendMessage(ChatColor.GRAY + "You have been given " + ChatColor.GOLD + 
				"" + ChatColor.BOLD + "a bow :(");
		
		for(int i = 0; i < 21; i++) {
			world.dropItem(loc, new ItemStack(Material.ARROW));
		}
		
		world.dropItem(loc, bow);
	}
	//Power Punch Bow
	public void getPowerPunchBow(Player player, Location loc) {
		
		ItemStack bow = new ItemStack(Material.BOW);
		ItemMeta meta = bow.getItemMeta();
		
		meta.setDisplayName(ChatColor.LIGHT_PURPLE + "The Good Bow");
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.GRAY + "A better bow than regular bow.");
		meta.setLore(lore);
		bow.setItemMeta(meta);
		bow.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
		bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 2);
		
		World world = player.getWorld();
		
		player.sendMessage(ChatColor.GRAY + "You have been given " + ChatColor.GOLD + 
				"" + ChatColor.BOLD + "The Good Bow");
		
		for(int i = 0; i<21; i++) {
			world.dropItem(loc,new ItemStack(Material.ARROW));
		}
		
		world.dropItem(loc, bow);
		}
	// 4 stacks of knockback 1 snowballs
	public void getSnowballs(Player player, Location loc) {
		
		ItemStack ball = new ItemStack(Material.SNOWBALL);
		ItemMeta meta = ball.getItemMeta();
		
		meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Knockbock Snowballs");
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.GRAY + "They are very bouncy.");
		meta.setLore(lore);
		ball.setItemMeta(meta);
		ball.addEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
		
		World world = player.getWorld();
		
		player.sendMessage(ChatColor.GRAY + "You have been given " + ChatColor.GOLD + 
				"" + ChatColor.BOLD + "Knockback Snowballs!");
		
		for(int i = 0; i < 64; i++) {
					world.dropItem(loc, ball);
		}

		}
	//Iron Sword
	public void getIronSword(Player player, Location loc) {
		
		ItemStack sword = new ItemStack(Material.IRON_SWORD);
		
		World world = player.getWorld();
		
		player.sendMessage(ChatColor.GRAY + "You have been given " + ChatColor.GOLD + 
				"" + ChatColor.BOLD + "and iron sword.");
		
		world.dropItem(loc, sword);
		}
	//Knockback 10 slimeball
	public void getSlimeBall(Player player, Location loc) {
		
		ItemStack slimeball = new ItemStack(Material.SLIME_BALL);
		ItemMeta meta = slimeball.getItemMeta();
		
		meta.setDisplayName(ChatColor.GREEN + "Knockback X Slimeball");
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.GRAY + "It's fun to be hit with this.");
		meta.setLore(lore);
		slimeball.setItemMeta(meta);
		slimeball.addUnsafeEnchantment(Enchantment.KNOCKBACK, 10);
		
		World world = player.getWorld();
		
		player.sendMessage(ChatColor.GRAY + "You have been given " + ChatColor.GOLD + 
				"" + ChatColor.BOLD + "The Knockback X Slimeball");
		
		world.dropItem(loc, slimeball);
		}
	//Wooden Sword
	public void getWoodenSword(Player player, Location loc) {
		
		ItemStack sword = new ItemStack(Material.WOODEN_SWORD);
		ItemMeta meta = sword.getItemMeta();
		
		meta.setDisplayName(ChatColor.GRAY + "Wooden Sword");
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.GRAY + "Pointy");
		meta.setLore(lore);
		sword.setItemMeta(meta);
		sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
		
		World world = player.getWorld();
		
		player.sendMessage(ChatColor.GRAY + "You have been given " + ChatColor.GOLD + 
				"" + ChatColor.BOLD + "a wooden sword.");
		
		world.dropItem(loc, sword);
		}
	//Explosive Bow
	public void getExplosiveBow(Player player, Location loc) {
		
		ItemStack bow = new ItemStack(Material.BOW);
		ItemMeta meta = bow.getItemMeta();
		
		meta.setDisplayName(ChatColor.RED + "Explosive Bow");
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.GRAY + "Haha, Bow go boom!");
		meta.setLore(lore);
		bow.setItemMeta(meta);
		
		World world = player.getWorld();
		
		player.sendMessage(ChatColor.GRAY + "You have been given " + ChatColor.GOLD + 
				"" + ChatColor.BOLD + "The Explosive Bow");
		
		for(int i = 0; i < 6; i++) {
			world.dropItem(loc, new ItemStack(Material.ARROW));
		}
		
		world.dropItem(loc, bow);
		}
	//The Spoon
	public void getTheSpoon(Player player, Location loc) {
		
		ItemStack spoon = new ItemStack(Material.WOODEN_SHOVEL);
		ItemMeta meta = spoon.getItemMeta();
		
		meta.setDisplayName(ChatColor.AQUA + "The Spoon");
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.GRAY + "Use this to scoop people up.");
		meta.setLore(lore);
		spoon.setItemMeta(meta);
		spoon.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
		
		World world = player.getWorld();
		
		player.sendMessage(ChatColor.GRAY + "You have been given " + ChatColor.GOLD + 
				"" + ChatColor.BOLD + "The Spoon");
		
		world.dropItem(loc, spoon);
		}
	//Sword of El Dorado
	public void getSwordElDorado(Player player, Location loc) {
		
		ItemStack sword = new ItemStack(Material.STICK);
		ItemMeta meta = sword.getItemMeta();
		
		meta.setDisplayName(ChatColor.GOLD + "Sword of El Dorado");
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.GRAY + "Part of the collection of El Dorado");
		meta.setLore(lore);
		sword.setItemMeta(meta);
		sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);
		sword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 1);
		
		World world = player.getWorld();
		
		player.sendMessage(ChatColor.GRAY + "You have been given " + ChatColor.GOLD + 
				"" + ChatColor.BOLD + "The Sword of El Dorado");
		
		world.dropItem(loc, sword);
		}
	//Vomit Bagel
	public void getVomitBagel(Player player, Location loc) {
		
		ItemStack bagel = new ItemStack(Material.PUMPKIN_PIE);
		ItemMeta meta = bagel.getItemMeta();
		
		meta.setDisplayName(ChatColor.GREEN + "Vomit Bagel");
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.GRAY + "Ewww");
		meta.setLore(lore);
		bagel.setItemMeta(meta);
		bagel.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
		
		World world = player.getWorld();
		
		player.sendMessage(ChatColor.GRAY + "You have been given " + ChatColor.GOLD + 
				"" + ChatColor.BOLD + "The Vomit Bagel");
		
		world.dropItem(loc, bagel);
		}
	//Happy Little Tree
	public void getHappyTree(Player player, Location loc) {
		
		ItemStack tree = new ItemStack(Material.OAK_SAPLING);
		ItemMeta meta = tree.getItemMeta();
		
		meta.setDisplayName(ChatColor.GREEN + "Happy Little Tree");
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.GRAY + "Just a happy little tree.");
		meta.setLore(lore);
		tree.setItemMeta(meta);
		tree.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 3);
		
		World world = player.getWorld();
		
		player.sendMessage(ChatColor.GRAY + "You have been given " + ChatColor.GOLD + 
				"" + ChatColor.BOLD + "a Happy Little Tree.");
		
		world.dropItem(loc, tree);
		}
	//One Pound Fish
	public void getFish(Player player, Location loc) {
		
		ItemStack fish = new ItemStack(Material.SALMON);
		ItemMeta meta = fish.getItemMeta();
		
		meta.setDisplayName(ChatColor.BLUE + "One Pound Fish");
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.GRAY + "A very heavy fish.");
		meta.setLore(lore);
		fish.setItemMeta(meta);
		fish.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
		fish.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
		
		World world = player.getWorld();
		
		player.sendMessage(ChatColor.GRAY + "You have been given " + ChatColor.GOLD + 
				"" + ChatColor.BOLD + "a One Pound Fish.");
		
		world.dropItem(loc, fish);
		}
	//Self Attacking Sword
	public void getSelfSword(Player player, Location loc) {
		
		ItemStack sword = new ItemStack(Material.IRON_SWORD);
		ItemMeta meta = sword.getItemMeta();
		
		meta.setDisplayName(ChatColor.RED + "Self Attacking Sword");
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.GRAY + "Have fun with this one.");
		meta.setLore(lore);
		sword.setItemMeta(meta);
		
		World world = player.getWorld();
		
		player.sendMessage(ChatColor.GRAY + "You have been given " + ChatColor.GOLD + 
				"" + ChatColor.BOLD + "The Self Attacking Sword");
		
		world.dropItem(loc, sword);
		}
	//Prune
	public void getPrune(Player player, Location loc) {
		
		ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
		ItemMeta meta = axe.getItemMeta();
		
		meta.setDisplayName(ChatColor.GOLD + "Axe Of Prune");
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.GRAY + "Aquire the power of Thor!");
		meta.setLore(lore);
		axe.setItemMeta(meta);
		
		World world = player.getWorld();
		
		player.sendMessage(ChatColor.GRAY + "You have been given " + ChatColor.GOLD + 
				"" + ChatColor.BOLD + "a Prune");
		
		world.dropItem(loc, axe);
		}

	
}
