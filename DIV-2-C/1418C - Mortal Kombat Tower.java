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
                int[] ar = new int[n];
                int[][] dp = new int[n][2];
                for(int[] temp:dp)Arrays.fill(temp,-1);
                for (int i = 0; i < n; i++) {
                    ar[i] = in.nextInt();
                }
                out.println(coin(ar,dp,0,0));
                // ---------------------------------------------------
            }
            out.close();
        } catch (Exception e) {
            out.println(e);
            return;
        }
    }
    private static int coin(int[] ar,int[][] dp, int i, int turn){
        if (i>=ar.length)return 0;
        if (dp[i][turn]!=-1)return dp[i][turn];
        int f = ar[i];
        int s = i+1<ar.length?ar[i+1]:-1;
        if (turn==0){
            int c = ar[i]==1?1:0;
            int need = 0;
             int pas1 = coin(ar,dp,i+1,1) + c;
            int pas2 = Integer.MAX_VALUE;
            if (s!=-1){
                c+=ar[i+1]==1?1:0;
                pas2 = c + coin(ar,dp,i+2,1);
            }
            return dp[i][turn] =  min(pas1,pas2);
        }
        int pas1 = coin(ar,dp,i+1,0);
        int pas2 = Integer.MAX_VALUE;
        if (s!=-1)pas2 = coin(ar,dp,i+2,0);
        return dp[i][turn] =  min(pas1,pas2);

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