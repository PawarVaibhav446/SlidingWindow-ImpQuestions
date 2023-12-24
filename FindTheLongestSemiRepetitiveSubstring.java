class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        
        int i = 0;
        int j = 0;
        int n = s.length();
        int count = 0;
        int maxLen = 1;


        while(j < n - 1 && i <= j){
            j++;

            if(s.charAt(j) == s.charAt(j - 1)){
                count++;
            }

            while(count >= 2){
                i++;
                if(s.charAt(i) == s.charAt(i - 1)){
                    count--;
                }
            }
            
            maxLen = Math.max(maxLen, j - i + 1);
        }

        return maxLen;
    }
}
