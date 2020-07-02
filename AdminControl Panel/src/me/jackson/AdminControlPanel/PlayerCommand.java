package me.jackson.AdminControlPanel;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(label.equalsIgnoreCase("acplayer") || label.equalsIgnoreCase("acp")) {
			Player p;
			if(sender instanceof Player) {
				Player player = (Player) sender;
				if(player.hasPermission("admincontrol.gui.player.open")) {
					if(args.length == 1) {
					p = Bukkit.getPlayer(args[0]);
					if(p != null) {
						GUI.showPlayer(p, player);
					}else {
						player.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD + "The player you specified is not online.");
					}
					}else {
						player.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD + "Incorrect Usage! Usage: /acplayer (player).");
					}
				}else {
					player.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD + "You do not have permission to run this command.");
				}
			}else {
				System.out.println("This is a player only command.");
			}
		}
		
		
		
		
		
		return false;
	}

}
