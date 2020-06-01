import java.util.Scanner;

public class Cajero {
	private  int billetesDeCien = 500;
	private int billetesDeQuinientos = 500;
	private int billetesDeMil = 500;
	private ArchivoDeCuentas lector;
	private MensajesATM mensaje;
	private Scanner sc;
	private Long cuit;
	private Tarjeta tarjeta;

	public Cajero() {
		lector = new ArchivoDeCuentas();
		mensaje = new MensajesATM();
		sc = new Scanner(System.in);
		
	}
	public void iniciar() throws ExcepcionTarjeta {
		
		
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
			String reintentar = sc.nextLine();
			if(reintentar.equalsIgnoreCase("Y")) {
				iniciar();
			}
		}

	}
	
	private void extraerEfectivo() {

		mensaje.extraerEfectivo();
		int cuenta = sc.nextInt();
		mensaje.extraerEfectivoMonto();
		int monto = sc.nextInt();
		
		switch(cuenta) {
		
		case 1:
			lector.getTarjetas().getCuitCliente().get(cuit).getArs().extraer(monto);
			break;
			
		case 2:
			lector.getTarjetas().getCuitCliente().get(cuit).getCC().extraer(monto);
			break;
		}
		
	}
	
	
	private void comprarUSD() {
		mensaje.comprarUSD();
		int cuenta = sc.nextInt();
		mensaje.comprarUSDMonto();
		int monto = sc.nextInt();
		
		switch(cuenta) {
		
		case 1:
			lector.getTarjetas().getCuitCliente().get(cuit).getArs().comprarUSD(lector.getTarjetas().getCuitCliente().get(tarjeta), monto);
			break;
			
		case 2:
			lector.getTarjetas().getCuitCliente().get(cuit).getCC().comprarUSD(lector.getTarjetas().getCuitCliente().get(tarjeta), monto);
			break;
			
		}
	}
	
	private void depositarEfectivo() {
		mensaje.depositarEfectivo();
		int cuenta = sc.nextInt();
		mensaje.depositarEfectivoMonto();
		int monto = sc.nextInt();
		
		switch(cuenta) {
		
		case 1:
			lector.getTarjetas().getCuitCliente().get(cuit).getArs().depositar(monto);
			break;
		
		case 2:
			lector.getTarjetas().getCuitCliente().get(cuit).getCC().depositar(monto);
			break;
			
		case 3:
			lector.getTarjetas().getCuitCliente().get(cuit).getUSD().depositar(monto);
			break;
		}
		
		
	}


	private void transferenciaEntreCuentas() {
		mensaje.transferenciaEntreCuentas();
		int cuenta = sc.nextInt();
		mensaje.transferenciaEntreCuentasMonto();
		int monto = sc.nextInt();
		
		switch(cuenta) {
		
		case 1:
			lector.getTarjetas().getCuitCliente().get(cuit).getCC().transferir(lector.getTarjetas().getCuitCliente().get(tarjeta), monto);
			break;
			
		case 2:
			lector.getTarjetas().getCuitCliente().get(cuit).getArs().transferir(lector.getTarjetas().getCuitCliente().get(tarjeta), monto);
			break;
		}
	}


}
