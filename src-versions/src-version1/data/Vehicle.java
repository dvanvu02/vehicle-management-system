package data;

import java.io.Serializable;

public abstract class Vehicle implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected String id, name, brand, color;
	protected double price;
	
	public Vehicle(String id, String name, String brand, String color, double price) {
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.color = color;
		this.price = price;
	}
	
	public String getId() {return id;}
	public String getName() {return name;}
	public String getBrand() {return brand;}
	public String getColor( ) {return color;}
	public double getPrice() {return price;}
	
	public void setId(String id) {this.id = id;}
	public void setName(String name) {this.name = name;}
	public void setBrand(String brand) {this.brand = brand;}
	public void setColor(String color) {this.color = color;}
	public void setPrice(double price) {this.price = price;}
	
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", name=" + name + ", brand=" + brand + ", color=" + color + ", price=" + price+ "]";
	}

	public abstract String getDetails();
	/*
	 * Ideas ở đây là class Vehicle mặc định sẽ có phương thức makeSound() nhưng không làm gì cả.
	 * 
	 * makeSound() gần giống với Abstract methods, 
	 * cha chỉ nói nhưng không làm, cha để làm con tự làm/tự @Override,
	 * nhưng khác với phương thức bình thường ở chỗ là,
	 * không phải loại Vehicle nào cũng makeSound() được cho nên @Override là TỰ NGUYỆN đối với con
	 * con không muốn @Override thì không có makeSound(),
	 * con muốn thay đổi, phát triển, phát huy thêm từ methods của Cha thì @Override
	 * 		==> TÍNH ĐA HÌNH/POLYMORPHISM xuất hiện, 1 methods makeSound() nhưng có N cách @Override
	 * 
	 * Một điều nữa, nếu bây giờ method makeSound() mà là Abstract methods,
	 * thì class Car/Motorbike BẮT BUỘC phải implement/triển khai the body of abstract method's
	 * NHƯNG có một vấn đề là Car không tạo ra sound mà Motorbike mới tạo ra sound
	 * cho nên không sử dụng abstract vì Car không sử dụng method makeSound()
	 * NẾU KHÔNG BẮT BUỘC Car phải implement rồi tạo ra tiếng kêu của riêng mình mặc dù không có :))
	 */
	public void makeSound() {}
}
