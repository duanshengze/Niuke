package lesson2;

import utils.Utils;

import java.util.Arrays;

import static utils.Utils.printArray;

/**
 * 堆排序的思想
 * 1.将数组变成大根堆
 * 2.将堆顶与堆尾进行交换，将堆的heapSize-1
 * 3.然后将对调的堆 heapify调整
 * 4.重复 2、3部至到heapsize为1
 */
public class HeapSort {


    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        while (heapSize > 0) {
            swap(arr, 0, heapSize - 1);
            heapSize--;
            heapify(arr, 0, heapSize);
        }
    }

    public void heapInsert(int[] arr, int index) {
        int father = (index - 1) / 2;
        while (father >= 0 && arr[index] > arr[father]) {
            swap(arr, index, father);
            index = father;
            father = (index - 1) / 2;
        }
    }

    /**
     * 1.找到树的最大值 与根部交换
     * 2.依次循环 第1步骤 至到叶子节点
     *
     * @param arr
     * @param index
     * @param heapSize
     */
    private void heapify(int[] arr, int index, int heapSize) {
        while (index < heapSize) {
            int bigestIndex = index;
            int left = 2 * index + 1;
            if (left < heapSize && arr[left] > arr[bigestIndex]) {
                bigestIndex = left;
            }
            //right
            if (left + 1 < heapSize && arr[left + 1] > arr[bigestIndex]) {
                bigestIndex = left + 1;
            }
            //如果根部本来最大 则直接跳出 不需要调整
            if (bigestIndex == index) {
                break;
            }
            swap(arr, index, bigestIndex);
            index = bigestIndex;
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int testTime = 5000000;
        int maxSize = 100;
        int maxValue = 100;
        for (int i=0;i<testTime;i++){
            int[] arrTest=Utils.generateRamdomArray(maxValue,maxSize);
            int[]arrTestB=Utils.copyArray(arrTest);
            heapSort.sort(arrTest);
            Arrays.sort(arrTestB);
            if (!Utils.isArrayEqual(arrTest,arrTestB)){
                System.out.println("fucked is bad array");
                System.out.println("heapsort:");
                printArray(arrTest);
                System.out.println("Arrays.sort:");
                printArray(arrTestB);
            }
        }
        System.out.println("Nice!");

    }


}
