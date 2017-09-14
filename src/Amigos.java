import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Amigos {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new FileInputStream("entrada-amigos-hard.txt"));
		PrintStream ps = new PrintStream("saida-amigos-hard.txt");

		List<String> nomes = new ArrayList<>();
		Map<String, Integer> indices = new HashMap<>();

		int n = Integer.parseInt(s.nextLine());
		for (int i = 0; i < n; i++) {
			String nome = s.nextLine();
			nomes.add(nome);
			indices.put(nome, i);
		}

		UnionSet union = new UnionSet(nomes.size());

		int c = Integer.parseInt(s.nextLine());
		for (int i = 0; i < c; i++) {
			String nomeA = s.nextLine();
			String nomeB = s.nextLine();
			int idA = indices.get(nomeA);
			int idB = indices.get(nomeB);
			union.union(idA, idB);
		}

		int q = Integer.parseInt(s.nextLine());
		for (int i = 0; i < q; i++) {
			String nomeA = s.nextLine();
			String nomeB = s.nextLine();
			int idA = indices.get(nomeA);
			int idB = indices.get(nomeB);
			if (union.find(idA) == union.find(idB)) {
				ps.println("conhecidos");
			} else {
				ps.println("desconhecidos");
			}
		}

		ps.close();
		s.close();
	}

}
