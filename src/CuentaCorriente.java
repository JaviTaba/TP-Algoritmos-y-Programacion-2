/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author javi1
 */
public class CuentaCorriente extends Pesos {
    private double descubierto;
 
    public CuentaCorriente(int tipo, String alias, double saldo, double descubierto){
        super(tipo,alias,saldo);
        this.descubierto = descubierto;
                
        
    }
    
    
    
   
    
}