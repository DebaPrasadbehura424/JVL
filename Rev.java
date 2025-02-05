import java.util.*;
//note java only supports 32 bit engine means 31 range must present other wise 0
class Rev{
  public static void main(String args[]){
    @SuppressWarnings("resource")
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int rev=0;
    while(n>0){
     int digit=n%10;
    n=n/10;
    rev=rev*10+digit;
   }
   if(rev>Integer.MAX_VALUE/10 || rev<Integer.MIN_VALUE/10) {
 System.out.println(0);
 }else{

   System.out.println(rev);
}
   }   
}