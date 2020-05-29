public class Tarjeta {
	
    public int numero;
    public int pin;
    
    
    
    public Tarjeta(int numero, int pin) throws ExcepcionTarjeta {
        if (contadorCaracteres(numero) == 8 && contadorCaracteres(pin) == 4) {
        	
            this.numero=numero;
            this.pin = pin;
            
        } 
        
        else {
            throw new ExcepcionTarjeta("La tarjeta debe tener 8 digitos y el pin 4.");
        }
        
        
    }
    
    
    
    /**
     * @POST Cuenta la cantidad de cifras de la variable numero
     * 
     * 
     */
    private int contadorCaracteres(int numero) {
        int cifras = 0;
        
        while (numero != 0){
            numero/=10;
            cifras++;            
        }        
        
        return cifras;
        
    }
    
}
