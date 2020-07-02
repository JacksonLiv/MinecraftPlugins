package me.jackson.AdminControlPanel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	private static ArrayList<Player> frozen;
	private static HashMap<String, Integer> banLength;
	
	private static File offenses;
	private static YamlConfiguration modifyOffenses;
	
	@Override
	public void onEnable() {
		
		try {
			initiateFile();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		//Config File Setup
		this.getConfig().options().copyDefaults();
		saveDefaultConfig();
		
		banLength = new HashMap<>();
		
		banLength.put("disrespect-spam", this.getConfig().getInt("disrespect-spam"));
		banLength.put("inappropriate-skin-name", this.getConfig().getInt("inappropriate-skin-name"));
		banLength.put("scamming-advertising", this.getConfig().getInt("scamming-advertising"));
		banLength.put("exploiting", this.getConfig().getInt("exploiting"));
		banLength.put("xray", this.getConfig().getInt("xray-hacking"));
		banLength.put("pvp", this.getConfig().getInt("pvp-hacking"));
		banLength.put("movement", this.getConfig().getInt("movement-hacking"));
		
		//Array List for frozen players
		frozen = new ArrayList<>();
		
		//Listeners for GUI's
		Bukkit.getPluginManager().registerEvents(new warnListener(), this);
		Bukkit.getPluginManager().registerEvents(new GUIListener(), this);
		Bukkit.getPluginManager().registerEvents(new GUIControlListener(), this);
		Bukkit.getPluginManager().registerEvents(new BanListener(this), this);
		
		//Opening GUI Commands
		//Online Players GUI
		getCommand("aconline").setExecutor(new OnlineCommand());
		//Specific Player GUI
		getCommand("acplayer").setExecutor(new PlayerCommand());
		
		//Ban Command for Ban GUI
		getCommand("acban").setExecutor(new BanCommand());
		
		//Warn Player
		getCommand("acwarn").setExecutor(new WarnCommand(this));
		
	}

	public static ArrayList<Player> getFrozen() {
		return frozen;
	}
	
	public File getFile() { return offenses; }
	public static YamlConfiguration getOffenses() { return modifyOffenses; }
	
	public void initiateFile() throws IOException{
		offenses = new File(Bukkit.getServer().getPluginManager().getPlugin("AdminControlPanel").getDataFolder(), "offenses.yml");
		if(!offenses.exists()) {
			offenses.createNewFile();
		}
		
		modifyOffenses = YamlConfiguration.loadConfiguration(offenses);
		
	}
	
	public static HashMap<String, Integer> getBanLength(){
		return banLength;
	}
	
}
