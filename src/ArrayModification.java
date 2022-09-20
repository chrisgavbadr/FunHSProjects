import java.util.Arrays;

public class ArrayModification {
    public static void main(String[] args) {
        int[] numbers = buildArray(10);

        System.out.println("Array: " + Arrays.toString(numbers));
        incrementAll(numbers);
        System.out.println("Incremented: " + Arrays.toString(numbers));
        numbers = reverseAll(numbers);
        System.out.println("Reversed: " + Arrays.toString(numbers));
    }

    public static int[] buildArray(int magnitude) {
        int[] array = new int[magnitude];

        for (int i = 0; i < array.length; i++) {
            array[i] = i * i;
        }
        return array;
    }

    public static void incrementAll(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i]++;
        }
    }

    public static int[] reverseAll(int[] array) {
        int[] reversedArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            reversedArray[i] = array[(array.length - 1) - i];
        }
        return reversedArray;
    }
}