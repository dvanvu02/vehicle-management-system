package data;

public class Car extends Vehicle {
	
	private static final long serialVersionUID = 1L;
	
	private String type;
	private int yearOfManufacture;
	
	public Car(String id, String name, String brand, String color, 
			   double price, String type, int yearOfManufacture) {
		super(id, name, color, brand, price);
		this.type = type;
		this.yearOfManufacture = yearOfManufacture;
	}

	public String getType() {return type;}
	public int getYearOfManufacture() {return yearOfManufacture;}
	
	public void setType(String type) {this.type = type;}
	public void setYearOfManufacture(int yearOfManufacture) {this.yearOfManufacture = yearOfManufacture;}

	@Override
	public String getDetails() {
		return "Car [id=" + id + ", name=" + name + ", color=" + color +
		   ", brand=" + brand + ", price=" + price + ", type=" + type +
		   ", yearOfManufacture=" + yearOfManufacture + "]";
	}
}

