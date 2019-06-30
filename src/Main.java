public class Main
{
	public static void main(String args[])
	{
		OrdenacaoTopologica ord = new OrdenacaoTopologica();
		
		String nomeEntrada = "teste.txt";
		
		ord.realizaLeitura(nomeEntrada);

		System.out.println("KOE PERUANO");
		
		if(!ord.executa())
			System.out.println("O conjunto nao é parcialmente ordenado.");
		else
			System.out.println("O conjunto é parcialmente ordenado.");
	}
}
