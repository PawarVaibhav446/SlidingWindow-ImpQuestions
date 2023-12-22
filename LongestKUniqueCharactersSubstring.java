import java.util.HashMap;

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int i = 0;
        int j = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int n = s.length();
        
        while(j < n){
            
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            
            if(map.size() == k){
                maxLen = Math.max(maxLen, j - i + 1);
            }
            
            j++;
            
            if(map.size() > k){
                while(map.size() > k){
                    int a = map.get(s.charAt(i));
                    map.put(s.charAt(i), --a);
                    
                    if(a == 0){
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
            }
        }
        
        return maxLen == 0 ? -1 : maxLen;
    }
}