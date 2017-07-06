package b_StackQueueTree;

public class RecursionTree2 extends RecursionTree1 {
	int countLeaf, countDepthL, countDepthR;
	void counter(TreeNode root){
		
		if (root!=null){
			counter(root.left);
			counter(root.right);

			if(root.left==null && root.right==null){
				countLeaf++;
				System.out.print("n: " + root.item + " "
						+ "c: " + countLeaf + " \n");
			}			
		}
	}
	int c2, n;
	void counterD(TreeNode root){
		c2++;
		if (root!=null){
			n++;
			counterD(root.left);
			counterD(root.right);
			System.out.println(" n: " + n +" c2: " + c2 +" i: " + root.item);
		}
	}
	
	static void postorderPrint( TreeNode root ) {
		   if ( root != null ) {  
		      postorderPrint( root.left );   
		      postorderPrint( root.right );  
		      System.out.print( root.item + " " );  
		   }
		} // end postorderPrint()
	static void inorderPrint( TreeNode root ) {
		   if ( root != null ) {  
		      inorderPrint( root.left );   
		      System.out.print( root.item + " " );  
		      inorderPrint( root.right );  
		   }
		} // end inorderPrint()
}
