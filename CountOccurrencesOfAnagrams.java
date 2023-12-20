import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CountOccurrencesOfAnagrams {
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
      
        String pat = input.next();
        String txt = input.next();

        // Given Window Size -> k
        // i -> start of the window
        // j -> end of the window

        // Current Window Size -> j - i + 1


        int k = pat.length();
        HashMap<Character, Integer> patMap = new HashMap<>();
        
        for(int i = 0;i < k;i++){
            patMap.put(pat.charAt(i), patMap.getOrDefault(pat.charAt(i), 0) + 1);
        }
        
        int i = 0;
        int j = 0;
        int count = patMap.size();
        int ans = 0;
        
        while(j < txt.length()){
            if(patMap.containsKey(txt.charAt(j))){
                int a = patMap.get(txt.charAt(j));
                patMap.put(txt.charAt(j), --a);
                if(a == 0){
                    count--;
                }
            }
            
            if(j - i + 1 < k){
                j++;
            }else if(j - i + 1 == k){
                if(count == 0){
                    ans++;
                }
                
                if(patMap.containsKey(txt.charAt(i))){
                    int a = patMap.get(txt.charAt(i));
                    if(a == 0){
                        count++;
                    }
                    patMap.put(txt.charAt(i), ++a);
                }
                i++;
                j++;
            }
        }
        
        System.out.println(ans);

    }
}
