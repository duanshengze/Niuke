package utils;

public class Utils {
    public static int[] generateRamdomArray(int maxVal, int maxSize) {
        int arraySize = (int) (Math.random() * (maxSize + 1));// [0,maxSize]
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            int value = (int) (Math.random() * (maxVal + 1)) - (int) (Math.random() * (maxVal + 1));
            array[i] = value;
        }
        return array;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static int[] copyArray(int[] array) {
        if (array == null) {
            return null;
        }
        int[] arrayB = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayB[i] = array[i];
        }
        return arrayB;
    }

    public static boolean isArrayEqual(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1 != null && arr2 != null) {
            int arraySize1 = arr1.length;
            int arraySize2 = arr2.length;
            if (arraySize1 == arraySize2) {
                boolean equal = true;
                for (int i = 0; i < arraySize1; i++) {
                    if (arr1[i] != arr2[i]) {
                        equal = false;
                        break;
                    }
                }
                return equal;
            }

        }
        return false;
    }
}
