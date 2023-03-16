import static java.lang.Math.*;
import static java.lang.System.*;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {

        static long mod = 1000000007;
        static HashMap<Integer,Pair> map;



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
                int q = in.nextInt();
                int[] ar = new int[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = in.nextInt();
                }
                long[][] dp = new long[n][2];
                for (long[] d:dp)Arrays.fill(d,-1);
                out.println(maxPokemon(ar,dp,0,1));

                // ---------------------------------------------------
            }
            out.close();
        } catch (Exception e) {
            out.println(e);
            return;
        }
    }
    private static   long maxPokemon(int[] ar,long[][] dp, int i, int op){
        if (i==ar.length)return 0;
        if (dp[i][op]!=-1)return dp[i][op];
        if (op == 1) {
            long take = ar[i] + maxPokemon(ar,dp,i+1,0);
            long notTake = maxPokemon(ar,dp,i+1,1);
            return dp[i][op] =  max(take,notTake);
        }
        long take = -ar[i] + maxPokemon(ar,dp,i+1,1);
        long notTake = maxPokemon(ar,dp,i+1,0);
        return dp[i][op] = max(take,notTake);
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