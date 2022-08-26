package com.pikamumu.sort;

import java.util.Arrays;

// 归并排序实现
public class MergeSort {
    public static int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        
        //切分数组，然后递归排序，并用 merge 合并
        int mid = nums.length / 2;
        
        // 分别拷贝左半子数组和右半子数组
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);
 
        return merge(sortArray(left), sortArray(right));
    }
    
    /*
    *   归并排序
    *   将两段排序好的数组合并成一个排序数组
    *   @params left
    *   @params right
    *   @return
    * */
    public static int[] merge(int[] left, int[] right) {
        // 准备一个空数组，长度为两个数组的长度
        int[] result = new int[left.length + right.length];
        // 下面做分组的合并， 合并的时候，需要两个指针l，r分别遍历左右两部分，进行比较，放入result
        for (int i = 0, l = 0, r = 0; i < result.length; i++) {
            // 如果左边数组已经取完，直接取右边数组的值即可
            if (l >= left.length) result[i] = right[r++];
            // 如果右边数组已经取完，直接取左边数组的值即可
            else if (r >= right.length) result[i] = left[l++];
            // 如果左数小于右数，因为是升序排，我们取左数的值
            else if (left[l] < right[r]) result[i] = left[l++];
            // 如果左数大于右数，因为是升序排，我们取右数的值
            else if (left[l] > right[r]) result[i] = right[r++];
        }
        return result;
    }
}
