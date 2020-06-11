
public interface Reversible {
	
	public void revertirTransferencia(int tipoDeCuenta, double monto, String alias) throws ExcepcionTransaccion, ExcepcionCuenta;

}
