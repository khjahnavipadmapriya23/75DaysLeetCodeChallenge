class Solution {
    public boolean isSubsequence(String s, String t) {
       int checkS = 0;
       int checkT = 0;
       
       while(checkS < s.length() && checkT < t.length()){
        if(s.charAt(checkS)==t.charAt(checkT)){
            checkS++;
        }
        checkT++;
       }
    return checkS == s.length();
    }
}