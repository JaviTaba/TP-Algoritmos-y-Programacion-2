import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ArchivoDeCuentas {

	
	private void lectorDeCuentas() throws IOException, NumberFormatException, ExcepcionCuenta {
		
		FileReader fr = new FileReader("cuentas.txt");
		BufferedReader br = new BufferedReader(fr);
		String linea = br.readLine();
		ArchivoDeClientes usar2 = new ArchivoDeClientes();
		HashMap<String, Cliente> clienteConAlias = usar2.getAliasCliente();
		
		
		while(linea != null) {
			String[] spliteado = linea.split(",");
	
			switch(spliteado[0]) {
				
			case"01":
				CajaAhorroPesos cuenta = new CajaAhorroPesos(spliteado[1], Integer.parseInt(spliteado[2]));
				clienteConAlias.get(spliteado[1]).asociarPesos(cuenta);
				break;
				
			case"02":
				CuentaCorriente cuenta2 = new CuentaCorriente(spliteado[1],Integer.parseInt(spliteado[2]), Integer.parseInt(spliteado[3]));
				clienteConAlias.get(spliteado[1]).asociarCuentaCorriente(cuenta2);
				break;
				
			case"03":
				CajaAhorroUSD cuenta3 = new CajaAhorroUSD(spliteado[1], Integer.parseInt(spliteado[2]));
				clienteConAlias.get(spliteado[1]).asociarUSD(cuenta3);
				break;
			}
			
		
			
		}
		
		br.close();
		
		
		
		
		
	}

}
