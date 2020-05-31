public class CajaAhorroUSD extends Cuenta{
    
    public CajaAhorroUSD(String alias, double saldo) throws ExcepcionCuenta{
    	
        super(alias, saldo);
        
    }
    
    public void depositar(int monto) {
    	if(verificarMonto(monto)) {
    		saldo+= monto;
    	}
    }
    
}