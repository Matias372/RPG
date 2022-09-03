import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Inventario {

	
		
		public int F=20;
		public int C=6;
	//GENERAR ATRIBUTOS DE LA CLASE (MATRIZ[][]= OBJECT()?)
		Objeto [][] Mochila = new Objeto[F][C];
	
		//UTILIZAR SOLO CUANDO SE GENERA UNA NUEVA PARTIDA Y DESPUES DE GENERAR EL INVENTARIO.
		private void LimpiarMochila(){
			for(int i=0; i < Mochila.length ; i++ ) {
				for(int r=0; r < Mochila[i].length; r++) {
					Mochila[i][r]=null;
				};
			}
		};
		
		
	//---------------------------------------------------------------------------------------------------------	
		
	//Identifica el Cod_id ingresado, busca el objeto en los archivos y lo copia en el objeto para usar.
		public Objeto Identificar(String Cod_Item) {
			
			Objeto Item = new Objeto();
			
			try {
				
				String filePath = "./Datos/Lista de Objetos/" + Cod_Item + ".dat";
				ObjectInputStream input = new ObjectInputStream(new FileInputStream(filePath));
				Item = (Objeto) input.readObject();
				input.close();
				System.out.println(Item.Nombre);
				System.out.println(Item.Categoria);
				System.out.println("----------------------------------");
				
			}
			catch (IOException ioe){
				System.err.println("Error leyendo objeto.");
			}
			catch (ClassNotFoundException cnfe){
				System.err.println("Objeto leido no es " + Cod_Item);
			}
			return Item;
		}
	
	
	//---------------------------------------------------------------------------------------------------------------
	
	
	//ACCIONES---------------------------------------------
	
	
	//COLOCAR OBJETO EN INVENTARIO
	//verifica si es consumible o equipo. si es equipo agregarlo en un espacio vacio aunque ya lo tengas, si es consumible aumentear cantidad
		public void GuardarObjeto(Objeto Item) {
			
			boolean colocado = false;
			if (Item.Categoria == "Consumible") {
				
				
				for(int i=0; i < Mochila.length ; i++ ) {
					for(int r=0; r < Mochila[i].length; r++) {
						
						if(colocado == false && Mochila[i][r].Cod_id == Item.Cod_id) {
							
							Mochila[i][r].Cantidad += 1;  //MODIFICAR MAS ADELANTE PARA QUE SUME LA CANTIDAD ENCONTRADA Ej: 10 pociones
							colocado = true;
							
						};
					}
				}
				
				// SI EL ANTERIOR FOR NO ENCUENTRA EL OBJETO EN EL INVENTARIO LO COLOCA EN UN ESPACIO VACIO
				for(int i=0; i < Mochila.length ; i++ ) {
					for(int r=0; r < Mochila[i].length; r++) {
						
						
						// colocar despues de verificar cada espacio.
						if (colocado == false && Mochila[i][r]==null) {
							
							Mochila[i][r] = Item;//AGREGAR DEBAJO LA CANTIDAD QUE AGREGA AL INVENTARIO
							colocado = true;
							
						}	
					}
				}
				
			}else if (Item.Categoria == "Equipo" || Item.Categoria == "Mision" ) {
				
			
				for(int i=0; i < Mochila.length ; i++ ) {
					for(int r=0; r < Mochila[i].length; r++) {
						
						
						// colocar despues de verificar cada espacio.
						if (colocado == false && Mochila[i][r]==null) {
							
							Mochila[i][r] = Item;//AGREGAR DEBAJO LA CANTIDAD QUE AGREGA AL INVENTARIO
							colocado = true;
							
						}	
					}
				}
			}
			
			
			if(colocado == false) {
				System.out.println("El inventario esta lleno. Vende algunos objetos para hacer espacio.");
			};
			
		}
		
		
	//MOVER OBJETO DENTRO DEL INVENTARIO
	
	//VENDER OBJETO
	
	
	
	
	
}
