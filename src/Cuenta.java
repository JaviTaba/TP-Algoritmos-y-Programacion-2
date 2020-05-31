public abstract class Cuenta {
	
	
	
    public String alias;
    public double saldo;
   
    
    
    public Cuenta (String alias, double saldo) throws ExcepcionCuenta {
    	
      
       this.alias = alias;
       this.saldo = saldo;
       
    }
    
    
    public String getAlias() {
    	return alias;
    }
    
    public double getSaldo() {
    	return saldo;
    }
    
    protected boolean verificarMonto(int monto) {
    	if (monto>0) {
    		return true;
    	}
    	return false;
    }
    
    protected boolean verificarSaldo(int monto) {
    	if (saldo>monto) {
    		return true;
    	}
    	return false;
    }
    
    
}