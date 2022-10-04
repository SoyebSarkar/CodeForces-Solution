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
        StringBuilder str = new StringBuilder(s);
        int i=str.length()-2;
        int j=i+1;
        while (i>=0){
            if(j < str.length() - 1 && str.charAt(i) == '1' && str.charAt(j) == '0' && str.charAt(j + 1) == '0'){
                str.deleteCharAt(j+1);
            }
            else if(str.charAt(i)=='1' && str.charAt(j)=='0'){
                str.deleteCharAt(i);
                 i=str.length()-2;
                 j=i+1;
            }
            else {
                i--;
                j--;
            }
        }
        System.out.println(str.toString());


    }



}