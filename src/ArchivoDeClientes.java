import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ArchivoDeClientes {
	
	
	private HashMap<String, Long> aliasCuit;
	
	
	public ArchivoDeClientes() {
		aliasCuit = new HashMap<String, Long>();
		lectorDeClientes();
		
	}
	
	private void lectorDeClientes() {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("clientes.txt"));
			
			try {
				
				String linea = br.readLine();
				
				while(linea != null) {
					
					String[] spliteado = linea.split(",");
					
					aliasCuit.put(spliteado[1], Long.parseLong((spliteado[0])) );
					
					linea = br.readLine();
				}
				
				
		} finally {
			br.close();
			}
			
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		
		
	}


	public HashMap<String, Long> getAliasCuit() {
		return aliasCuit;
	}

}
