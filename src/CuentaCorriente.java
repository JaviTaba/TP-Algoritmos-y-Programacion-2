public class CuentaCorriente extends Pesos {

	private double descubierto;

	public CuentaCorriente(String alias, double saldo, double descubierto) throws ExcepcionCuenta {

		super(alias,saldo);
		this.descubierto = descubierto;



	}

	@Override
	public void extraer(double monto, Ticket ticket) throws ExcepcionTransaccion {
		if(verificarMonto(monto) && verificarSaldo(monto)) {
			saldo-= monto;
			movimientos.add(ticket);
		}

		//hay que agregar la parte de ticket y modificar el txt
	}

	@Override
	public void transferir(Cliente cliente,double monto, Ticket ticket) throws ExcepcionTransaccion {
		if(verificarMonto(monto) && verificarSaldo(monto) && cliente.getArs() != null) {
			saldo -= monto;
			cliente.getArs().saldo += monto;
			movimientos.add(ticket);
		} 
		//hay que agregar la parte de ticket y modificar el txt
	}

	@Override
	public void comprarUSD(Cliente cliente, double monto, Ticket ticket) throws ExcepcionTransaccion {
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

	@Override
	protected boolean verificarSaldo(double monto) {
		if (saldo>=(monto-descubierto)) {
			return true;
		}
		return false;
	}





}