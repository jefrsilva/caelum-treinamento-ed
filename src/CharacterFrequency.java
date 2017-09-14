import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CharacterFrequency {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new FileInputStream("entrada-texto.txt"));

		int[] letras = new int[26];

		while (s.hasNext()) {
			String linha = s.nextLine().toLowerCase();

			for (int i = 0; i < linha.length(); i++) {
				char c = linha.charAt(i);
				if (c - 'a' >= 0 && c - 'a' <= 25) {
					letras[c - 'a']++;
				}
			}
		}

		for (char c = 'a'; c <= 'z'; c++) {
			System.out.print(c + ": ");
			for (int i = 0; i < letras[c - 'a'] / 10; i++) {
				System.out.print("*");
			}
			System.out.println();
		}

		s.close();
	}

}
