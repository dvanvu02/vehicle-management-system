package ui;

import java.util.ArrayList;
import util.Utils;

public class Menu {
	private String menuTitle;
	private ArrayList<String> options = new ArrayList<String>();
	
	public Menu(String menuTitle) {this.menuTitle = menuTitle;}
	
	public void addNewOption(String newOption) {
		//Kiểm tra xem option mới có trùng với những option có sẵn không?
		if (!options.contains(newOption))
			options.add(newOption);
	}
	
	public void printMenu() {
		if (options.isEmpty()) {
			System.out.println("There is no item in the menu");
			return;
		}
		System.out.println("----------" + menuTitle + "----------");
		for (String option : options) {System.out.println(option);}
	}
	
	public int getChoice() {
		int maxOption = options.size();
		String inputMsg = "Choose [1.." + maxOption + "]: ";
		String errorMsg = "You are required to choose the option 1.." + maxOption; 
		return Utils.getAnInteger(inputMsg, errorMsg, 1, maxOption);
	}
}

