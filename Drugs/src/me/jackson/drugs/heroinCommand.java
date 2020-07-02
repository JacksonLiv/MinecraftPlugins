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

public class heroinCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		int num = 0;
		ItemStack heroin = new ItemStack(Material.COAL);
		ItemMeta meta = heroin.getItemMeta();
		meta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Heroin");
		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add("Be careful with this one...");
		meta.setLore(lore);
		heroin.setItemMeta(meta);
		
		if(sender instanceof Player) {
		Player player = (Player) sender;
		
		if(label.equalsIgnoreCase("heroin")) {
			if(player.hasPermission("drugs.heroin.get")) {
			if(args.length == 0) {
				player.getInventory().addItem(heroin);
				return true;
			}else if(args.length == 1){
				try {
					num = Integer.parseInt(args[0]);
				}catch(Exception e){
					player.sendMessage(ChatColor.RED + "Incorrect Usage: /heroin (amount)");
					return true;
				}
				for(int i = 0; i < num; i++) {
					player.getInventory().addItem(heroin);
				}
				return true;
			}else {
				player.sendMessage(ChatColor.RED + "Incorrect Usage: /heroin (amount)");
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
