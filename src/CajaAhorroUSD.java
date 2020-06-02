import java.io.IOException;

public class CajaAhorroUSD extends Cuenta{
    
    public CajaAhorroUSD(String alias, double saldo) throws ExcepcionCuenta{
    	
        super(alias, saldo);
        
    }
    
    public void depositar(double monto) throws IOException {
    	if(verificarMonto(monto) && monto%100==0) {
    		saldo+= monto;
    	
    	}
    }
    
}