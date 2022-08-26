package com.pikamumu.sort;

// 希尔排序实现 （使用常用的增量序列 {N/2, (N/2)/2, ...,  1}）
public class ShellSort {
    public static int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        int len = nums.length;
        
        /* 按增量分组之后，每个分组中，temp代表当前待排序数据, 该元素之前的组内元素均已经被排序过了 */
        /* gap指用来分组的增量, 会依次递减 */
        int currentValue, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                currentValue = nums[i];
                // 我们让nums[i-gap]和nums[i]组成一组
                // 组内已被排序数据的索引
                int preIndex = i - gap;
                /* 在组内已被排序过数据中倒序寻找合适的位置，
                *  如果当前待排序数据比比较的元素要小，则将比较的元素在组内后移一位
                * */
                
                while(preIndex >= 0 && (currentValue < nums[preIndex])) {
                    nums[preIndex + gap] = nums[preIndex];
                    preIndex -= gap;
                }
                
                // while 循环结束的时候，说明已经找到合适插入位置
                nums[preIndex + gap] = currentValue;
            }
            // 别忘了，这里gap还要得到增量序列中的下一个数
            gap /= 2;
        }
        
        return nums;
    }
}
