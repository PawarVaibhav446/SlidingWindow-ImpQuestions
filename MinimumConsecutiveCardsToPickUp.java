import java.util.HashMap;

class Solution {
    public int minimumCardPickup(int[] cards) {
        int n = cards.length;
        int j = 0;
        int ans = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (j < n) {
            if(map.containsKey(cards[j])){
                int a = map.get(cards[j]);
                ans = Math.min(j - a + 1, ans);
            }

            map.put(cards[j], j);
            j++;
        }

        ans = (ans == Integer.MAX_VALUE) ? -1 : ans;
        return ans;
    }
}
