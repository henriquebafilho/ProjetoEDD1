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
		
		if(this.prim == null) {
			
			FileReader entradaFile = new FileReader("src/entrada.txt");
			
			BufferedReader lerArq = new BufferedReader(entradaFile);
			
			String linha = lerArq.readLine().trim();
			
			String[] linhaA = linha.split("<");
			
			Elo A,B;
			
			A = new Elo(Integer.parseInt(linhaA[1]), 0, null, null);
			B = new Elo(Integer.parseInt(linhaA[2]), 0, null, null);
			
			A.prox = B;
			A.listaSuc = new EloSuc(B, null);
			A.contador++;
			
		}
		
	}

	/* M�todo para impress�o do estado atual da estrutura de dados. */
	private void debug() {
		/* Preencher. */
	}

	/* M�todo respons�vel por executar o algoritmo. */
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