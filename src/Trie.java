import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Trie {

	Map<Character, Trie> nodes = new HashMap<>();

	public void add(Trie t, String s) {
		if (s.isEmpty())
			return;

		Character c = s.charAt(0);
		Trie trie = nodes.get(c);
		if (trie == null) {
			trie = new Trie();
			nodes.put(c, trie);
		}
		trie.add(trie, s.substring(1));
	}

	public Trie find(String s) {
		if (s.isEmpty()) {
			return null;
		}

		Character c = s.charAt(0);
		Trie trie = nodes.get(c);
		if (trie != null) {
			if (s.length() == 1) {
				return trie;
			}
			return trie.find(s.substring(1));
		}
		return null;
	}

	public void travel(Trie t, String s) {
		if (t.nodes.isEmpty()) {
			System.out.println(s);
			return;
		}
		for (Character c : t.nodes.keySet()) {
			travel(t.nodes.get(c), s + c);
		}
	}

	public void autocomplete(String s) {
		Trie t = find(s);
		if (t != null) {
			travel(t, s);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new FileInputStream("entrada-autocomplete.txt")).useDelimiter("\n");
		Trie trie = new Trie();

		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			String nome = s.next().toLowerCase();
			trie.add(trie, nome);
		}

		int k = s.nextInt();
		for (int i = 0; i < k; i++) {
			String p = s.next().toLowerCase();
			trie.autocomplete(p);
			System.out.println("-----");
		}
		s.close();
	}

}
