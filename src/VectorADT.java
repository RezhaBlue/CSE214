
public class VectorADT{
private int MAX_ELEMENTS = 60;
private int size = 0;
private int[] vector;

	public VectorADT(int size) throws IllegalSizeException{
		this.size = size;
		if((size < 1) || (size > MAX_ELEMENTS))
			throw new IllegalSizeException();
		else{
			vector = new int[size];
			for (int i = 0; i < size; i++)
				vector[i] = 0;
		}
	}
	
	public Object clone() throws RuntimeException{
		VectorADT vektor;
		try{
			vektor = (VectorADT) super.clone();
		}
		catch(CloneNotSupportedException e)
		{
			throw new RuntimeException("Cloneable not implemented");
		}
		
		vektor.vector = (int[]) vector.clone();
		return vektor;
	}
	
	public boolean equals(Object obj){
		if (obj instanceof VectorADT){
			VectorADT gpig = (VectorADT) obj;
			int counter = 0;
			for (int i = 0; i < size; i++){
				if(gpig.vector[i] != vector[i])
					counter++;
			}
			return (counter == 0)&&(gpig.size == size);
		}
		return false;
	}
	
	public void setElement(int value, int element) throws IllegalArgumentException{
		if((element < 0)||(element >= size))
			throw new IllegalArgumentException("Invalid Range. The position must" 
			  + " be between 0 and " + (getSize() -1) + "inclusive");
		vector[element] = value;
	}
	
	public int getElement(int element) throws IllegalArgumentException{
		if((element < 0)||(element > MAX_ELEMENTS))
			throw new IllegalArgumentException("Invalid range");
		return vector[element];
	}
	
	public int getSize(){
		return size;
	}
	
	public static VectorADT add(VectorADT v1, VectorADT v2) throws IllegalSizeException{
		if (v1.getSize() != v2.getSize())
			throw new IllegalSizeException("The Vectors must be of equal size");
		if ((v1 == null)||(v2 == null))
			throw new IllegalArgumentException("Null vector detected. Cannot sum null vector.");
		else{
			VectorADT v3 = new VectorADT(v1.getSize());
			for(int i = 0; i < v1.getSize(); i++){
			v3.setElement((v1.getElement(i) + v2.getElement(i)), i);
			}
			return v3;
		}
	}
	
	public static VectorADT subtract(VectorADT v1, VectorADT v2) throws IllegalSizeException{
		if (v1.size != v2.size)
			throw new IllegalSizeException("The Vectors must be of equal size");
		if ((v1 == null)||(v2 == null))
			throw new IllegalArgumentException("Null vector detected. Cannot sum null vector.");
		VectorADT v3 = new VectorADT(v1.size);
		for(int i = 0; i < v1.size; i++){
			v3.setElement((v1.getElement(i) - v2.getElement(i)), i);
		}
		return v3;
	}
	
	public static VectorADT multiplyByScalar(VectorADT v, int scalar){
		if(v == null)
			return null;
		VectorADT v2 = (VectorADT) v.clone();
		for (int i = 0; i < v2.size; i++){
			 v2.setElement(v2.getElement(i) * scalar, i);
		 }
		return v2;
	}
	
	public static VectorADT dotProduct(VectorADT v1, VectorADT v2) throws IllegalSizeException{
		if (v1.size != v2.size)
			throw new IllegalSizeException("The Vectors must be of equal size");
		if ((v1 == null)||(v2 == null))
			throw new IllegalArgumentException("Null vector detected. Cannot sum null vector.");
		else{
			VectorADT v3 = new VectorADT(v1.size);
			for(int i = 0; i < v1.size; i++){
			v3.setElement((v1.getElement(i) * v2.getElement(i)), i);
			}
			return v3;
		}
	}
	
	public String toString(){
		String s = new String("");
		for (int i = 0; i < size; i++)
			s += getElement(i) + " ";
		return s;
	}
}
