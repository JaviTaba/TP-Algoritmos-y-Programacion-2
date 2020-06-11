public abstract class Pesos extends Cuenta {
    
    public Pesos(String alias, double saldo) throws ExcepcionCuenta {
        super(alias, saldo);
    }
    
    protected void extraer(double monto) throws ExcepcionTransaccion {
    	if(verificarMonto(monto) && verificarSaldo(saldo)) {
			saldo -= monto;
		}
    }
    
    protected void transferir(Cuenta cuenta, double monto) throws ExcepcionTransaccion, ExcepcionCuenta {
    	if(verificarMonto(monto)&& verificarSaldo(monto)) {
    		this.extraer(monto);
    		cuenta.depositar(monto);
    		
    	}
    }
    
    protected void comprarUSD(Cliente cliente,double monto) throws ExcepcionTransaccion {
		double montoConImpuesto = monto*1.3;
		if(verificarMonto(monto) && verificarSaldo(montoConImpuesto) && cliente.getUSD()!= null) {
			
			saldo-= montoConImpuesto*this.dolar;
			cliente.getUSD().saldo += monto;
			
			
			
			//hay que agregar la parte de ticket y modificar el txt
			
		}
	}
    
   
    
    

}


