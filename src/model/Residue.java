package model;
import java.util.*;

public abstract class Residue{	
	//Atributes
	protected String identifierR;
	protected String nameR;
	protected String origin;
	protected String color;
	protected int timeDecompose;
	
	//Constructor
	public Residue(String identifierR,String nameR,String origin,String color,int timeDecompose){
		this.identifierR = identifierR;
		this.nameR = nameR;
		this.origin = origin;
		this.color = color;
		this.timeDecompose = timeDecompose;
	}
	
	public abstract String getIdentifier();
	public abstract String getName();
	public abstract String getOrigin();
	public abstract String getColor();
	public abstract int getTimeDecompose();
	public abstract double noxToxicity();
	public abstract boolean usability();
}