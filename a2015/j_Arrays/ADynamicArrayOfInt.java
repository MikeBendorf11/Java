package j_Arrays;

public class ADynamicArrayOfInt {

    int[] data; 
    ADynamicArrayOfInt() {

      data = new int[1];
   }
   
    int get(int position) {/////////////////////////
     
      if (position >= data.length)
         return 0;
      else
         return data[position];
   }
   
   public void put(int position, int value) {///////////////////

      if (position >= data.length) {

         int newSize = 2 * data.length;
         if (position >= newSize)
            newSize = 2 * position;
         int[] newData = new int[newSize];
         System.arraycopy(data, 0, newData, 0, data.length);
         data = newData;
             // The following line is here for demonstration purposes only.
         System.out.println("Size of dynamic array increased to " + newSize);
      }
      data[position] = value;
   }

} // end class DynamicArrayOfInt