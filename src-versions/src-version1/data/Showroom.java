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
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	private int countCar = 0, countMotorbike = 0;

	public void addNewVehicle() {
		Menu subMenu = new Menu("2) Add new Vehicle (Car/Motorbike)");
		subMenu.addNewOption("1. Add new car");
		subMenu.addNewOption("2. Add new motorbike");
		subMenu.addNewOption("3. Quit/Exit");

		int choice;
		do {
			System.out.println();
			subMenu.printMenu();
			System.out.println();
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
		System.out.println("Car #" + (countCar + 1));
		String id;
		int pos;
		do { 
			id = Utils.getId("Input car ID(Cxxxxx): ",
					"The format of ID is Cxxxxx (x stands for a digit)",
					"^[Cc]\\d{5}$");
			pos = searchVehicleByID(id);
			if (pos >= 0) {
				System.out.println("The car id already exist, input the another one!");
			}
		} while (pos != -1);
		
		String name = Utils.getAString("Input car name: ", "The car name is required");
		String brand = Utils.getAString("Input car brand: ", "The car brand is required");
		String color = Utils.getAString("Input car color: ", "The car color is required");
		double price = Utils.getADouble("Input car price(0..100K$): ", 
				"Price is from 0 to 100K$", 0, 100);
		String type = Utils.getAString("Input car type: ", "The car type is required");
		int yearOfManufacture = Utils.getAnInteger("Input car year of manufacturer (2002..2024): ",
				"Year of Manufacture is from 2002 to 2024", 2002, 2024);
		/* 
		 * System.out.print("Input car id: ");
		 * String id = sc.nextLine();
		 * 
		 * System.out.print("Input car name: ");
		 * String name = sc.nextLine();
		 * 
		 * System.out.print("Input car color: ");
		 * String color = sc.nextLine();
		 * 
		 * System.out.print("Input car brand: ");
		 * String brand = sc.nextLine();
		 * 
		 * System.out.print("Input car price: ");
		 * double price = Double.parseDouble(sc.nextLine());
		 * 
		 * System.out.print("Input car type: ");
		 * String type = sc.nextLine();
		 * 
		 * System.out.print("Input car year of manufacture: ");
		 * int yearOfManufacture = Integer.parseInt(sc.nextLine());
		 */
		// LƯU Ý PHẢI CHẶN COLOR NỮA!!!!
		return new Car(id, name, color, brand, price, type, yearOfManufacture);
	}
	
	public Motorbike newMotorbike() {
	// public Motorbike addNewMotorbike()
		System.out.println("Motorbike #" + (countMotorbike + 1));
		String id;
		int pos;
		do { 
			id = Utils.getId("Input motorbike ID(Mxxxxx): ",
					"The format of ID is Mxxxxx (x stands for a digit)",
					"^[Mm]\\d{5}$");
			pos = searchVehicleByID(id);
			if (pos >= 0) {
				System.out.println("The motorbike id already exist, input the another one!");
			}
		} while (pos != -1);
		
		String name = Utils.getAString("Input motorbike name: ", "The motorbike name is required");
		String brand = Utils.getAString("Input motorbike brand: ", "The motorbike brand is required");
		String color = Utils.getAString("Input motorbike color: ", "The motorbike color is required");
		double price = Utils.getADouble("Input motorbike price(0..999K$): ", 
				"Price is from 0K$ to 100K$", 0, 999);
		double speed = Utils.getADouble("Input motorbike speed(110..180): ",
				"Speed is from 110km/h to 180km/h", 110, 180);
		String requireLincense = Utils.getAString("License require (yes/no)? ",
				"You MUST input Yes/No, not anything else!!!",
				"^(?i)(Yes|No)$");
		/*
		 * System.out.print("Input motorbike id: ");
		 *String id = sc.nextLine();
		 *
		 * System.out.print("Input motorbike name: ");
		 * String name = sc.nextLine();
		 * 
		 * System.out.print("Input motorbike color: ");
		 * String color = sc.nextLine();
		 * 
		 * System.out.print("Input motorbike brand: ");
		 * String brand = sc.nextLine();
		 * 
		 * System.out.print("Input motorbike price: ");
		 * double price = Double.parseDouble(sc.nextLine());
		 * 
		 * System.out.print("Input motorbike speed: ");
		 * double speed = Double.parseDouble(sc.nextLine());
		 * 
		 * System.out.print("License require (t/f): ");
		 * boolean requireLicense = sc.nextBoolean();
		 */
		return new Motorbike(id, name, color, brand, price, speed, requireLincense);
	}
	
	// Helper method, for addNewCar() method and addNewMotorBike() method
	//					  deleteVehicleByID() method
	public int searchVehicleByID(String vehicleID) {
		// This method returns the position of the Vehicle that they found in ArrayList (if they found)
		// int position;
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
		String currentID = Utils.getId("Input the id of the vehicle that you want ([C/M]xxxxx): ",
				"The format of ID is Cxxxxx or Mxxxxx (x stands for a digit)",
				"^[CcMm]\\d{5}$");
		/*
		 * id, name, brand của Vehicle nói chung thì không NÊN thay đổi.
		 * 
		 * Còn đối với Vehicle nói riêng, như Car hay Motorbike thì
		 * type và yearOfManufacture cũng không thay đổi vì kiểu dáng và năm sản xuất đều cố định
		 * speed và requireLinces cũng thế, không thay đổi hoặc có thay đổi nhưng rất lâu mới thay đổi.
		 * 
		 * Nhiều hãng xe cũng không cho thay đổi màu sắc của xe, lý do bản quyền
		 * thứ có thể bị thay đổi CHỈ CÓ giá của xe.
		 */	
		for (int i = 0; i < vehicles.size(); i++) {
			if (vehicles.get(i).getId().equalsIgnoreCase(currentID)) {
				System.out.println("Here is the information of the vehicle,");
				System.out.println(vehicles.get(i).getDetails());
				double newPrice = Utils.getADouble("Input new vehicle price (0..999K$): ", 
						"The vehicle price is required", 0, 999);
				vehicles.get(i).setPrice(newPrice);
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
	
	public void addAVehicleTest(Vehicle vehicle) { // Khi gọi phương thức add, thì đổ new Vehicle/Car/Motorbike(...) vào đây.
		/*
		 * System.out.println("Vehicle #" + (count + 1));
		 * System.out.print("Input vehicle id: ");
		 * String id = sc.nextLine();
		 * 
		 * System.out.print("Input the name of vehicle: ");
		 * String name = sc.nextLine();
		 *
		 * System.out.print("Input the color of vehicle: ");
		 * String color = sc.nextLine();
		 *
		 * System.out.print("Input the brand of vehicle: ");
		 * String brand = sc.nextLine();
		 *
		 * System.out.print("Input the price of vehicle: ");
		 * double price = sc.nextDouble();
		 * 
		 * vehicles[count] = new Vehicle(id, name, color, brand, price);
		 * count++;
		 */
		vehicles.add(vehicle);
		System.out.println("Vehicle added successfully!");
	}
	
	public void showAllVehiclesTest() {
		if (vehicles.isEmpty()) {
			System.out.println("The showroom doesn't has vehicles to display.");
			// return;
		} else {
			for (Vehicle v : vehicles) { // v <==> vehicles.get(i)
				System.out.println(v.getDetails());
				v.makeSound();
			}
		}
	}
	
	public void sortDescendingByPriceTest() {
		for (int i = 0; i < vehicles.size() - 1; i++) {
			for (int j = i + 1; j < vehicles.size(); j++) {
				if (vehicles.get(i).getPrice() < vehicles.get(j).getPrice()) {
					Vehicle temp = vehicles.get(i);
					vehicles.set(0, vehicles.get(1));
					vehicles.set(1, temp);
				}
			}
		}
	}
	
	public void loadDataFromFile() {
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
	        // Đếm số lượng Car và Motorbike trong danh sách
	        for (Vehicle v : vehicles) {
	            if (v instanceof Car) countCar++;
	            if (v instanceof Motorbike) countMotorbike++;
	            System.out.println(v);
	        }
	        System.out.println("Data loaded successfully! " + countCar + " cars and " + countMotorbike + " motorbikes.");
		} catch (Exception e) {
			System.out.println(e);
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
