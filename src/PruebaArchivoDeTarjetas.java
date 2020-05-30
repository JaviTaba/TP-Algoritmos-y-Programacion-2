import java.io.IOException;

import org.junit.Test;

public class PruebaArchivoDeTarjetas {
	
	private ArchivoDeTarjetas arch;
	
	@Test
	public void validoCreacion() throws IOException {
		arch = new ArchivoDeTarjetas();
		arch.getCuitCliente();
		arch.getCuitTarjeta();
	}
	
}
