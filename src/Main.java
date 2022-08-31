import java.util.Scanner;

public class Main {
		
	
		public static void main(String args[]) {
		
			System.out.println("Inicio de Programa.");
			boolean MenuOk= false; // para validar y avanzar con el menu principal
			String Decision = "NO";
			Personaje Jugador = new Personaje();
			Scanner Respuesta = new Scanner(System.in);
			// agregar inicio donde elige nombre y clase. crear clases
			
			do{//MENU
				System.out.println("-Iniciar Partida\n-Cargar Partida");
				String Inicio = Respuesta.nextLine();
				Inicio = Inicio.toUpperCase();
				switch (Inicio) {
				
					case "INICIAR PARTIDA":
						//Nueva partida-----------------------------------------
						do {//NOMBRE-----------------------------------------------
							
							System.out.println("Escribe el nombre del personaje:");
							Jugador.Nombre = Respuesta.nextLine();
							System.out.println("Tu nombre es: " + Jugador.Nombre + "?\n-SI\n-NO");
							Decision = Respuesta.nextLine();
							Decision = Decision.toUpperCase();
							
						}while (Decision.equals("SI") == false);
						MenuOk=true;
						break;
						
					case "CARGAR PARTIDA":	
						//Cargar partida---------------------------------------------
						System.out.println("Aun no disponible");
						break;
					default:
						System.out.println("No se entendio la respuesta.");
						break;
				}
			}while(MenuOk == false);//mas adelante acomodar menu
			//---------------------------------------
			
			do {//ACCION-----------------------------------------------
					
				Jugador.Accion();	
					
			}while(Jugador.Vida > 0 && Jugador.Salir == false);
			
			if (Jugador.Vida < 1) {
				
				System.out.println("HAS MUERTO");
				
			}else {
				
				System.out.println("Se cerro el juego.");
				
			}
			
		}
	
	
	
	
	
	
	
	
	
	
}
