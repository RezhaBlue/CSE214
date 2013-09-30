
import java.util.Scanner;
import java.util.StringTokenizer;

public class VectorOperations {
public static void main(String[]args) throws IllegalSizeException{
	Scanner s = new Scanner(System.in);
	String pick;
	System.out.print("A) Add \nD) Dot Product \nE) Equality \nM) Multiply \nS) Subtract \nQ) Quit program \n\n\n");
	System.out.print("Enter Your Choice: ");
	pick = s.next();
	if (pick.equalsIgnoreCase("a")){
			Scanner j = new Scanner(System.in);
			System.out.println("Enter First Vector: ");
			String s1 = j.nextLine();
			StringTokenizer vc = new StringTokenizer(s1);
			VectorADT v1 = new VectorADT(vc.countTokens());
			while(vc.hasMoreTokens()){
				for (int i = 0; i < v1.getSize(); i++)
					v1.setElement(Integer.parseInt(vc.nextToken()), i);
			}
			System.out.println("Enter Second Vector: ");
			String s2 = new String(j.nextLine());
			StringTokenizer vx = new StringTokenizer(s2);
			VectorADT v2 = new VectorADT(vx.countTokens());
			while(vx.hasMoreTokens()){
				for (int i = 0; i < v2.getSize(); i++)
					v2.setElement(Integer.parseInt(vx.nextToken()), i);
			}
			System.out.println(v1.toString() + " +");
			System.out.println(v2.toString() + " =");
			VectorADT v3 = VectorADT.add(v1, v2);
			System.out.print(v3.toString());
		}
	System.out.println("end");
	}
}
    

/*
Scanner s = new Scanner(System.in);
System.out.println("Enter First Vector: ");
String s1 = new String(s.nextLine());
StringTokenizer vc = new StringTokenizer(s1);
VectorADT v1 = new VectorADT(vc.countTokens());
while(vc.hasMoreTokens()){
	for (int i = 0; i < v1.getSize(); i++)
		v1.setElement(Integer.parseInt(vc.nextToken()), i);
}
System.out.println("Enter Second Vector: ");
String s2 = new String(s.nextLine());
StringTokenizer vx = new StringTokenizer(s1);
VectorADT v2 = new VectorADT(vx.countTokens());
while(vx.hasMoreTokens()){
	for (int i = 0; i < v2.getSize(); i++)
		v2.setElement(Integer.parseInt(vx.nextToken()), i);
}
System.out.println(v1.toString() + " +");
System.out.println(v2.toString() + " =");
VectorADT v3 = VectorADT.add(v1, v2);
System.out.print(v3.toString());
*/
