package leetcode;

import utils.ListUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 没有完全AC
* */
public class L15_threeSum {
    public static void main(String[] args){
        L15_threeSum l15_threeSum = new L15_threeSum();
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> list = l15_threeSum.threeSum(nums);
        for (List l : list) {
            ListUtils.printList(l);
        }

    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int k = 0; k < nums.length; k++) {

            int i = 0;
            int j = nums.length - 1;
            while (i < k && j > k) {
                if (nums[i] + nums[j] +nums[k]> 0) {
                    j--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    i++;
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[k]);
                    list.add(nums[j]);
                    if (!lists.contains(list)) {
                        lists.add(list);
                    }
                    i++;
                }
            }
        }
        return lists;
    }
}
