package node;
/** The <code>Editor</code> class receives commands from 
 * the user to create and manipulate a LineList.
 *    
 *
 * @author Rezaul Hassan 
 *    e-mail: rezaul_h@ymail.com
 *    Stony Brook ID: 108822849
 **/
import java.util.Scanner;
import java.util.Date;


public class Editor {
	public static void main(String[]args){
		LineList list = new LineList();
		int counter;
		int counter2;
		String pick; //A string to hold the selected operation code.
		Scanner s = new Scanner(System.in);
		System.out.println("CSE214 Editor, Version 1.0, " + new Date());
		System.out.println("A)   Append one or more lines at the end of file. \nI) "
			+ "  Insert one or more lines before the current line. \nH    Help.  "
			+ "\nL)   List one or more lines. \nP)   Move to the previous line. "
			+ "\nN)   Move to the next line. \nQ)   Quit program \nR)   Remove "
			+ "the current line.");
		pick = "";	
		while(!"Q".equalsIgnoreCase(pick)){ //Continue until user wishes to quit
			pick = null;
			System.out.print("\n> ");
			String[] holder = new String[3];
			holder = s.nextLine().replaceFirst("^ ", "").split(" "); //TRIM, spaces causing error
			pick = holder[0];
			
			if (pick.equalsIgnoreCase("A")){ //Append line(s) at end of file
				counter = Integer.parseInt(holder[1]);
				int temp = counter;
				while(counter != 0){
					for (int i = 0; i < counter; counter--){
						System.out.print(list.cursorLineNo()+1 + "*");
						list.append(s.nextLine());
					}
				}
				System.out.println(list.getSize()); //Check size
				
			}
		
			if (pick.equalsIgnoreCase("I")){ //Insert line(s) before current line
				counter = Integer.parseInt(holder[1]);
				int temp = counter;
				while(counter != 0){
					for (int i = 0; i < counter; counter--){
						System.out.print(list.cursorLineNo() + "*");
						list.insertBeforeCursor(s.nextLine());
					}
				}
				System.out.println(list.getSize()); //check size
			}
		
			if (pick.equalsIgnoreCase("H")){ //Help
				System.out.print("A)   Append one or more lines at the end of file. \nI) "
						+ "  Insert one or more lines before the current line. \nH    Help.  "
						+ "\nL)   List one or more lines. \nP)   Move to the previous line. "
						+ "\nN)   Move to the next line. \nQ)   Quit program \nR)   Remove "
						+ "the current line.");
			}
		
			if (pick.equalsIgnoreCase("L")){ //List specified line(s)
				counter = Integer.parseInt(holder[1]);
				counter2 = Integer.parseInt(holder[2]);
				list.printList(counter, counter2);
			}
		
			if (pick.equalsIgnoreCase("P")){ //Go to previous line
				if(list.prevLine() == null)
					System.out.println("** Top of file reached **");
				else
					System.out.println(list.prevLine());
			}
			
			if (pick.equalsIgnoreCase("N")){ //Go to next line
				if(list.nextLine() == null)
					System.out.println("** End of file reached **");
				else
					System.out.println(list.nextLine());
			}
			
			if (pick.equalsIgnoreCase("R")){ //Remove current line
				list.removeCursor();
			}
		}
		pick = null;
		System.out.println("Program terminating normally...");
		s.close(); //closes Scanner
		System.exit(0); //exits Program
	}
}
