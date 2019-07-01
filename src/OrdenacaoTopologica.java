import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class OrdenacaoTopologica {
	private class Elo {
		/* Identificação do elemento. */
		public int chave;

		/* Número de predecessores. */
		public int contador;

		/* Aponta para o próximo elo da lista. */
		public Elo prox;

		/* Aponta para o primeiro elemento da lista de sucessores. */
		public EloSuc listaSuc;

		public Elo() {
			prox = null;
			contador = 0;
			listaSuc = null;
		}

		public Elo(int chave, int contador, Elo prox, EloSuc listaSuc) {
			this.chave = chave;
			this.contador = contador;
			this.prox = prox;
			this.listaSuc = listaSuc;
		}
	}

	private class EloSuc {
		/* Aponta para o elo que é sucessor. */
		public Elo id; 

		/* Aponta para o próximo elemento. */
		public EloSuc prox;

		public EloSuc() {
			id = null;
			prox = null;
		}

		public EloSuc(Elo id, EloSuc prox) {
			this.id = id;
			this.prox = prox;
		}
	}

	/* Ponteiro (referência) para primeiro elemento da lista. */
	private Elo prim;

	/* Número de elementos na lista. */
	private int n;

	public OrdenacaoTopologica() {
		prim = null;
		n = 0;
	}

	/* Método responsável pela leitura do arquivo de entrada. */
	public void realizaLeitura(String nomeEntrada) throws IOException {

		if (this.prim == null) {

			int x, y;

			String caminho = "src/" + nomeEntrada;

			FileReader entradaFile = new FileReader(caminho);

			BufferedReader lerArq = new BufferedReader(entradaFile);

			String linha = lerArq.readLine().trim();

			String[] linhaA = linha.split("<");

			Elo A, B;

			A = new Elo(Integer.parseInt(linhaA[0].trim()), 0, null, null);
			B = new Elo(Integer.parseInt(linhaA[1].trim()), 0, null, null);

			A.prox = B;
			B.contador++;
			A.listaSuc = new EloSuc(B, null);

			this.n = 2;

			this.prim = A;

			while ((linha = lerArq.readLine()) != null) {

				linha = linha.trim();

				linhaA = linha.split("<");

				x = Integer.parseInt(linhaA[0].trim());
				y = Integer.parseInt(linhaA[1].trim());

				Elo p;

				int cont = 0;
				int cont1 = 0;

				Elo suc = null;

				for (p = prim; p != null; p = p.prox) {

					if (p.chave == y) {
						cont++;
						p.contador++;

						suc = p;
					}

					if (p.prox == null && cont == 0) {
						p.prox = new Elo(y, 0, null, null);
						this.n++;
					}

				}

				for (p = prim; p != null; p = p.prox) {

					if (p.chave == x) {
						p = atualizaListaSuc(p, suc);
						cont1++;
					}

					if (p.prox == null && cont1 == 0) {
						p.prox = new Elo(x, 0, null, null);
						this.n++;

					}

				}

			}

			this.debug();
			
			lerArq.close();
			entradaFile.close();

		}

	}

	private Elo atualizaListaSuc(Elo p, Elo novoSuc) {

		Elo q;
		EloSuc r;

		if (p.listaSuc == null) {

			p.listaSuc = new EloSuc(novoSuc, null);
		} else {
			r = p.listaSuc;
			p.listaSuc = new EloSuc(novoSuc, r);
		}

		q = p;
		p = null;
		return q;
	}

	/* Método para impressão do estado atual da estrutura de dados. */
	private void debug() {
		System.out.println("Debug");
		Elo p;
		EloSuc r;
		for (p = this.prim; p != null; p = p.prox) {
			System.out.print(p.chave + " predecessores: " + p.contador + ", sucessores: ");
			for (r = p.listaSuc; r != null; r = r.prox) {
				if (r.prox != null || r != null) {
					System.out.print(r.id.chave + " -> ");
				}

				if (r.prox == null) {
					System.out.print("NULL");
				}

			}

			if (p.listaSuc == null) {
				System.out.print("NULL");
			}

			System.out.println("");

		}
		r = null;
		p = null;
	}

	/* Método responsável por executar o algoritmo. */
	public boolean executa() {
		/* Preencher. */

		return false;
	}

//	try {
//		
//		String[] linhas = new String[12];
//		
//		FileReader entradaFile = new FileReader("src/entrada.txt");
//		
//		BufferedReader lerArq = new BufferedReader(entradaFile);
//		
//		for(int i = 0 ; i<12; i++) {
//			
//			linhas[i] = lerArq.readLine();
//			
//		}
//		
//		int cont = 0;
//		
//		for(int i = 0; i<12; i++) {
//			
//			System.out.println(linhas[i]);
//		}
//		
//				
//	} catch (FileNotFoundException e) {
//		
//		e.printStackTrace();
//	}
//	

}