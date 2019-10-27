package model;
import java.util.*;

public class Biodegradable extends Residue implements Noxus{
	//Atributes
	private boolean compostable;
	private boolean usable;
	
	//Constructor
	public Biodegradable(String identifierR, String nameR, String origin, String color, int timeDecompose, boolean compostable){
		super(identifierR, nameR, origin, color, timeDecompose);
		this.compostable = compostable;
	}
	
	public boolean usability(){
		if(timeDecompose < 365 && compostable){usable = true;}
		else usable = false;
		return usable;
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
*<b>Name:</b> usable.<br>
*This method calculates the usability of a residue.<br>
*@return returns a boolean value saying if the residue is either usable(True) or not (False)<br>
*/	
	public boolean usable(){
		if(timeDecompose < 365 && compostable){
			usable = true;
		}
		return usable;
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
		
		if(compostable){toxic = timeDecompose * (factor-0.01);}
		else if(compostable == false){toxic = timeDecompose * factor;}
		
		return toxic;
	}
}