package a_thisSuper;
abstract class Overriding{
   public void disp1(){
     System.out.println("Concrete method of abstract class");
   }
   abstract public void disp2();
}

class Demo2 extends Overriding{
   /* I have given the body to abstract method of Demo1 class
   It is must if you don't declare abstract method of super class
   compiler would throw an error*/  
   public void disp2()
   {
       System.out.println("I'm overriding abstract method");
   }
   public static void main(String args[]){
       Demo2 obj = new Demo2();
       obj.disp2();
   }
}