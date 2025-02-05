import java.util.*;

class DNC{
  public static void main(String args[]){

     List<Integer>arr= new ArrayList<>();//3,2,1
     arr.add(1);
     arr.add(2);
     arr.add(3);
    
    int sum=0;
    for(int i=0;i<arr.size();i++){
        sum+=arr.get(i)*Math.pow(10,i);
    }
    System.out.print(sum);
   }   
}