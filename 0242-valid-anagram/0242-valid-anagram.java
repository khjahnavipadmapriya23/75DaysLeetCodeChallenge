class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length()!=t.length())
            return false;

        int[] count = new int[26];

        for(int i=0;i<s.length();i++){
            // Increase count for character in string s
            // Example: 'c' - 'a' = 2 → index 2
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }

        for(int num : count){
            if(num!=0)
                return false;
        }

        return true;
    }
}