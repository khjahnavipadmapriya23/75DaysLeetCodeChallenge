class Solution {
    public boolean checkIfPangram(String sentence) {
        sentence = sentence.toLowerCase();
        boolean[] seen = new boolean[26];
        for(char ch : sentence.toCharArray()){
            if(ch >= 'a' && ch <= 'z')
                seen[ch - 'a'] = true;
        }
        for(boolean present : seen){
            if(!present)
                return false;
        }
        return true;
    }
}