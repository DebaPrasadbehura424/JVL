
import java.util.Scanner;

public class Sets {
    public void execute() {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the size : ");
            int size = sc.nextInt();
            int arr[] = new int[size];

            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 0; i < size; i++) {
                System.out.print(arr[i]);
                System.out.print(" ");
            }
            System.out.println();

            // approach 1;
            // Arrays.sort(arr);

            // appraoch 2 use merge-sort
            // merge(arr);
            // appraoch 2 use quick-sort
            // appraoch 3 use two-pointer
            for (int i = 0; i < size; i++) {
                System.out.print(arr[i]);
                System.out.print(" ");
            }
        }

    }

    public static void main(String[] args) {
        Sets set012 = new Sets();
        set012.execute();
    }
}
