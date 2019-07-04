import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class OrdenacaoTopologica {
	private class Elo {
		/* Identifica��o do elemento. */
		public int chave;

		/* N�mero de predecessores. */
		public int contador;

		/* Aponta para o pr�ximo elo da lista. */
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
		/* Aponta para o elo que � sucessor. */
		public Elo id; 

		/* Aponta para o pr�ximo elemento. */
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

	/* Ponteiro (refer�ncia) para primeiro elemento da lista. */
	private Elo prim;

	/* N�mero de elementos na lista. */
	private int n;

	public OrdenacaoTopologica() {
		prim = null;
		n = 0;
	}

	/* M�todo respons�vel pela leitura do arquivo de entrada. */
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
			A = null;
			B = null;

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

	/* M�todo para impress�o do estado atual da estrutura de dados. */
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
	
	public void remove(int chave)
	{
		Elo p;
		Elo ant = null;
		
		for(p = prim; ((p != null) && (p.chave != chave)); p = p.prox)
			ant = p;
		
		if (p == prim)
			prim = prim.prox;
		else
			ant.prox = p.prox;

		p = null;
		
	}

	/* M�todo respons�vel por executar o algoritmo. */
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
			n--;
			for(s = r.listaSuc; s!=null; s = s.prox) {
				s.id.contador--;
				if(s.id.contador == 0) {
					p = r.prox;
					r.prox = s.id;
					r.prox.prox = p;
				}
				r.listaSuc = s.prox;
			}
			this.remove(r.chave);			
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