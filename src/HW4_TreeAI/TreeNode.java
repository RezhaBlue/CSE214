package HW4_TreeAI;

public class TreeNode {
	String label;
	String message;
	String prompt;
	TreeNode rightC;
	TreeNode leftC;
	TreeNode midC;
	
	public TreeNode(String label, String message, String prompt){
		this.label = label;
		this.message = message;
		this.prompt = prompt;
	}
	
	public String toString(){
		return label;
	}
}
