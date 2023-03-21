
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
                int[] ar = new int[n+1];
                for (int i = 1; i <= n; i++) {
                    ar[i] = in.nextInt();
                }
                long res = 0;
                if (n%2==1){
                    for (int i = 2; i < n; i+=2) {
                        res+=max(0, max(ar[i-1],ar[i+1])-ar[i] +1);
                    }
                    out.println(res);
                    continue;
                }


                long[] prefix = new long[n+1];
                long[] suffix = new long[n+3];
                for (int i = 2; i+1 <=n ; i++) {
                    if (i%2==1){
                        prefix[i] = prefix[i-1];
                        continue;
                    }
                    prefix[i] = prefix[i-1] + max(0,max(ar[i+1],ar[i-1])-ar[i]+1);

                }
                for (int i = n-1; i-1 >=1 ; i--) {
                    if (i%2==0){
                        suffix[i] =suffix[i+1];
                        continue;
                    }
                    suffix[i] = suffix[i+1] + max(0,max(ar[i+1],ar[i-1])-ar[i]+1);
                }
                long ans = -1;
                res = Long.MAX_VALUE;
                for (int i = 1; i<=n; i+=2) {
                    ans= prefix[i-1] + suffix[i+2];
                    res = min(res,ans);
                }

                out.println(res);


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

