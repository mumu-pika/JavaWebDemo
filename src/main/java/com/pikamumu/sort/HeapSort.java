package com.pikamumu.sort;

// 堆排序实现, 这里来实现一个最大堆产生一个升序的数组
public class HeapSort {
    // 声明一个全局变量，用来记录数组array的长度
    private static int len;
    
    public static int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        len = nums.length;
        // 1、构建一个最大堆
        buildMaxHeap(nums);
        // 2、循环将堆首位（最大值）与未排序数据末位交换，然后重新调整为最大堆
        while (len > 0) {
            swap(nums, 0, len -1);
            len--;
            // 这个时候因为len--, 所以这个二叉堆已经将末位那个最大的数剥离出了二叉堆
            // 接下里对剩下的那个二叉堆做调整
            adjustHeap(nums, 0);
        }
        return nums;
    }
    
    // 交换数组中的两个数
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    // 构建最大堆的方法
    public static void buildMaxHeap(int[] array) {
        // 从最后的一个非叶子节点开始向上构造最大堆
        for (int i = (len / 2 - 1); i >= 0; i--) {
            adjustHeap(array, i);
        }
    }
    
    // 调整使得这个节点及之下的二叉堆是个最大堆
    // 调整使之成为最大堆的方法
    public static void adjustHeap(int[] array, int i) {
        int maxIndex = i;
        // 完全二叉树中第i个节点的左子节点的下标为 2 * i + 1
        int left = 2 * i + 1;
    
        // 完全二叉树中第i个节点的右子节点的下标为 2 * (i + 1)
        int right = 2 * (i + 1);
        
        // 如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (left < len && array[left] > array[maxIndex])
            maxIndex = left;
        // 如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (right < len && array[right] > array[maxIndex])
            maxIndex = right;
        // 如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置
        if (maxIndex != i ) {
            swap(array, maxIndex, i);
            // 继续向下调整
            adjustHeap(array, maxIndex);
        }
        
    }
}
