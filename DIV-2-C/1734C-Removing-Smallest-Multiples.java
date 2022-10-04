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
        StringBuilder str = new StringBuilder('9'+s);
        long cost =0;
        for (int i = 1; i <= n; i++) {
            if (str.charAt(i)=='0'){
                cost+=i;
                int fact = 2;
                while (fact*i<=n){

                    if (fact*i<=n && str.charAt((fact*i))=='0'){
                        cost+=i;
                        str.setCharAt((fact*i),'9');
                    }
                    else if(fact*i<=n && str.charAt(fact*i)!='9') break;
                    fact++;
                }

            }
            else if(str.charAt(i)=='9'){
                int fact = 2;
                while (fact*i<=n){

                    if (fact*i<=n && str.charAt((fact*i))=='0'){
                        cost+=i;
                        str.setCharAt((fact*i),'9');
                    }
                    else if(fact*i<=n && str.charAt(fact*i)!='9') break;
                    fact++;
                }
            }
        }
        System.out.println(cost);

    }


}