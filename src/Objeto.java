import java.io.Serializable;


public class Objeto implements Serializable{
	
	public String Cod_id= null;
	public String Nombre = null;
	public int Cantidad=0;
	public String Categoria = null;
	public String Descripcion = null;
	public int ValorCompra= 0;
	public int ValorVenta= 0;
	
	
	//bonificacion de atributos / Pociones
	public String Bonif_Atributo1=null; // si es pocion colocar Vida o Mana y abajo la cantidad que recupera.
	public int Bonif_cant1=0;
	public String Bonif_Atributo2=null;
	public int Bonif_cant2=0;
	public String Bonif_Atributo3=null;
	public int Bonif_cant3=0;
	public String Bonif_Atributo4=null;
	public int Bonif_cant4=0;
	
	//agregar estadisticas para equipamiento
	public int Obj_ATK = 0;
	public int Obj_DEF = 0;
	
	
	
	
	
	
}


