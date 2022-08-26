package com.pikamumu.sort;

// 快速排序实现 （使用分区指示器, 采用一个基准值）
public class QuickSort {
    public static int[] sortArray(int[] nums) {
        return sort (nums, 0, nums.length - 1);
    }
    
    // 快速排序的递归实现
    // 这里参数中 start 和 end 是数组的索引下标的值
    public static int[] sort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) {
            return null;
        }
        
        // 数据分割成独立的两部分时, zoneIndex为分区指示器
        int zoneIndex = partition(array, start, end);
        if (zoneIndex > start)  sort(array, start, zoneIndex - 1);
        if (zoneIndex < end) sort(array, zoneIndex + 1, end);
        
        return array;
    }
    
    
    // 快速排序分区方法
    public static int partition(int[] array, int start, int end) {
        // 当只有一个元素的时候，无需再分区
        if (start == end) return start;
        
        // 准备工作
        // 随机选取一个基准数
        int pivot = (int) (start  + Math.random() * (end - start + 1));
        
        // zoneIndex 是分区指示器, 初始值为分区头元素下标减一
        int zoneIndex = start - 1;
        
        // 将基准值和分区尾元素交换位置, 这里默认将基准值置于尾部，方便从前向后遍历
        swap(array, pivot, end);
        
        // --------------基准值准备工作完成，下面做快排的遍历-------------------//
        
        for (int i = start; i <= end; i++) {
            // 当前元素小于等于基准数
            if (array[i] <= array[end]) {
                // 分区指示器累加
                zoneIndex++;
                // 如果当前元素在分区指示器的右边，交换当前元素和分区指示器元素
                if (i > zoneIndex) swap(array, i, zoneIndex);
            }
        }
        return zoneIndex;
    }
    
    // 交换数组内两个元素, 参数给定数组，两个元素的数组下标
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
}
