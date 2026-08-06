class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int minSubarray = Integer.MAX_VALUE;
        int windowSum = 0;
        int length = 0;

        for(int right = 0; right<n; right++){
            windowSum += nums[right];
            
            while(windowSum >= target){
                length = right-left+1;
                minSubarray = Math.min(minSubarray,length);

                windowSum -= nums[left];
                left++;
            }
        }
        if(minSubarray == Integer.MAX_VALUE)
        return 0;

        return minSubarray;
    }
}