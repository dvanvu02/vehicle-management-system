package data;

public class Motorbike extends Vehicle {
	
	private static final long serialVersionUID = 1L;
	
	private double speed;
	private String requireLicense;
	
	public Motorbike(String id, String name, String brand, String color,
					 double price, double speed, String requireLicense) {
		super(id, name, color, brand, price);
		this.speed = speed;
		this.requireLicense = requireLicense;
	}
	
	public double getSpeed() {return speed;}
	// public String getRequireLicense() {return requireLicense;}
	public String requireLicense() {return requireLicense;}
	public void setSpeed(double speed) {this.speed = speed;}
	
	@Override
	public String getDetails() {
		// Implement the body of abstract methods (BẮT BUỘC)
		return "Motorbike [id=" + id + ", name=" + name + ", color=" + color +
			   ", brand=" + brand + ", price=" + price + ", speed=" + speed + 
			   ", requireLicense=" + requireLicense + "]";
	}
	
	@Override
	public void makeSound() {
		// Ghi đè/Phát triển/Sửa đổi những gì được extends từ class Vehicle
		System.out.println("Tin tin tin");
	}
}
