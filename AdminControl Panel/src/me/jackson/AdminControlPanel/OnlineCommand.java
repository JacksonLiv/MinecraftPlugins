package me.jackson.AdminControlPanel;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OnlineCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(label.equalsIgnoreCase("aconline") || label.equalsIgnoreCase("aco")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				if(player.hasPermission("admincontrol.gui.onlineplayers.open")) {
					GUI.showOnlinePlayers(player, 1);
					return true;
				}else {
					player.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD + "You do not have permission to run that command.");
					return true;
				}
				
				
			}else {
				System.out.println("This is a player only command.");
				return true;
			}
		}
		
		
		return false;
	}

}
