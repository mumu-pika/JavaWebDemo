package com.pikamumu.sort;

import java.util.ArrayList;

// 基数排序的实现
public class RadixSort {
    public static int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        
        // 找出最大数
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
    
        // 准备工作
        // mod 为基数，这里为十进制的数，所以mod为 10
        int mod = 10, div = 1;
        // 构建好桶
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < mod; i++) {
            bucketList.add(new ArrayList<Integer>());
        }
        
        // 先算出最大数的位数，这个位数决定了我们需要进行几轮的排序
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        
        // 按照从右往左的顺序遍历，依次将每一位都当做一次关键字
        // 然后按照这个关键字对数组排序，每一轮排序都基于上轮排序后的结果
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            // 遍历原始数组，投入桶中
            for (int j = 0; j < nums.length; j++) {
                // 获取到应该要投到哪个小桶的索引
                int num = (nums[j] % mod) / div;
                bucketList.get(num).add(nums[j]);
            }
            
            // 将桶中的数据写回原始数组，清除桶，准备下一轮的排序
            int index = 0;
            // 遍历大桶
            for (int j = 0; j < bucketList.size(); j++) {
                // 遍历大桶中每个元素（小桶）
                for (int k = 0; k <  bucketList.get(j).size(); k++) {
                    nums[index++] = bucketList.get(j).get(k);
                }
                // 清空小桶，等待下一轮数据投放桶里
                bucketList.get(j).clear();
            }
        }
        
        return nums;
    }

}
