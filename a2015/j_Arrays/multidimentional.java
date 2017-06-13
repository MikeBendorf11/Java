package j_Arrays;

public class multidimentional {
	public static void main(String[]args){
		int [] [] kinsFarmStores = { {1, 2, 3, 55 },
									{76, 78, 99  },
									{54, 67, 49, 75 } };
		/*add each store value */
		int [] storeSum = new int [kinsFarmStores.length];
		for (int storeN=0; storeN<kinsFarmStores.length; storeN++){
			for (int valN = 0; valN<kinsFarmStores[storeN].length; valN++){
				storeSum[storeN]+= kinsFarmStores[storeN][valN];
			}										
		}
		for (int storeN=0; storeN<kinsFarmStores.length; storeN++){
			System.out.println("Store N"+storeN+" "+storeSum[storeN]);
		}
		
	}
}

