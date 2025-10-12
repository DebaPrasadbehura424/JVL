package bitmanipulation;

public class AddTwoInteger {
    public static String reverse(String current) {
        char ch[] = current.toCharArray();
        int i = 0;
        int j = ch.length-1;
        while (i <= j) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
        return new String(ch);
    }
    public static void main(String[] args) {
        String current = "Hello";
        String ans = reverse(current);
        System.out.println(ans);
    }
}
