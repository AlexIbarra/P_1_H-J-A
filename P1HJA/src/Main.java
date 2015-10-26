import java.io.IOException;

import IO.FileIn;
import carta.Carta;
import carta.Mano;
import jugadas.Jugadas;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			FileIn filein = new FileIn("src/data/entrada1.txt");
			Mano mano = ParserManos.parse(filein.getCartas());
			Jugadas jugada = ParserJugadas.parse(mano);
			System.out.println("La mano es: " + mano.toString());
			System.out.println("La mejor jugada es: " + jugada.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
