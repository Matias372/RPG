import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Inventario {


	//Identifica el Cod_id ingresado, busca el objeto en los archivos y lo copia en el objeto para usar.
		public void Identificar(String Cod_Item, Objeto Item) {
			
			try {
				String filePath = "./Datos/Lista de Objetos/" + Cod_Item + ".dat";
				ObjectInputStream input = new ObjectInputStream(new FileInputStream(filePath));
				Item = (Objeto) input.readObject();
				input.close();
			}
			catch (IOException ioe){
				System.err.println("Error leyendo objeto.");
			}
			catch (ClassNotFoundException cnfe){
				System.err.println("Objeto leido no es " + Cod_Item);
			}
		}
	
	
	//GENERAR ATRIBUTOS DE LA CLASE (MATRIZ[][]= OBJECT()?)
	
	
	
	//ACCIONES---------------------------------------------
	
	
	//COLOCAR OBJETO EN INVENTARIO
	//verificar si es consumible o equipo. si es equipo agregarlo en un espacio vacio aunque ya lo tengas, si es consumible aumentear cantidad
	
	//MOVER OBJETO DENTRO DEL INVENTARIO
	
	//VENDER OBJETO
	
	
	
	
	
}
