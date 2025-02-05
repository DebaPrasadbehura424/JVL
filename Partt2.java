class Partt2{



  public static void lashes(int num){

     for(int i=num;i>0;i--){
         for(int j=1;j<=i;j++){
           if(j==i){
            System.out.print("*");
           }else{
             System.out.print(" ");
            }
         }
            System.out.println("");
      }


   }
  public static void main(String args[]){
     
     for(int i=0;i<5;i++){
      System.out.print("*");  
      }
       System.out.println("");
       lashes(3);
    for(int i=0;i<5;i++){
      System.out.print("*");  
      }
    }
}