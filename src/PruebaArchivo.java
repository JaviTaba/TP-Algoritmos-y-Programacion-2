import java.io.IOException;

import org.junit.Test;

public class PruebaArchivo {
	
	private ArchivoDeTarjetas tarjetas;
	private ArchivoDeCuentas cuentas;
	private ArchivoDeClientes clientes;
	
	@Test
	public void validoCreacionDeArchivoDeTarjetas() throws IOException {
		tarjetas = new ArchivoDeTarjetas();
		System.out.println(tarjetas.getCuitCliente());
		System.out.println(tarjetas.getCuitTarjeta());
	}
	
	@Test
	public void validoCreacionDeArchivoDeCuentas() throws IOException {
		cuentas = new ArchivoDeCuentas();
	}
	
	@Test
	public void validoCreacionDeArchivoDeClientes() throws IOException {
		clientes = new ArchivoDeClientes();
		System.out.println(clientes.getAliasCliente());
	}
	
}
