import java.io.IOException;

import org.junit.*;

public class TransaccionesTest {
	private ArchivoDeCuentas adc;


	@Before
	public void creando() throws IOException, ExcepcionTarjeta, ExcepcionTransaccion, ExcepcionCuenta {
		adc = new ArchivoDeCuentas();

	}

	@Test
	public void depo1000Pesos() throws ExcepcionTransaccion {
		long cuit = adc.getClientes().getAliasCuit().get("isla.pez.arbol");
		adc.getTarjetas().getCuitCliente().get(cuit).getArs().extraer(1000.00);
		Assert.assertEquals(11000.03,adc.getTarjetas().getCuitCliente().get(cuit).getArs().getSaldo() , 0.01);

	}

	@Test
	public void transfiereCorrectamente100PesosDeUnaCuentaAOtra() throws ExcepcionTransaccion, ExcepcionCuenta {
		long cuit1 = this.adc.getClientes().getAliasCuit().get("lobo.luna.pasto");
		long cuit2 = this.adc.getClientes().getAliasCuit().get("uva.sandalia.halcon");
		adc.getTarjetas().getCuitCliente().get(cuit1).getCC().transferir(adc.encontrarCuenta("uva.sandalia.halcon"), 50);
		Assert.assertEquals("transfiereCorrectamente100PesosDeUnaCuentaAOtra", -100.97, this.adc.getTarjetas().getCuitCliente().get(cuit1).getCC().getSaldo(), 0.01);
		Assert.assertEquals("transfiereCorrectamente100PesosDeUnaCuentaAOtra", 50.0, this.adc.getTarjetas().getCuitCliente().get(cuit2).getArs().getSaldo(), 0.01);
	}
}

