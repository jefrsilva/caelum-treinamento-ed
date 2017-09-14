
public class UnionSet {

	private int[] id;

	public UnionSet(int size) {
		id = new int[size];
		for (int i = 0; i < size; i++) {
			id[i] = i;
		}
	}

	public int find(int n) {
		int i = -1;
		for (i = n; i != id[n]; i = id[n]);
		return i;
	}

	public void union(int a, int b) {
		int ida = find(a);
		id[b] = ida;
	}
}
