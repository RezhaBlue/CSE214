
public class IllegalSizeException extends Exception{
	public IllegalSizeException(){
		super("Vector size must range from 1 to 60");
	}
	
	public IllegalSizeException(String msg){
		super(msg);
	}
}
