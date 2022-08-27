import java.util.Scanner;

public class Personaje {

	String Raza;
	String Nombre;
	Clases clase = new Clases();
	boolean Seguro = true; // Hogar=True / Ciudad = False / Masmorra= False.  usar estado para verificar si se puede dormir
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
	
		System.out.println("Deseas descansar?");
		
	}
	
	public void Atacar() {
	
	}
	
	public void Dormir() {
		
		Scanner respuesta = new Scanner(System.in);
		
		System.out.println("Deseas descansar?");
		System.out.println("-SI		-NO");
		String decision = respuesta.nextLine();
		
		switch (decision) {
		
		case "SI":
			if(Seguro == true) {
				System.out.println("...Estas durmiendo.");
				Vida = VidaMax;
				Mana = ManaMax;
				System.out.println("Te recuperaste.");
				
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
