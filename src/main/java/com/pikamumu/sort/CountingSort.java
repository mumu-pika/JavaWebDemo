package com.pikamumu.sort;

import java.util.Arrays;

// 计数排序实现
public class CountingSort {
    public static int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        // 寻找数组中最大值（最小值）, 也就是确定一个范围（min 到 max 的范围）
        int bias, min = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) min =nums[i];
            else if (nums[i] > max) max = nums[i];
        }
        
        // bia；偏移量，用于定位原始数组每个元素在计数数组中的下标位置
        bias = 0 - min;
        
        // 获得计数数组的容量
        int[] counterArray = new int[max - min + 1];
        // 将counterArray填充满0
        Arrays.fill(counterArray, 0);
        
        // 遍历整个原始数组，将原始数组中的每个元素值转化为计数数组的下标，
        // 并将计数数组下标对应的元素置大小进行累加，累加的值也就是这个元素出现的次数
        for (int i = 0; i < nums.length; i++) {
            counterArray[nums[i] + bias]++;
        }
        
        int numsIndex = 0; // 访问原始数组时的下标计数器
        int counterIndex = 0; // 访问计数数组时的下标计数器
        
        // 访问计数数组，将计数数组中的元素转换后，重新写回原始数组
        while (numsIndex < nums.length) {
            // 只要计数数组中当前下标对应元素的值不为0，就需要将这个下标的值写回原始数组
            if (counterArray[counterIndex] > 0) {
                nums[numsIndex] = counterIndex - bias;
                counterArray[counterIndex]--;
                numsIndex ++;
            }
            else counterIndex++;
        }
        
        return nums;
    }
}
