import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;

public class GeradorDeNomes {

	public static void geraAmizade(List<String> nomes, PrintStream ps) {
		int i = 0;
		int j = 0;
		do {
			i = (int) (Math.random() * nomes.size());
			j = (int) (Math.random() * nomes.size());
		} while (i == j);
		ps.println(nomes.get(i) + "\n" + nomes.get(j));
	}

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream ps = new PrintStream("entrada-amigos.txt");

		Faker faker = new Faker(new Locale("pt-BR"));

		Set<String> nameSet = new HashSet<>();
		for (int i = 0; i < 1000; i++) {
			Name name = faker.name();
			nameSet.add(name.firstName() + " " + name.lastName());
		}

		List<String> names = new ArrayList<>(nameSet);
		ps.println(nameSet.size());
		for (String name : names) {
			ps.println(name);
		}

		int numConexoes = 100000;
		ps.println(numConexoes);
		for (int i = 0; i < numConexoes; i++) {
			geraAmizade(names, ps);
		}
		
		int numQueries = 1000;
		ps.println(numQueries);
		for (int i = 0; i < numQueries; i++) {
			geraAmizade(names, ps);
		}
		
		ps.close();
	}

}
