import java.util.Random;

public class Algorithms {
    public static int[] initialize(int size) {
        Random generator = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = generator.nextInt(10000000);
        }
        return array;
    }

    public static int linearCount(int[] array, int target) {
        int count = 0;
        for (int value : array) {
            if (value == target) {
                count++;
            }
        }
        return count;
    }

    public static int[] bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i] > array[j]) {
                    // Swap elements
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int size = 10000;
        Timer myTimer = new Timer();
        int[] data = initialize(size);
        myTimer.start();
        int position = linearCount(data, 50);
        myTimer.stop();
        System.out.println("Search Time : " + myTimer.getTime());
        myTimer.start();
        bubbleSort(data);
        myTimer.stop();
        System.out.println("Sort Time : " + myTimer.getTime());
    }
}