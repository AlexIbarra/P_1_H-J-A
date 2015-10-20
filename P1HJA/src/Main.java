import java.io.IOException;

import IO.FileIn;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("hola pokerface2");
		
		try {
			FileIn filein = new FileIn("data/entrada1.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
