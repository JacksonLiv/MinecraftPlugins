package me.jackson.drugs;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class clearDrugCommand implements CommandExecutor {

	Main main;
	
	public clearDrugCommand(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(label.equalsIgnoreCase("resetdrugusers") || label.equalsIgnoreCase("rdu")) {
		for(int i = 0; i < main.usersCocaine.size(); i++) {
			main.usersCocaine.remove(i);
		}
		for(int i = 0; i < main.highCocaine.size(); i++) {
			main.highCocaine.remove(i);
		}
		for(int i = 0; i < main.usersHeroin.size(); i++) {
			main.usersHeroin.remove(i);
		}
		for(int i = 0; i < main.highHeroin.size(); i++) {
			main.highHeroin.remove(i);
		}
		for(int i = 0; i < main.overdoseHeroin.size(); i++) {
			main.overdoseHeroin.remove(i);
		}
		for(int i = 0; i < main.userMeth.size(); i++) {
			main.userMeth.remove(i);
		}
		for(int i = 0; i < main.highMeth.size(); i++) {
			main.highMeth.remove(i);
		}
		for(int i = 0; i < main.highShroom.size(); i++) {
			main.highShroom.remove(i);
		}
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			player.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "Drug User adverse effects have been reset.");
		}else {
			System.out.println("Drug User adverse effects have been reset.");
		}
		}
		
		return false;
	}

}
