package j_Arrays;

public class test2 {
	public static void main(String[]args){
		
		int [] a = {23,15,5,1,0,5,22,10,3,7,8,9,12,11};
		int []temp = a;
	 System.out.print("a = {");
	 for(int i =0; i<a.length;i++){
		 if (i<(a.length-1))
		 System.out.print(a[i]+",");
		 else System.out.print(a[i]);
	 }
	 System.out.println("}");
	 int position = 4;
	 int num=4;
	 
		for(int ps=0;ps<temp.length;ps++){
			for(int sw=0;sw<temp.length;sw++){
				if (temp[sw]<temp[ps]){
					int m = temp[sw];
					temp[sw]=temp[ps];
					temp[ps]=m;
					ps--;
					break;
				}			
			}
		}
		
	 System.out.print("a = {");
	 for(int i =0; i<a.length;i++){
		 if (i<(a.length-1))
		 System.out.print(a[i]+",");
		 else System.out.print(a[i]);
	 }
	 System.out.println("}");
 }
}
