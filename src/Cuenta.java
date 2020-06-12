import java.util.Stack;

public abstract class Cuenta {
	
	
	
    protected String alias;
    protected double saldo;
    protected double dolar;
    protected Stack<Ticket> movimientos;
    
    public Cuenta (String alias, double saldo) throws ExcepcionCuenta {
    	
      if(alias.equals(null) || alias.isEmpty()) {
    	  throw new ExcepcionCuenta("Alias incorrecto.");
      }
      	
       this.alias = alias;
       this.saldo = saldo;
       dolar = 70;
       movimientos = new Stack<Ticket>();
       
    }
    
    protected void depositar(double monto) throws ExcepcionTransaccion {
		if(verificarMonto(monto)) {
			saldo += monto;
	
		

		}
	}
    
    
    /**
     * @POST Devuelve el Alias de la Cuenta
     * 
     */
    public String getAlias() {
    	return alias;
    }
    
    
    
    /**
     * @POST Devuelve el Saldo de la Cuenta
     */
    public double getSaldo() {
    	return saldo;
    }
    
    
    /**
     * @POST Verifica que el monto de la transacción no sea negativo
     * 
     *  
     * 
     */
    protected boolean verificarMonto(double monto) throws ExcepcionTransaccion{
    	if (monto>0) {
    		return true;
    	}
    	return false;
    }
    
    
    /**
     * @POST Verifica que la cuenta contiene el saldo necesario para la transaccion
     */
    protected boolean verificarSaldo(double monto) throws ExcepcionTransaccion {
    	if (saldo>monto) {
    		return true;
    	}
    	
    	return false;
    }
    
    
    
    
}