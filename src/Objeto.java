import java.io.Serializable;


public class Objeto implements Serializable{
	
	public String Cod_id= null;
	public String Nombre = null;
	public Integer Cantidad=0;
	public String Categoria = null;
	public String Equipo=null;//Arma, Armadura, Casco, Escudo
	public String Posion_Tipo = null; // Vida - Mana
	public Integer Mano=1;
	public String Descripcion = null;
	public Integer ValorCompra= 0;
	public Integer ValorVenta= 0;
	
	
	//bonificacion de atributos / Pociones
	Integer Equipo_Vida_Bonif = 0;
	Integer Equipo_Mana_Bonif = 0;
	Integer Equipo_Fuerza_Bonif = 0;
	Integer Equipo_Agilidad_Bonif = 0;
	Integer Equipo_Defensa_Bonif = 0;
	Integer Equipo_Inteligencia_Bonif = 0;
	Integer Equipo_Recupera_Vida = 0;
	Integer Equipo_Recupera_Mana = 0;
	
	//agregar estadisticas para equipamiento
	public Integer Obj_ATK = 0;
	public Integer Obj_DEF = 0;
	
	
	
	
	
	
}


