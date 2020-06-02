import org.junit.*;

public class TestTicket {
	
	private Ticket ticket;
	private CajaAhorroPesos cuenta;
	private Tarjeta tarjeta;
	private Cliente cliente;
	
	@Test
	public void ticket() throws ExcepcionCuenta, ExcepcionTarjeta, ExcepcionCliente {
		tarjeta = new Tarjeta(12345678, 1234);
		cliente = new Cliente(20353780191L,tarjeta);
		cuenta = new CajaAhorroPesos("black.beatles.air", 50000);
		
		cuenta.extraer(5000);
		
		//System.out.println(ticket.extraer(cuenta.saldo, 100));
		//System.out.println(ticket.transferir(cuenta.saldo,500));
		//System.out.println(ticket.depositar(cuenta.saldo,1000));
		//System.out.println(ticket.comprarUSD(cuenta.saldo, 20000));
		System.out.println();
		
	}
	
	
}
