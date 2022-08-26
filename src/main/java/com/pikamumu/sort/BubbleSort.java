package com.pikamumu.sort;

// 冒泡排序实现
public class BubbleSort {
    public static int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        // 循环遍历
        for (int i = 0; i < nums.length; i++) {

            // 从第0个元素  开始，依次和后面的元素进行比较
            // j <nums.length - 1 -i, 表示这轮选定的数已经冒泡到了合适的位置，无需进行比较
            // 可以减少比较次数
            for (int j = 0; j < nums.length -1 - i; j++) {
                // 比较前后两个数大小
                // 如果第j个元素比第j+1个元素大，交换两个数的位置
                if(nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
}
