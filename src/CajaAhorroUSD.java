public class CajaAhorroUSD extends Cuenta{
    
    public CajaAhorroUSD(String alias, double saldo) throws ExcepcionCuenta{
    	
        super(alias, saldo);
        
    }
    
    public void depositar(double monto, Ticket ticket) throws ExcepcionTransaccion {
    	if(verificarMonto(monto)) {
    		saldo+= monto;
    		movimientos.add(ticket);
    	}
    }
    
}