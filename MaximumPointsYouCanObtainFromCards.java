class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int n = cardPoints.length;
        int i = 0;
        int j = 0;
        int minSum = Integer.MAX_VALUE;
        int sum = 0;
        int totalSum = 0;
        int windowSize = n - k;

        while(j < n){
            totalSum += cardPoints[j];
            sum += cardPoints[j];
            if(j - i + 1 < windowSize){
                j++;
            }else{
                minSum = Math.min(minSum, sum);
                sum -= cardPoints[i];
                i++;
                j++;
            }
        }

        if(windowSize == 0){
            return totalSum;
        }

        return totalSum - minSum;
    }
}