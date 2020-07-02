package me.jackson.AdminControlPanel;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BanCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player banned;
		
		if(label.equalsIgnoreCase("acban") || label.equalsIgnoreCase("acb")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				if(player.hasPermission("admincontrol.gui.ban.open")) {
					if(args.length == 1) {
						banned = (Player) Bukkit.getOfflinePlayer(args[0]);
						if(banned != null) {
							GUI.banPlayer(banned, player);
						}else {
							player.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD + "Can not find specified player.");
						}
					}else {
						player.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD + "Invalid Usage! Usage: /acban (player).");
					}
				}else {
					player.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD + "You do not have permission to run that command.");
				}
			}else {
				System.out.println("This is a player only command.");
			}
		}
		
		return false;
	}

}
