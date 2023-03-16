import static java.lang.Math.*;
import static java.lang.System.*;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {

        static long mod = 1000000007;



    public static void main(String[] args) throws IOException {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();
//          Author: Soyeb Sarkar


            int testcases = in.nextInt();
//            int testcases = 1;
            while (testcases-- > 0) {
                //---------------------------------------------------------

                int n = in.nextInt();
                int x = in.nextInt();
                int[] ar = new int[n];
                long sum = 0;
                int tot = 0;
                for (int i = 0; i < n; i++) {
                    ar[i] = in.nextInt();
                    if (ar[i]%x!=0)tot++;
                    sum+=ar[i];

                }
                if (sum%x!=0){
                    out.println(n);
                    continue;
                }
                int left = -1;
                for (int i = 0; i < n; i++) {
                    if (ar[i]%x!=0){
                        left = i;
                        break;
                    }
                }
                if (left==-1){
                    out.println(-1);
                    continue;
                }
                int right = -1;
                for (int i = n-1; i >=0 ; i--) {
                    if (ar[i]%x!=0){
                        right = i;
                        break;
                    }
                }
                int ans = max(left,n-left-1);
                ans = max(ans,max(right,n-right-1));
                out.println(ans);
                // ---------------------------------------------------
            }
            out.close();
        } catch (Exception e) {
            out.println(e);
            return;
        }
    }



    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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
                str = br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }

}

class Pair{
    int fe;
    int se;
    Pair(int f, int s){
        this.fe = f;
        this.se = s;
    }
}