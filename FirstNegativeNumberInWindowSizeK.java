import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FirstNegativeNumberInWindowSizeK {
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

        // Sum all the elements while you havent reached your window size, if u have
        // reached it then
        // perform necessary mathemathical operations.

        // Increment j if you havent reached, if reached then increment both i and j.

        ArrayList<Long> list = new ArrayList<>();
        ArrayList<Long> ans = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (j < n) {
            if (a[j] < 0) {
                list.add((long) a[j]);
            }

            if(j - i + 1 < k){
                j++;
            }else if(j - i + 1 == k){
                if(list.isEmpty()){
                    ans.add((long) 0);
                }else{
                    ans.add(list.get(0));
                    if (a[i] < 0) {
                        list.remove(0);
                    }
                }
                j++;
                i++;
                
            }
        }

        for (int l = 0; l < list.size(); l++) {
            System.out.print(list.get(l) + " ");
        }

    }
}
