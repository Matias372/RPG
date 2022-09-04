import java.util.ArrayList;


public class TEST {

	public static void main(String args[]) {
		
		String Codigo="Obj0001";
		Objeto Obj_Temporal = new Objeto();
		Inventario TestMochila = new Inventario();
		
		System.out.println(Obj_Temporal.Nombre);
		System.out.println(Obj_Temporal.Categoria);
		System.out.println("----------------------------------");
		
		Obj_Temporal= TestMochila.Identificar(Codigo);
		
		System.out.println(Obj_Temporal.Nombre);
		System.out.println(Obj_Temporal.Categoria);
	
	
		//TestMochila.Mochila[2][2]= Obj_Temporal;
		
		//System.out.println(TestMochila.Mochila[2][2].Cod_id);
		
		
		ArrayList<Objeto> Almacenamiento = new ArrayList<Objeto>();
		Almacenamiento.add(Obj_Temporal);
		System.out.println(Almacenamiento.get(0).Cantidad);
		Almacenamiento.get(0).Cantidad++;
		System.out.println(Almacenamiento.get(0).Cantidad);

	}
}
