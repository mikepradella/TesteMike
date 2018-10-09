package funcionalidadesUtils;

import java.util.Random;

public class NumeroRandomicos {
	
	
	public int gerarNumeroRandomico() {
		Random numero = new Random();
		int numeroRandomicos =  numero.nextInt(10000)+1;
		return numeroRandomicos;	
	}
	public static String gerarNumeroRandomicoStatico() {
		Random numero = new Random();
		// funciona o cast para os 3 tipos, podendo usar String.valueOf ou Integer.toString ou concatenando com aspas ""
		//String numeroRandomicos =  (String.valueOf(numero.nextInt(10000)+1));
	//	String numeroRandomicos =  (Integer.toString(numero.nextInt(10000)+1));
		String numeroRandomicos1 =  ("" + numero.nextInt(10000)+1);			
		return numeroRandomicos1;	
	}
}
