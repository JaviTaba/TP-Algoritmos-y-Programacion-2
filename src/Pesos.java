public abstract class Pesos extends Cuenta {
    
    public Pesos(String alias, double saldo) throws ExcepcionCuenta {
        super(alias, saldo);
    }
    
    protected void extraer(double monto) throws ExcepcionTransaccion {
    	if(verificarMonto(monto) && verificarSaldo(monto)) {
			saldo -= monto;
		}
    }
    
    protected void transferir(Cuenta cuenta, double monto) throws ExcepcionTransaccion, ExcepcionCuenta {
    	if(verificarSaldo(monto)) {
    		this.extraer(monto);
    		cuenta.depositar(monto);
    		
    	}else {
    		throw new ExcepcionTransaccion("Usted no posee el saldo suficiente para realizar esta transferencia");
    	}
    }
    
    protected void comprarUSD(Cliente cliente,double monto) throws ExcepcionTransaccion {
		double montoConImpuesto = monto*1.3;
		if(cliente.getUSD()!= null) {
			if(verificarSaldo(montoConImpuesto)) {
				
				saldo-= montoConImpuesto*this.dolar;
				cliente.getUSD().saldo += monto;
				
				
				
	
				
			}
				
		}else {
			throw new ExcepcionTransaccion("Usted no posee una Caja de Ahorro en USD");
		
		
		}
	}
    
   
    
    

}


