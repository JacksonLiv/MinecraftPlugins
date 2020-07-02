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

public class methCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		int num = 0;
		ItemStack meth = new ItemStack(Material.QUARTZ);
		ItemMeta meta = meth.getItemMeta();
		meta.setDisplayName(ChatColor.DARK_PURPLE + "Meth");
		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add("The good stuff.");
		meta.setLore(lore);
		meth.setItemMeta(meta);
		
		if(sender instanceof Player) {
	Player player = (Player) sender;
		
		if(label.equalsIgnoreCase("meth")) {
			if(player.hasPermission("drugs.meth.get")) {
			if(args.length == 0) {
				player.getInventory().addItem(meth);
				return true;
			}else if(args.length == 1){
				try {
					num = Integer.parseInt(args[0]);
				}catch(Exception e){
					player.sendMessage(ChatColor.RED + "Incorrect Usage: /meth (amount)");
					return true;
				}
				for(int i = 0; i < num; i++) {
					player.getInventory().addItem(meth);
				}
				return true;
			}else {
				player.sendMessage(ChatColor.RED + "Incorrect Usage: /meth (amount)");
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
