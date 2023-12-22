import java.util.HashMap;

class Solution{
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
        
        int maxLen = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0;i < N;i++){
            sum += A[i];
            if(sum == K){
                maxLen = Math.max(maxLen, i + 1);
            }
            
            int remSum = sum - K;
            if(map.containsKey(remSum)){
                int len = i - map.get(remSum);
                maxLen = Math.max(maxLen, len);
            }
            
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        
        return maxLen;
        
    }
}