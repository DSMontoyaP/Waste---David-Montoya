package model;
import java.util.*;

public class Inert extends Residue implements Noxus{
	//Atributes
	private String tip;
	
	//Constructor
	public Inert(String identifierR, String nameR, String origin, String color, int timeDecompose, String tip){
		super(identifierR, nameR, origin, color, timeDecompose);
		this.tip = tip;
}
	public String getIdentifier(){
		return identifierR;
	}
	
	public String getName(){
		return nameR;
	}
	
	public String getOrigin(){
		return origin;
	}
	
	public String getColor(){
		return color;
	}
	
	public int getTimeDecompose(){
		return timeDecompose;
	}
	
/**
*<b>Name:</b> noxToxicity.<br>
*This method calculates toxicity of the residue.<br>
*@return returns the value of toxicity<br>
*/
	public double noxToxicity(){
		double toxic = 0;
		double factor = 0;
		if(origin.equalsIgnoreCase("Industrial")){factor = 0.1;}
		
		else if(origin.equalsIgnoreCase("Domiciliary")){factor = 0.05;}
		
		else if(origin.equalsIgnoreCase("Building")){factor = 0.08;}
		
		else if(origin.equalsIgnoreCase("Municipal")){factor = 0.12;}
		
		else if(origin.equalsIgnoreCase("Hospitable")){factor = 0.15;}
		
		else System.out.println("Invalid origin");
		
		return toxic;
	}
	
	public boolean usability(){
		boolean a = false;
		return a;
	}
}