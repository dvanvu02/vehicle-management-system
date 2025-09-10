package util;

import java.time.ZonedDateTime;
import java.util.Scanner;

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
	
	public static int getAnInteger(String inputMsg, String errorMsg) {
		while (true) {
			try {
				System.out.print(inputMsg);
				return Integer.parseInt(sc.nextLine());
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
	
	public static double getADouble(String inputMsg, String errorMsg) {
		while (true) {
			try {
				System.out.print(inputMsg);
				double number = Double.parseDouble(sc.nextLine());
				if (number > 0) 
					return number;
				System.out.println("Error, the number must be greater than 0!");
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
			//không cần sử dụng s.length() vì phương thức isEmpty() đã kiểm tra độ dài chuỗi
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
	
    public static String getColor(String inputMsg) {
    	String result = "";
    	boolean check = true;
    	do {
    		 System.out.print(inputMsg);
             try {
                 String currentStr = sc.nextLine();
                 if (!currentStr.isEmpty() && (currentStr.equalsIgnoreCase("Red") 
                 							|| currentStr.equalsIgnoreCase("Green")
                 							|| currentStr.equalsIgnoreCase("Blue"))) {
                     result = currentStr;
                     check = false;
                 }
                 else
                     System.out.println("Enter the wrong color, please re-enter (Red/Green/Blue)!");
             } catch (Exception e) {e.printStackTrace();}
    	} while (check);
    	return result;
    }
    
    public static String getType(String inputMsg) {
    	String result = "";
    	boolean check = true;
    	do {
    		 System.out.print(inputMsg);
             try {
                 String currentStr = sc.nextLine();
                 if (!currentStr.isEmpty() && (currentStr.equalsIgnoreCase("Sport") 
                 							|| currentStr.equalsIgnoreCase("Travel")
                 							|| currentStr.equalsIgnoreCase("Common"))) {
                     result = currentStr;
                     check = false;
                 }
                 else
                     System.out.println("Enter the wrong type, please re-enter (Sport/Travel/Common)!");
             } catch (Exception e) {e.printStackTrace();}
    	} while (check);
    	return result;
    }
    
    public static int getYearOfManufacture(String inputMsg, String errorMsg) {
        int number;
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        int currentYear = zonedDateTime.getYear();
        while (true) {
            try {
                System.out.print(inputMsg);
                number = Integer.parseInt(sc.nextLine());
                if (number > 0 && number <= currentYear)
                    return number;
                else
                    System.out.println("The yeaf of manufacture must must be greater than 0 and less than the current year, please re-enter!");
            } catch (Exception e) {System.out.println(errorMsg);}
        }
    }
    
    public static int getSpeed(String inputMsg, String errorMsg) {
        int number;
        while (true) {
            try {
                System.out.print(inputMsg);
                number = Integer.parseInt(sc.nextLine());
                if (number > 0)
                    return number;
                else
                    System.out.println("Invalid price, please re-enter number > 0!");
            } catch (Exception e) {System.out.println(errorMsg);}
        }
    }
    
    public static String getYesNo(String inputMsg) {
        String result = "";
        boolean check = true;
        do {
            System.out.print(inputMsg);
            String currentStr = sc.nextLine();
            if (!currentStr.isEmpty() && (currentStr.equalsIgnoreCase("Yes") 
            							|| currentStr.equalsIgnoreCase("No"))) {
                result = currentStr;
                check = false;
            } else {
                System.out.println("Enter the wrong type, please re-enter (Yes/No)!");
            }
        } while (check);
        return result;
    }
}
