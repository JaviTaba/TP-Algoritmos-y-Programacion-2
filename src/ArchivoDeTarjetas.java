import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ArchivoDeTarjetas {
    
    public void lector(){
        try {
            FileReader fr = new FileReader("tarjetas.txt");
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontro el archivo");
        }
    }
    
}
