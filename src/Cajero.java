import java.io.IOException;
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
	private ModificarCuentas modificarCuentas;

	public Cajero() throws IOException {
		lector = new ArchivoDeCuentas();
		mensaje = new MensajesATM();
		sc = new Scanner(System.in);
		ticket = new Ticket();
		modificarCuentas = new ModificarCuentas();

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
			ticket.crearTicket();
			ticket.imprimirTicket();
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

		if(monto%100==0 && monto>0) {

			switch(cuenta) {

			case 1:
				cliente(cuit).getArs().extraer(monto);
				dispensar(monto);
				ticket.extraer(lector.getTarjetas().getCuitCliente().get(cuit).getArs(), monto);
				
				String alias = lector.getTarjetas().getCuitCliente().get(cuit).getArs().getAlias();
				double antiguoSaldo = lector.getTarjetas().getCuitCliente().get(cuit).getArs().getSaldo();
				double descubierto1 = lector.getTarjetas().getCuitCliente().get(cuit).getArs().getDescubierto();
				double nuevoSaldo = lector.getTarjetas().getCuitCliente().get(cuit).getArs().getSaldo()-monto;
				
				modificarCuentas.modificarSaldo("01", alias, antiguoSaldo , descubierto1, nuevoSaldo);
				break;

			case 2:
				cliente(cuit).getCC().extraer(monto);
				dispensar(monto);
				ticket.extraer(lector.getTarjetas().getCuitCliente().get(cuit).getCC(), monto);
				
				String alias1 = lector.getTarjetas().getCuitCliente().get(cuit).getCC().getAlias();
				double antiguoSaldo1 = lector.getTarjetas().getCuitCliente().get(cuit).getCC().getSaldo();
				double nuevoSaldo1 = lector.getTarjetas().getCuitCliente().get(cuit).getCC().getSaldo()-monto;
				double descubierto = lector.getTarjetas().getCuitCliente().get(cuit).getCC().getDescubierto();
				
				modificarCuentas.modificarSaldo("02", alias1, antiguoSaldo1, descubierto, nuevoSaldo1);
				break;
			}

		}else {
			System.out.println("-------------------------------------------------------");
			System.out.println("Error: El monto a extraer debe ser multiplo de 100");
			System.out.println("-------------------------------------------------------");
			extraerEfectivo1(cuenta);

		}
	}
	private void comprarUSD() throws ExcepcionTransaccion, IOException {
		mensaje.comprarUSD();
		int cuenta = sc.nextInt();
		mensaje.comprarUSDMonto();
		int monto = sc.nextInt();
		
		if(monto>0) {
			switch(cuenta) {

			case 1:
				cliente(cuit).getArs().comprarUSD(lector.getTarjetas().getCuitCliente().get(cuit), monto);
				ticket.comprarUSD(lector.getTarjetas().getCuitCliente().get(cuit).getArs(), monto);
				
				String alias = lector.getTarjetas().getCuitCliente().get(cuit).getArs().getAlias();
				double antiguoSaldo = lector.getTarjetas().getCuitCliente().get(cuit).getArs().getSaldo();
				double descubierto = lector.getTarjetas().getCuitCliente().get(cuit).getArs().getDescubierto();
				double nuevoSaldo = lector.getTarjetas().getCuitCliente().get(cuit).getArs().getSaldo() - (monto * lector.getTarjetas().getCuitCliente().get(cuit).getArs().dolar * 1.3);
				modificarCuentas.modificarSaldo("01", alias, antiguoSaldo, descubierto, nuevoSaldo);
				
				String aliasDolar = lector.getTarjetas().getCuitCliente().get(cuit).getUSD().getAlias();
				double antiguoSaldoDolar = lector.getTarjetas().getCuitCliente().get(cuit).getUSD().getSaldo();
				double descubiertoDolar = lector.getTarjetas().getCuitCliente().get(cuit).getUSD().getDescubierto();
				double nuevoSaldoDolar = lector.getTarjetas().getCuitCliente().get(cuit).getUSD().getSaldo() + monto;
				modificarCuentas.modificarSaldo("03", aliasDolar, antiguoSaldoDolar, descubiertoDolar, nuevoSaldoDolar);
				break;

			case 2:
				cliente(cuit).getCC().comprarUSD(lector.getTarjetas().getCuitCliente().get(cuit), monto);
				ticket.comprarUSD(lector.getTarjetas().getCuitCliente().get(cuit).getCC(), monto);
				
				String alias1 = lector.getTarjetas().getCuitCliente().get(cuit).getArs().getAlias();
				double antiguoSaldo1 = lector.getTarjetas().getCuitCliente().get(cuit).getCC().getSaldo();
				double descubierto1 = lector.getTarjetas().getCuitCliente().get(cuit).getCC().getDescubierto();
				double nuevoSaldo1 = lector.getTarjetas().getCuitCliente().get(cuit).getCC().getSaldo() - (monto * lector.getTarjetas().getCuitCliente().get(cuit).getArs().dolar * 1.3);
				modificarCuentas.modificarSaldo("02", alias1, antiguoSaldo1, descubierto1, nuevoSaldo1);
				
				String aliasDolar1 = lector.getTarjetas().getCuitCliente().get(cuit).getUSD().getAlias();
				double antiguoSaldoDolar1 = lector.getTarjetas().getCuitCliente().get(cuit).getUSD().getSaldo();
				double descubiertoDolar1 = lector.getTarjetas().getCuitCliente().get(cuit).getUSD().getDescubierto();
				double nuevoSaldoDolar1 = lector.getTarjetas().getCuitCliente().get(cuit).getUSD().getSaldo() + monto;
				modificarCuentas.modificarSaldo("03", aliasDolar1, antiguoSaldoDolar1, descubiertoDolar1, nuevoSaldoDolar1);
				break;

			}
		}else {
			System.out.println("-------------------------------------------------------");
			System.out.println("Error: El monto debe ser mayor a 0");
			System.out.println("-------------------------------------------------------");
			comprarUSD();
		}

		
	}
	private void depositarEfectivo() throws ExcepcionTransaccion,IOException {
		mensaje.depositarEfectivo();
		int cuenta = sc.nextInt();
		mensaje.depositarEfectivoMonto();
		int monto = sc.nextInt();
		
		if(monto>0) {
			switch(cuenta) {

			case 1:
				cliente(cuit).getArs().depositar(monto);
				ticket.depositar(lector.getTarjetas().getCuitCliente().get(cuit).getArs(), monto);
				
				String alias = lector.getTarjetas().getCuitCliente().get(cuit).getArs().getAlias();
				double antiguoSaldo = lector.getTarjetas().getCuitCliente().get(cuit).getArs().getSaldo();
				double descubierto = lector.getTarjetas().getCuitCliente().get(cuit).getArs().getDescubierto();
				double nuevoSaldo = lector.getTarjetas().getCuitCliente().get(cuit).getArs().getSaldo() + monto;
				
				modificarCuentas.modificarSaldo("01", alias, antiguoSaldo, descubierto, nuevoSaldo);
				break;

			case 2:
				cliente(cuit).getCC().depositar(monto);
				ticket.depositar(lector.getTarjetas().getCuitCliente().get(cuit).getCC(), monto);
				
				String alias1 = lector.getTarjetas().getCuitCliente().get(cuit).getCC().getAlias();
				double antiguoSaldo1 = lector.getTarjetas().getCuitCliente().get(cuit).getCC().getSaldo();
				double descubierto1 = lector.getTarjetas().getCuitCliente().get(cuit).getCC().getDescubierto();
				double nuevoSaldo1 = lector.getTarjetas().getCuitCliente().get(cuit).getCC().getSaldo() + monto;
				
				modificarCuentas.modificarSaldo("02", alias1, antiguoSaldo1, descubierto1, nuevoSaldo1);
				break;

			case 3:
				cliente(cuit).getUSD().depositar(monto);
				ticket.depositar(lector.getTarjetas().getCuitCliente().get(cuit).getUSD(), monto);
				
				String aliasDolar = lector.getTarjetas().getCuitCliente().get(cuit).getUSD().getAlias();
				double antiguoSaldoDolar = lector.getTarjetas().getCuitCliente().get(cuit).getUSD().getSaldo();
				double descubiertoDolar = lector.getTarjetas().getCuitCliente().get(cuit).getUSD().getDescubierto();
				double nuevoSaldoDolar = lector.getTarjetas().getCuitCliente().get(cuit).getUSD().getSaldo() + monto;
				
				modificarCuentas.modificarSaldo("03", aliasDolar, antiguoSaldoDolar, descubiertoDolar, nuevoSaldoDolar);
				break;
			}
		}else {
			System.out.println("-------------------------------------------------------");
			System.out.println("Error: El monto debe ser mayor a 0.");
			System.out.println("-------------------------------------------------------");
			depositarEfectivo();
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
				mensaje.operacionCorrecta();
				mensaje.deseaRevertirLaTransferencia();
				String revertir = sc.next();
				
				if(revertir.equalsIgnoreCase("REVERTIR")){
					revertirTransferencia(1, monto, alias);
					mensaje.seRevirtioConExito();
					break;
					
				} else {
					ticket.transferir(lector.getTarjetas().getCuitCliente().get(cuit).getArs(), monto);
					
					String alias1 = lector.getTarjetas().getCuitCliente().get(cuit).getArs().getAlias();
					double antiguoSaldo = lector.getTarjetas().getCuitCliente().get(cuit).getArs().getSaldo();
					double nuevoSaldo = lector.getTarjetas().getCuitCliente().get(cuit).getArs().getSaldo() - monto;
					
					modificarCuentas.modificarSaldo("01", alias1, antiguoSaldo, 0, nuevoSaldo);
					
					String tipoDeCuenta = lector.getTarjetas().getCuitCliente().get(cuit).getArs().getTipoDeCuenta();
					double antiguoSaldo1 = lector.encontrarCuenta(alias).getSaldo();
					double descubierto = lector.encontrarCuenta(alias).getDescubierto();
					double nuevoSaldo1 = lector.encontrarCuenta(alias).getSaldo() + monto;
					
					modificarCuentas.modificarSaldo(tipoDeCuenta, alias, antiguoSaldo1, descubierto, nuevoSaldo1);
					
					
					break;
				}
				

			case 2:
				cliente(cuit).getCC().transferir(lector.encontrarCuenta(alias), monto);
				mensaje.operacionCorrecta();
				mensaje.deseaRevertirLaTransferencia();
				String revertir1 = sc.next();
				
				if(revertir1.equalsIgnoreCase("REVERTIR")){
					revertirTransferencia(2, monto, alias);
					mensaje.seRevirtioConExito();
					break;
					
				} else {
					ticket.transferir(lector.getTarjetas().getCuitCliente().get(cuit).getCC(), monto);
					
					String alias1 = lector.getTarjetas().getCuitCliente().get(cuit).getCC().getAlias();
					double antiguoSaldo = lector.getTarjetas().getCuitCliente().get(cuit).getCC().getSaldo();
					double descubierto = lector.getTarjetas().getCuitCliente().get(cuit).getCC().getDescubierto();
					double nuevoSaldo = lector.getTarjetas().getCuitCliente().get(cuit).getCC().getSaldo() - monto;
					
					modificarCuentas.modificarSaldo("02", alias1, antiguoSaldo, descubierto, nuevoSaldo);
					
					String tipoDeCuenta = lector.getTarjetas().getCuitCliente().get(cuit).getCC().getTipoDeCuenta();
					double antiguoSaldo1 = lector.encontrarCuenta(alias).getSaldo();
					double descubierto1 = lector.encontrarCuenta(alias).getDescubierto();
					double nuevoSaldo1 = lector.encontrarCuenta(alias).getSaldo() + monto;
					
					modificarCuentas.modificarSaldo(tipoDeCuenta, alias, antiguoSaldo1, descubierto1, nuevoSaldo1);
					
					break;
				}


			}
			
			
			
			
		}else {
			System.out.println("-------------------------------------------------------");
			System.out.println("Error: El monto debe ser mayor a 0.");
			System.out.println("-------------------------------------------------------");
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
