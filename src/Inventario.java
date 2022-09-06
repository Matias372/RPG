import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class Inventario {

	
		ArrayList<Objeto> Mochila = new ArrayList<Objeto>();
		Objeto Arma = new Objeto(); 
		Objeto Armadura = new Objeto();
		Objeto Casco = new Objeto();
		Objeto Escudo = new Objeto();
	
		//UTILIZAR SOLO CUANDO SE GENERA UNA NUEVA PARTIDA Y DESPUES DE GENERAR EL INVENTARIO.
		private void LimpiarMochila(){
			Mochila.clear();
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
	//COLOCAR OBJETO EN INVENTARIO
	
		public void GuardarObjeto(Objeto Item, int Limit, int Cantidad) {
			
			boolean colocado = false;
			if (Item.Categoria == "Consumible") {
				
				
				for(int i=0; i < Mochila.size() ; i++ ) {
						
					if(colocado == false && Mochila.get(i).Cod_id == Item.Cod_id) {
							
						Mochila.get(i).Cantidad += Cantidad;  //MODIFICAR MAS ADELANTE PARA QUE SUME LA CANTIDAD ENCONTRADA Ej: 10 pociones
						colocado = true;
							
					};
					
				}
				
				// SI EL ANTERIOR FOR NO ENCUENTRA EL OBJETO EN EL INVENTARIO LO COLOCA EN UN ESPACIO VACIO
				if(colocado == false && Mochila.size() < Limit) {
					
					Item.Cantidad = Cantidad;
					Mochila.add(Item);
					
				}
				
			}else if (Item.Categoria == "Equipo" || Item.Categoria == "Mision" ) {
				
					
						
					if (colocado == false && Mochila.size() < Limit) {
							
						Mochila.add(Item);
						colocado = true;
							
					}	
					
				
			}
			
			
			if(colocado == false) {
				System.out.println("El inventario esta lleno. Vende algunos objetos para hacer espacio.");
				// Preguntar si quiere intercambiarlo por otro objeto. If(si){
				Scanner Respuesta = new Scanner(System.in);
				
				while(colocado == false) {
					
					System.out.println("Deseas intercambiarlo por un objeto del inventario?");
					System.out.println("-SI\n-NO");
					String decision = Respuesta.nextLine();
					decision = decision.toUpperCase();
					
					if(decision == "SI") {
						
						//for{for{}} para mostrar todos los objetos
						for(int i=0; i < Mochila.size(); i++) {
							System.out.println("- "+Mochila.get(i).Nombre);
						}
						System.out.println("- Descartar");
						// preguntar cual quiere cambiar. 
						System.out.println("Cual objeto deseas cambiar por "+ Cantidad + " " + Item.Nombre);
						decision = Respuesta.nextLine();
						boolean Ubicado =false;
							if(decision == "Descartar") {
								colocado = true;
							}else{
								
								for(int i=0; i < Mochila.size() ; i++ ) {
									
									if(colocado == false && Mochila.get(i).Nombre == decision) {// ubicar objeto por nombre.
										
										Ubicado=true;
										System.out.println("Estas seguro de cambiar " + Mochila.get(i).Cantidad + " " + Mochila.get(i).Nombre + "por " + Cantidad + " " + Item.Nombre + "?");
										decision = Respuesta.nextLine();
										decision = decision.toUpperCase();
										
										if(decision == "SI") {
											Item.Cantidad = Cantidad;
											Mochila.set(i,Item);
											colocado = true;
										}else if(decision == "NO") {
											
										}else {
											System.out.println("No se entendio la respuesta.");
										}
											
									};
									
								}
								
							}
							if(Ubicado == false) {
								System.out.println("No se entendio la respuesta.");
							}
					}
					
				}
			};
			
		}
		
	
	//---------------------------------------------------------------------------------------------------------------
	//VENDER OBJETO
	public int Vender() {
		
		int x=0;
		Scanner Respuesta = new Scanner(System.in);
		System.out.println("Deseas vender un objeto?"); //verificar si quiere vender. if
		System.out.println("-SI\n-NO");
		String decision = Respuesta.nextLine();
		decision = decision.toUpperCase();
			if(decision == "SI") {
				
				for(int i=0; i < Mochila.size(); i++) {
					System.out.println("- "+Mochila.get(i).Nombre);
				}
				System.out.println("- Cancelar");
				
				// preguntar cual quiere Vender. 
				System.out.println("Cual objeto deseas vender?");
				decision = Respuesta.nextLine();
				boolean Ubicado =false;
				if(decision == "Atras") {
					
				}else{
					
					for(int i=0; i < Mochila.size() ; i++ ) {
						
						if(Mochila.get(i).Nombre == decision) {//VENDE EQUIPO
							
							Ubicado=true;
							if(Mochila.get(i).Categoria == "Equipo") {
								System.out.println("Estas seguro de vender "  + Mochila.get(i).Nombre + "?");
								decision = Respuesta.nextLine();
								decision = decision.toUpperCase();
								
								if(decision == "SI") {
									
									x = Mochila.get(i).ValorVenta;
									Mochila.remove(i);
									
								}else if(decision == "NO") {
									Vender();
								}else {
									System.out.println("No se entendio la respuesta.");
									Vender();
								}
							}else if(Mochila.get(i).Categoria == "Consumible") { // VENDE CONSUMIBLE
								
								boolean Ok = false;
								
								while(Ok == false) {
									System.out.println("tienes " + Mochila.get(i).Cantidad + ". Cuantos deseas vender?");
									int Cant_Vender = Respuesta.nextInt();
									
									if(Cant_Vender <= Mochila.get(i).Cantidad) {
										System.out.println("Estas seguro de vender " + Mochila.get(i).Cantidad + " " + Mochila.get(i).Nombre + "?");
										decision = Respuesta.nextLine();
										decision = decision.toUpperCase();
										
										if(decision == "SI") {
											
											Ok=true;
											x = (Mochila.get(i).ValorVenta * Cant_Vender);
											
											if(Cant_Vender == Mochila.get(i).Cantidad) {
												Mochila.remove(i);
											}else {
												Mochila.get(i).Cantidad -= Cant_Vender;
											}
											
										}else if(decision == "NO") {
											//vuelve solo a preguntar la cantidad a vender
										}else {
											System.out.println("No se entendio la respuesta.");
										}
									}
									
								}
							}
						};
						
					}
					
				}
				if(Ubicado == false) {
					System.out.println("No se entendio la respuesta.");
				}
				
			}else if (decision == "NO") {
				
			}else {
				System.out.println("No se entendio la respuesta.");
				Vender();
			};
		//for{for{}} para mostrar todos los objetos
		// preguntar cual quiere vender. 
		// ubicar objeto por nombre.
		//verificar categoria. if Consumible{
		//Consumible: preguntar cantidad
		//verificar que CantidadAVender <= Objeto.Cantidad
		//aumentar x = (Objeto.Valor * CantidadAVender)
		// Disminuir la Objeto.Cantidad-= CantidadAVender
		//if (Objeto.Cantidad == 0){ Matriz[][]==null;
		//
		
		return x;
		
	}
	
	//---------------------------------------------------------------------------------------------------------------	
	//Organizar OBJETO DENTRO DEL INVENTARIO
	public void OrganizarAZ() {
		
	}
	
	
	//VER INVENTARIO. DESCRIPCIONES DE OBJETOS, SI ES EQUIPO PODER EQUIPARLO... PASARLO A OBJETO (Arma, Armadura, Casco, Escudo)
	public void VerInventario() {
		
	}
	
	public void Equipar() { 
		
		
		
	}
}
