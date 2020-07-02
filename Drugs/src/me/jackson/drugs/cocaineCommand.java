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

public class cocaineCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		int num = 0;
		ItemStack coke = new ItemStack(Material.SUGAR);
		ItemMeta meta = coke.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Cocaine");
		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add("This stuff makes you go zoom!");
		meta.setLore(lore);
		coke.setItemMeta(meta);
		if(sender instanceof Player) {
		Player player = (Player) sender;
		
		if(label.equalsIgnoreCase("cocaine")) {
			if(player.hasPermission("drugs.cocaine.get")) {
			if(args.length == 0) {
				player.getInventory().addItem(coke);
				return true;
			}else if(args.length == 1){
				try {
					num = Integer.parseInt(args[0]);
				}catch(Exception e){
					player.sendMessage(ChatColor.RED + "Incorrect Usage: /cocaine (amount)");
					return true;
				}
				for(int i = 0; i < num; i++) {
					player.getInventory().addItem(coke);
				}
				return true;
			}else {
				player.sendMessage(ChatColor.RED + "Incorrect Usage: /cocaine (amount)");
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
