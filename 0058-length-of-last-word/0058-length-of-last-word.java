class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int start = s.lastIndexOf(" ")+1;
        String lastWord = s.substring(start);
        return lastWord.length();
    }
}