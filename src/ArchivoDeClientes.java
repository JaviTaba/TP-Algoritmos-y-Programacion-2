import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ArchivoDeClientes {
	
	
	HashMap<String, Cliente> aliasCliente;
	
	
	public ArchivoDeClientes() {
		aliasCliente = new HashMap<String, Cliente>();
		lectorDeClientes();
		
	}
	
	private void lectorDeClientes() {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("clientes.txt"));
			
			try {
				ArchivoDeTarjetas cliente = new ArchivoDeTarjetas();		
				String linea = br.readLine();
				
				while(linea != null) {
					
					String[] spliteado = linea.split(",");
					
					aliasCliente.put(spliteado[1], cliente.getCuitCliente().get(Long.parseLong(spliteado[1])) );
					
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


	public HashMap<String, Cliente> getAliasCliente() {
		return aliasCliente;
	}

}
