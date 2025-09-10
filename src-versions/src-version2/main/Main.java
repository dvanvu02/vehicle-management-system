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
		menu.addNewOption("5. Search vehicle");
		menu.addNewOption("6. Show vehicle list");
		menu.addNewOption("7. Store data to file");
		menu.addNewOption("8. Quit");
		
		int choice;
		do {
			System.out.println("");
			menu.printMenu();
			System.out.println("");
			choice = menu.getChoice();
			switch (choice) {
				case 1:
					System.out.println("You are required to load/read data from file");
					System.out.println("");
					sr.loadDataFromFile();
					break;
				case 2:
					System.out.println("You are required to add new vehicle");
					sr.addNewVehicle();
					break;
				case 3:
					System.out.println("You are required to update vehicle by id");
					sr.updateVehicleByID();
					break;
				case 4:
					System.out.println("You are required to delete vehicle by id");
					System.out.println("");
					sr.deleteVehicleByID();
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
					System.out.println("You are required to store/write data to file");
					sr.storeDataToFile();
					break;
				case 8:
					System.out.println("Thank you, see you next time :)");
					break;
			}
		} while (choice != 8);
	}	 
}