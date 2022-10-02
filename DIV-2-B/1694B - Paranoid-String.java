
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class FastReader {
        public BufferedReader br;
        public StringTokenizer st;

        public FastReader(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
            st = null;
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader(new BufferedInputStream(System.in));
        int times = sc.nextInt();
        while (times-- > 0){
            solve(sc);
        }


    }
    public static void solve(FastReader sc){
        int n = sc.nextInt();
        String s = sc.next();
        long pairs = 0;
        StringBuilder str = new StringBuilder(s);
        for (int i = str.length()-1; i >=0; i--) {
            if (i>0 && str.charAt(i)!=str.charAt(i-1)){
                pairs+=i+1;
            }
            else {
                pairs++;
            }
        }
        System.out.println(pairs);


    }



}