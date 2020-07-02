package me.jackson.AdminControlPanel;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarnCommand implements CommandExecutor {

	private Main main;
	
	public WarnCommand(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

	if(label.equalsIgnoreCase("acwarn") || label.equalsIgnoreCase("acw")) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("admincontrol.gui.warn")) {
				if(args.length >= 2) {
					Player warned = Bukkit.getPlayer(args[0]);
					if(warned != null) {
						
						StringBuilder message = new StringBuilder();
						
						for(int i = 1; i < args.length; i++) {
							message.append(args[i]);
							message.append(" ");
						}
						
						Calendar cal = Calendar.getInstance();
						Date date = cal.getTime();
						
						if(!Main.getOffenses().contains(warned.getName())) {
							Main.getOffenses().createSection(warned.getName());
						}
							
						Main.getOffenses().set(warned.getName() + ".warning." + date, message.toString());

						System.out.println(Main.getOffenses().getConfigurationSection(warned.getName() + ".").getKeys(false).size());
						
						try {
							Main.getOffenses().save(main.getFile());
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						GUI.warnPlayer(warned, player, message.toString());
						
					}else {
						player.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD + "Can not find specified player.");
					}
				}else {
					player.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD + "Invalid Usage! Usage: /acwarn (player) (reason)");
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
