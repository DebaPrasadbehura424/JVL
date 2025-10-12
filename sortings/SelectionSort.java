package sortings;

public class SelectionSort {
    public static void main(String[] args) {

        int[] array = new int[] { -100, 40, -200, 10, 410, 54 };
        int min = 0;
        // 0 1 2 3 4 5
        // -200 -100 10 40 54 410// done
        for (int i = 0; i < array.length; i++) {
            min = i;// 0//1////3//4//5
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;// 2//2//3//5
                }
            }

            int temp = array[min];// -200//-100// 10//410
            array[min] = array[i];// -100//40//40//410
            array[i] = temp;// -200//-100//10//54
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
