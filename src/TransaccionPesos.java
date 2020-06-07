

public abstract interface TransaccionPesos  {      

	
	abstract void extraer(double monto, Ticket ticket) throws ExcepcionTransaccion;
	abstract void transferir(Cliente cliente, double monto, Ticket ticket) throws ExcepcionTransaccion;
	abstract void comprarUSD(Cliente cliente, double monto, Ticket ticket) throws ExcepcionTransaccion;
	abstract void depositar(double monto, Ticket ticket) throws ExcepcionTransaccion;
        
       
       
	
	
}