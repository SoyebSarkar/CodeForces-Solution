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

                char[] ar = in.next().toCharArray();
                int n =ar.length;
                int numberOfOnes = 0;
                int numberOfZeros = 0;
                for (int i = 0; i < n; i++) {
                    if (ar[i]=='0')numberOfZeros++;
                    else numberOfOnes++;
                }
                if (numberOfOnes==0 || numberOfZeros==0){
                    out.println(0);
                    continue;
                }
                int oneSoFar = 0;
                int zeroSoFar = 0;
                int operation = Integer.MAX_VALUE;
                for (int i = 0; i < n; i++) {
                    if (ar[i]=='0')zeroSoFar++;
                    else oneSoFar++;
                    operation = min(operation,zeroSoFar + (numberOfOnes - oneSoFar));
                    operation = min(operation,oneSoFar + (numberOfZeros - zeroSoFar));
                }
                out.println(operation);

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