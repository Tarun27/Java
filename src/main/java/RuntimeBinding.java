
class A  {
 void f1() {  //this holds address of object of B     
   System.out.println("A f1");
 }
 void f2() {
   System.out.println("A f2");
 }
}//A



class B extends A {


 void f3() {   //new method     
   System.out.println("B f3");
 }

 void f2() { //this holds address of object of B     
   System.out.println("B f2 starts");
   f3(); //this.f3()
   System.out.println("B f2 ends ");

 } }  //B


public class TypeCmptbl {
   public static void main(String args[]) {
      A ref; //reference of A
      ref = new B();//Object of B

      //ref.inherited()  allowed
      ref.f1();

      //ref.overridden() allowed
      ref.f2();

     //ref.newMembersOfChild() not allowed
    //ref.f3(); // error: cannot find symbol  ref.f3();

  }//main
}

/*
Consider the statement

  ref.f2();

Here ref is a reference of class A and it has address of object of class B f2() is a overridden method.

When compiler detects such a statement then it doesn't bind the function call with any definition. It only validates the call.

Binding of such calls is left for the runtime environment. At program runtime system identifies the datatype of the object
and binds the function call with the function definition provided by the class of object. This type of binding between the function call
and function defination is called as "late binding" or "runtime binding" or "runtime polymorphism" or "dynamic method dispatch".

*/


