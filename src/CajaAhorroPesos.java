public class CajaAhorroPesos extends Pesos{
    
    public CajaAhorroPesos( String alias, double saldo) throws ExcepcionCuenta {
    	
    	super(alias, saldo);
    	
    }

	@Override
	public void extraer(double monto, Ticket ticket) throws ExcepcionTransaccion {
		if(verificarMonto(monto) && verificarSaldo(saldo)) {
			saldo -= monto;
			movimientos.add(ticket);
		}
		
	}

	@Override
	public void transferir(Cliente cliente, double monto, Ticket ticket) throws ExcepcionTransaccion {
		if(verificarMonto(monto) && verificarSaldo(monto) && cliente.getCC() != null) {
			saldo -= monto;
			cliente.getCC().saldo += monto;
			movimientos.add(ticket);	
			
			
			
		}
		//hay que agregar la parte de ticket y modificar el txt
	}


	@Override
	public void comprarUSD(Cliente cliente,double monto, Ticket ticket) throws ExcepcionTransaccion {
		double montoConImpuesto = monto*1.3;
		if(verificarMonto(montoConImpuesto) && verificarSaldo(montoConImpuesto) && cliente.getUSD()!= null) {
			
			saldo-= montoConImpuesto;
			cliente.getUSD().saldo += montoConImpuesto/this.dolar;
			movimientos.add(ticket);
			
			
			//hay que agregar la parte de ticket y modificar el txt
			
		}
	}

	@Override
	public void depositar(double monto, Ticket ticket) throws ExcepcionTransaccion {
		if(verificarMonto(monto)) {
			saldo += monto;
			movimientos.add(ticket);
			//hay que agregar la parte de ticket y modificar el txt

		}
	}

    
}