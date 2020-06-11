
public class MensajesATM {
	
	public void bienvenidaYTarjeta() {
		System.out.println("-------------------------------------------------------");
		System.out.println("                    BIENVENIDO                         ");
		System.out.println("                                                       ");
		System.out.println("                   BANCO  CHALA                        ");
		System.out.println("                                                       ");
		System.out.println("-------------------------------------------------------");
		System.out.println("Inserte su tarjeta:");
		System.out.println("");
		
	}
	
	
	public void ingresePin() {
		System.out.println("");
		System.out.println("-------------------------------------------------------");
		System.out.println("Ingrese su PIN de 4 dígitos: ");
		System.out.println("");
	}
	
	public void queOperacionDeseaHacer() {
		System.out.println("");
		System.out.println("-------------------------------------------------------");
		System.out.println("¿Qué operación desea realizar? (Digite el número)");
		System.out.println("-------------------------------------------------------");
		System.out.println("1.- Extraer efectivo");
		System.out.println("2.- Comprar USD");
		System.out.println("3.- Depositar efectivo");
		System.out.println("4.- Transferir desde su cuenta");
		
	}
	
	
	//Extraer efectivo
	
	public void extraerEfectivo() {
		System.out.println("");
		System.out.println("-------------------------------------------------------");
		System.out.println("Seleccione la cuenta de la cual desea extraer efectivo:");
		System.out.println("-------------------------------------------------------");
		System.out.println("1.- Caja de Ahorro en Pesos");
		System.out.println("2.- Cuenta Corriente");
		System.out.println("");		
		
	}
	
	public void extraerEfectivoMonto() {
		System.out.println("");
		System.out.println("-------------------------------------------------------");
		System.out.println("Digite la cantidad que desea extraer:");
		System.out.println("");
	}
	
	
	
	
	
	//Comprar USD
	
	public void comprarUSD() {
		System.out.println("");
		System.out.println("-------------------------------------------------------");
		System.out.println("Seleccione la cuenta desde la cual desea comprar USD");
		System.out.println("Dolar actual: 70$. ");
		System.out.println("(No incluye impuesto PAIS)");
		System.out.println("-------------------------------------------------------");
		System.out.println("1.- Caja de Ahorro en Pesos");
		System.out.println("2.- Cuenta Corriente");
		System.out.println("");	
		
	}
	
	public void comprarUSDMonto() {
		System.out.println("");
		System.out.println("-------------------------------------------------------");
		System.out.println("Digite la cantidad de USD que desea comprar");
		System.out.println("");
	}
	
	
	
	//Depositar efectivo
	
	public void depositarEfectivo() {
		System.out.println("");
		System.out.println("-------------------------------------------------------");
		System.out.println("Seleccione la cuenta en la que desea depositar");
		System.out.println("-------------------------------------------------------");
		System.out.println("1.- Caja de Ahorro en Pesos");
		System.out.println("2.- Cuenta Corriente");
		System.out.println("3.- Caja de Ahorro en USD");
		System.out.println("");
	}
	
	public void depositarEfectivoMonto() {
		System.out.println("");
		System.out.println("-------------------------------------------------------");
		System.out.println("Digite el monto que desea depositar");
		System.out.println("");
	}
	
	
	
	//Transferencia entre cuentas
	
	public void transferir() {
		System.out.println("");
		System.out.println("-------------------------------------------------------");
		System.out.println("Ingrese el alias de la cuenta a la cual desea transferir:");
		System.out.println("");
	}
	
	public void transferirMonto() {
		System.out.println("");
		System.out.println("-------------------------------------------------------");
		System.out.println("Digite el monto que desea transferir:");
		System.out.println("");
	}
	
	public void desdeQueCuentaDeseaTransferir() {
		System.out.println("");
		System.out.println("-------------------------------------------------------");
		System.out.println("Seleccione la cuenta desde la cual desea transferir:");
		System.out.println("-------------------------------------------------------");
		System.out.println("1- Caja de Ahorro en Pesos");
		System.out.println("2- Cuenta Corriente");
		System.out.println("");
	}
	
	
	
	
	
	//Extras
	
	public void terminarONo() {
		System.out.println("");
		System.out.println("-------------------------------------------------------");
		System.out.println("Desea realizar otra operacion? (Y/N)");
		System.out.println("");
	}
	
	public void operacionCorrecta() {
		System.out.println("");
		System.out.println("-------------------------------------------------------");
		System.out.println("La operacion se ha realizado con exito.");
		
	}
	
	public void operacionIncorrecta() {
		System.out.println("");
		System.out.println("-------------------------------------------------------");
		System.out.println("La operacion no pudo ser realizada.");
	}
	
	public void adios() {
		System.out.println("");
		System.out.println("-------------------------------------------------------");
		System.out.println("Gracias por utilizar nuestro cajero automatico.");
		System.out.println("¡Vuelva prontos!");
		System.out.println("-------------------------------------------------------");
		
		
	}
	
	public void numeroOPinIncorrectos() {
		System.out.println("");
		System.out.println("-------------------------------------------------------");
		System.out.println("El número de la tarjeta o el PIN son incorrectos.");
	}
	
	public void reintentar() {
		System.out.println("");
		System.out.println("-------------------------------------------------------");
		System.out.println("¿Desea reintentar?");
		System.out.println("-------------------------------------------------------");
		System.out.println("1.- Si");
		System.out.println("2.- No");
	}
	
	
}
