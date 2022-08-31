import java.util.Scanner;

public class Personaje {

	String Ubicacion="Ciudad"; // Ciudad / Mazmorra
	int Piso=0;// piso de mazmorra, si esta en ciudad ser cero.
	String Nombre;
	boolean Salir = false;
	boolean Seguro = true; // Ciudad=True / Masmorra= False.  usar estado para verificar si se puede dormir
	//ESTADISTICAS
	int Vida = 100;
	int VidaMax = 100; //vida maximo
	int Mana = 100;
	int ManaMax =100; //mana maximo
	int Fuerza = 5;
	int Agilidad = 5;
	int Defensa = 5;
	int Inteligencia = 5;
	//variables extra
	float Dinero = 0;
	float Experiencia =0;
	// agregar variable clase
	
	//ACCIONES
	
	public void Accion() {//TOMA DE DECISIONES PRINCIPAL
		
		Scanner Respuesta = new Scanner(System.in);
	
		System.out.println("Cual es tu proxima accion?");
		
		if(Ubicacion == "Ciudad") {
			System.out.println("-Dormir\t-Ver Personaje\n-Mover\t-Salir");
			String decision = Respuesta.nextLine();
			decision = decision.toUpperCase();
			
			switch(decision) {
				
			case "DORMIR":
				Dormir();
				break;
			case "VER PERSONAJE":
				System.out.println("EN CONSTRUCCION...");
				// generar clase equipo, clase inventario, acomodar estadisticas.
				Accion();
				break;
			case "MOVER":
				Mover(); //modificar funcion. dependiendo de ubicacion cambiar menu (colocar -Tienda -Explorar ciudad -Mazmorra -Atras)
				break;
			case "SALIR":
				Salir();
				break;
				default:
					System.out.println("No se entendio la respuesta.");
					Accion();
					break;
			}
		}
		else if(Ubicacion == "Mazmorra") {
			System.out.println("-Explorar\t-Ver Personaje\n-Mover\t-Salir");
			String decision = Respuesta.nextLine();
			decision = decision.toUpperCase();
			switch(decision) {
			
			case "EXPLORAR":
				System.out.println("EN CONSTRUCCION...");
				// generar Accion Explorar
				Accion();
				break;
			case "VER PERSONAJE":
				System.out.println("EN CONSTRUCCION...");
				// generar clase equipo, clase inventario, acomodar estadisticas.
				Accion();
				break;
			case "MOVER":
				Mover(); //modificar funcion. dependiendo de ubicacion cambiar menu (colocar -Piso -Ciudad -Atras)
				break;
			case "SALIR":
				Salir();
				break;
				default:
					System.out.println("No se entendio la respuesta.");
					Accion();
					break;
			}
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
		
		if (Ubicacion == "Ciudad") {
			System.out.println("Estas en la " + Ubicacion + ". Donde deseas ir?");
			System.out.println("-Tienda\t-Explorar Ciudad\n-Mazmorra\t-Atras");
			String decision = Respuesta.nextLine();
			
			switch (decision) {
			
			case "Tienda":
				break;
				
			case "Explorar Ciudad":
				break;
				
			case "Mazmorra":
				break;
				
			case "Atras":
				break;
			
			default:
				System.out.println("No se entendio la respuesta.");
				Mover();
				break;
			}
		}
		else if(Ubicacion =="Mazmorra") {
			
		}
		
		
		/*
		Scanner Respuesta = new Scanner(System.in);
		
		System.out.println("Estas en la " + Ubicacion + ". Donde deseas ir?");
		System.out.println("-Ciudad \n-Mazmorra");
		String decision = Respuesta.nextLine();
		
		
		switch (decision) {
		
			case "Ciudad":
				
				Ubicacion = "Ciudad";
				Seguro = true;
				System.out.println("Estas en la " + Ubicacion);
				Accion();
					
				break;
				
			case "Mazmorra":
				Ubicacion = "Mazmorra";
				Seguro = false;
				System.out.println("Estas en la " + Ubicacion);
				Accion();
				break;
				
			default:
				System.out.println("No se entendio la respuesta.");
				Mover();
				break;
		
		}
	*/	
	}
	//-------------------------------------------------------------------------------------------------------------------------
	public void Explorar() {
		
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
