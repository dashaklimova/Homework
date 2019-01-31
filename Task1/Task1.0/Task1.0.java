package core;

public class task0 {
	public static void main(String[] args) {

		int intValue = 77;
		short shortValue = 5;
		long longValue = 89L;
		double doubleValue = 2.2d;
		float floatValue = 15.9f;
		char charValue = 'x';
		boolean booleanValue = true;

		int result1 = intValue + shortValue;
		double result2 = longValue - doubleValue;
		double result3 = floatValue * doubleValue;
		boolean result4 = longValue > doubleValue;
		boolean result5 = floatValue < intValue;
		boolean result6 = intValue == shortValue;
		boolean result7 = floatValue != doubleValue;

		System.out.println("int : " + intValue);
		System.out.print("short : " + shortValue + " | ");
		System.out.println("long : " + longValue);
		System.out.print("double : " + doubleValue + " | ");
		System.out.println("float : " + floatValue);
		System.out.print("char : " + charValue + " | ");
		System.out.println("boolean : " + booleanValue);

		System.out.println("int + short : " + result1);
		System.out.print("long - double : " + result2 + " | ");
		System.out.println("float * double : " + result3);
		System.out.print("long > double : " + result4 + " | ");
		System.out.println("float < int : " + result5);
		System.out.print("int = short : " + result6 + " | ");
		System.out.println("float != double : " + result7);

	}

}
