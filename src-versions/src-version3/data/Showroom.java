package data;

import java.util.ArrayList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import util.Utils;
import ui.Menu;

public class Showroom extends ArrayList<Vehicle> {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	private int count = 0, countCar = 0, countMotorbike = 0;

	public void loadDataFromFile() {
		System.out.println("");
		File file = new File(
				"C:\\Users\\Vanvu\\Desktop\\OOPwithJava.Lab\\OOP\\Project\\P1.VehicleManagementSystem\\vehicles.txt");
	    if (!file.exists()) {
	        System.out.println("File does not exist. No data loaded.");
	        return;
	    }
		try (
			FileInputStream fins = new FileInputStream(file);
			ObjectInputStream oins = new ObjectInputStream(fins);	
		) {
			vehicles = (ArrayList<Vehicle>) oins.readObject();
			countCar = 0;
	        countMotorbike = 0;
	        for (Vehicle v : vehicles) {
	            if (v instanceof Car) countCar++;
	            if (v instanceof Motorbike) countMotorbike++;
	            System.out.println(v.getDetails());
	        }
	        System.out.println("");
	        System.out.println("Data loaded successfully! " + countCar + " cars and " + countMotorbike + " motorbikes.");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void addNewVehicle() {
		Menu subMenu = new Menu("2) Add new Vehicle (option)");
		subMenu.addNewOption("1. Add new car");
		subMenu.addNewOption("2. Add new motorbike");
		subMenu.addNewOption("3. Back to menu");

		int choice;
		do {
			System.out.println("");
			subMenu.printMenu();
			System.out.println("");
			choice = subMenu.getChoice();
			switch (choice) {
				case 1:
					System.out.println("You are required to add new Car");
					vehicles.add(newCar());
					System.out.println("Successfully!");
					countCar++;
					break;
				case 2:
					System.out.println("You are required to add new Motorbike");
					vehicles.add(newMotorbike());
					System.out.println("Successfully!");
					countMotorbike++;
					break;
				case 3:
					System.out.println("Okay, now we comeback to the main menu");
					break;
			}
		} while (choice != 3);
	}
	public Car newCar() {
		System.out.println("Vehicle #" + (count + 1));
		String id;
		int pos;
		do { 
			id = Utils.getId("Input Car ID(Cxxxxx): ", 
				"The format of ID is Cxxxxx (x stands for a digit)",
				"^[Cc]\\d{5}$");
			pos = searchVehicleByID(id);
			if (pos >= 0)
				System.out.println("The Car id already exist, input the another one!");
		} while (pos != -1);
		String name = Utils.getAString("Input Car name: ", "The car name is required");
		String brand = Utils.getAString("Input Car brand: ", "The car brand is required");
		String color = Utils.getColor("Input Car color (Red/Green/Blue): ");
		double price = Utils.getADouble("Input Car price: ", "Error, please input right number!");
		String type = Utils.getType("Input Car type (Sport/Travel/Common): ");
		int yearOfManufacture = Utils.getYearOfManufacture("Input Car year of manufacturer: ",
				"Error, please input right number!");
		return new Car(id, name, color, brand, price, type, yearOfManufacture);
	}	
	public Motorbike newMotorbike() {
		System.out.println("Vehicle #" + (countMotorbike + 1));
		String id;
		int pos;
		do { 
			id = Utils.getId("Input Motorbike ID(Mxxxxx): ",
					"The format of ID is Mxxxxx (x stands for a digit)",
					"^[Mm]\\d{5}$");
			pos = searchVehicleByID(id);
			if (pos >= 0)
				System.out.println("The Motorbike id already exist, input the another one!");
		} while (pos != -1);	
		String name = Utils.getAString("Input Motorbike name: ", "The motorbike name is required");
		String brand = Utils.getAString("Input Motorbike brand: ", "The motorbike brand is required");
		String color = Utils.getColor("Input Motorbike color (Red/Green/Blue): ");
		double price = Utils.getADouble("Input Motorbike price: ", "Error, please input right number!");
		int speed = Utils.getSpeed("Input Motorbike speed: ", "Error, please input right number! ");
		String license = Utils.getYesNo("Require license (Yes/No)? ");
		return new Motorbike(id, name, color, brand, price, speed, license);
	}
	public int searchVehicleByID(String vehicleID) {
		//This method returns the position of the Vehicle that they found in ArrayList (if they found)
		//int position;
		if (vehicles.isEmpty())
			return -1;
		for (int i = 0; i < vehicles.size(); i++) {
			if (vehicles.get(i).getId().equalsIgnoreCase(vehicleID))
				return i;
		}
		return -1;
	}
	
	public void updateVehicleByID() {
		if (vehicles.isEmpty()) {
			System.out.println("The showroom doesn't have any vehicles!");
			return;
		}
		
		Menu subMenu = new Menu("3) Update Vehicle by ID (option)");
		subMenu.addNewOption("1. Update id");
		subMenu.addNewOption("2. Update name");
		subMenu.addNewOption("3. Update brand");
		subMenu.addNewOption("4. Back the main menu");
		//Update thử 2 attribute, sau cập nhật thêm Update brand
		int choice;
		do {
			System.out.println("");
			subMenu.printMenu();
			System.out.println("");
			choice = subMenu.getChoice();
			switch (choice) {
			case 1:
				System.out.println("You are required to update id");
				System.out.println("");
				updateVehicleID();
				break;
			case 2:
				System.out.println("You are required to update name");
				System.out.println("");
				updateVehicleName();
				break;
			case 3:
				System.out.println("You are required to update brand");
				System.out.println("");
				updateVehicleBrand();
				break;
			case 4:
				System.out.println("Okay, now we comeback to the main menu");
				break;
			}
		} while (choice != 4);
	}
	public void updateVehicleID() {
		String currentID = Utils.getId("Input the id of the vehicle that you want to update ([C/M]xxxxx): ",
				"The format of ID is Cxxxxx or Mxxxxx (x stands for a digit)",
				"^[CcMm]\\d{5}$");
		for (int i = 0; i < vehicles.size(); i++) {
			if (vehicles.get(i).getId().equalsIgnoreCase(currentID)) {
				System.out.println("");
				System.out.println("Here is the information of the vehicle,");
				System.out.println(vehicles.get(i).getDetails());
				System.out.println("");
				String newID;
				int pos;
				do { 
					newID = Utils.getId("Input new ID([C/M]xxxxx): ", 
						"The format of ID is Cxxxxx or Mxxxxx (x stands for a digit)",
						"^[CcMm]\\d{5}$");
					pos = searchVehicleByID(newID);
					if (pos >= 0)
						System.out.println("The Car id already exist, input the another one!");
				} while (pos != -1);
				vehicles.get(i).setId(newID);
				System.out.println("");
				System.out.println("After update, the information of the vehicle,");
				System.out.println(vehicles.get(i).getDetails());
				return;
			}
		}
		System.out.println("Vehicle does not exist!");
		
	}
	public void updateVehicleName() {
		String currentID = Utils.getId("Input the id of the vehicle that you want to update ([C/M]xxxxx): ",
				"The format of ID is Cxxxxx or Mxxxxx (x stands for a digit)",
				"^[CcMm]\\d{5}$");
		for (int i = 0; i < vehicles.size(); i++) {
			if (vehicles.get(i).getId().equalsIgnoreCase(currentID)) {
				System.out.println("");
				System.out.println("Here is the information of the vehicle,");
				System.out.println(vehicles.get(i).getDetails());
				System.out.println("");
				String newName = Utils.getAString("Input new name: ", "The name is required");
				vehicles.get(i).setName(newName);
				System.out.println("");
				System.out.println("After update, the information of the vehicle,");
				System.out.println(vehicles.get(i).getDetails());
				return;
			}
		}
		System.out.println("Vehicle does not exist!");
	}
	public void updateVehicleBrand() {
		String currentID = Utils.getId("Input the id of the vehicle that you want to update ([C/M]xxxxx): ",
				"The format of ID is Cxxxxx or Mxxxxx (x stands for a digit)",
				"^[CcMm]\\d{5}$");
		for (int i = 0; i < vehicles.size(); i++) {
			if (vehicles.get(i).getId().equalsIgnoreCase(currentID)) {
				System.out.println("");
				System.out.println("Here is the information of the vehicle,");
				System.out.println(vehicles.get(i).getDetails());
				System.out.println("");
				String newBrand = Utils.getAString("Input new brand: ", "The brand is required");
				vehicles.get(i).setBrand(newBrand);
				System.out.println("After update, the information of the vehicle,");
				System.out.println(vehicles.get(i).getDetails());
				return;
			}
		}
		System.out.println("Vehicle does not exist!");
	}
	// Helper method, for updateVehicleByID() method (if you use)
	public Vehicle searchVehicleObject(String vehicleID) {
		if (vehicles.isEmpty())
			return null;
		for (int i = 0; i < vehicles.size(); i++)
			if (vehicles.get(i).getId().equalsIgnoreCase(vehicleID))
				return vehicles.get(i);
		return null;
	}
	
	public void deleteVehicleByID() {
		if (vehicles.isEmpty()) {
			System.out.println("The showroom doesn't have any vehicles!");
			return;
		}
		System.out.println("Here is the list of vehicle in showroom");
		for (Vehicle vehicle : vehicles)
			System.out.println(vehicle.getDetails());
		System.out.println("");
		String currentID = Utils.getId("Input the id of the vehicle ([C/M]xxxxx): ",
				"The format of ID is Cxxxxx or Mxxxxx (x stands for a digit)",
				"^[CcMm]\\d{5}$");
		for (int i = 0; i < vehicles.size(); i++) {
			if (vehicles.get(i).getId().equalsIgnoreCase(currentID)) {
				System.out.println("Here is the infor of the vehicle, which have ID=" + vehicles.get(i).getId());
				System.out.println(vehicles.get(i).getDetails());
				System.out.println("");
				String choice = Utils.getAString(
						"We are preparing to delete this infor, are you sure (Yes/No)? ",
						"You MUST input Yes/No, not anything else!!!",
						"^(?i)(Yes|No)$");
				if (choice.equalsIgnoreCase("Yes")) {
					vehicles.remove(i);
					System.out.println("Success! The infor has been deleted");
					return;
				}
				return;
			}
		}
		System.out.println("Vehicle does not exist!");
	}
	
	public void searchVehicle() {
		Menu subMenu = new Menu("5) Search vehicle");
		subMenu.addNewOption("1. Search vehicle by name");
		subMenu.addNewOption("2. Search vehicle by ID");
		subMenu.addNewOption("3. Quit/Exit");
		
		int choice;
		do {
			System.out.println();
			subMenu.printMenu();
			System.out.println();
			choice = subMenu.getChoice();
			switch (choice) {
				case 1:
					System.out.println("You are required to search vehicle by name");
					this.searchVehicleByName();
					break;
				case 2:
					System.out.println("You are required to search vehicle by ID");
					this.searchVehicleByID();
					break;
				case 3:
					System.out.println("Okay, now we comeback to the main menu");
					break;
			}
		} while (choice != 3);
	}
	public void searchVehicleByName() {
		if (vehicles.isEmpty()) {
			System.out.println("The showroom doesn't has vehicles to display");
			return;
		}
		String currentName = Utils.getAString("Input the name of the vehicle: ",
				"The name of the vehicle is required");
		for (int i = 0; i < vehicles.size(); i++) {
			if (vehicles.get(i).getName().equalsIgnoreCase(currentName)) {
				System.out.println();
				System.out.println("Here is the infor of the vehicle, which has name: " + currentName);
				System.out.println(vehicles.get(i).getDetails());
				return;
			}
		}
		System.out.println("We don't find any vehicles with name: " + currentName);
	}
	public void searchVehicleByID() {
		if (vehicles.isEmpty()) {
			System.out.println("The showroom doesn't has vehicles to display");
			return;
		}
		String currentID = Utils.getId("Input the id of the vehicle that you want ([C/M]xxxxx): ",
				"The format of ID is Cxxxxx or Mxxxxx (x stands for a digit)",
				"^[CcMm]\\d{5}$");
		for (int i = 0; i < vehicles.size(); i++) {
			if (vehicles.get(i).getId().equalsIgnoreCase(currentID)) {
				System.out.println();
				System.out.println("Here is the infor of the vehicle, which has ID: " + currentID);
				System.out.println(vehicles.get(i).getDetails());
				return;
			}
		}
		System.out.println("We don't find any vehicle with ID: " + currentID);
	}
	
	public void showVehicleList() {
		Menu subMenu = new Menu("6) Show vehicle list");
		subMenu.addNewOption("1. Show all vehilce list");
		subMenu.addNewOption("2. Show vehicle list (descending by price)");
		subMenu.addNewOption("3. Quit/Exit");
		
		int choice;
		do {
			System.out.println();
			subMenu.printMenu();
			System.out.println();
			choice = subMenu.getChoice();
			switch (choice) {
				case 1:
					System.out.println("You are required to show all vehicle list");
					this.showAllVehicleList();
					break;
				case 2:
					System.out.println("You are required to show vehicle list (descending by price)");
					this.showVehicleListDescendingByPrice();;
					break;
				case 3:
					System.out.println("Okay, now we comeback to the main menu");
					break;
			}
		} while (choice != 3);
	}
	public void showAllVehicleList() {
		if (vehicles.isEmpty()) {
			System.out.println("The showroom doesn't has vehicles to display");
			return;
		}
		for (Vehicle vehicle : vehicles) {
			System.out.println(vehicle.getDetails());
			vehicle.makeSound();
		}
	}
	public void showVehicleListDescendingByPrice() {
		if (vehicles.isEmpty()) {
			System.out.println("The showroom doesn't has vehicles to display");
			return;
		}
		for (int i = 0; i < vehicles.size() - 1; i++) {
			for (int j = i + 1; j < vehicles.size(); j++) {
				if (vehicles.get(i).getPrice() < vehicles.get(j).getPrice()) {
					Vehicle temp = vehicles.get(i);
					vehicles.set(i, vehicles.get(j));
					vehicles.set(j, temp);
				}
			}
		}
		for (Vehicle vehicle : vehicles) {
			System.out.println(vehicle.getDetails());
			vehicle.makeSound();
		}
	}
	
	public void storeDataToFile() {
		File file = new File("C:\\Users\\Vanvu\\Desktop\\OOPwithJava.Lab\\OOP\\Project\\P1.VehicleManagementSystem\\vehicles.txt");
		try {
			FileOutputStream fouts = new FileOutputStream(file);
			ObjectOutputStream oouts = new ObjectOutputStream(fouts);
			oouts.writeObject(vehicles);
			System.out.println("Saved!");
			oouts.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
