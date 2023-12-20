class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        
        int n = nums.length;
        int[] freq = new int[51];
        int[] res = new int[nums.length - k + 1];

        for(int i = 0, j = 0, idx = 0; i < n; i++) {

            if(nums[i] < 0){
                freq[Math.abs(nums[i])]++;
            } 
            
            if(i - j + 1 >= k) {
                int cnt = 0;

                for(int L = 50; L >= 1; L--) {
                    cnt += freq[L];
                    if(cnt >= x){ 
                        res[idx++] = -L; 
                        break;
                    }
                }

                if(cnt < x){
                    res[idx++] = 0;
                } 

                if(nums[j] < 0){
                    freq[Math.abs(nums[j])]--;
                } 
                
                j++;
            }
        }

        return res;
    }
}