package links;

import java.util.Scanner;

public class NodeViewer {
	public static void main(String[]args){
		DLinkList list = new DLinkList();
		int counter;
		int counter2;
		String pick; //A string to hold the selected operation code.
		Scanner s = new Scanner(System.in);
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
			holder = s.nextLine().replaceFirst("^ ", "").split(" ");
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
			}
		
			if (pick.equalsIgnoreCase("H")){ //Help
				System.out.print("A)   Append one or more lines at the end of file. \nI) "
						+ "  Insert one or more lines before the current line. \nH    Help.  "
						+ "\nL)   List one or more lines. \nP)   Move to the previous line. "
						+ "\nN)   Move to the next line. \nQ)   Quit program \nR)   Remove "
						+ "the current line.");
			}
		
			/**if (pick.equalsIgnoreCase("L")){ //List line(s)
				counter = Integer.parseInt(holder[1]);
				counter2 = Integer.parseInt(holder[2]);
				if((counter > counter2) || (counter < 1))
					System.out.println("**Invalid input**");
				while(list.getCursor() != list.getHead())
					list.getCursor() = cursor.getPrev();
				for(int i = 0; i < counter; i++)
					temp = temp.getNext();
				
				while(counter!=counter2){
					list.printCursor();
				}
			}*/
		
			if (pick.equalsIgnoreCase("P")){ //Go to previous line
				if(list.previousLine().equals(null))
					System.out.println("** Top of file reached **");
				else
					System.out.println(list.previousLine());
			}
			
			if (pick.equalsIgnoreCase("N")){ //Go to next line
				if(list.nextLine().equals(null))
					System.out.println("** End of file reached **");
				else
					System.out.println(list.nextLine());
			}
			
			if (pick.equalsIgnoreCase("R")){ //Remove current line

			}
		}
		pick = null;
		System.out.println("Program terminating normally...");
		s.close(); //closes Scanner
		System.exit(0); //exits Program
	}
}

