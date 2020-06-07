

public abstract interface TransaccionPesos  {      

	
	abstract void extraer(double monto) throws ExcepcionTransaccion;
	abstract void transferir(Cliente cliente, double monto) throws ExcepcionTransaccion;
	abstract void comprarUSD(Cliente cliente, double monto) throws ExcepcionTransaccion;
	abstract void depositar(double monto) throws ExcepcionTransaccion;
        
       
       
	
	
}