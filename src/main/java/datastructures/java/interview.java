public class MyClass {
    public static void main(String args[]) {
      Integer x=1110;
      Integer y=1110;
      int z=111;
      int w=111;

      System.out.println(x.equals(y));// true
      System.out.println(x == y);     //false
      System.out.println(z == w);     // true

   Integer a = Integer.valueOf(1);
   Integer b = Integer.valueOf(1);

   System.out.println(a==b);  //true
        //This is because the valueOf() method stores the Integer in a cache to avoid creating too many wrapper objects with the same value. 
        //Therefore, the method returns the same Integer instance for both calls.
        
        Integer a = new Integer(1);
        Integer b = new Integer(1);


   System.out.println(a==b); // false // memory addresses are compared
        
        
 // store objects in sorted order 
        
        PriorityQueue<Student> pq = new
             PriorityQueue<Student>(new StudentComparator());
        
        TreeSet<students> mrks= new TreeSet<students>(new myNameComparator());
        
    }
}

class myNameComparator implements Comparator<students>
{
    public int compare(students s1, students s2)
    {
        return s1.getName().compareTo(s2.getName());
    }
}

class StudentComparator implements Comparator<Student>{
             
            // Overriding compare()method of Comparator
                        // for descending order of cgpa
            public int compare(Student s1, Student s2) {
                if (s1.cgpa < s2.cgpa)
                    return 1;
                else if (s1.cgpa > s2.cgpa)
                    return -1;
                                return 0;
                }
        }
 
class Student {
    public String name;
    public double cgpa;
}
