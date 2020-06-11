import java.io.IOException;
import java.security.DrbgParameters.NextBytes;
import java.util.Scanner;

public class Cajero implements Reversible{
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
	public void iniciar() throws ExcepcionTarjeta, ExcepcionTransaccion, IOException, ExcepcionCuenta {


		mensaje.bienvenidaYTarjeta();
		int numeroTarjeta = sc.nextInt();
		mensaje.ingresePin();
		int pin = sc.nextInt();

		tarjeta = new Tarjeta(numeroTarjeta, pin);


		cuit = lector.getTarjetas().getCuitTarjeta().get(tarjeta);

		if(cuit != null) {
			cuerpoCajero();			
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








	private void cuerpoCajero() throws ExcepcionTransaccion, IOException, ExcepcionCuenta {
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
			transferencia();
			break;
		}

		mensaje.operacionCorrecta();
		mensaje.terminarONo();
		String yesOrNo = sc.next();
		if(yesOrNo.equalsIgnoreCase("Y")) {
			cuerpoCajero();
		}else {
			mensaje.adios();
		}

	}

	private void extraerEfectivo() throws ExcepcionTransaccion, IOException{
		mensaje.extraerEfectivo();
		int cuenta = sc.nextInt();
		extraerEfectivo1(cuenta);
	}
	private void extraerEfectivo1(int cuenta) throws ExcepcionTransaccion, IOException {


		mensaje.extraerEfectivoMonto();
		int monto = sc.nextInt();

		if(monto%100==0) {

			switch(cuenta) {

			case 1:
				cliente(cuit).getArs().extraer(monto);
				dispensar(monto);
				ticket.extraer(lector.getTarjetas().getCuitCliente().get(cuit).getArs(), monto);
				break;

			case 2:
				cliente(cuit).getCC().extraer(monto);
				dispensar(monto);
				ticket.extraer(lector.getTarjetas().getCuitCliente().get(cuit).getCC(), monto);
				break;
			}

		}else {
			System.out.println("El monto a extraer debe ser multiplo de 100");
			extraerEfectivo1(cuenta);

		}
	}
	private void comprarUSD() throws ExcepcionTransaccion, IOException {
		mensaje.comprarUSD();
		int cuenta = sc.nextInt();
		mensaje.comprarUSDMonto();
		int monto = sc.nextInt();

		switch(cuenta) {

		case 1:
			cliente(cuit).getArs().comprarUSD(lector.getTarjetas().getCuitCliente().get(cuit), monto);
			ticket.comprarUSD(lector.getTarjetas().getCuitCliente().get(cuit).getArs(), monto);
			break;

		case 2:
			cliente(cuit).getCC().comprarUSD(lector.getTarjetas().getCuitCliente().get(cuit), monto);
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
			cliente(cuit).getArs().depositar(monto);
			ticket.depositar(lector.getTarjetas().getCuitCliente().get(cuit).getArs(), monto);
			break;

		case 2:
			cliente(cuit).getCC().depositar(monto);
			ticket.depositar(lector.getTarjetas().getCuitCliente().get(cuit).getCC(), monto);
			break;

		case 3:
			cliente(cuit).getUSD().depositar(monto);
			ticket.depositar(lector.getTarjetas().getCuitCliente().get(cuit).getUSD(), monto);
			break;
		}


	}
	private void transferencia() throws ExcepcionTransaccion, ExcepcionCuenta, IOException {
		mensaje.transferir();
		String alias = sc.next();		
		mensaje.transferirMonto();
		double monto = sc.nextDouble();

		if(monto>0) {

			mensaje.desdeQueCuentaDeseaTransferir();
			int cuenta = sc.nextInt();

			switch(cuenta) {

			case 1:
				cliente(cuit).getArs().transferir( lector.encontrarCuenta(alias), monto);
				mensaje.deseaRevertirLaTransferencia();
				String revertir = sc.next();
				if(revertir.equalsIgnoreCase("REVERTIR")){
					revertirTransferencia(1, monto, alias);
					mensaje.seRevirtioConExito();
					break;
				}else {
					ticket.transferir(lector.getTarjetas().getCuitCliente().get(cuit).getArs(), monto);
					break;
				}
				

			case 2:
				cliente(cuit).getCC().transferir(lector.encontrarCuenta(alias), monto);
				mensaje.deseaRevertirLaTransferencia();
				String revertir1 = sc.next();
				if(revertir1.equalsIgnoreCase("REVERTIR")){
					revertirTransferencia(2, monto, alias);
					mensaje.seRevirtioConExito();
					break;
				}else {
				ticket.transferir(lector.getTarjetas().getCuitCliente().get(cuit).getCC(), monto);
				break;
				}


			}
			
			
			
			
		}else {
			System.out.println("El monto debe ser mayor a 0.");
			transferencia();

		}


	}

	private Cliente cliente(Long cuit) {
		return lector.getTarjetas().getCuitCliente().get(cuit);
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
	
	
	@Override
	public void revertirTransferencia(int tipoDeCuenta, double monto, String alias) throws ExcepcionTransaccion, ExcepcionCuenta {
		switch(tipoDeCuenta) {

		case 1:
			cliente(cuit).getArs().transferir( lector.encontrarCuenta(alias), -monto);
			break;
		
		case 2:
			cliente(cuit).getCC().transferir(lector.encontrarCuenta(alias), -monto);
			break;
		
		}



	}


}
