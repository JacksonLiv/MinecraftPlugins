package me.jackson.AdminControlPanel;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class GUI {
	
	//Online Players GUI
	@SuppressWarnings("deprecation")
	public static void showOnlinePlayers(Player player, int page) {
		
		List<ItemStack> onlinePlayers = new ArrayList<>();
		
		Inventory gui = Bukkit.createInventory(null, 54, "Online Players | Page - " + page);
		
		ItemStack left;
		ItemMeta leftMeta;
		if(PageUtil.isPageValid(onlinePlayers, page - 1, 52)) {
			left = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
			leftMeta = left.getItemMeta();
			leftMeta.setDisplayName(ChatColor.GREEN.toString() + ChatColor.BOLD + "Go Page Left");
		}else {
			left = new ItemStack(Material.RED_STAINED_GLASS_PANE);
			leftMeta = left.getItemMeta();
			leftMeta.setDisplayName(ChatColor.RED.toString() + ChatColor.BOLD + "No Page Available");
		}
		leftMeta.setLocalizedName(page + "");
		left.setItemMeta(leftMeta);
		
		gui.setItem(0, left);
		
		ItemStack right;
		ItemMeta rightMeta;
		if(PageUtil.isPageValid(onlinePlayers, page + 1, 52)) {
			right = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
			rightMeta = right.getItemMeta();
			rightMeta.setDisplayName(ChatColor.GREEN.toString() + ChatColor.BOLD + "Go Page Left");
		}else {
			right = new ItemStack(Material.RED_STAINED_GLASS_PANE);
			rightMeta = right.getItemMeta();
			rightMeta.setDisplayName(ChatColor.RED.toString() + ChatColor.BOLD + "No Page Available");
		}
		right.setItemMeta(rightMeta);
		
		gui.setItem(8, right);
		
		for(ItemStack item : PageUtil.getPageItems(onlinePlayers, page, 52)) {
			gui.setItem(gui.firstEmpty(), item);
		}
		
		
		for(Player p: Bukkit.getOnlinePlayers()) {
            ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta meta = (SkullMeta) skull.getItemMeta();
            meta.setOwner(p.getName());
            meta.setDisplayName(ChatColor.AQUA + p.getName());
            skull.setItemMeta(meta);
            gui.setItem(gui.firstEmpty(), skull);
        }
		
		player.openInventory(gui);
		
	}
	
	//Player's GUI
	
	@SuppressWarnings("deprecation")
	public static void showPlayer(Player player, Player admin){
		
		//Creating Inventory
		Inventory gui = Bukkit.createInventory(null, 27, ChatColor.AQUA.toString() + ChatColor.BOLD + "Player: " + player.getName());
		
		//Skull
		ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
		SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
		skullMeta.setOwner(player.getName());
		skullMeta.setDisplayName(ChatColor.AQUA.toString() + ChatColor.BOLD + player.getName());
		List<String> skullLore = new ArrayList<>();
		skullLore.add("");
		skullLore.add(ChatColor.GRAY.toString() + player.getUniqueId());
		skullMeta.setLore(skullLore);
		skull.setItemMeta(skullMeta);
		
		//Compass - TP to player
		ItemStack compass = new ItemStack(Material.COMPASS);
		ItemMeta compMeta = compass.getItemMeta();
		compMeta.setDisplayName(ChatColor.AQUA.toString() + ChatColor.BOLD + "Teleport To Player");
		List<String> compLore = new ArrayList<>();
		compLore.add("");
		compLore.add(ChatColor.GRAY.toString() + "Teleport to player's location.");
		compMeta.setLore(compLore);
		compass.setItemMeta(compMeta);
		
		//Beacon - TP Player to your location
		ItemStack beacon = new ItemStack(Material.BEACON);
		ItemMeta beaconMeta = beacon.getItemMeta();
		beaconMeta.setDisplayName(ChatColor.AQUA.toString() + ChatColor.BOLD + "Teleport Player To Me");
		List<String> beaconLore = new ArrayList<>();
		beaconLore.add("");
		beaconLore.add(ChatColor.GRAY.toString() + "Teleport a player to your location.");
		beaconMeta.setLore(beaconLore);
		beacon.setItemMeta(beaconMeta);
		
		//Chest - Open Player's Inventory
		ItemStack chest = new ItemStack(Material.CHEST);
		ItemMeta chestMeta = chest.getItemMeta();
		chestMeta.setDisplayName(ChatColor.AQUA.toString() + ChatColor.BOLD + "Open Player Inventory");
		List<String> chestLore = new ArrayList<>();
		chestLore.add("");
		chestLore.add(ChatColor.GRAY.toString() + "Opens the player's inventory.");
		chestMeta.setLore(chestLore);
		chest.setItemMeta(chestMeta);
		
		//Ice - freeze's player
		ItemStack ice = new ItemStack(Material.ICE);
		ItemMeta iceMeta = ice.getItemMeta();
		iceMeta.setDisplayName(ChatColor.AQUA.toString() + ChatColor.BOLD + "Freeze Player");
		List<String> iceLore = new ArrayList<>();
		iceLore.add("");
		iceLore.add(ChatColor.GRAY.toString() + "Freezes a player at their location.");
		iceMeta.setLore(iceLore);
		ice.setItemMeta(iceMeta);
		
		//Firecharge - Unfreeze Player
		ItemStack fire = new ItemStack(Material.FIRE_CHARGE);
		ItemMeta fireMeta = fire.getItemMeta();
		fireMeta.setDisplayName(ChatColor.AQUA.toString() + ChatColor.BOLD + "Unfreeze Player");
		List<String> fireLore = new ArrayList<>();
		fireLore.add("");
		fireLore.add(ChatColor.GRAY.toString() + "Unfreezes a frozen player.");
		fireMeta.setLore(fireLore);
		fire.setItemMeta(fireMeta);
		
		
		//Redstone Block - Ban
		ItemStack red = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta redMeta = red.getItemMeta();
		redMeta.setDisplayName(ChatColor.AQUA.toString() + ChatColor.BOLD + "Ban Player");
		List<String> redLore = new ArrayList<>();
		redLore.add("");
		redLore.add(ChatColor.GRAY.toString() + "Opens ban GUI for specified player.");
		redMeta.setLore(redLore);
		red.setItemMeta(redMeta);
		
		//Sign - Mute Player
		ItemStack feather = new ItemStack(Material.FEATHER);
		ItemMeta featherMeta = feather.getItemMeta();
		featherMeta.setDisplayName(ChatColor.AQUA.toString() + ChatColor.BOLD + "Fling Player");
		List<String> featherLore = new ArrayList<>();
		featherLore.add("");
		featherLore.add(ChatColor.GRAY.toString() + "Flings player into air.");
		featherMeta.setLore(featherLore);
		feather.setItemMeta(featherMeta);
		
		//Redstone Torch - Kick Player
		ItemStack torch = new ItemStack(Material.REDSTONE_TORCH);
		ItemMeta torchMeta = torch.getItemMeta();
		torchMeta.setDisplayName(ChatColor.AQUA.toString() + ChatColor.BOLD + "Kick Player");
		List<String> torchLore = new ArrayList<>();
		torchLore.add("");
		torchLore.add(ChatColor.GRAY.toString() + "Kicks player from server.");
		torchMeta.setLore(torchLore);
		torch.setItemMeta(torchMeta);
		
		//Sword - Kills Player
		ItemStack sword = new ItemStack(Material.IRON_SWORD);
		ItemMeta swordMeta = sword.getItemMeta();
		swordMeta.setDisplayName(ChatColor.AQUA.toString() + ChatColor.BOLD + "Kill Player");
		List<String> swordLore = new ArrayList<>();
		swordLore.add("");
		swordLore.add(ChatColor.GRAY.toString() + "Kills the player.");
		swordMeta.setLore(swordLore);
		sword.setItemMeta(swordMeta);
		
		//Building GUI
		gui.setItem(4, skull);
		gui.setItem(10, compass);
		gui.setItem(12, chest);
		gui.setItem(14, red);
		gui.setItem(16, torch);
		gui.setItem(19, beacon);
		if(Main.getFrozen().contains(player)) {
			gui.setItem(21, fire);
		}else {
			gui.setItem(21, ice);
		}
		gui.setItem(23, feather);
		gui.setItem(25, sword);
		
		admin.openInventory(gui);
	}
	
	//Ban Gui
	public static void banPlayer(Player player, Player admin) {
		
		Inventory gui = Bukkit.createInventory(null, 36, "Ban Player: " + player.getName());
		
		//GUI Outline
		ItemStack outline = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta outlineMeta = outline.getItemMeta();
		outlineMeta.setDisplayName(ChatColor.GRAY + "...");
		outlineMeta.setLocalizedName(player.getName());
		outline.setItemMeta(outlineMeta);
		
		Ban spam = Ban.SPAM;
		Ban skin = Ban.SKIN;
		Ban scam = Ban.SCAM;
		Ban exploit = Ban.EXPLOIT;
		Ban xray = Ban.XRAY;
		Ban pvp = Ban.PVP;
		Ban move = Ban.MOVEMENT;
		
		//Spam
		ItemStack spamItem = new ItemStack(spam.getMaterial());
		ItemMeta spamMeta = spamItem.getItemMeta();
		spamMeta.setDisplayName(ChatColor.AQUA.toString() + spam.getName());
		List<String> spamLore = new ArrayList<>();
		spamLore.add(ChatColor.GRAY.toString() + "Bans player for " + ChatColor.DARK_RED.toString() +
				ChatColor.BOLD.toString() + Main.getBanLength().get("disrespect-spam") + ChatColor.GRAY.toString() + " days.");
		spamMeta.setLore(spamLore);
		spamItem.setItemMeta(spamMeta);
		
		ItemStack skinItem = new ItemStack(skin.getMaterial());
		ItemMeta skinMeta = skinItem.getItemMeta();
		skinMeta.setDisplayName(ChatColor.AQUA.toString() + skin.getName());
		List<String> skinLore = new ArrayList<>();
		skinLore.add(ChatColor.GRAY.toString() + "Bans player for " + ChatColor.DARK_RED.toString() + 
				ChatColor.BOLD.toString() + Main.getBanLength().get("inappropriate-skin-name") + ChatColor.GRAY.toString() + " days.");
		skinMeta.setLore(skinLore);
		skinItem.setItemMeta(skinMeta);
		
		ItemStack scamItem = new ItemStack(scam.getMaterial());
		ItemMeta scamMeta = scamItem.getItemMeta();
		scamMeta.setDisplayName(ChatColor.AQUA.toString() + scam.getName());
		List<String> scamLore = new ArrayList<>();
		scamLore.add(ChatColor.GRAY.toString() + "Bans player for " + ChatColor.DARK_RED.toString() + 
				ChatColor.BOLD.toString() + Main.getBanLength().get("scamming-advertising") + ChatColor.GRAY.toString() + " days.");
		scamMeta.setLore(scamLore);
		scamItem.setItemMeta(scamMeta);
		
		ItemStack exploitItem = new ItemStack(exploit.getMaterial());
		ItemMeta exploitMeta = exploitItem.getItemMeta();
		exploitMeta.setDisplayName(ChatColor.AQUA.toString() + exploit.getName());
		List<String> exploitLore = new ArrayList<>();
		exploitLore.add(ChatColor.GRAY.toString() + "Bans player for " + ChatColor.DARK_RED.toString() + 
				ChatColor.BOLD.toString() + Main.getBanLength().get("exploiting") + ChatColor.GRAY.toString() + " days.");
		exploitMeta.setLore(exploitLore);
		exploitItem.setItemMeta(exploitMeta);
		
		ItemStack xrayItem = new ItemStack(xray.getMaterial());
		ItemMeta xrayMeta = xrayItem.getItemMeta();
		xrayMeta.setDisplayName(ChatColor.AQUA.toString() + xray.getName());
		List<String> xrayLore = new ArrayList<>();
		xrayLore.add(ChatColor.GRAY.toString() + "Bans player for " + ChatColor.DARK_RED.toString() + 
				ChatColor.BOLD.toString() + Main.getBanLength().get("xray") + ChatColor.GRAY.toString() + " days.");
		xrayMeta.setLore(xrayLore);
		xrayItem.setItemMeta(xrayMeta);
		
		ItemStack pvpItem = new ItemStack(pvp.getMaterial());
		ItemMeta pvpMeta = pvpItem.getItemMeta();
		pvpMeta.setDisplayName(ChatColor.AQUA.toString() + pvp.getName());
		List<String> pvpLore = new ArrayList<>();
		pvpLore.add(ChatColor.GRAY.toString() + "Bans player for " + ChatColor.DARK_RED.toString() + 
				ChatColor.BOLD.toString() + Main.getBanLength().get("pvp") + ChatColor.GRAY.toString() + " days.");
		pvpMeta.setLore(pvpLore);
		pvpItem.setItemMeta(pvpMeta);
		
		ItemStack moveItem = new ItemStack(move.getMaterial());
		ItemMeta moveMeta = moveItem.getItemMeta();
		moveMeta.setDisplayName(ChatColor.AQUA.toString() + move.getName());
		List<String> moveLore = new ArrayList<>();
		moveLore.add(ChatColor.GRAY.toString() + "Bans player for " + ChatColor.DARK_RED.toString() + 
				ChatColor.BOLD.toString() + Main.getBanLength().get("movement") + ChatColor.GRAY.toString() + " days.");
		moveMeta.setLore(moveLore);
		moveItem.setItemMeta(moveMeta);
		
		gui.setItem(10, spamItem);
		gui.setItem(11, skinItem);
		gui.setItem(12, scamItem);
		gui.setItem(13, exploitItem);
		gui.setItem(14, xrayItem);
		gui.setItem(15, pvpItem);
		gui.setItem(16, moveItem);
		
		ItemStack oneHour = new ItemStack(Material.LIGHT_BLUE_WOOL);
		ItemMeta oneHourMeta = oneHour.getItemMeta();
		oneHourMeta.setDisplayName(ChatColor.AQUA + "1 Hour Ban");
		oneHour.setItemMeta(oneHourMeta);
		
		ItemStack oneDay = new ItemStack(Material.YELLOW_WOOL);
		ItemMeta oneDayMeta = oneDay.getItemMeta();
		oneDayMeta.setDisplayName(ChatColor.AQUA + "1 Day Ban");
		oneDay.setItemMeta(oneDayMeta);
		
		ItemStack fiveDay = new ItemStack(Material.LIME_WOOL);
		ItemMeta fiveDayMeta = fiveDay.getItemMeta();
		fiveDayMeta.setDisplayName(ChatColor.AQUA + "5 Day Ban");
		fiveDay.setItemMeta(fiveDayMeta);
		
		ItemStack fifteenDay = new ItemStack(Material.PINK_WOOL);
		ItemMeta fifteenDayMeta = fifteenDay.getItemMeta();
		fifteenDayMeta.setDisplayName(ChatColor.AQUA + "15 Day Ban");
		fifteenDay.setItemMeta(fifteenDayMeta);
		
		ItemStack thirtyDay = new ItemStack(Material.MAGENTA_WOOL);
		ItemMeta thirtyDayMeta = thirtyDay.getItemMeta();
		thirtyDayMeta.setDisplayName(ChatColor.AQUA + "30 Day Ban");
		thirtyDay.setItemMeta(thirtyDayMeta);
		
		ItemStack sixtyDay = new ItemStack(Material.RED_WOOL);
		ItemMeta sixtyDayMeta = sixtyDay.getItemMeta();
		sixtyDayMeta.setDisplayName(ChatColor.AQUA + "60 Day Ban");
		sixtyDay.setItemMeta(sixtyDayMeta);
		
		ItemStack perm = new ItemStack(Material.BEDROCK);
		ItemMeta permMeta = perm.getItemMeta();
		permMeta.setDisplayName(ChatColor.RED.toString() + ChatColor.BOLD + "Permanent/IP Ban");
		perm.setItemMeta(permMeta);
		
		gui.setItem(19, oneHour);
		gui.setItem(20, oneDay);
		gui.setItem(21, fiveDay);
		gui.setItem(22, fifteenDay);
		gui.setItem(23, thirtyDay);
		gui.setItem(24, sixtyDay);
		gui.setItem(25, perm);
		
		for(int i = 0; i < 22; i++) {
			gui.setItem(gui.firstEmpty(), outline);
		}
		
		admin.openInventory(gui);
		
	}
	
	public static void warnPlayer(Player player, Player admin, String message) {
		
		Inventory gui = Bukkit.createInventory(null, 27, "Infraction Warning");
		
		ItemStack warn = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta meta = warn.getItemMeta();
		meta.setDisplayName(ChatColor.RED.toString() + ChatColor.BOLD + "Infraction Warning");
		List<String> lore = new ArrayList<>();
		lore.add(ChatColor.GRAY + "Reason: " + message);
		lore.add(ChatColor.GRAY + "This will be your only warning. Next infraction will result in a more severe punishment.");
		lore.add("By closing this menu, you acknowlege the information given above.");
		meta.setLore(lore);
		warn.setItemMeta(meta);
		
		gui.setItem(13, warn);
		
		ItemStack outline = new ItemStack(Material.RED_STAINED_GLASS_PANE);
		ItemMeta outlineMeta = outline.getItemMeta();
		outlineMeta.setDisplayName(ChatColor.GRAY + "...");
		outline.setItemMeta(outlineMeta);
		
		for(int i = 0; i < 26; i++) {
			gui.setItem(gui.firstEmpty(), outline);
		}
		
		admin.sendMessage(ChatColor.AQUA.toString() + ChatColor.BOLD + "Player warning sent.");
		player.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD + "You have received a Rule Infraction Warning.");
		
		player.openInventory(gui);
		
	}
	
	
}


