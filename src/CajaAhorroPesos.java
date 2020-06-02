import java.io.IOException;

public class CajaAhorroPesos extends Pesos{
    
    public CajaAhorroPesos( String alias, double saldo) throws ExcepcionCuenta {
    	
    	super(alias, saldo);
    	
    }

	@Override
	public void extraer(double monto) throws IOException {
		if(verificarMonto(monto) && verificarSaldo(monto) && monto%100 == 0) {
			saldo-= monto;
		
		}
	}

	@Override
	public void transferir(Cliente cliente, double monto) throws IOException {
		if(verificarMonto(monto) && verificarSaldo(monto) && cliente.getCC() != null) {
			saldo -= monto;
			cliente.getCC().saldo += monto;
				
			
			
			
		}
		//hay que agregar la parte de ticket y modificar el txt
	}


	@Override
	public void comprarUSD(Cliente cliente,double monto) throws IOException {
		double sinImpuestos = monto*70;
		double conImpuestos = sinImpuestos+= sinImpuestos*0.3;
		if(verificarMonto(monto) && verificarSaldo(monto) && cliente.getUSD()!= null) {
			
			saldo-= conImpuestos;
			cliente.getUSD().depositar(monto);
			
			
			
			//hay que agregar la parte de ticket y modificar el txt
			
		}
	}

	@Override
	public void depositar(double monto) throws IOException {
		if(verificarMonto(monto) && monto%100 == 0) {
			saldo += monto;
			
			//hay que agregar la parte de ticket y modificar el txt

		}
	}

    
}