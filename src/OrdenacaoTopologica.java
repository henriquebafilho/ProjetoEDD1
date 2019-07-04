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

		//O(2nm)
		
		if (this.prim == null) {

			int x, y;

			String caminho = "src/" + nomeEntrada;

			FileReader entradaFile = new FileReader(caminho);

			BufferedReader lerArq = new BufferedReader(entradaFile);

			String linha = lerArq.readLine().trim(); 

			String[] linhaA = linha.split("<");

			Elo X, Y;

			X = new Elo(Integer.parseInt(linhaA[0].trim()), 0, null, null);
			Y = new Elo(Integer.parseInt(linhaA[1].trim()), 0, null, null);

			X.prox = Y;
			Y.contador++;
			X.listaSuc = new EloSuc(Y, null);

			this.n = 2;

			this.prim = X;

			while ((linha = lerArq.readLine()) != null) {

				linha = linha.trim();

				linhaA = linha.split("<");

				x = Integer.parseInt(linhaA[0].trim());
				y = Integer.parseInt(linhaA[1].trim());

				Elo p;

				Elo suc = null;

				for (p = prim; p != null; p = p.prox) {

					if (p.chave == y) {
						p.contador++;

						suc = p;
						break;
					}

					if (p.prox == null) {
						p.prox = new Elo(y, 0, null, null);
						this.n++;
					}

				}


				for (p = prim; p != null; p = p.prox) {

					if (p.chave == x) {
						atualizaListaSuc(p, suc);
						break;
					}

					if (p.prox == null) {
						p.prox = new Elo(x, 0, null, null);
						this.n++;

					}

				}

			}

			this.debug();
			
			lerArq.close();
			entradaFile.close();
			X = null;
			Y = null;

		}

	}

	//O(1)
	private void atualizaListaSuc(Elo p, Elo novoSuc) {

		EloSuc r;

		if (p.listaSuc == null) {

			p.listaSuc = new EloSuc(novoSuc, null);
		} else {
			r = p.listaSuc;
			p.listaSuc = new EloSuc(novoSuc, r);
		}

	}
	
	//O(nm)
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
	
	//O(2nm)
	/* Método responsável por executar o algoritmo. */
	public boolean executa() {
		
		Elo p = prim;
		Elo q;
		
		prim = null;
		
		while(p!= null) {
			
			q = p;
			p = q.prox;
			
			if(q.contador == 0) {
				q.prox = prim;
				prim = q;
			}
		}
		
		Elo r;
		EloSuc s;
		
		System.out.println(" ");
		System.out.println("Ordenacao topologica");
		
		for(r = prim; r!=null; r = r.prox) {
			
			System.out.print(r.chave+" ");
			for(s = r.listaSuc; s!=null; s = s.prox) {
				s.id.contador--;
				if(s.id.contador == 0) {
					p = r.prox;
					r.prox = s.id;
					r.prox.prox = p;
				}
				r.listaSuc = s.prox;
			}
			prim = prim.prox;
			n--;			
		}
		
		System.out.println(" ");
		System.out.println(" ");
		
		if(this.n == 0) {
			return true;
		}else {
			return false;
		}
		
	}

}