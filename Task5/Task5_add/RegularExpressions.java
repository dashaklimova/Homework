package core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {

	public static void main(String[] args) {

		// regular expressions checking
		System.out.println(RegularExpressions.checkAlphanumeric1("fflll"));
		System.out.println(RegularExpressions.checkAlphanumeric1("fff"));
		System.out.println(RegularExpressions.checkAlphanumeric2("75-_"));
		System.out.println(RegularExpressions.checkAlphanumeric2("mmm-0"));
	}

	public static boolean checkAlphanumeric1(String testString) {
		Pattern p = Pattern.compile("[a-zA-Z]{0,4}");
		Matcher m = p.matcher(testString);
		return m.matches();
	}

	public static boolean checkAlphanumeric2(String testString) {
		Pattern p = Pattern.compile(".{4}");
		Matcher m = p.matcher(testString);
		return m.matches();
	}
}
