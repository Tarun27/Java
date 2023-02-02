 interface I1 {
     default String getGreeting() {
        return "Good Morning!";
     }
     
     default String method(){
         return "hi";
     }
}

interface I2 {
    default String getGreeting() {
        return "Good Night!";
    }
}

 interface Alarm {

    default String turnAlarmOn() {
        return "Turning the alarm on.";
    }
    
    default String turnAlarmOff() {
        return "Turning the alarm off.";
    }
}

public class C1 implements Alarm, I1 ,I2 {       
  
  // without overriding getGreeting() method class will throw I1, I2 are incompatible error
  //To solve this ambiguity, we must explicitly provide an implementation for the methods:
//   @Override
//   public String getGreeting(){
//       return I1.super.getGreeting();
//   }
  
    @Override
  public String getGreeting(){
      return I1.super.getGreeting() +  I2.super.getGreeting();
  }
  
  public String getGreetingI2(){
       System.out.println( I2.super.getGreeting()); 
      return I2.super.getGreeting();
  }
  
  public static void main(String args[]){
        C1 c = new C1();
        c.turnAlarmOn();
        
        System.out.println(c.turnAlarmOn());
      
        System.out.println(c.method()); 
        
         System.out.println(c.getGreeting());
         
         System.out.println(c.getGreetingI2());
         
         // System.out.println( I2.super.getGreeting()); // error: not an enclosing class: I2
 
  }
    
}
