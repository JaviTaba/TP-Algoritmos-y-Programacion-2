import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ModificarTxts {
	
	
	/**
	 * public void modificarCuentas(ArchivoDeCuentas lector, String alias, double nuevoSaldo) throws IOException {
	FileReader fr = new FileReader("cuentas.txt");
	FileWriter fw = new FileWriter("cuentas.txt");
	BufferedReader br = new BufferedReader(fr);
	BufferedWriter bw = new BufferedWriter(fw);
	
	String linea = br.readLine();
	
	while(linea != null) {
	String[]split =	linea.split(",");
		if(split[1].equalsIgnoreCase(alias)) {
			switch(split[0]) {
			
			case "01":
				
				break;
				
			
			  case "02":
				linea.replace(split[0]+split[1]+split[2]+split[3],split[0]+split[1]+nuevoSaldo);
				break;
			
			}	
		}else {
			linea = br.readLine();
		}
	}
}
	 */
}
