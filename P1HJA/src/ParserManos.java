import java.util.ArrayList;

import carta.Carta;
import carta.Mano;

public class ParserManos {
	
	
	public static ArrayList <Mano> parse(String s) {
		
		ArrayList <Mano> arrayManos = new ArrayList<Mano>();
		int i=0, n=0;
//		char[] token = s.toCharArray();
		String[] array = s.split("\n");	
		char[] token;
		String[] arrayAux;
		
		long time_start, time_end;
		time_start = System.currentTimeMillis();
		
		do {
			
			arrayAux = array[i].split(";");
			n = Integer.parseInt(arrayAux[1]);
			arrayAux[0]+=arrayAux[2];
			
			token = array[i].toCharArray();
			
			arrayManos.add(new Mano());
					
			arrayManos.get(i).setMano(new Carta(token[0], token[1]));
			arrayManos.get(i).setMano(new Carta(token[2], token[3]));
			arrayManos.get(i).setMano(new Carta(token[4], token[5]));
			arrayManos.get(i).setMano(new Carta(token[6], token[7]));
			arrayManos.get(i).setMano(new Carta(token[8], token[9]));
			
			/* Ordenamos la mano pasandole los rangos del array de manos */
			arrayManos.get(i).ordenaMano(0, 4);
			i++;
			 
		} while(i < array.length);
		
		
//		time_end = System.currentTimeMillis();
//		System.out.println("tiempo en generar las manos (ordenadas) "+ ( time_end - time_start ) +" milliseconds");
		
		return arrayManos;
		
	}

}
