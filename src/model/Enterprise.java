package model;
import java.util.*;

public class Enterprise{
	//Atributes
	private ArrayList<Product> ar;
	private Scanner user1;
	private Scanner user2;
	private String name;
	
	public Enterprise(String name){
		this.name = name;
		ar = new ArrayList<>();		
	}


/**
*<b>Name:</b> createProduct.<br>
*This method creates a product.<br>
*@param identifier the identifier of the product.<br>
*@param name the name of the product. <br>
*@param description the description of the product.<br>
*@param cant the quantity of residues of the product
*<b>Pos:</b> product created succesfully.<br>
*@return return a message that the product was created succesfully<br>
*/	
	public String createProduct(String identifier, String name, String description, int cant){
		String msg = "";
		ar.add(new Product(identifier, name, description, cant));
		msg = "Product created succesfully";
		return msg;
	}

/**
*<b>Name:</b> nameSearch.<br>
*This method sends the name to the product's method.<br>
*@param name the name of the residue.<br>
*@return return a message with either an error or all the information of the residue.<br>
*/
	public String nameSearch(String name){
		String msg = "";
		boolean continuity = true;
		for(int i = 0; i < ar.size() && continuity; i++){
			if((ar.get(i).checkResidueName(name)).equalsIgnoreCase(name)){
					msg = ar.get(i).getInfoByName(name);
					continuity = false;
				}
			else msg = "Residue not found";
		}
	return msg;}
	
	
/**
*<b>Name:</b> getInfoByName.<br>
*This method sends the identifier to the product's method.<br>
*@param identifier the name of the residue.<br>
*@return return a message with either an error or all the information of the residue.<br>
*/
	public String identifierSearch(String identifier){
		String msg = "";
		boolean continuity = true;
		for(int i = 0; i < ar.size() && continuity; i++){
			if((ar.get(i).getIdentifier()).equalsIgnoreCase(identifier)){
					msg = ar.get(i).getInfoByIdentifier(identifier);
					continuity = false;
			}
			
			else msg = "Product not found";
		}
		return msg;
	}
	
	
/**
*<b>Name:</b> showProducts.<br>
*This method shows the products in the arraylist.<br>
*@return return a message with all the products on the arraylist.<br>
*/	
	public String showProducts(){
		String msg = "";
		for(int i = 0; i<ar.size(); i++){
			msg += ar.get(i).getName() + "\n";
		}
		
		return msg;
	}
	
/**
*<b>Name:</b> checkToxicity.<br>
*This method sends the name of the residue to the product.<br>
*@param name the name of the residue.<br>
*@return double of the toxicity value of the residue.<br>
*/
	public double checkToxicity(String name){
		double toxicity = 0;
		double b = 0;
		boolean continuity = true;
		for(int i = 0; i < ar.size() && continuity; i++){
			if((ar.get(i).checkResidueName(name)).equalsIgnoreCase(name)){
					b = ar.get(i).getToxicity(name);
					continuity = false;
				}
			
			
			else b = 0;
		}
		return b;
	}	
	
	public String resourceReport(){
		String msg = "";
		for(int i = 0; i<ar.size(); i++){
			msg += "\n" +" "+ i + ". " + ar.get(i).resourceInform();
		
		}
		
		return msg;
	}
	
/**
*<b>Name:</b> getUsability.<br>
*This method sends the name to the product's method.<br>
*@param name the name of the residue.<br>
*@return a boolean value of the usability result.<br>
*/
	public boolean getUsability(String name){
		Scanner user1 = new Scanner(System.in);
		boolean a = false;
		boolean continuity = true;
		for(int i = 0; i<ar.size() && continuity; i++){
			if((ar.get(i).getName()).equalsIgnoreCase(name)){
				System.out.println("Enter the name of the residue to calculate on " + ar.get(i).getName());
				String k = user1.nextLine();
				a = ar.get(i).getUsabilityR(k);
			}
		}
		return a;
	}
}