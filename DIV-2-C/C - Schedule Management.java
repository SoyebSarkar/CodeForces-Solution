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
                int m = in.nextInt();
                HashMap<Integer,Integer> map = new HashMap<>();
                for (int i = 0; i < m; i++) {
                    int x = in.nextInt();
                    map.put(x,map.getOrDefault(x,0)+1);
                }
                int low =1;
                int high = 2*m;
                int res = m;
                while (low<=high){
                    int mid = low + (high-low)/2;
                    long left = 0;
                    long extra = 0;
                    for (int i = 1; i <=n; i++) {
                        int cur = map.getOrDefault(i,0);
                        if (cur>mid){
                            left+=cur-mid;
                        }
                        else extra+=(mid-cur)/2;
                    }
                    if (left<=extra){
                        res = mid;
                        high = mid-1;
                    }
                    else low = mid+1;
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

