package model;
import java.util.*;

public class Recyclable extends Residue implements Noxus{
	//Atributes
	private String type;
	private String description;
	private boolean usable;
	
	//Constructor
	public Recyclable(String identifierR, String nameR, String origin, String color, int timeDecompose, String type, String description){
		super(identifierR, nameR, origin, color, timeDecompose);
		this.type = type;
		this.description = description;
		usable = true;
}
	public String getIdentifier(){
		return identifierR;
	}
	
	public boolean usability(){
		return usable;
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
		
		System.out.println("Residue is recyclable, thus, a 2% is substracted from the formula");
		toxic = timeDecompose * (factor-0.02);
		
		return toxic;
	}
}