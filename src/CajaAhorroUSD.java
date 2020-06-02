public class CajaAhorroUSD extends Cuenta{
    
    public CajaAhorroUSD(String alias, double saldo) throws ExcepcionCuenta{
    	
        super(alias, saldo);
        
    }
    
    public void depositar(double monto) {
    	if(verificarMonto(monto)) {
    		saldo+= monto;
    		ticket.depositar(saldo, monto);
    	}
    }
    
}