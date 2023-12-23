import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        int i = 0;
        int j = 0;
        int maxLen = 0;
        HashSet<Character> set = new HashSet<>();

        while(j < n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                maxLen = Math.max(maxLen, set.size());
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        
        return maxLen;
    }
}