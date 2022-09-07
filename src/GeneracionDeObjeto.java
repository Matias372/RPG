import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GeneracionDeObjeto {

	public static void main(String args[]) {
		

		//----------------------------------------------------------------------------------------------------------------------------
		// GENERACION DE POSION BASICA CON VARIABLES
		Objeto Posion_Basica = new Objeto();
		Posion_Basica.Cod_id= "Obj0001";
		Posion_Basica.Nombre = "Posion basica";
		Posion_Basica.Descripcion="posion basica. cura 10 de vida.";
		Posion_Basica.ValorCompra= 100;
		Posion_Basica.ValorVenta=20;
		Posion_Basica.Categoria= "Consumible";
		Posion_Basica.Posion_Tipo= "Vida";
		Posion_Basica.Equipo_Recupera_Vida = 25;
		
		
		//GUARDAR Posion_Basica EN ARCHIVO
				try {
					String filePath = "./Datos/Lista de Objetos/Obj0001.dat";
					ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filePath));
					output.writeObject(Posion_Basica);
					output.close();
				}
				catch (IOException ioe){
					System.err.println("Error salvando objeto.");
				}
		//----------------------------------------------------------------------------------------------------------------------------
		
		// GENERACION DE DAGA VIEJA CON VARIABLES
		Objeto Daga_Vieja = new Objeto();
		Daga_Vieja.Cod_id= "Eq0001";
		Daga_Vieja.Nombre= "Daga Vieja";
		Daga_Vieja.Descripcion="Una vieja daga oxidada.";
		Daga_Vieja.ValorCompra= 200;
		Daga_Vieja.ValorVenta=25;
		Daga_Vieja.Categoria= "Equipo";
		Daga_Vieja.Equipo= "Arma";
		Daga_Vieja.Obj_ATK= 1;
		
		
		//GUARDAR Posion_Basica EN ARCHIVO
				try {
					String filePath = "./Datos/Lista de Objetos/Eq0001.dat";
					ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filePath));
					output.writeObject(Daga_Vieja);
					output.close();
				}
				catch (IOException ioe){
					System.err.println("Error salvando objeto.");
				}
		//----------------------------------------------------------------------------------------------------------------------------
				
		
		
	}	
}
