package main;

import data.Showroom;
import ui.Menu;

public class Main {

	public static void main(String[] args) {
		Showroom sr = new Showroom();
		
		Menu menu = new Menu("Vehicle Management System");
		menu.addNewOption("1. Load data from file");
		menu.addNewOption("2. Add new vehicle");
		menu.addNewOption("3. Update vehicle by ID");
		menu.addNewOption("4. Delete vehicle by ID");
		menu.addNewOption("5. Search vehicle");
		menu.addNewOption("6. Show vehicle list");
		menu.addNewOption("7. Store/Save data to file");
		menu.addNewOption("8. Quit");
		
		String check = null;
		int count = 0, choice;
		do {
			System.out.println("");
			menu.printMenu();
			System.out.println("");
			choice = menu.getChoice();
			switch (choice) {
				case 1:
					System.out.println("You are required to load/read data from file");
					sr.loadDataFromFile();
					break;
				case 2:
					System.out.println("You are required to add new vehicle");
					sr.addNewVehicle();
					count = 1;
					break;
				case 3:
					System.out.println("You are required to update vehicle by id");
					sr.updateVehicleByID();
					count = 1;
					break;
				case 4:
					System.out.println("You are required to delete vehicle by id");
					System.out.println("");
					sr.deleteVehicleByID();
					count = 1;
					break;
				case 5:
					System.out.println("You are required to search vehicle");
					sr.searchVehicle();
					break;
				case 6:
					System.out.println("You are required to show vehicle list");
					sr.showVehicleList();
					break;
				case 7:
					System.out.println("You are required to save/write data to file");
					sr.storeDataToFile();
					break;
				case 8:
					System.out.println("Oke bye, see you next time!");
					break;
				default:
					System.out.println("Invalid option! Please choose a valid option.");
				}
		} while (choice != 8);
	}	 
}