class Solution {
    public boolean isPalindrome(int x) {
        int original = x;
        int temp = x;
        int rem =0, rev =0;
        if(x<0)
            return false;
        while(temp!=0){
            rem = temp %10;
            rev = rev*10 + rem;
            temp/= 10;
        }
        if(rev==original)
            return true;
            
    return false;
    }
}