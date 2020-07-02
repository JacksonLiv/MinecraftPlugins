package me.jackson.drugs;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	//Alcohol
	ArrayList<Player> beer = new ArrayList<>();
	ArrayList<Player> wine = new ArrayList<>();
	ArrayList<Player> whiskey = new ArrayList<>();
	ArrayList<Player> vodka = new ArrayList<>();
	ArrayList<Player> champ = new ArrayList<>();
	ArrayList<Player> corona = new ArrayList<>();
	ArrayList<Player> drunk = new ArrayList<>();
	
	//Drugs
	ArrayList<Player> highShroom = new ArrayList<>();
	ArrayList<Player> usersCocaine = new ArrayList<>();
	ArrayList<Player> highCocaine = new ArrayList<>();
	ArrayList<Player> usersHeroin = new ArrayList<>();
	ArrayList<Player> highHeroin = new ArrayList<>();
	ArrayList<Player> overdoseHeroin = new ArrayList<>();
	ArrayList<Player> highMeth = new ArrayList<>();
	ArrayList<Player> userMeth = new ArrayList<>();
		
	@Override
	public void onEnable() {
		
		for(int i = 0; i < usersCocaine.size(); i++) {
			usersCocaine.remove(i);
		}
		for(int i = 0; i < highCocaine.size(); i++) {
			highCocaine.remove(i);
		}
		for(int i = 0; i < usersHeroin.size(); i++) {
			usersHeroin.remove(i);
		}
		for(int i = 0; i < highHeroin.size(); i++) {
			highHeroin.remove(i);
		}
		for(int i = 0; i < overdoseHeroin.size(); i++) {
			overdoseHeroin.remove(i);
		}
		for(int i = 0; i < userMeth.size(); i++) {
			userMeth.remove(i);
		}
		for(int i = 0; i < highMeth.size(); i++) {
			highMeth.remove(i);
		}
		for(int i = 0; i < highShroom.size(); i++) {
			highShroom.remove(i);
		}
		
		//Alcohol commands and listeners
		Bukkit.getPluginManager().registerEvents(new alcoholListener(this), this);
		getCommand("alcohol").setExecutor(new alcoholCommand());
		
		//Command to clear arrays
		getCommand("resetdrugusers").setExecutor(new clearDrugCommand(this));
		
		//Drug Commands and Listeners
		Bukkit.getPluginManager().registerEvents(new fentListener(), this);
		getCommand("fentanyl").setExecutor(new fentCommand());
		Bukkit.getPluginManager().registerEvents(new weedListener(this), this);
		getCommand("weed").setExecutor(new weedCommand());
		Bukkit.getPluginManager().registerEvents(new shroomListener(this), this);
		getCommand("shroom").setExecutor(new shroomCommand());
		Bukkit.getPluginManager().registerEvents(new cocaineListener(this), this);
		getCommand("cocaine").setExecutor(new cocaineCommand());
		Bukkit.getPluginManager().registerEvents(new heroinListener(this), this);
		getCommand("heroin").setExecutor(new heroinCommand());
		Bukkit.getPluginManager().registerEvents(new narcanListener(this), this);
		getCommand("narcan").setExecutor(new narcanCommand());
		Bukkit.getPluginManager().registerEvents(new methListener(this), this);
		getCommand("meth").setExecutor(new methCommand());
		
		//Drug Recipes
		heroinListener heroin = new heroinListener();
		heroin.recipe();
		methListener meth = new methListener();
		meth.recipe();
		shroomListener shroom = new shroomListener();
		shroom.recipe();
		weedListener weed = new weedListener();
		weed.recipe();
		
		//Alcohol Recipes
		alcoholListener alcohol = new alcoholListener(this);
		alcohol.grapeRecipe();
		alcohol.wineRecipe();
		alcohol.champRecipe();
		alcohol.whiskeyRecipe();
		alcohol.vodkaRecipe();
		alcohol.coronaRecipe();
		alcohol.beerRecipe();
	}
	
	public void onDisable() {
		
	}
	
}
