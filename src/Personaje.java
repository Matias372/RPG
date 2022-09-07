import java.util.ArrayList;
import java.util.Scanner;

public class Personaje {

	private String Ubicacion="Ciudad"; // Ciudad / Mazmorra
	private Integer Piso=0;// piso de mazmorra, si esta en ciudad ser cero.
	public String Nombre;
	public boolean Salir = false;
	public boolean Seguro = true; // Ciudad=True / Masmorra= False.  usar estado para verificar si se puede dormir
	
	//ESTADISTICAS BASE
	Integer Vida_Base = 100;
	Integer Mana_Base = 100;
	Integer Fuerza_Base = 5;
	Integer Agilidad_Base = 5;
	Integer Defensa_Base = 5;
	Integer Inteligencia_Base = 5;
	
	//ESTADISTICAS BONIF_EQUIPO
	Integer Arma_Bonif_Vida = 0;
	Integer Armadura_Bonif_Vida = 0;
	Integer Casco_Bonif_Vida = 0;
	Integer Escudo_Bonif_Vida = 0;
	Integer Arma_Bonif_Mana = 0;
	Integer Armadura_Bonif_Mana = 0;
	Integer Casco_Bonif_Mana = 0;
	Integer Escudo_Bonif_Mana = 0;
	Integer Arma_Bonif_Atk = 0;
	Integer Armadura_Bonif_Atk = 0;
	Integer Casco_Bonif_Atk = 0;
	Integer Escudo_Bonif_Atk = 0; 
	Integer Arma_Bonif_Agi = 0;
	Integer Armadura_Bonif_Agi = 0;
	Integer Casco_Bonif_Agi = 0;
	Integer Escudo_Bonif_Agi = 0;
	Integer Arma_Bonif_Def = 0;
	Integer Armadura_Bonif_Def = 0;
	Integer Casco_Bonif_Def = 0;
	Integer Escudo_Bonif_Def = 0;
	Integer Arma_Bonif_Int = 0;
	Integer Armadura_Bonif_Int = 0;
	Integer Casco_Bonif_Int = 0;
	Integer Escudo_Bonif_Int = 0;
	
	//ESTADISTICAS Bonif
	Integer Vida_Bonif = Arma_Bonif_Vida + Armadura_Bonif_Vida + Casco_Bonif_Vida + Escudo_Bonif_Vida;
	Integer Mana_Bonif = Arma_Bonif_Mana + Armadura_Bonif_Mana + Casco_Bonif_Mana + Escudo_Bonif_Mana;
	Integer Fuerza_Bonif = Arma_Bonif_Atk + Armadura_Bonif_Atk + Casco_Bonif_Atk + Escudo_Bonif_Atk;
	Integer Agilidad_Bonif = Arma_Bonif_Agi + Armadura_Bonif_Agi + Casco_Bonif_Agi + Escudo_Bonif_Agi;
	Integer Defensa_Bonif = Arma_Bonif_Def + Armadura_Bonif_Def + Casco_Bonif_Def + Escudo_Bonif_Def;
	Integer Inteligencia_Bonif = Arma_Bonif_Int + Armadura_Bonif_Int + Casco_Bonif_Int + Escudo_Bonif_Int;
	
	
	//ESTADISTICAS TOTALES
	Integer Mana_Total = Vida_Base + Vida_Bonif; //mana maximo
	Integer Vida_Total = Mana_Base + Mana_Bonif; //vida maximo
	Integer Fuerza_Total = Fuerza_Base + Fuerza_Bonif;
	Integer Agilidad_Total = Agilidad_Base + Agilidad_Bonif;
	Integer Defensa_Total = Defensa_Base + Defensa_Bonif;
	Integer Inteligencia_Total = Inteligencia_Base + Inteligencia_Bonif;
	
	//ESTADISTICAS ADAPTABLES (que se van modificando a medida que juega)
	Integer Vida = Vida_Total;
	Integer Mana = Mana_Total;
	
	//variables extra
	public float Dinero = 0;
	public float Experiencia =0;
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
				Mover(); 
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
				System.out.println(Vida);
				System.out.println(Mana);
				// generar clase equipo, clase inventario, acomodar estadisticas.
				//vuelve solo a Accion();
				break;
			case "MOVER":
				Mover(); 
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
				Vida = Vida_Total;
				Mana = Mana_Total;
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
	
	
	public void VerificarEquipoBonif (Objeto Arma_bonif, Objeto Armadura_bonif, Objeto Casco_bonif, Objeto Escudo_bonif) {
		
	}
	
	//Usar Posion.
	public void Usar( ArrayList <Objeto> inventario ) {
		
		Scanner Respuesta = new Scanner(System.in);
		System.out.println("Deseas usar un objeto?"); //verificar si quiere vender. if
		System.out.println("-SI\n-NO");
		String decision = Respuesta.nextLine();
		decision = decision.toUpperCase();
		
		if(decision == "SI") {
			
			for(Integer i=0; i < inventario.size(); i++) {
				System.out.println("- "+inventario.get(i).Nombre);
			}
			System.out.println("- Cancelar");
			// preguntar cual quiere Vender. 
			boolean OK = false;
			while (OK == false) { // si no ubica el objeto repite la pregunta.
				System.out.println("Cual objeto deseas usar?");
				decision = Respuesta.nextLine();
				
				if(decision == "Cancelar") {
					OK = true; 
				}else{
					
					for(Integer i=0; i < inventario.size() ; i++ ) {
						
						if(inventario.get(i).Nombre == decision) {
							OK = true;
							//rellenar if xxxxx.Posion_Tipo ==
							if(inventario.get(i).Posion_Tipo == "Vida") {
								
								Vida = Math.min((Vida + inventario.get(i).Equipo_Recupera_Vida), Vida_Total); //devuelve el numero mas chico asi que si la vida recuperada es mayor a la vida total solo devuelve la total.
								
							}else if(inventario.get(i).Posion_Tipo == "Mana") {
								
								Mana = Math.min((Mana + inventario.get(i).Equipo_Recupera_Mana), Mana_Total); //devuelve el numero mas chico asi que si la Mana recuperada es mayor a la Mana total solo devuelve la total.
								
							}
							
						}else {
							System.out.println("No se entendio la respuesta.");
						}
					}
			
				}
			}
		}else if (decision == "NO") {
			
		}else {
			System.out.println("No se entendio la respuesta.");
		};
		
		
		
	}
	
}
