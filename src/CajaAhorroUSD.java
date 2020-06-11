public class CajaAhorroUSD extends Cuenta{
    
    public CajaAhorroUSD(String alias, double saldo) throws ExcepcionCuenta{
    	
        super(alias, saldo);
        
    }
    
    @Override
    protected void depositar(double monto) throws ExcepcionTransaccion {
 		if(!(this == null)) {
 			saldo += monto;
 	
 			//hay que agregar la parte de ticket y modificar el txt

 		}
 	}
    
    
}
