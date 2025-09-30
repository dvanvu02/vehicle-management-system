# Vehicle Management System
## 📌 Overview
A console-based application for managing vehicles in a showroom.  
Supports two types of vehicles: **Car** and **Motorbike**.  
Developed as part of a university assignment to practice **Java OOP, DSA, and File I/O**.  
## 🚀 Features
- Add new vehicle (Car or Motorbike) with validation.
- Update vehicle details by ID.  
- Delete vehicle by ID with confirmation.
- Search vehicle:
    - By name (descending order).
    - By ID.
- Display vehicle list:
    - All vehicles
    - Sorted by price (descending).
- Load data from file and save data back to file.
- Motorbikes include a special function `makeSound()` → prints **"Tin tin tin"**. 
## 🛠️ Technologies Used
- Java 
- OOP (Encapsulation, Inheritance, Abstraction, Polymorphism)
- File I/O
## 📂 Project Structure
src/
├── data/
│ ├── Vehicle.java
│ ├── Car.java
│ ├── Motorbike.java
│ └── Showroom.java
├── ui/
│ └── Menu.java
├── util/
│ └── Utils.java
└── main/
└── Main.java
## ▶️ How to Run
1. Clone the repository:
    ```bash
    git clone https://github.com/dvanvu02/vehicle-management-system.git
2.Open the project in your IDE (e.g., Eclipse, NetBeans, IntelliJ, VS Code).
3.Compile and run Main.java.
4. Interact with the menu to manage vehicles.
## 📝 Sample Run
----------Vehicle Management System----------
1. Load data from file
2. Add new vehicle
3. Update vehicle by ID
4. Delete vehicle by ID
5. Search vehicle
6. Show vehicle list
7. Store/Save data to file
8. Quit

Choose [1..8]:

## 📸 Screenshot
![Console Demo](https://github.com/dvanvu02/vehicle-management-system/blob/main/demo-images/console-demo.png)
## 📖 Learning Outcomes
- Practiced OOP principles (Encapsulation, Inheritance, Abstraction, Polymorphism).
- Applied File I/O for persistence.
- Learned to design modular code with multiple packages.
#### dvanvu02