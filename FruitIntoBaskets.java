import java.util.HashMap;

class Solution {
    public int totalFruit(int[] fruits) {
        
        int n = fruits.length;
        int i = 0;
        int j = 0;
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        if(fruits.length == 1){
            return 1;
        }

        while(j < n){
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);

            if(map.size() <= 2){
                maxLen = Math.max(maxLen, j - i + 1);
            }

            j++;

            if(map.size() > 2){
                while(map.size() > 2){
                    int a = map.get(fruits[i]);
                    map.put(fruits[i], --a);

                    if(a == 0){
                        map.remove(fruits[i]);
                    }
                    i++;
                }
            }
        }

        return maxLen;
    }
}