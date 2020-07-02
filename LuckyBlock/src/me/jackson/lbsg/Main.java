package me.jackson.lbsg;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	
	Weapon weapon = new Weapon(this);
	WildCrazyInsane wci = new WildCrazyInsane(this);
	
	@Override
	public void onEnable() {
		
		Bukkit.getPluginManager().registerEvents(new CrazyListener(), this);
		Bukkit.getPluginManager().registerEvents(this, this);
		Bukkit.getPluginManager().registerEvents(weapon, this);
		Bukkit.getPluginManager().registerEvents(new weaponListener(this), this);
		getCommand("luckyblock").setExecutor(new luckblockCommand(this));
		
	}
	
	@Override
	public void onDisable() {
		
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		
		Player player = e.getPlayer();
		Block block = e.getBlock();
		if(block.getType() == Material.GREEN_STAINED_GLASS) {
			Location loc = e.getBlock().getLocation();
			World world = e.getBlock().getWorld();
			WildCrazyInsane.Random(player, loc, world);
		}else if(block.getType() == Material.RED_STAINED_GLASS) {
			Location loc = e.getBlock().getLocation();
			weapon.random(player, loc);
		}
		
	}

}
