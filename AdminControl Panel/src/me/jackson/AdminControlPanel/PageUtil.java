package me.jackson.AdminControlPanel;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.inventory.ItemStack;

public class PageUtil {
	

	//Returns items on a page of GUI
	public static List<ItemStack> getPageItems(List<ItemStack> items, int page, int spaces){
		int upperBound = page * spaces;
		int lowerBound = upperBound - spaces;
		List<ItemStack> newItems = new ArrayList<>();
		for(int i = lowerBound; i < upperBound; i++) {
			try {
				newItems.add(items.get(i));
			}catch(IndexOutOfBoundsException e) {
				continue;
			}	
		}
		return newItems;
	}
	
	//Returns if a page is valid
	public static boolean isPageValid(List<ItemStack> items, int page, int spaces) {
		
		if(page <= 0) return false;
		
		int upperBound = page * spaces;
		int lowerBound = upperBound - spaces;
		
		return items.size() > lowerBound;
		
	}
	
	
	
}
