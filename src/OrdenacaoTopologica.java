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

	/* Método para impressão do estado atual da estrutura de dados. */
	private void debug() {
		/* Preencher. */
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