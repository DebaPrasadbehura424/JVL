import java.util.*;


class Prime {
    public static boolean CheckPrimeOrNot(int num) {
        if (num == 2) 
            return true;
        if (num % 2 == 0 || num < 2) 
            return false; 
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) 
                return false; 
        }
        return true;
    }


    public static int countPrimes(int n) {
        if (n < 2) 
            return 0; 
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (CheckPrimeOrNot(i)) {
                count++;
            }
        }
        return count; 
    }
   public static void main(String args[]){
      Scanner sc= new Scanner(System.in);
      int n =sc.nextInt();
      int ans=countPrimes(n);
      System.out.println(ans);
   }
    //tc->o(n*sqrt(n))
    //sc->o(1)
}
