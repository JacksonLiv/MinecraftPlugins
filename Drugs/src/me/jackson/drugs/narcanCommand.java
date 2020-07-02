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

public class narcanCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		int num = 0;

		ItemStack narcan = new ItemStack(Material.POTION);
		PotionMeta meta = (PotionMeta) narcan.getItemMeta();
		meta.setBasePotionData(new PotionData(PotionType.WATER));
		meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Narcan");
		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add("Use this to stop a Heroin Overdose!");
		meta.setLore(lore);
		narcan.setItemMeta(meta);
		if(sender instanceof Player) {
			Player player = (Player) sender;
		if(label.equalsIgnoreCase("narcan")) {
			if(player.hasPermission("drugs.narcan.get")) {
				if(args.length == 0) {
					player.getInventory().addItem(narcan);
					return true;
				}else if(args.length == 1){
					try {
						num = Integer.parseInt(args[0]);
					}catch(Exception e){
						player.sendMessage(ChatColor.RED + "Incorrect Usage: /heroin (amount)");
						return true;
					}
					for(int i = 0; i < num; i++) {
						player.getInventory().addItem(narcan);
					}
					return true;
				}else {
					player.sendMessage(ChatColor.RED + "Incorrect Usage: /narcan (amount)");
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
