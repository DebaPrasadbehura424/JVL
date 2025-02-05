
import java.util.*;

class CND{
  public static void main(String args[]){
     @SuppressWarnings("resource")
     Scanner sc=new Scanner(System.in);
     int n=sc.nextInt();
     List<Integer>arr= new ArrayList<>();
    
     while(n>0){
          int fact=n%10;
          arr.add(fact);
          n=n/10;
     }
    for(int i=arr.size()-1;i>=0;i--){//array type use length if tlc size()
         System.out.print(arr.get(i) +" ");
    }
   }   
}