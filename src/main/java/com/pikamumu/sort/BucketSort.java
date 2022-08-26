package com.pikamumu.sort;

import java.util.ArrayList;

// 桶排序的实现
// @params bucketCap 桶的
public class BucketSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> array, int bucketCap) {
        if (array == null || array.size() < 2) return array;
        
        int max = array.get(0), min = array.get(0);
        // 寻找出原始数组的最大值和最小值
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max) {
                max = array.get(i);
            }
            else if (array.get(i) < min) {
                min = array.get(i);
            }
        }
        
        // 获得桶的数量
        int bucketCount = (max - min) / bucketCap + 1;
        
        // 构建大桶 bucketArr, 其中它里面的每一个元素是一个小桶，也就是一个个小的ArrayList
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        
        // 给大桶里加入一个个小桶
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        
        // 将原始数组中的数据分配到桶中
        for (int i = 0; i < array.size(); i++) {
            bucketArr.get((array.get(i) - min) / bucketCap).add(array.get(i));
        }
        
        for (int i = 0; i < bucketCount; i++) {
            // 如果每个小桶的容量为 1
            if (bucketCap == 1) {
                for (int j = 0; j < bucketArr.get(i).size(); j++) {
                    resultArr.add(bucketArr.get(i).get(j));
                }
            }
            else {
                // 只有一个小桶的话，说明划分的不够细，我们还需要在这个小桶里再细分。
                if (bucketCount == 1) bucketCap--;
                // 对小桶中的数据再次进行桶排序
                ArrayList<Integer> temp = sort(bucketArr.get(i),bucketCap);
                for (int j = 0; j < temp.size(); j++) {
                    resultArr.add(temp.get(j));
                }
            }
        }
        
        return resultArr;
    }
}
