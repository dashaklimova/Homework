package core;

public class Calculator {

	public static void main(String[] args) {
		double a = Double.parseDouble(args[0]);
		double b = Double.parseDouble(args[1]);
		System.out.println("Сумма: " + (a + b));
		System.out.println("Разность: " + (a - b));
		System.out.println("Произведение: " + (a * b));
		System.out.println("Частное: " + (a / b));
	}
}
