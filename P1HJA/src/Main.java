import java.io.IOException;

import IO.FileIn;
import carta.Carta;
import carta.Mano;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			FileIn filein = new FileIn("data/entrada1.txt");
			Mano mano = Parser.parse(filein.getCartas());
			//System.out.println("La primera carta leida es: "+ mano.getNumero()+ mano.getPalo());
			System.out.println("La mano es: " + mano.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
