import java.util.Scanner;

public class Main {
		
	
		public static void main(String args[]) {
		
			System.out.println("Inicio de Juego.");
			String Decision = "NO";
			Personaje Jugador = new Personaje();
			
			// agregar inicio donde elige nombre y clase. crear clases
			
			
			
			do {//NOMBRE-----------------------------------------------
				
				System.out.println("Escribe el nombre del personaje:");
				Scanner Respuesta = new Scanner(System.in);
				Jugador.Nombre = Respuesta.nextLine();
				System.out.println("Tu nombre es: " + Jugador.Nombre + "?\n-SI\n-NO");
				Decision = Respuesta.nextLine();
				Decision = Decision.toUpperCase();
				
			}while (Decision.equals("SI") == false);
			
			do {//ACCION-----------------------------------------------
					
				System.out.println("Estado:");
				System.out.println("Vida: "+ Jugador.Vida);
				System.out.println("Mana: "+ Jugador.Mana);
				Jugador.Accion();	
					
			}while(Jugador.Vida > 0 && Jugador.Salir == false);
			
			if (Jugador.Vida < 1) {
				
				System.out.println("HAS MUERTO");
				
			}else {
				
				System.out.println("Se cerro el juego.");
				
			}
			
		}
	
	
	
	
	
	
	
	
	
	
}
