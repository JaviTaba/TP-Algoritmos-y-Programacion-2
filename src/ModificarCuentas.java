import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class ModificarCuentas {
	
	File archivo;
	
	public ModificarCuentas() {
		archivo = new File ("cuentas.txt");
	}
	
	public void modificarSaldo(String tipoDeCuenta, String alias, double antiguoSaldo, double descubierto, double nuevoSaldo) {
		
		DecimalFormatSymbols separadorDecimal = new DecimalFormatSymbols();
		separadorDecimal.setDecimalSeparator('.');
		DecimalFormat convertidor = new DecimalFormat("#.00", separadorDecimal);
		
		if (tipoDeCuenta.equals("01") || tipoDeCuenta.equals("03")) {
			String lineaOriginal = tipoDeCuenta + "," + alias + "," + convertidor.format(antiguoSaldo);
			String lineaNueva = tipoDeCuenta + "," + alias + "," + convertidor.format(nuevoSaldo);
			modificar(archivo, lineaOriginal, lineaNueva);
			
		} else if ( tipoDeCuenta.equals("02") ) {
			String lineaOriginal = tipoDeCuenta + "," + alias + "," + convertidor.format(antiguoSaldo) + "," + convertidor.format(descubierto);
			String lineaNueva = tipoDeCuenta + "," + alias + "," + convertidor.format(nuevoSaldo) + "," + convertidor.format(descubierto);
			modificar(archivo, lineaOriginal, lineaNueva);
		}
		
	}

	private void escribir(File archivo, String texto) {
		BufferedWriter escritor;
		try {
			if ( !archivo.exists() ) {
				archivo.createNewFile();
			}
			escritor = new BufferedWriter(new FileWriter(archivo,true));
			escritor.write(texto+"\n");
			escritor.close();
		} catch(Exception e) {
			System.out.println("No se pudo escribir el archivo");
		}
	}

	private void borrar (File archivo) {
		try {
			if ( archivo.exists() ) {
				archivo.delete();
			}
		} catch(Exception e) {
			System.out.println("No se pudo borrar el archivo");
		}
	}

	private void modificar (File archivoOrginal, String textoOriginal, String textoNuevo) {
		
		String direccionArchivoNuevo = archivoOrginal.getParent()+"-auxiliar.txt";
		File archivoNuevo= new File(direccionArchivoNuevo);
		BufferedReader escritor;

		try {
			if ( archivoOrginal.exists() ) {
				escritor = new BufferedReader(new FileReader(archivoOrginal));
				String linea;

				while ( ( linea=escritor.readLine() ) != null ) {
					if ( linea.equals( textoOriginal ) ) {
						escribir(archivoNuevo,textoNuevo);
					} else {
						escribir(archivoNuevo,linea);
					}
				}
				escritor.close();
				borrar(archivoOrginal);
				archivoNuevo.renameTo(archivoOrginal);

			} else {
				System.out.println( "El archivo no existe" );
			}
		} catch (Exception e) {
			System.out.println( "No se pudo modificar el archivo" );
		}
	 
	}
	
	

    
}