package lesson2;

import utils.Utils;

import java.util.Arrays;

/**
 * 经典快排的思想
 * 1.将数组选取数组最后一个数作为基准值 A
 * 2.将数组分为 <A |=A | >A 三部分 （快排的核心思想partion）
 * 3.选取 <A部分 继续选取新的基准值 继续重复2
 * 4.选取 >A部分 继续选取新的基准值 继续重复2
 */
public class QuickSort {

    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int index1, int index2) {
        if (index1 >= index2) {
            return;
        }
        int[] partion = partion(array, index1, index2, array[index2]);
        sort(array, 0, partion[0] - 1);
        sort(array, partion[1] + 1, index2);
    }

    /**
     * partion的思想：
     * 1.选取less 索引 数组的起始索引-1
     * 2.选取more 索引 数组的结束索引+1
     * 使用当前cur游标遍历数组
     * 当前arr[cur]>value ,将当前值 与arr[more-1] 交换 并more自减1 注意cur 不加1
     * 当前arr[cur]==value cur++
     * 当前arr[cur]<value 将当前值 与arr[less+1]交换 less加1 注意cur加1
     *  循环遍历 结束条件是cur>=more
     * @param array
     * @param index1
     * @param index2
     * @param value
     * @return 等于value 起始索引和结束索引
     */
    private int[] partion(int[] array, int index1, int index2, int value) {
        int[] res = new int[2];
        if (array == null || array.length == 0) {
            return res;
        }
        int small = index1 - 1;
        int more = index2 + 1;
        int cur = index1;
        while (cur < more) {
            if (array[cur] < value) {
                Utils.swap(array, ++small, cur++);
            } else if (array[cur] > value) {
                Utils.swap(array, --more, cur);
            } else if (array[cur] == value) {
                cur++;
            }
        }
        res[0] = small + 1;
        res[1] = more - 1;
        return res;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int times = 50000;
        int maxSize = 100;
        int maxValue = 1000;
        boolean succeed = true;
        long startTime=System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            int[] array = Utils.generateRamdomArray(maxValue, maxSize);
            int[] arraryB = Utils.copyArray(array);
            Arrays.sort(arraryB);
            quickSort.sort(array);
            if (!Utils.isArrayEqual(array, arraryB)) {
                System.out.println("fucked error");
                Utils.printArray(array);
                Utils.printArray(arraryB);
                succeed = false;
            }
        }
        if (succeed){
            System.out.println("Nice! spend:"+(System.currentTimeMillis()-startTime)+"ms");
        }

    }
}
