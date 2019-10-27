package model;
import java.util.*;


public class Product{
	//Atributes
	private String identifier;
	private String name;
	private String description;
	private int cant;
	private	ArrayList<Residue> residues;
	private Scanner user1; 
	private Scanner user2;
	
	//Constructor
	public Product(String identifier, String name, String description, int cant){
		this.identifier = identifier;
		this.name = name;
		this.description = description;
		residues = new ArrayList<>();
		int a = cant;
		user1 = new Scanner(System.in);
		user2 = new Scanner(System.in);
		for(int i = 0; i<a; i++){
			System.out.println("Residue " + (i+1));
			System.out.println("Select type of residue (1)Biodegradable (2)Inert (3)Recyclable");
			int c = user1.nextInt();
			
			
			
			if(c == 1){
			System.out.println("Enter the identifier");
			String identifierR = user2.nextLine();
			System.out.println("Enter the name");
			String nameR = user2.nextLine();
			System.out.println("Enter the origin (1)Industrial (2)Municipal (3)Domiciliary (4)Hospitable (5)Building");
			int originChoiche = user1.nextInt();
			String origin = "";
			if(originChoiche == 1){origin = "Industrial";}
			else if(originChoiche == 2){origin = "Municipal";}
			else if(originChoiche == 3){origin = "Domiciliary";}
			else if(originChoiche == 4){origin = "Hospitable";}
			else if(originChoiche == 5){origin = "building";}
			else origin = "Invalid";
			System.out.println("Enter the color");
			String color = user2.nextLine();
			System.out.println("Enter the time decomposing (in days)");
			int timeDecompose = user1.nextInt();
			boolean compostable = false;
			System.out.println("Is the residue compostable? (1)Yes (2)No");
			int choice = user1.nextInt();
			if(choice == 1){compostable = true;}
			else if(choice == 2){compostable = false;}
			Biodegradable d = createResidue(identifierR, nameR, origin, color, timeDecompose, compostable);
			residues.add(d);
			System.out.println("Biodegradable product created");}
			
			else if(c == 2){
			System.out.println("Enter the identifier");
			String identifierR = user2.nextLine();
			System.out.println("Enter the name");
			String nameR = user2.nextLine();
			System.out.println("Enter the origin");
			String origin = user2.nextLine();
			System.out.println("Enter the color");
			String color = user2.nextLine();
			System.out.println("Enter the time to decompose (in days)");
			int timeDecompose = user1.nextInt();
			System.out.println("Enter a tip for the lessening of use of this residue");
			String tip = user2.nextLine();
			Inert d = createResidue (identifierR, nameR, origin, color, timeDecompose, tip);
			System.out.println("Inert residue created");
			residues.add(d);}
			
			
			else if(c == 3){
			System.out.println("Enter the identifier");
			String identifierR = user2.nextLine();
			System.out.println("Enter the name");
			String nameR = user2.nextLine();
			System.out.println("Enter the origin");
			String origin = user2.nextLine();
			System.out.println("Enter the color");
			String color = user2.nextLine();
			System.out.println("Enter the time to decompose (in days)");
			int timeDecompose = user1.nextInt();
			System.out.println("Enter the type");
			String type = user2.nextLine();
			System.out.println("Enter a short description of the residue");
			String descriptionR = user2.nextLine();
			Recyclable d = createResidue(identifierR, nameR, origin, color, timeDecompose, type, descriptionR);
			residues.add(d);
			System.out.println("Recyclable product created");}
		}
		
		System.out.println("Product " + name + " created correctly with " + residues.size() + " residues.");
	}
	
	
/**
*<b>Name:</b> createResidue.<br>
*This method creates a biodegradable residue into the arraylist.<br>
*@param identifierR identifier of the residue.<br>
*@param nameR the name of the residue.<br>
*@param origin the origin of the residue.<br>
*@param color the color of the residue.<br>
*@param timeDecompose the days that the product has already been decomposing.<br>
*@param compostable boolean with the choice made by the user of the compostability of the product.<br>
*<b>Pos:</b> Biodegradable residue created.<br>
*@return return a Biodegradable object<br>
*/

	public Biodegradable createResidue(String identifierR, String nameR, String origin, String color, int timeDecompose, boolean compostable){
		Biodegradable a = new Biodegradable(identifierR, nameR,  origin,  color, timeDecompose, compostable);
		return a;
	}
	
/**
*<b>Name:</b> createResidue.<br>
*This method creates an inert residue into the arraylist.<br>
*@param identifierR identifier of the residue.<br>
*@param nameR the name of the residue.<br>
*@param origin the origin of the residue.<br>
*@param color the color of the residue.<br>
*@param timeDecompose the days that the product has already been decomposing.<br>
*@param tip tip for the disposal of the product.<br>
*<b>Pos:</b> Inert residue created.<br>
*@return return a Inert object<br>
*/
	public Inert createResidue(String identifierR,String nameR,String origin,String color,int timeDecompose,String tip){
		Inert a = new Inert(identifierR, nameR,  origin,  color, timeDecompose, tip);
		return a;
	}
	
/**
*<b>Name:</b> createResidue.<br>
*This method creates an recyclable residue into the arraylist.<br>
*@param identifierR identifier of the residue.<br>
*@param nameR the name of the residue.<br>
*@param origin the origin of the residue.<br>
*@param color the color of the residue.<br>
*@param timeDecompose the days that the product has already been decomposing.<br>
*@param type type of the recyclable residue.<br>
*@param description description of the recyclable residue.<br>
*<b>Pos:</b> Recyclable residue created.<br>
*@return return a Recyclable object<br>
*/		
	public Recyclable createResidue(String identifierR,String nameR,String origin,String color,int timeDecompose,String type,String description){
		Recyclable a = new Recyclable(identifierR, nameR, origin, color, timeDecompose, type, description);
		return a;
	}
	
	public String getIdentifier(){
		return identifier;
	}
	
	public String getName(){
		return name;
	}
	
/**
*<b>Name:</b> checkResidueName.<br>
*This method checks if the name of the residue is in the arraylist.<br>
*@param name the name of the residue. <br>
*@return message with either the name of the residue or with a message with an error<br>
*/
	public String checkResidueName(String name){
		String msg = "";
		boolean continuity = true;
		
		for(int i = 0; i<residues.size() && continuity; i++){
			if((residues.get(i).getName()).equalsIgnoreCase(name)){
				msg = name;
				continuity = false;
			}
		}
		
		if(continuity){
			msg = "There is no resource with that name";
		}
		
	return msg;}
	
/**
*<b>Name:</b> getInfoByName.<br>
*This method returns the information of a residue.<br>
*@param name the name of the residue.<br>
*@return returns a message with either an error or all the information of the residue.<br>
*/
	public String getInfoByName(String name){
		String msg = "";
		boolean continuity = true;
		for(int i = 0; i<residues.size() && continuity; i++){
			if(((residues.get(i).getName()).equalsIgnoreCase(name))){
				msg += residues.get(i).getIdentifier() + "\n" + residues.get(i).getName() + "\n" + residues.get(i).getOrigin() + "\n" + residues.get(i).getColor() + "\n" + residues.get(i).getTimeDecompose() + "\n" + " Produced by:" + getName();
			}
			
			else msg = "There are no residues with that name";			
		}
		
		return msg;
	}


/**
*<b>Name:</b> getInfoByName.<br>
*This method gets the information of the residues in a product.<br>
*@param idtf the identifier of the product.<br>
*@return returns a message with the names of the residues in the product.<br>
*/	
	public String getInfoByIdentifier(String idtf){
		String msg = "";
		if(idtf.equals(identifier)){
		for(int i = 0; i<residues.size(); i++){
			msg += "\n" + residues.get(i).getName();
		}
		}
		return msg;
	}
	
/**
*<b>Name:</b> getInfoByName.<br>
*This method shows the usability of a residue.<br>
*@param name the name of the residue.<br>
*@return returns a boolean value of the usability of a residue.<br>
*/
	public boolean getUsabilityR(String name){
		boolean a = false;
		boolean continuity = true;
		for(int i = 0; i<residues.size() && continuity; i++){
			if((residues.get(i).getName()).equalsIgnoreCase(name)){
			
			if(residues.get(i) instanceof Recyclable){
			a = true;}
			
			else if(residues.get(i) instanceof Biodegradable){
			a = residues.get(i).usability();}
			
			
			else if(residues.get(i) instanceof Inert){
				System.out.println(residues.get(i).getName() + " is an inert residue, thus, it does not have usability");
				a = false;
				}
				
			}
			continuity = false;
			
			}
			return a;
	}	
	
/**
*<b>Name:</b> getInfoByName.<br>
*This method gives the toxicity value of a residue.<br>
*@param name the name of the residue.<br>
*@return returns the numeric value of the toxicity of a residue.<br>
*/
	
	public double getToxicity(String name){
		double t = 0;
		boolean continuity = true;
		for(int i = 0; i<residues.size() && continuity; i++){
			if((residues.get(i).getName()).equalsIgnoreCase(name)){
				t = residues.get(i).noxToxicity();
				continuity = false;
			}
		}
		return t;
	}
	
/**
*<b>Name:</b> getInfoByName.<br>
*This method shows the information of all resources in the product.<br>
*@return returns a message with all the information of the residues.<br>
*/
	public String resourceInform(){
		String msg = "";
		for(int i = 0; i<residues.size(); i++){
			if(residues.get(i) instanceof Recyclable){
			msg += "\n Residue type: Recyclable" + "\n" + residues.get(i).getIdentifier() + "\n" + residues.get(i).getName() + "\n" + residues.get(i).getOrigin() + "\n" + residues.get(i).getColor() + "\n" + residues.get(i).getTimeDecompose() + "\n" + " Produced by:" + getName();
			}
			
			else if(residues.get(i) instanceof Biodegradable){
			msg += "\n Residue type: Biodegradable" + "\n" + residues.get(i).getIdentifier() + "\n" + residues.get(i).getName() + "\n" + residues.get(i).getOrigin() + "\n" + residues.get(i).getColor() + "\n" + residues.get(i).getTimeDecompose() + "\n" + " Produced by:" + getName();
			}	
			
			else if(residues.get(i) instanceof Inert){
			msg += "\n Residue type: Inert" + "\n" + residues.get(i).getIdentifier() + "\n" + residues.get(i).getName() + "\n" + residues.get(i).getOrigin() + "\n" + residues.get(i).getColor() + "\n" + residues.get(i).getTimeDecompose() + "\n" + " Produced by:" + getName();
			}				
		}
		return msg;
	}
}

