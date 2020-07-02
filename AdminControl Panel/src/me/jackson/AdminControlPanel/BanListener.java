package me.jackson.AdminControlPanel;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BanListener implements Listener {
	
	private Main main;
	public BanListener(Main main) {
		this.main = main;
	}
	
	//Event Handler for Ban GUI
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
		Player player = (Player) e.getWhoClicked();
		ItemStack item = e.getCurrentItem();
		Inventory inv = e.getInventory();
	
		Player banned = Bukkit.getPlayer(inv.getItem(0).getItemMeta().getLocalizedName());
		
		if(item != null && item.getType() != null && e.getView().getTitle().contains("Ban Player: ")) {
			
			Calendar cal = Calendar.getInstance();
			Date date;
			int days;
			
			String message = null;
			
			if(e.getRawSlot() == 19 && item.getType().equals(Material.LIGHT_BLUE_WOOL)) {
				
				//1 Hour Ban
				cal.set(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DATE), Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + 1, Calendar.getInstance().get(Calendar.MINUTE));
				date = cal.getTime();
				Bukkit.getBanList(Type.NAME).addBan(banned.getName(), ChatColor.RED.toString() + ChatColor.BOLD + "You have been banned.", date, null);
				banned.kickPlayer(ChatColor.RED.toString() + ChatColor.BOLD + "You have been banned till " + date.toString());
				player.sendMessage(ChatColor.AQUA.toString() + ChatColor.BOLD + "Successfully banned " + banned.getName() + ".");
				
				message = "1 Hour Ban";
				
			}else if(e.getRawSlot() == 20 && item.getType().equals(Material.YELLOW_WOOL)) {			
				
				//1 Day Ban
				cal.set(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DATE) + 1);
				date = cal.getTime();
				Bukkit.getBanList(Type.NAME).addBan(banned.getName(), ChatColor.RED.toString() + ChatColor.BOLD + "You have been banned.", date, null);
				banned.kickPlayer(ChatColor.RED.toString() + ChatColor.BOLD + "You have been banned till " + date.toString());
				player.sendMessage(ChatColor.AQUA.toString() + ChatColor.BOLD + "Successfully banned " + banned.getName() + ".");
				
				message = "1 Day Ban";
				
			}else if(e.getRawSlot() == 21 && item.getType().equals(Material.LIME_WOOL)){
				
				//5 Day Ban
				cal.set(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DATE) + 5);
				date = cal.getTime();
				Bukkit.getBanList(Type.NAME).addBan(banned.getName(), ChatColor.RED.toString() + ChatColor.BOLD + "You have been banned.", date, null);
				banned.kickPlayer(ChatColor.RED.toString() + ChatColor.BOLD + "You have been banned till " + date.toString());
				player.sendMessage(ChatColor.AQUA.toString() + ChatColor.BOLD + "Successfully banned " + banned.getName() + ".");
				
				message = "5 Day Ban";
				
			}else if(e.getRawSlot() == 22 && item.getType().equals(Material.PINK_WOOL)) {
				
				//15 Day Ban
				cal.set(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DATE) + 15);
				date = cal.getTime();
				Bukkit.getBanList(Type.NAME).addBan(banned.getName(), ChatColor.RED.toString() + ChatColor.BOLD + "You have been banned.", date, null);
				banned.kickPlayer(ChatColor.RED.toString() + ChatColor.BOLD + "You have been banned till " + date.toString());
				player.sendMessage(ChatColor.AQUA.toString() + ChatColor.BOLD + "Successfully banned " + banned.getName() + ".");
				
				message = "15 Day Ban";
				
			}else if(e.getRawSlot() == 23 && item.getType().equals(Material.MAGENTA_WOOL)) {
				
				//30 Day ban
				cal.set(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DATE) + 30);
				date = cal.getTime();
				Bukkit.getBanList(Type.NAME).addBan(banned.getName(), ChatColor.RED.toString() + ChatColor.BOLD + "You have been banned.", date, null);
				banned.kickPlayer(ChatColor.RED.toString() + ChatColor.BOLD + "You have been banned till " + date.toString());
				player.sendMessage(ChatColor.AQUA.toString() + ChatColor.BOLD + "Successfully banned " + banned.getName() + ".");
				
				message = "30 Day Ban";
				
			}else if(e.getRawSlot() == 24 && item.getType().equals(Material.RED_WOOL)) {
				
				//60 Day Ban
				cal.set(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DATE) + 60);
				date = cal.getTime();
				Bukkit.getBanList(Type.NAME).addBan(banned.getName(), ChatColor.RED.toString() + ChatColor.BOLD + "You have been banned.", date, null);
				banned.kickPlayer(ChatColor.RED.toString() + ChatColor.BOLD + "You have been banned till " + date.toString());
				player.sendMessage(ChatColor.AQUA.toString() + ChatColor.BOLD + "Successfully banned " + banned.getName() + ".");
				
				message = "60 Day Ban";
				
			}else if(e.getRawSlot() == 25 && item.getType().equals(Material.BEDROCK)) {
				//Perm Ban
				Bukkit.getBanList(Type.IP).addBan(banned.getName(), ChatColor.RED.toString() + ChatColor.BOLD + "You have been permanently banned.", null, null);
				banned.kickPlayer(ChatColor.RED.toString() + ChatColor.BOLD + "You have been permanently banned.");
				player.sendMessage(ChatColor.AQUA.toString() + ChatColor.BOLD + "Successfully banned " + banned.getName() + ".");
				
				message = "Permanent Ban";
				
			}else if(e.getRawSlot() == 10 && item.getType().equals(Ban.SPAM.getMaterial())) {
				
				// Disrespect / Spamming Ban
				days = Main.getBanLength().get("disrespect-spam");
				cal.set(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DATE) + days);
				date = cal.getTime();
				Bukkit.getBanList(Type.NAME).addBan(banned.getName(), ChatColor.RED.toString() + ChatColor.BOLD + Ban.SPAM.getMessage(), date, null);
				banned.kickPlayer(ChatColor.RED.toString() + ChatColor.BOLD + "You have been banned till " + date.toString() + " for " + Ban.SPAM.getMessage());
				player.sendMessage(ChatColor.AQUA.toString() + ChatColor.BOLD + "Successfully banned " + banned.getName() + ".");
				
				message = "Ban for Disrespect/Spamming";
				
			}else if(e.getRawSlot() == 11 && item.getType().equals(Ban.SKIN.getMaterial())) {
				
				// Inappropriate Skin or Name
				days = Main.getBanLength().get("inappropriate-skin-name");
				cal.set(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DATE) + days);
				date = cal.getTime();
				Bukkit.getBanList(Type.NAME).addBan(banned.getName(), ChatColor.RED.toString() + ChatColor.BOLD + Ban.SKIN.getMessage(), date, null);
				banned.kickPlayer(ChatColor.RED.toString() + ChatColor.BOLD + "You have been banned till " + date.toString() + " for " + Ban.SKIN.getMessage());
				player.sendMessage(ChatColor.AQUA.toString() + ChatColor.BOLD + "Successfully banned " + banned.getName() + ".");
				
				message = "Ban for Inappropriate Skin or Name";
				
			}else if(e.getRawSlot() == 12 && item.getType().equals(Ban.SCAM.getMaterial())) {
				
				// Scam of Advertising
				days = Main.getBanLength().get("scamming-advertising");
				cal.set(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DATE) + days);
				date = cal.getTime();
				Bukkit.getBanList(Type.NAME).addBan(banned.getName(), ChatColor.RED.toString() + ChatColor.BOLD + Ban.SCAM.getMessage(), date, null);
				banned.kickPlayer(ChatColor.RED.toString() + ChatColor.BOLD + "You have been banned till " + date.toString() + " for " + Ban.SCAM.getMessage());
				player.sendMessage(ChatColor.AQUA.toString() + ChatColor.BOLD + "Successfully banned " + banned.getName() + ".");
				
				message = "Ban for Scamming or Advertising";
				
			}else if(e.getRawSlot() == 13 && item.getType().equals(Ban.EXPLOIT.getMaterial())) {
				
				// Exploiting
				days = Main.getBanLength().get("exploiting");
				cal.set(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DATE) + days);
				date = cal.getTime();
				Bukkit.getBanList(Type.NAME).addBan(banned.getName(), ChatColor.RED.toString() + ChatColor.BOLD + Ban.EXPLOIT.getMessage(), date, null);
				banned.kickPlayer(ChatColor.RED.toString() + ChatColor.BOLD + "You have been banned till " + date.toString() + " for " + Ban.EXPLOIT.getMessage());
				player.sendMessage(ChatColor.AQUA.toString() + ChatColor.BOLD + "Successfully banned " + banned.getName() + ".");
				
				message = "Ban for Exploiting";
				
			}else if(e.getRawSlot() == 14 && item.getType().equals(Ban.XRAY.getMaterial())) {
				
				//Xray Hacking
				days = Main.getBanLength().get("xray");
				cal.set(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DATE) + days);
				date = cal.getTime();
				Bukkit.getBanList(Type.NAME).addBan(banned.getName(), ChatColor.RED.toString() + ChatColor.BOLD + Ban.XRAY.getMessage(), date, null);
				banned.kickPlayer(ChatColor.RED.toString() + ChatColor.BOLD + "You have been banned till " + date.toString() + " for " + Ban.XRAY.getMessage());
				player.sendMessage(ChatColor.AQUA.toString() + ChatColor.BOLD + "Successfully banned " + banned.getName() + ".");
				
				message = "Ban for XRAY Hacking";
				
			}else if(e.getRawSlot() == 15 && item.getType().equals(Ban.PVP.getMaterial())) {
				
				//PVP hacks
				days = Main.getBanLength().get("pvp");
				cal.set(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DATE) + days);
				date = cal.getTime();
				Bukkit.getBanList(Type.NAME).addBan(banned.getName(), ChatColor.RED.toString() + ChatColor.BOLD + Ban.PVP.getMessage(), date, null);
				banned.kickPlayer(ChatColor.RED.toString() + ChatColor.BOLD + "You have been banned till " + date.toString() + " for " + Ban.PVP.getMessage());
				player.sendMessage(ChatColor.AQUA.toString() + ChatColor.BOLD + "Successfully banned " + banned.getName() + ".");
				
				message = "Ban for PVP Hacking";
				
			}else if(e.getRawSlot() == 16 && item.getType().equals(Ban.MOVEMENT.getMaterial())){
				
				//Movement Hacks
				days = Main.getBanLength().get("movement");
				cal.set(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DATE) + days);
				date = cal.getTime();
				Bukkit.getBanList(Type.NAME).addBan(banned.getName(), ChatColor.RED.toString() + ChatColor.BOLD + Ban.MOVEMENT.getMessage(), date, null);
				banned.kickPlayer(ChatColor.RED.toString() + ChatColor.BOLD + "You have been banned till " + date.toString() + " for " + Ban.MOVEMENT.getMessage());
				player.sendMessage(ChatColor.AQUA.toString() + ChatColor.BOLD + "Successfully banned " + banned.getName() + ".");	
				
				message = "Ban for Movement Hacking";
				
			}
			
			
			
			Calendar scal = Calendar.getInstance();
			Date sdate = scal.getTime();
			
			if(!Main.getOffenses().contains(banned.getName())) {
				Main.getOffenses().createSection(banned.getName());
			}
				
			Main.getOffenses().set(banned.getName() + ".ban." + sdate, message);

			System.out.println(Main.getOffenses().getConfigurationSection(banned.getName() + ".").getKeys(false).size());
			
			try {
				Main.getOffenses().save(main.getFile());
			} catch (IOException f) {
				f.printStackTrace();
			}
			
			e.setCancelled(true);
		}
		
	}
	
	
}
