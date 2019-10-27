package ui;

import java.util.*;
import model.*;

public class MainWaste{
	public Enterprise ent1;
	public static Scanner user1;

	public MainWaste(){
		ent1= new Enterprise("Empresa 1");
	}

	public static void main(String[] args){
	MainWaste obj = new MainWaste();
	boolean continuity = true;
	int a = -1;
	user1 = new Scanner(System.in);
	System.out.println("Welcome");
	while(continuity){
		
		switch(a){
		case -1: System.out.println("Please enter an operation (0 for operation list)");
		a = user1.nextInt();
		break;
		
		
		case 0: System.out.printf("%n List of operations: %n(1)Register a product %n(2)Show product list %n(3)Search a residue by its name %n(4)Show residue names by product identifier %n(5)Search the noxivity of a residue by its name %n(6)Calculate usability of a residue %n");
		a--;
		break;
		
		case 1: 
		obj.registerProduct();
		a -= 2;
		break;
		
		case 2:
		System.out.println(obj.productList());
		a -=3;
		break;
		
		case 3:
		System.out.println(obj.resNameSearch());
		a-=4;
		break;
		
		case 4:
		System.out.println(obj.residuesByIdentifier());
		a-=5;
		break;
		
		case 5:
		System.out.println(obj.residueNoxivity());
		a-=6;
		break;
		
		case 6:
		System.out.println(obj.usabilityCalc());
		a-=7;
		break;}
	}
	}
	
	public String registerProduct(){
		Scanner userNmbrs = new Scanner(System.in);
		Scanner userLns = new Scanner(System.in);
		String msg = "";
		System.out.println("Enter the identifier of the product");
		String identifier = userLns.nextLine();
		System.out.println("Enter the name of the product");
		String name = userLns.nextLine();
		System.out.println("Enter a short description of the product");
		String description = userLns.nextLine();
		System.out.println("Enter the amount of residues that this product has");
		int cant = userNmbrs.nextInt();
		ent1.createProduct(identifier, name, description, cant);
		msg = "Product created succesfully";	
		return msg;
	}
	
	public String productList(){
		String msg = ent1.showProducts();
		return msg;
	}
	
	public String resNameSearch(){
		String msg = "";
		System.out.println("Enter the name of the product");
		Scanner userLns = new Scanner(System.in);
		String name = userLns.nextLine();
		msg = ent1.nameSearch(name);
		return msg;
	}
	
	public String residuesByIdentifier(){
		System.out.println("Enter the identifier");
		String msg = "";
		Scanner userNmbrs = new Scanner(System.in);
		String identifier = userNmbrs.nextLine();
		msg = ent1.identifierSearch(identifier);
		return msg;
	}
	
	public double residueNoxivity(){
		double msg = 0;
		System.out.println("Enter the name of the residue");
		Scanner userLns = new Scanner(System.in);
		String name = userLns.nextLine();
		msg = ent1.checkToxicity(name);
		return msg;
	}
	
	public boolean usabilityCalc(){
		boolean a;
		Scanner userLns = new Scanner(System.in);
		System.out.println("Enter the name of the product");
		String name = userLns.nextLine();
		a = ent1.getUsability(name);
		
		return a;	
	}
}