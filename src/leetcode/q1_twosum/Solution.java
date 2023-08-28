package leetcode.q1_twosum;

/*
https://leetcode.com/problems/two-sum/
*/

public class Solution {

    private boolean isEven(int x) {
        if(x % 2 == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int[] ans = {0,0};
        for(int x = 0; x < nums.length; x++) {
            int first = nums[x];
            for(int y = 0; y < nums.length; y++) {
                if(x!=y) {
                    int second = nums[y];
                    if(first + second == target) {
                        ans = new int[]{x, y};
                        break;
                    }

                }


            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {2,7,11,15};
        int target = 9;

        Solution ans = new Solution();
        int[] op  =  ans.twoSum(nums,target);
        System.out.println(op[0] + " " + op[1]);
    }
}