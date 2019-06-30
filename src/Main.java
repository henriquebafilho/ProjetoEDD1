import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main
{
	public static void main(String args[]) throws IOException
	{
//		OrdenacaoTopologica ord = new OrdenacaoTopologica();
//		
//		String nomeEntrada = "teste.txt";
//		
//		ord.realizaLeitura(nomeEntrada);
//		
//		if(!ord.executa())
//			System.out.println("O conjunto nao é parcialmente ordenado.");
//		else
//			System.out.println("O conjunto é parcialmente ordenado.");
		
		
		try {
			
			String[] linhas = new String[12];
			
			FileReader entradaFile = new FileReader("src/entrada.txt");
			
			BufferedReader lerArq = new BufferedReader(entradaFile);
			
			for(int i = 0 ; i<12; i++) {
				
				linhas[i] = lerArq.readLine();
				
			}
			
			int cont = 0;
			
			for(int i = 0; i<12; i++) {
				
				System.out.println(linhas[i]);
			}
			
					
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
	}
}
