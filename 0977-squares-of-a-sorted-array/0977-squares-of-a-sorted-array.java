class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int pos = nums.length-1;
        int[] result = new int[nums.length];
        while(left<=right){
            if(Math.abs(nums[left])>=Math.abs(nums[right])){
                int a = nums[left];
                result[pos] = a*a;
                left++;
            }
            else{
                int a = nums[right];
                result[pos] = a*a;
                right--;
            }
            pos--;
        }
        return result;
    }
}