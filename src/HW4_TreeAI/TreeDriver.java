package HW4_TreeAI;
import java.util.Scanner;

public class TreeDriver {
	public static void main(String[]args){
		String pick; //A string to hold the selected operation code.
		Scanner s = new Scanner(System.in);
		System.out.println("L)   Load a tree.\nH    Begin a Help Session."
			+ "\nT)   Traverse the Tree in preorder.\nB)   Go to the " 
			+"previous menu.\nQ)   Quit program");
		pick = "";
		while(!"Q".equalsIgnoreCase(pick)){ //Continue until user wishes to Quit
			pick = null;
			System.out.print("\nChoice> ");
			pick = s.next();
			if (pick.equalsIgnoreCase("L")){ //Load input file and build a tree
				System.out.print("\nEnter the file name> ");
				pick = s.next();
			}
		
			if (pick.equalsIgnoreCase("H")){ //Start help session
				System.out.print("1)   Append one or more lines at the end of file. \n2) "
						+ "  Insert one or more lines before the current line. \n.    Help.  "
						+ "\n0)   List one or more lines.");
			}
		
		
			if (pick.equalsIgnoreCase("T")){ //Traverse the tree in pre-order
				
			}
			
			if (pick.equalsIgnoreCase("B")){//Go back to previous menu
				
			}
		pick = null;
		System.out.println("Thank you for using our automated help services!");
		s.close(); //closes Scanner
		System.exit(0); //exits Program
	}
	}
}
