import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Cajero {
	
	private static int billetesDeCien = 500;
	private static int billetesDeQuinientos = 500;
	private static int billetesDeMil = 500;
	
			
	public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            
            System.out.println("----------------------------------");
            System.out.println("Bienvenido al Banco Chala");
            System.out.println("----------------------------------");
            System.out.println("");
            System.out.println("Ingrese su tarjeta:");
            String tarjeta = sc.nextLine();
            //Aca hay que buscar la tarjeta y validarla
            System.out.println("----------------------------------");
            System.out.println("Ingrese su pin de 4 digitos:");
            int pin = sc.nextInt();
            //Validar el pin
            System.out.println("----------------------------------");
           
		
		
	}
}
	