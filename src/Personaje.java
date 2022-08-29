import java.util.Scanner;

public class Personaje {

	String Ubicacion="Ciudad";
	String Nombre;
	boolean Salir = false;
	boolean Seguro = true; // Ciudad=True / Masmorra= False.  usar estado para verificar si se puede dormir
	//ESTADISTICAS
	int Vida = 100;
	int VidaMax = 100; //vida completa
	int Mana = 100;
	int ManaMax =100; //mana
	int Fuerza = 5;
	int Agilidad = 5;
	int Defensa = 5;
	int Inteligencia = 5;
	//variables extra
	float Dinero = 0;
	float Experiencia =0;
	// agregar variable clase
	
	//ACCIONES
	
	public void Accion() {
		
		Scanner Respuesta = new Scanner(System.in);
	
		System.out.println("Cual es tu proxima accion?");
		System.out.println("-Atacar\n-Dormir\n-Consumir\n-Mover\n-Buscar\n-Salir");
		String decision = Respuesta.nextLine();
		switch (decision) {
	
		case "Atacar":
			if(Seguro == false) {//agregar la condicion de que haya encontrado mounstruo. con la funcion buscar.
			
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
			Salir();
			break;
			//agregar funcion para ver estadisticas
		default: 
			System.out.println("No se entendio la respuesta.");
			Accion();
		}
	}
	//-------------------------------------------------------------------------------------------------------------------------
	public void Dormir() {
		
		Scanner Respuesta = new Scanner(System.in);
		
		System.out.println("Deseas descansar?");
		System.out.println("-SI \n-NO");
		String decision = Respuesta.nextLine();
		decision = decision.toUpperCase();
		
		switch (decision) {
		
		case "SI":
			if(Seguro == true) {
				System.out.println("Te fuiste a descansar a tu hogar.");
				Vida = VidaMax;
				Mana = ManaMax;
				System.out.println("...Recuperaste la salud y mana al dormir.");
			}else {
				System.out.println("No es posible dormir en la ubicacion actual");
				Accion();
			}
			break;
			
		case "NO":
			Accion();
			break;
			
		default:
			System.out.println("No se entendio la respuesta.");
			Dormir();
			break;
		
		}
	}
		
	//-------------------------------------------------------------------------------------------------------------------------
	public void Consumir() {
		
	}
	//-------------------------------------------------------------------------------------------------------------------------
	public void Mover() {
		
		Scanner Respuesta = new Scanner(System.in);
		
		System.out.println("Estas en la " + Ubicacion + ". Donde deseas ir?");
		System.out.println("-Ciudad \n-Masmorra");
		String decision = Respuesta.nextLine();
		decision = decision.toUpperCase();
		
		switch (decision) {
		
			case "CIUDAD":
				
				Ubicacion = "CIUDAD";
				Seguro = true;
				System.out.println("Estas en la " + Ubicacion);
				Accion();
					
				break;
				
			case "MASMORRA":
				Ubicacion = "MASMORRA";
				Seguro = false;
				System.out.println("Estas en la " + Ubicacion);
				Accion();
				break;
				
			default:
				System.out.println("No se entendio la respuesta.");
				Mover();
				break;
		
		}
		
	}
	//-------------------------------------------------------------------------------------------------------------------------
	public void Buscar() {
		
	}
	//-------------------------------------------------------------------------------------------------------------------------
	public void Salir() {
		Scanner Respuesta = new Scanner(System.in);
		
		System.out.println("Deseas Salir?");
		System.out.println("-SI \n-NO");
		String decision = Respuesta.nextLine();
		decision = decision.toUpperCase();
		
		switch (decision) {
		
			case "SI":
				
				Salir=true;
					
				break;
				
			case "NO":
				Accion();
				break;
				
			default:
				System.out.println("No se entendio la respuesta.");
				Salir();
				break;
		
		}
	}
	
}
