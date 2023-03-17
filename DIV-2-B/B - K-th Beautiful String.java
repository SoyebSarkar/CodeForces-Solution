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
                int k = in.nextInt();
                long start = 1;
                long end = n;
                long  posMax = 0;
                while (start<=end){
                    long mid = start + (end-start)/2;
                    long poss = ( mid *(mid-1))/2;
                    if (poss>=k){
                        posMax = mid;
                        end = mid-1;
                    }
                    else start = mid+1;
                }

                long firstB = posMax;
                long secondB =  (((posMax*(posMax-1))/2) - k);
                StringBuilder str = new StringBuilder();

                for (long i = firstB-1-secondB-1; i >0 ; i--) {
                    str.insert(0,'a');
                }

                str.insert(0,'b');
                for (long i = firstB-1; i > (firstB-1)-secondB; i--) {
                    str.insert(0,'a');
                }
                str.insert(0,'b');
                for (long i = firstB+1; i <=n ; i++) {
                    str.insert(0,'a');
                }
                out.println(str.toString());

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