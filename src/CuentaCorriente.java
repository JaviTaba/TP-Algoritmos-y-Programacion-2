public class CuentaCorriente extends Pesos {
	
    private double descubierto;
 
    public CuentaCorriente(String alias, double saldo, double descubierto) throws ExcepcionCuenta {
    	
        super(alias,saldo);
        this.descubierto = descubierto;
       
                
       
    }

	@Override
	public void extraer(int monto) {
		if(verificarMonto(monto) && verificarSaldo(monto)) {
			saldo-= monto;
		}
		
		//hay que agregar la parte de ticket y modificar el txt
	}

	@Override
	public void transferir(int monto) {
		if(verificarMonto(monto) && verificarSaldo(monto)) {
			saldo -= monto;
			mapaCuentas.getClienteAlias().get(alias).getArs().depositar(monto);
		}
		//hay que agregar la parte de ticket y modificar el txt
	}

	@Override
	public void comprarUSD(int monto) {
		int sinImpuestos = monto*70;
		int conImpuestos = sinImpuestos+= sinImpuestos*0.3;
		if(verificarMonto(monto) && verificarSaldo(monto)) {
			
			saldo-= conImpuestos;
			
			mapaCuentas.getClienteAlias().get(alias).getUSD().depositar(monto);
			//hay que agregar la parte de ticket y modificar el txt
		
		}
		
	}

	@Override
	public void depositar(int monto) {
		if(verificarMonto(monto)) {
			saldo+= monto;
			//hay que agregar la parte de ticket y modificar el txt

		}
		
	}
	
	@Override
	protected boolean verificarSaldo(int monto) {
		if (saldo>(monto-descubierto)) {
    		return true;
    	}
    	return false;
    }
	
	
    

    
}