package com.pikamumu.sort;

// 插入排序实现
// 注意！第一个数默认是排好的，我们从第二个数开始排
public class InsertionSort {
    public static int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        
        int currentValue; // 当前待排序数据，该元素之前的元素已经被排序过了
        for (int i = 0; i < nums.length - 1; i++) {
            int preIndex = i; // 记录已经排好序列的最后一个数的索引
            currentValue = nums[preIndex + 1];
            
            // 在已经被排序过的数据中倒序寻找可以插入的合适的位置
            while (preIndex >= 0 && (currentValue < nums[preIndex])) {
                nums[preIndex + 1] = nums[preIndex];
                preIndex--;
            }
            
            // 当while循环完毕, 就说明已经找到了待排序的合适的位置
            // 做插入处理
            nums [preIndex + 1] = currentValue;
        }
        return nums;
    }
}
