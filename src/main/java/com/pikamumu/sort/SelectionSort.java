package com.pikamumu.sort;

// 选择排序实现
public class SelectionSort {
    public static int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        // 循环遍历
        for (int i = 0; i < nums.length - 1; i++) {
            // 记录最小的数
            int min = nums[i];
            // 遍历剩余的元素, 并和最小数做比较
            for (int j = i + 1; j < nums.length; j++) {
                // 交换
                if (nums[j] < min) {
                    nums[i] = nums[j];
                    nums[j] = min;
                    min = nums[i];
                }
            }
        }
        return nums;
    }
}
