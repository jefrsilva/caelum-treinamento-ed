
public class Heap {

	private int[] dados;
	private int tamanho;

	public Heap() {
		dados = new int[200];
	}

	public void insert(int valor) {
		dados[++tamanho] = valor;
		heapUp(tamanho);
	}

	public int getMax() {
		troca(1, tamanho);
		tamanho--;
		heapDown(1);
		return dados[tamanho];
	}

	private void heapUp(int indice) {
		while (indice > 1 && dados[indice / 2] < dados[indice]) {
			troca(indice, indice / 2);
			indice = indice / 2;
		}
	}

	private void heapDown(int indice) {
		while (2 * indice <= tamanho) {
			int indiceFilho = 2 * indice;
			if (indiceFilho < tamanho && dados[indiceFilho] < dados[indiceFilho + 1]) {
				indiceFilho++;
			}
			if (dados[indice] >= dados[indiceFilho])
				break;
			troca(indice, indiceFilho);
			indice = indiceFilho;
		}
	}

	private void troca(int i, int j) {
		int temp = dados[i];
		dados[i] = dados[j];
		dados[j] = temp;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= tamanho; i++) {
			sb.append(dados[i] + " ");
		}
		return sb.toString();
	}

}
