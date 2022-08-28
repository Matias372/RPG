import java.util.Scanner;

public class Personaje {

	String Raza;
	String Nombre;
	Clases clase = new Clases();
	boolean Seguro = true; // Ciudad=True / Masmorra= False.  usar estado para verificar si se puede dormir
	int Vida = 100;
	int VidaMax = 100; //vida completa
	int Mana = 100;
	int ManaMax =100; //mana
	int Fuerza = 5;
	int Agilidad = 5;
	int Defensa = 5;
	int Inteligencia = 5;
	float Dinero = 0;
	float Experiencia =0;
	
	
	//ACCIONES
	
	public void Accion() {
		
		Scanner Respuesta = new Scanner(System.in);
	
		System.out.println("Cual es tu proxima accion?");
		System.out.println("-Atacar\n-Dormir\n-Consumir\n-Mover\n-Buscar");
		String decision = Respuesta.nextLine();
		switch (decision) {
	
		case "Atacar":
			if(Seguro == false) {//si se genera en personaje seria igual Jugador.Seguro ya que cualquier daño o curacion seria a la persona Jugador, no a la clase Persona.
			
			}else {
				System.out.println("No es posible Atacar.");
			}	
			break;
		case "Dormir":
			Dormir();
			break;
		case "Consumir":
			break;
		case "Mover":
			break;
		case "Buscar":
			break;
		case "Salir":
			break;
			//agregar funcion para ver estadisticas
		default: 
				
		}
	}
	
	public void Dormir() {
		
		Scanner Respuesta = new Scanner(System.in);
		
		System.out.println("Deseas descansar?");
		System.out.println("-SI \n-NO");
		String decision = Respuesta.nextLine();
		
		switch (decision) {
		
		case "SI":
			if(Seguro == true) {
				System.out.println("Te fuiste a descansar a tu hogar.");
				Vida = VidaMax;
				Mana = ManaMax;
				System.out.println("...Recuperaste la salud y mana al dormir.");
			}else {
				System.out.println("No es posible dormir en la ubicacion actual");
			}
			break;
			
		case "NO":
			
			break;
			
		default:
			
			break;
		
		}
	}
		
	
	public void Consumir() {
		
	}
	
	public void Mover() {
		
	}
	
	public void Buscar() {
		
	}
	
}
