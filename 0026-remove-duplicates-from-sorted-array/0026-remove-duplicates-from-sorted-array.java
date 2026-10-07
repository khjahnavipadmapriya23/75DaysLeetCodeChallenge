class Solution {
    public int removeDuplicates(int[] nums) {
        int read = 1;
        int write = 0;
        int count = 1;
        while(read < nums.length){
            if(nums[write]==nums[read]){
                read++;
            }
            else{
                count++;
                write++;
                nums[write] = nums[read];
            }
        }
        return count;
    }
}