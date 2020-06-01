public class CajaAhorroPesos extends Pesos{
    
    public CajaAhorroPesos( String alias, double saldo) throws ExcepcionCuenta {
    	
    	super(alias, saldo);
    	
    }

	@Override
	public void extraer(double monto) {
		if(verificarMonto(monto) && verificarSaldo(monto) && monto/100 == 0) {
			saldo-= monto;
		
			//hay que agregar la parte de ticket y modificar el txt

		}
	}

	@Override
	public void transferir(Cliente cliente, double monto) {
		if(verificarMonto(monto) && verificarSaldo(monto)) {
			saldo -= monto;
			cliente.getCC().depositar(monto);
		}
		//hay que agregar la parte de ticket y modificar el txt
	}


	@Override
	public void comprarUSD(Cliente cliente,double monto) {
		double sinImpuestos = monto*70;
		double conImpuestos = sinImpuestos+= sinImpuestos*0.3;
		if(verificarMonto(monto) && verificarSaldo(monto)) {
			if(cliente.getUSD()!= null) {
				saldo-= conImpuestos;
				cliente.getUSD().depositar(monto);
				
			}
			
			//hay que agregar la parte de ticket y modificar el txt
		
		}
	}

	@Override
	public void depositar(double monto) {
		if(verificarMonto(monto) && monto/100 == 0) {
			saldo+= monto;
			
			//hay que agregar la parte de ticket y modificar el txt

		}
	}

    
}