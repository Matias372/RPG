import java.util.Scanner;

public class Personaje {

	private String Ubicacion="Ciudad"; // Ciudad / Mazmorra
	private int Piso=0;// piso de mazmorra, si esta en ciudad ser cero.
	public String Nombre;
	public boolean Salir = false;
	public boolean Seguro = true; // Ciudad=True / Masmorra= False.  usar estado para verificar si se puede dormir
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
	private float Dinero = 0;
	private float Experiencia =0;
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
				//vuelve solo a Accion();
				break;
			case "MOVER":
				Mover(); //modificar funcion. dependiendo de ubicacion cambiar menu (colocar -Tienda -Explorar ciudad -Mazmorra -Atras)
				break;
			case "SALIR":
				Salir();
				break;
				default:
					System.out.println("No se entendio la respuesta.");
					//vuelve solo a Accion();
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
				//vuelve solo a Accion();
				break;
			case "VER PERSONAJE":
				System.out.println("EN CONSTRUCCION...");
				// generar clase equipo, clase inventario, acomodar estadisticas.
				//vuelve solo a Accion();
				break;
			case "MOVER":
				Mover(); //modificar funcion. dependiendo de ubicacion cambiar menu (colocar -Piso -Ciudad -Atras)
				break;
			case "SALIR":
				Salir();
				break;
				default:
					System.out.println("No se entendio la respuesta.");
					//vuelve solo a Accion();
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
				//vuelve solo a Accion();
			}else {
				System.out.println("No es posible dormir en la ubicacion actual");
				//vuelve solo a Accion();
			}
			break;
			
		case "NO":
			//vuelve solo a Accion();
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
				System.out.println("EN CONSTRUCCION...");
				//vuelve solo a Accion();
				break;
				
			case "Explorar Ciudad":
				System.out.println("EN CONSTRUCCION...");
				//vuelve solo a Accion();
				break;
				
			case "Mazmorra":
				System.out.println("Te diriges a la mazmorra.");
				Ubicacion= "Mazmorra";
				Piso= 1;
				//vuelve solo a Accion();
				break;
				
			case "Atras":
				//vuelve solo a Accion();
				break;
			
			default:
				System.out.println("No se entendio la respuesta.");
				Mover();
				break;
			}
		}
		else if(Ubicacion =="Mazmorra") {
			
			System.out.println("Estas en la Mazmorra en el piso " + Piso + ". Donde deseas ir?");
			System.out.println("-Piso\t-Ciudad\n-Atras");
			String decision = Respuesta.nextLine();
			
			switch (decision) {
			
				case "Piso":
					if(Piso == 1) {
						System.out.println("Estas en el piso " + Piso);
						System.out.println("-Piso" + (Piso++) + "\t-Atras");
						String decision2 = Respuesta.nextLine();
							//SE USA IF YA QUE EL SWITCH NO TOMA "Piso " + (Piso++).
							if (decision2 == "Piso " + (Piso++)) {
								System.out.println("Bajas las escaleras.");
								Piso++;
								//vuelve solo a Accion();
							}else if(decision2 != "Atras" && decision2 != "Piso " + (Piso++)) {
								System.out.println("No se entendio la respuesta.");
								Mover();
								
							}
					}else if(Piso > 1) {
						System.out.println("Estas en el piso " + Piso);
						System.out.println("-Piso" + (Piso--) +"\t-Piso" + (Piso++) + "\n-Atras");
						String decision2 = Respuesta.nextLine();
							//SE USA IF YA QUE EL SWITCH NO TOMA "Piso " + (Piso++).
							if (decision2 == "Piso " + (Piso--)) {
								System.out.println("Subes las escaleras.");
								Piso--;
								//vuelve solo a Accion();
							}else if(decision2 == "Piso " + (Piso++)) {
								System.out.println("Bajas las escaleras.");
								Piso++;
							
							}else if(decision2 != "Atras" && decision2 != "Piso " + (Piso++) && decision2 == "Piso " + (Piso--)) {
								System.out.println("No se entendio la respuesta.");
								Mover();
								
							}
							
					}
					break;
					
				case "Ciudad":
					System.out.println("Te diriges a la ciudad.");
					Ubicacion= "Ciudad";
					Piso= 0;
					//vuelve solo a Accion();
					break;
					
				case "Atras":
					//vuelve solo a Accion();
					break;
				
				default:
					System.out.println("No se entendio la respuesta.");
					Mover();
					break;
			}
		}
		
		
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
				//vuelve solo a Accion();
				break;
				
			default:
				System.out.println("No se entendio la respuesta.");
				Salir();
				break;
		
		}
	}
	
}
