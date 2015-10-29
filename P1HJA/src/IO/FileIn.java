package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileIn {

private File finStr;
private FileInputStream file;
private String cartas;
	
	
	public FileIn(String param) throws IOException{
		
		try {			
			this.finStr = new File(param);
			this.file = new FileInputStream(this.finStr);
			
			int content;
			this.cartas = new String();
					
			while ((content = file.read()) != -1) {
				// convert to char and display it
				this.cartas += (char) content;
				
			}
			this.file.close();
		} catch(FileNotFoundException exc) {
			throw new IOException("Error al acceder al fichero de entrada ("+ param + ")");
		} catch (IOException e) {
			throw new IOException("Error al acceder al fichero de entrada ("+ param + ")");
		}

	}
	
	
	public String getCartas() {
		return this.cartas;
	}
	

}
