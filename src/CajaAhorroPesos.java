public class CajaAhorroPesos extends Pesos{
    
    public CajaAhorroPesos( String alias, double saldo) throws ExcepcionCuenta {
    	
    	super(alias, saldo);
    	
    }
    
    @Override
    protected String getTipoDeCuenta() {
    	return "01";
    }

    
}