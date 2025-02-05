public class Vowel {
    public class Main {
        public static void main(String[] args) {
            String str = "Hello World";
            int count = 0;
            for (char c : str.toCharArray()) {
                if ("AEIOUaeiou".indexOf(c) != -1)
                    count++;
            }
            System.out.println("Number of vowels: " + count);
        }
    }
}
