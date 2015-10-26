import java.io.IOException;

import IO.FileIn;
import carta.Carta;
import carta.Mano;
import jugadas.Jugadas;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParserJugadas parserJ = new ParserJugadas();
		
		
		try {
			long time_start, time_end;
			time_start = System.currentTimeMillis();
			FileIn filein = new FileIn("src/data/entrada1.txt");
			Mano mano = ParserManos.parse(filein.getCartas());
			Jugadas jugada = parserJ.parse(mano);
			System.out.println("La mano es: " + mano.toString());
			System.out.println("La mejor jugada es: " + jugada.toString());
			time_end = System.currentTimeMillis();
			System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
