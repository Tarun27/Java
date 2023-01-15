
public class stack{

  Node head;
  int size;
  
  stack(){
  this.head==null;
  this.size=0;
  }
  
 public void push(int val){
  Node node = new Node(val);
  if(head==null){
  head= node;
  }else{
    node.next = head;
    head = node;
  }
   size++;
 }
  
public int pop(){
  try{
  if(head==null){
   throw new RuntimeException();
  }
  int val = head.val;
  head=head.next;
    size--;
  return val;
  }catch(Exception e){
    e.printStackTrace();
  }
}  

public int peak(){
return head.val;
}
  
public int size(){
return size;
}

}

class Node{
int val;
Node next;
  
Node(int val){
this.val = val;
}  
}
