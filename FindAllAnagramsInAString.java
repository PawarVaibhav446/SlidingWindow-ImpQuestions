import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s2, String s1) {

        int k = s1.length();
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0;i < k;i++){
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }

        int i = 0;
        int j = 0;
        int count = map.size();
        ArrayList<Integer> ans = new ArrayList<>();

        while(j < s2.length()){
            if(map.containsKey(s2.charAt(j))){
                int a = map.get(s2.charAt(j));
                map.put(s2.charAt(j), --a);
                if(a == 0){
                    count--;
                }
            }

            if(j - i + 1 < k){
                j++;
            }else if(j - i + 1 == k){
                if(count == 0){
                    ans.add(i);
                }

                if(map.containsKey(s2.charAt(i))){
                    int a = map.get(s2.charAt(i));
                    if(a == 0){
                        count++;
                    }
                    map.put(s2.charAt(i), ++a);
                }
                i++;
                j++;
            }
        }

        return ans;
    }
}