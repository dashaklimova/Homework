package core;

public class Task7_4 {

	public static void main(String[] args) {
		String[] wordsFromUser = ScannerHelper.readWords();
		String wordWithMinUniqueChars = findWordWithMinUniqueChars(wordsFromUser);
		System.out.println("Word with minimum unique chars: " + wordWithMinUniqueChars);

	}

	public static String findWordWithMinUniqueChars(String[] array) {
		String min = "";
		for (int i = 0; i < array.length; i++) {
			if (i == 0) {
				min = array[i];
				continue;
			}
			if (countUniqueChars(array[i]) < countUniqueChars(min)) {
				min = array[i];
			}
		}
		
		return min;
	}

	public static long countUniqueChars(String word) {
		long uniqueCharactersCount = word.chars().distinct().count();
		return uniqueCharactersCount;
	}
}
