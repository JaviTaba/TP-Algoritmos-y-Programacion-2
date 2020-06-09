import java.io.IOException;
import java.util.Scanner;

public class Cajero {
	private int billetesDeCien = 500;
	private int billetesDeQuinientos = 500;
	private int billetesDeMil = 500;
	private ArchivoDeCuentas lector;
	private MensajesATM mensaje;
	private Scanner sc;
	private Long cuit;
	private Tarjeta tarjeta;
	private Ticket ticket;

	public Cajero() throws IOException {
		lector = new ArchivoDeCuentas();
		mensaje = new MensajesATM();
		sc = new Scanner(System.in);
		ticket = new Ticket();
		
	}
	public void iniciar() throws ExcepcionTarjeta, ExcepcionTransaccion, IOException {
		
		
		mensaje.bienvenidaYTarjeta();
		int numeroTarjeta = sc.nextInt();
		mensaje.ingresePin();
		int pin = sc.nextInt();
		
		tarjeta = new Tarjeta(numeroTarjeta, pin);
		
		
		cuit = lector.getTarjetas().getCuitTarjeta().get(tarjeta);
		
		if(cuit != null) {
			mensaje.queOperacionDeseaHacer();
			int operacion = sc.nextInt();
			
			switch(operacion) {
			
			case 1:
				extraerEfectivo();
				
				break;
			case 2:
				comprarUSD();
				break;
			case 3:
				depositarEfectivo();
				break;
			case 4:
				transferenciaEntreCuentas();
				break;
			}
			
			
			
		}
		else {
			mensaje.numeroOPinIncorrectos();
			mensaje.reintentar();
			int reintentar = sc.nextInt();
			if(reintentar==1) {
				iniciar();
			}else {
				mensaje.adios();
			}
		}

	}
	
	private void extraerEfectivo() throws ExcepcionTransaccion, IOException {

		mensaje.extraerEfectivo();
		int cuenta = sc.nextInt();
		mensaje.extraerEfectivoMonto();
		int monto = sc.nextInt();
		
		switch(cuenta) {
		
		case 1:
			lector.getTarjetas().getCuitCliente().get(cuit).getArs().extraer(monto, ticket);
			dispensar(monto);
			ticket.extraer(lector.getTarjetas().getCuitCliente().get(cuit).getArs(), monto);
			break;
			
		case 2:
			lector.getTarjetas().getCuitCliente().get(cuit).getCC().extraer(monto, ticket);
			dispensar(monto);
			ticket.extraer(lector.getTarjetas().getCuitCliente().get(cuit).getCC(), monto);
			break;
		}
		
	}
	
	
	private void comprarUSD() throws ExcepcionTransaccion, IOException {
		mensaje.comprarUSD();
		int cuenta = sc.nextInt();
		mensaje.comprarUSDMonto();
		int monto = sc.nextInt();
		
		switch(cuenta) {
		
		case 1:
			lector.getTarjetas().getCuitCliente().get(cuit).getArs().comprarUSD(lector.getTarjetas().getCuitCliente().get(cuit), monto, ticket);
			ticket.comprarUSD(lector.getTarjetas().getCuitCliente().get(cuit).getArs(), monto);
			break;
			
		case 2:
			lector.getTarjetas().getCuitCliente().get(cuit).getCC().comprarUSD(lector.getTarjetas().getCuitCliente().get(cuit), monto, ticket);
			ticket.comprarUSD(lector.getTarjetas().getCuitCliente().get(cuit).getCC(), monto);
			break;
			
		}
	}
	
	private void depositarEfectivo() throws ExcepcionTransaccion,IOException {
		mensaje.depositarEfectivo();
		int cuenta = sc.nextInt();
		mensaje.depositarEfectivoMonto();
		int monto = sc.nextInt();
		
		switch(cuenta) {
		
		case 1:
			lector.getTarjetas().getCuitCliente().get(cuit).getArs().depositar(monto, ticket);
			ticket.depositar(lector.getTarjetas().getCuitCliente().get(cuit).getArs(), monto);
			break;
		
		case 2:
			lector.getTarjetas().getCuitCliente().get(cuit).getCC().depositar(monto, ticket);
			ticket.depositar(lector.getTarjetas().getCuitCliente().get(cuit).getCC(), monto);
			break;
			
		case 3:
			lector.getTarjetas().getCuitCliente().get(cuit).getUSD().depositar(monto, ticket);
			ticket.depositar(lector.getTarjetas().getCuitCliente().get(cuit).getUSD(), monto);
			break;
		}
		
		
	}


	private void transferenciaEntreCuentas() throws ExcepcionTransaccion, IOException {
		mensaje.transferenciaEntreCuentas();
		int cuenta = sc.nextInt();
		mensaje.transferenciaEntreCuentasMonto();
		int monto = sc.nextInt();
		
		switch(cuenta) {
		
		case 1:
			lector.getTarjetas().getCuitCliente().get(cuit).getCC().transferir(lector.getTarjetas().getCuitCliente().get(cuit), monto, ticket);
			ticket.transferir(lector.getTarjetas().getCuitCliente().get(cuit).getCC(), monto);
			break;
			
		case 2:
			lector.getTarjetas().getCuitCliente().get(cuit).getArs().transferir(lector.getTarjetas().getCuitCliente().get(cuit), monto, ticket);
			ticket.transferir(lector.getTarjetas().getCuitCliente().get(cuit).getArs(), monto);
			break;
		}
	}
	
		
	
	public void dispensar(int monto) {
		
		if(monto<500) {
			billetesDeCien-=monto/100;
		}else if(monto==500 || monto<1000) {
			billetesDeQuinientos--;
			billetesDeCien-=(monto-500)/100;	
		}else{
			billetesDeMil-=monto/1000;
			
			int miles = (monto/1000)*1000;
			int resto = monto-miles;
			
			if(resto<500) {
				billetesDeCien-=resto/100;
			}else if(resto==500 || resto<1000) {
				billetesDeQuinientos--;
				billetesDeCien-=(resto-500)/100;	
			}
			
		}
		
		
	}
	public int getBilletesDeCien() {
		return billetesDeCien;
	}
	public int getBilletesDeQuinientos() {
		return billetesDeQuinientos;
	}
	public int getBilletesDeMil() {
		return billetesDeMil;
	}
	
	
	

		
	
	
		
		
		
		
		
		
		
		
	


}
