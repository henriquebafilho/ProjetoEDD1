import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main
{
	public static void main(String args[])
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
		
		File entradaFile = new File("src/entrada.txt");
		
		try {
			Scanner entradaScanner = new Scanner(entradaFile);
			
			String[] nomes = new String[12];
			
			for(int i = 0; i < 13; i++) {
				nomes[i] = entradaScanner.next();
			}
				
			
			for(int i = 0;i<nomes.length;i++) {
				
				System.out.println(nomes[i]);
				
			}
			
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
	}
}
