package me.jackson.lbsg;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Wolf;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import net.md_5.bungee.api.ChatColor;

public class WildCrazyInsane implements Listener{

	Main main;
	
	public WildCrazyInsane(Main main) {
		this.main = main;
	}
	
	public static void Random(Player player, Location loc, World world) {
		int num = (int)(Math.random() * 11 + 1);
		
		switch (num) {
			
		case 1:
			getBeacon(player, loc, world);
			break;
		case 2:
			getHole(player, loc, world);
			break;
		case 3:
			getHorse(player, loc, world);
			break;
		case 4:
			getWater(player, loc, world);
			break;
		case 5:
			getFireworks(player, loc, world);
			break;
		case 6:
			getThreeWolves(player, loc, world);
			break;
		case 7:
			getBigSlime(player, loc, world);
			break;
		case 8:
			getKaboom(player, loc, world);
			break;
		case 9:
			getVillagerMob(player, loc, world);
			break;
		case 10:
			getSwap(player, loc, world);
			break;
		case 11:
			getSlime(player, loc, world);
			break;
		default:
			break;
		
		}
		
	}
	
	//Beacon 1
	public static void getBeacon(Player player, Location loc, World world) {
		
		
		
		loc.setY(loc.getY()-2);
		world.getBlockAt(loc).setType(Material.EMERALD_BLOCK);
		loc.setX(loc.getX() - 1);
		loc.setZ(loc.getZ() - 1);
		world.getBlockAt(loc).setType(Material.EMERALD_BLOCK);
		loc.setZ(loc.getZ() + 1);
		world.getBlockAt(loc).setType(Material.EMERALD_BLOCK);
		loc.setZ(loc.getZ() + 1);
		world.getBlockAt(loc).setType(Material.EMERALD_BLOCK);
		loc.setX(loc.getX() + 1);
		loc.setZ(loc.getZ() - 2);
		world.getBlockAt(loc).setType(Material.EMERALD_BLOCK);
		loc.setZ(loc.getZ() + 1);
		world.getBlockAt(loc).setType(Material.EMERALD_BLOCK);
		loc.setZ(loc.getZ() + 1);
		world.getBlockAt(loc).setType(Material.EMERALD_BLOCK);
		loc.setX(loc.getX() + 1);
		loc.setZ(loc.getZ() - 2);
		world.getBlockAt(loc).setType(Material.EMERALD_BLOCK);
		loc.setZ(loc.getZ() + 1);
		world.getBlockAt(loc).setType(Material.EMERALD_BLOCK);
		loc.setZ(loc.getZ() + 1);
		world.getBlockAt(loc).setType(Material.EMERALD_BLOCK);
		loc.setZ(loc.getZ() - 1);
		loc.setX(loc.getX() - 1);
		loc.setY(loc.getY() + 1);
		world.getBlockAt(loc).setType(Material.BEACON);
		
		
		for (Player p : Bukkit.getOnlinePlayers()) {
		    if(p.getWorld() == world) {
		    	p.sendMessage(ChatColor.AQUA + player.getDisplayName() + " is hiding at " + ChatColor.BOLD + player.getLocation().getX() + ", " + player.getLocation().getY() + ", " + player.getLocation().getZ() + ".");
		    }
		}
		
	}
	
	//Get Hole 2
	public static void getHole(Player player, Location loc, World world) {
		
		Location l = new Location(world, 0, 0, 0);
		
		loc.setY(loc.getY() - 1);
		loc.setX(loc.getX() - 1);
		loc.setZ(loc.getZ() - 1);
		
		for(int y = (int)loc.getY(); y > -1; y--) {
			
			for(int z = (int)loc.getZ(); z < loc.getZ() + 3; z++) {
				for(int x = (int)loc.getX(); x < loc.getX() + 3; x++) {
					l.setY(y);
					l.setX(x);
					l.setZ(z);
					world.getBlockAt(l).setType(Material.AIR);
				}
			}
			
		}
		
	}
	
	
	//Horse Spawn 4
	public static void getHorse(Player player, Location loc, World world) {
		
		Horse horse = (Horse) world.spawn(loc, Horse.class);
		horse.setCustomName(ChatColor.AQUA + player.getDisplayName() + "'s Horse");
		horse.setOwner(player);
		horse.setTamed(true);
		horse.setAdult();
		horse.setCustomNameVisible(true);
		horse.getInventory().setArmor(new ItemStack(Material.GOLDEN_HORSE_ARMOR));
		
	}
	
	//Water Island 5
	public static void getWater(Player player, Location loc, World world) {
		
		for(int i = (int) (loc.getX() - 5); i < loc.getX() + 5; i++) {
			for(int j = (int)(loc.getZ() - 5); j < loc.getZ() + 5; j++) {
				world.getBlockAt(new Location(world, i, loc.getY(), j)).setType(Material.WATER);
			}
		}
		
	}
	//FireWorks 6
	public static void getFireworks(Player player, Location loc, World world) {
		
		world.spawnEntity(loc, EntityType.FIREWORK);
		world.spawnEntity(loc, EntityType.FIREWORK);
		world.spawnEntity(loc, EntityType.FIREWORK);
		world.spawnEntity(loc, EntityType.FIREWORK);
		world.spawnEntity(loc, EntityType.FIREWORK);
		
	}
	//3 wolves 7
	public static void getThreeWolves(Player player, Location loc, World world) {
		
		for(int i = 0; i < 3; i++) {
		Wolf wolf = (Wolf) world.spawn(loc, Wolf.class);
		wolf.setCustomName(ChatColor.AQUA + player.getDisplayName() + "'s Wolf");
		wolf.setTamed(true);
		wolf.setOwner(player);
		wolf.isAdult();
		}
		
	}
	//Big-A-Slime 8
	public static void getBigSlime(Player player, Location loc, World world) {
		
		Slime slime = (Slime) world.spawn(loc, Slime.class);
		slime.setSize(6);
		
	}
	
	//Kaboom 9
	public static void getKaboom(Player player, Location loc, World world) {
		for(Player p : Bukkit.getOnlinePlayers()) {
			p.setInvulnerable(true);
		}
		for(Player p : Bukkit.getOnlinePlayers()) {
			p.setVelocity(new Vector(0, 50, 0));
		}
		for(Player p : Bukkit.getOnlinePlayers()) {
			p.setInvulnerable(false);
		}
	}
	
	//Villager Mob 10
	public static void getVillagerMob(Player player, Location loc, World world) {
		
		for(int i = 0; i < 10; i++) {
			world.spawnEntity(loc, EntityType.VILLAGER);
		}
	}	
	
	//Swap Places 11
	public static void getSwap(Player player, Location loc, World world) {
		
		List<Player> players = new ArrayList<>();
		for(Player p : Bukkit.getOnlinePlayers()) {
			players.add(p);
		}
		
		int num = (int)(Math.random() * players.size());
		
		player.teleport(players.get(num));
		players.get(num).teleport(loc);
		
	}
	
	//Splitter Slime 12
	public static void getSlime(Player player, Location loc, World world) {
		
		Slime slime = (Slime) world.spawnEntity(loc, EntityType.SLIME);
		slime.setSize(3);
		slime.setInvulnerable(false);
		slime.setCustomName(ChatColor.GREEN.toString() + ChatColor.BOLD + "Splitter Slime");
		slime.setCustomNameVisible(true);
		
	}
	
	
}
