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
import org.bukkit.inventory.meta.ItemMeta;

public class weedCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		int num = 0;
		ItemStack weed = new ItemStack(Material.FERN);
		ItemMeta meta = weed.getItemMeta();
		meta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Marijuana");
		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add("Aka Cannabis, Aka Weed, Aka Pot, Aka Mary Jane, Aka 420");
		meta.setLore(lore);
		weed.setItemMeta(meta);
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			
			if(label.equalsIgnoreCase("weed")) {
				if(player.hasPermission("drugs.weed.get")) {
				if(args.length == 0) {
					player.getInventory().addItem(weed);
					return true;
				}else if(args.length == 1){
					try {
						num = Integer.parseInt(args[0]);
					}catch(Exception e){
						player.sendMessage(ChatColor.RED + "Incorrect Usage: /weed (amount)");
						return true;
					}
					for(int i = 0; i < num; i++) {
						player.getInventory().addItem(weed);
					}
					return true;
				}else {
					player.sendMessage(ChatColor.RED + "Incorrect Usage: /weed (amount)");
					return true;
				}
				}
				
			}
			}else {
				System.out.println("This is a player only command.");
			}
		
		return false;
	}

}
