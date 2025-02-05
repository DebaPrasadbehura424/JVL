class Fibo{
  public static void main(String args[]){
     int l=0;
     int r=1;
    System.out.print(l+" "+r +" ");
    for(int i=0;i<10;i++){
      int ans=l+r;
      System.out.print(ans);
       System.out.print(" ");
      l=r;
      r=ans;
    }
   }   
}