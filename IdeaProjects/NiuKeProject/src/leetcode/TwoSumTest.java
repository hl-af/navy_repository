package leetcode;
/*
* 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
* */
import java.util.HashMap;
import java.util.Map;

public class TwoSumTest {
    public static void main(String[] args){
        TwoSumTest tst = new TwoSumTest();
        int[] nums = new int[]{3, 2, 4};
        int[] num2 = tst.twoSum(nums,6);
        for (Integer i :num2) {
            System.out.println(i);
        }
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i<nums.length;i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])&&map.get(nums[i])!=i) {
                int[] tmp = new int[2];
                tmp[0] = i;
                tmp[1] = map.get(target - nums[i]);
                return tmp;
            }
        }
        return null;


    }
}
