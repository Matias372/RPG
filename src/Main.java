import java.util.Scanner;

public class Main {

	boolean Salir = false;
	Personaje Jugador = new Personaje();
	
	//Deberia generar un while(Jugador.vida > 0  o  salir == false) ejecutar funcion accion.
	// la funcion accion deberia hacerla en main o personaje?
	
	
	do {
		
		public void Accion() {
			
			Scanner Respuesta = new Scanner(System.in);
			
			System.out.println("Cual es tu proxima accion?");
			System.out.println("-Atacar\n-Dormir\n-Consumir\n-Mover\n-Buscar");
			String decision = Respuesta.nextLine();
			switch (decision) {
			
			case "Atacar":
				if(Jugador.Seguro == false) {//si se genera en personaje seria igual Jugador.Seguro ya que cualquier daño o curacion seria a la persona Jugador, no a la clase Persona.
					
				}else {
					System.out.println("No es posible Atacar");
				}
				break;
			case "Dormir":
				Jugador.Dormir();
				break;
			case "Consumir":
				break;
			case "Mover":
				break;
			case "Buscar":
				break;
			
			}
			
		} 
		
	} while (Jugador.Vida > 0 && Salir == false );
	
}
