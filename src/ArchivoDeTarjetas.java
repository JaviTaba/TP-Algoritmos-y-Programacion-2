import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;



public class ArchivoDeTarjetas {
	    
    private HashMap<Tarjeta, Long> cuitTarjeta;
    private HashMap<Long, Cliente> cuitCliente;
  
    
    public ArchivoDeTarjetas() {
    	cuitTarjeta = new HashMap<Tarjeta, Long>();      
    	cuitCliente = new HashMap<Long,Cliente>();
    	lectorDeTarjetas();
    }


	public void lectorDeTarjetas(){
        try {
        	  			
        			
        	FileReader fr = new FileReader("archivos/tarjetas.txt");
            BufferedReader br = new BufferedReader(fr);
            
            String linea = br.readLine();
            
            while(linea != null) {
            	String[] spliteado = linea.split(",");
            	
            	
            long cuitDelUsuario = Long.parseLong(spliteado[2]);
            int tarjetaDelUsuario = Integer.parseInt(spliteado[0]);
            int pinDeLaTarjeta = Integer.parseInt(spliteado[1]);
            
            Tarjeta tarjeta = new Tarjeta(tarjetaDelUsuario, pinDeLaTarjeta);
            Cliente cliente = new Cliente(cuitDelUsuario, tarjeta);
            
            cuitTarjeta.put(tarjeta, cuitDelUsuario);
            cuitCliente.put(cuitDelUsuario, cliente);	
            
            br.readLine();
            
            
            
            
            }
            br.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontro el archivo");
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
    }
	
	
	
	public HashMap<Tarjeta, Long> getCuitTarjeta() {
		return cuitTarjeta;
	}

	public HashMap<Long, Cliente> getCuitCliente() {
		return cuitCliente;
	}


	
	
}
