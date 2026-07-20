class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int result = nums[left] + nums[right];
            if(result > target) right--;
            if(result < target) left++;
            if(result == target) return new int[]{left+1,right+1};
        }
        return new int[]{};
    }
}