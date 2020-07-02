package me.jackson.lbsg;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class luckblockCommand implements CommandExecutor {

	Main main;
	
	public luckblockCommand(Main main) {
		this.main = main;
	}

	// /luckyblock give (type) (amount)
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("luckyblock") || label.equalsIgnoreCase("lb")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				if(player.hasPermission("luckyblock.give")) {
					if(args.length < 2) {
						player.sendMessage("Incorrect Usage: /luckyblock give (type) (amount)");
						return true;
					}
					if(args[0].equalsIgnoreCase("give")) {
					
						//Weapon
						if(args[1].equalsIgnoreCase("weapon")) {
							Inventory inv = player.getInventory();
							ItemStack weapon = new ItemStack(Material.RED_STAINED_GLASS);
							ItemMeta meta = weapon.getItemMeta();
							meta.setDisplayName(ChatColor.BOLD + "" + ChatColor.RED + "Weapons " + ChatColor.GOLD + "Lucky Block");
							List<String> lore = new ArrayList<>();
							lore.add("");
							lore.add("Test your luck with a Weapons Lucky Block");
							meta.setLore(lore);
							weapon.setItemMeta(meta);
							int num = 0;
							try{num = Integer.parseInt(args[2]);}
							catch(Exception f) {
								player.sendMessage("Incorrect usage.");
								return false;
							}
							for(int i = 0; i < num; i++) {
								inv.addItem(weapon);
							}
							return true;
						}else if(args[1].equalsIgnoreCase("insane")) {
							Inventory inv = player.getInventory();
							ItemStack insane = new ItemStack(Material.GREEN_STAINED_GLASS);
							ItemMeta meta = insane.getItemMeta();
							meta.setDisplayName(ChatColor.BOLD + "" + ChatColor.GREEN + "Insane " + ChatColor.GOLD + "Lucky Block");
							List<String> lore = new ArrayList<>();
							lore.add("");
							lore.add("Test your luck with a Weapons Lucky Block");
							meta.setLore(lore);
							insane.setItemMeta(meta);
							int num = 0;
							try{num = Integer.parseInt(args[2]);}
							catch(Exception f) {
								player.sendMessage("Incorrect usage.");
								return false;
							}
							for(int i = 0; i < num; i++) {
								inv.addItem(insane);
							}
							return true;
						}
						
						
						
					}
				}else {
					player.sendMessage("You do not have permission to do this command.");
				}
			}
		}
		return false;
	}
	
}
