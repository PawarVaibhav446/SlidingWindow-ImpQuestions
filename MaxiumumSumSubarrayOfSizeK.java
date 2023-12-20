import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxiumumSumSubarrayOfSizeK{

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

        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = input.nextInt();
        }


        // Given Window Size -> k
        // i -> start of the window
        // j -> end of the window

        // Current Window Size -> j - i + 1

        // Sum all the elements while you havent reached your window size, if u have reached it then
        // perform necessary mathemathical operations.

        // Increment j if you havent reached, if reached then increment both i and j.

        int i = 0;
        int j = 0;

        int sum = 0;
        int max = Integer.MIN_VALUE;

        while(j < n){
            sum += a[j];
            if(j - i + 1 < k){
                j++;
            }else if(j - i + 1 == k){
                max = Math.max(sum, max);
                sum -= a[i];
                i++;
                j++;
            }
        }

        System.out.println(max);
    }
}