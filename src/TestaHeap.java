public class TestaHeap {
	public static void main(String[] args) {
		Heap heap = new Heap();

		int[] vals = { 3, 9, 6, 1, 8, 7, 4, 5, 2 };

		for (int i : vals) {
			heap.insert(i);
			System.out.println(heap);
		}

		heap.getMax();
		System.out.println(heap);
	}
}
