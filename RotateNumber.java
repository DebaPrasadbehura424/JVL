import java.util.*;
//note java only supports 32 bit engine means 31 range must present other wise 0
class RotateNumber{
  public static void main(String args[]){
   @SuppressWarnings("resource")
Scanner sc= new Scanner(System.in);
   int n =sc.nextInt();
   int k=sc.nextInt();
   ArrayList<Integer>arr= new ArrayList<>();
   while(n>0){
      int fact=n%10;
      n=n/10;
      arr.add(fact);
   }


   Collections.reverse(arr);
   for(int num : arr){
    System.out.print(num);
   }
   
 k=k%arr.size()-1;

   }   
}