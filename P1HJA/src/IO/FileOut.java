package IO;

import java.io.FileWriter;
import java.io.PrintWriter;

public class FileOut {
	
	private String file;
	
	public FileOut(String file) {
		this.file = file;
	}
	
	
	
	public void writePartida(String msg) {
		
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(this.file);
            pw = new PrintWriter(fichero);
 
            for (int i = 0; i < 10; i++)
                pw.println(msg);
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
	}

}
