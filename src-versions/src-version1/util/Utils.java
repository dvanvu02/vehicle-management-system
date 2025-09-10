package util;

import java.util.Scanner;
/*
 * Class Utils chứa các phương thức được sử dụng cho việc nhập xuất dữ liệu
 * dữ liệu cần nhập vào là đặc điểm/attribute/property of Object/Class
 */
public class Utils {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static int getAnInteger(String inputMsg, String errorMsg,
									int lowerBound, int upperBound) {
		int number;
		while (true) {
			try {
				System.out.print(inputMsg);
				number = Integer.parseInt(sc.nextLine());
				if (number < lowerBound || number > upperBound)
					throw new Exception();
				return number;
			} catch (Exception e) {
				System.out.println(errorMsg);
			}
		}
	}
	
	public static double getADouble(String inputMsg, String errorMsg,
									double lowerBound, double upperBound) {
		double number;
		while (true) {
			try {
				System.out.print(inputMsg);
				number = Double.parseDouble(sc.nextLine());
				if (number < lowerBound || number > upperBound) {throw new Exception();}
				return number;
			} catch (Exception e) {
				System.out.println(errorMsg);
			}
		}
	}
	
	public static String getAString(String inputMsg, String errorMsg) {
		String str;
		while (true) {
			System.out.print(inputMsg);
			str = sc.nextLine().trim();
			// không cần sử dụng s.length() vì phương thức isEmpty() đã kiểm tra độ dài chuỗi
			if (str.isEmpty())
				System.out.println(errorMsg);
			else
				return str;
		}
	}
	
	public static String getAString(String inputMsg, String errorMsg, String format) {
		String str;
		while (true) {
			System.out.print(inputMsg);
			/*
			 * s = sc.nextLine().trim().toUpperCase();
			 * 
			 * Đối với câu lệnh trên, đang convert sang chuỗi IN HOA = method toUpperCase()
			 * regex "^(Yes|No)$" không hỗ trợ in hoa
			 * ==> khi truyền regex vào trong format sẽ không có kết quả khớp 
			 * 
			 * ==> Giải pháp cho vấn đề này,
			 * 	+) bỏ phương thức toUpperCase() đi
			 * 	+) đảm bảo regex được truyền vào là mẫu hợp lệ = "^(?i)(Yes|No)$"
			 * 		để được hỗ trợ IN HOA.
			 */
			str = sc.nextLine().trim();
			if (str.isEmpty() || str.matches(format) == false)
				System.out.println(errorMsg);
			else 
				return str;
		}
	}
	
	public static String getId(String inputMsg, String errorMsg, String format) {
		String id;
		while (true) {
			System.out.print(inputMsg);
			id = sc.nextLine().trim();
			if (id.isEmpty() || id.matches(format) == false)
				System.out.println(errorMsg);
			else
				return id;
		}
	}
	
	// TEST methods
	public static void main(String[] args) {
		String id = getId("Input id(Vxxxxx): ",
				"Your input must be follow the format of Dxxxxx, x stands for a digit",
				"^[Vv]\\d{5}$");
		/*
		 * Topic) Regex/Regular Expression
		 * 
		 * ^, Ký hiệu bắt đầu chuỗi (chuỗi phải bắt đầu với những gì được mô tả sau dấu ^)
		 * 
		 * [D|d], Một tập hợp các ký tự. Ở đây, [D|d] yêu cầu ký tự đầu tiên của chuỗi là D hoặc d
		 * Lưu ý: Dấu | không cần thiết trong tập hợp [D|d]. [Dd] sẽ tương đương và hiệu quả hơn.
		 * 
		 * \\d, Biểu thị một chữ số (từ 0 đến 9)
		 * 
		 * {5}, Chỉ định rằng phải có đúng 5 chữ số liên tiếp
		 * 
		 * $, Ký hiệu kết thúc chuỗi (chuỗi phải kết thúc ngay sau các ký tự được mô tả trước đó).
		 */
		System.out.println("Your id: " + id);
	}
}
