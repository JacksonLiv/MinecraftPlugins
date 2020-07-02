package me.jackson.drugs;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

public class alcoholCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

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

		
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("drugs.alcohol.get")) {
			
				if(args.length == 1) {
					
					if(args[0].equalsIgnoreCase("beer")) {
						player.getInventory().addItem(beer);
					}else if(args[0].equalsIgnoreCase("wine")){
						player.getInventory().addItem(wine);
					}else if(args[0].equalsIgnoreCase("champagne")){
						player.getInventory().addItem(champ);
					}else if(args[0].equalsIgnoreCase("whiskey")){
						player.getInventory().addItem(whiskey);
					}else if(args[0].equalsIgnoreCase("vodka")){
						player.getInventory().addItem(vodka);
					}else if(args[0].equalsIgnoreCase("corona")){
						player.getInventory().addItem(corona);
					}else {
						player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Incorrect Usage. /alcohol <type>");
					}
					
				}else {
					player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Incorrect Usage. /alcohol <type>");
				}
				
			}
		}else {
			System.out.println("This is a player only command.");
		}
		
		return false;
	}
		
}