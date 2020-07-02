package me.jackson.AdminControlPanel;

import org.bukkit.Material;

public enum Ban {

	SPAM("Disrespect/Spamming", "Disrespect or Spamming.", Material.OAK_SIGN),
	SKIN("Inappropriate Skin/Name", "Inappropriate Skin or Name.\nNext offense will result in a Permanent Ban.", Material.ZOMBIE_HEAD),
	SCAM("Scamming/Advertisment", "Scamming or Advertising", Material.GOLD_INGOT),
	EXPLOIT("Exploiting", "Exploiting", Material.PISTON),
	XRAY("X-Ray Hacking", "X-Ray Hacking", Material.DIAMOND_ORE),
	PVP("PVP Hacking", "PVP Hacking", Material.IRON_SWORD),
	MOVEMENT("Movement Hacking", "Movement Hacking", Material.ELYTRA);
	
	public String name;
	public String message;
	public Material material;
	
	
	private Ban(String name, String message, Material material) {
		
		this.name = name;
		this.message = message;
		this.material = material;
		
	}
	
	public String getName() {
		return name;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Material getMaterial() {
		return material;
	}
	
	
	
}
