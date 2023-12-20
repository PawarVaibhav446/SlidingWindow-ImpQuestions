import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class MaximumSumOfDistinctSubarrayOfSizeK {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {

        FastReader input = new FastReader();
        int n = input.nextInt();
        int k = input.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = input.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;
        long sum = 0;
        long maxSum = 0;

        while(j < n){
            map.put(nums[j] , map.getOrDefault(nums[j], 0) + 1);
            sum += nums[j];

            if(j - i + 1 < k){
                j++;
            }else if(j - i + 1 == k){
                if(map.size() == k){
                    maxSum = Math.max(sum , maxSum);
                }
                sum -= nums[i];
                map.put(nums[i], map.get(nums[i]) - 1);                  
				if (map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
				i++;
                j++;
            }
        }

        System.out.println(maxSum);

    }
}
