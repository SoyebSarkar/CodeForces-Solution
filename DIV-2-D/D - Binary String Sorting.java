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
                char[] Carr = in.next().toCharArray();
                int[] ar = new int[Carr.length+1];

                int n = Carr.length;
                for (int i = 1; i <=n; i++) {
                    ar[i] = Carr[i-1]=='0'?0:1;
                }
                int[] prefixOne = new int[n+1];
                int[] suffixZero = new int[n+2];
                int one = 0;
                for (int i = 1; i <=n; i++) {
                    if (ar[i]==1)one++;
                    prefixOne[i] = one;
                }
                int zero = 0;
                for (int i = n; i >=1 ; i--) {
                    if (ar[i]==0)zero++;
                    suffixZero[i] = zero;
                }
                if (one==n || zero==n){
                    out.println(0);
                    continue;
                }

                out.println(min(firstZero(ar,prefixOne,suffixZero),firstOne(ar,prefixOne,suffixZero)));


                // ---------------------------------------------------
            }
            out.close();
        } catch (Exception e) {
            out.println(e);
            return;
        }
    }
    private static long firstOne(int[] ar,int[] prefixOne, int[] suffixZero){
        long c = (long) 1e12;
        int n = ar.length-1;
        long res = n*c;
        for (int i = 1; i <= n; i++) {
            if (i-1>=1 && ar[i]==0 && ar[i-1]==1){
                res = min(res,c + (prefixOne[i-1]+suffixZero[i]-2)*(c+1));
            }
            res = min(res,(prefixOne[i-1]+suffixZero[i])*(c+1));
        }
        return res;
    }
    private static long firstZero(int[] ar,int[] prefixOne, int[] suffixZero){
        long c = (long) 1e12;
        int n = ar.length-1;
        long res = n*c;
        for (int i = 1; i <= n; i++) {
            if (i+1<=n && ar[i]==1 && ar[i+1]==0){
                res = min(res,c + (prefixOne[i]+suffixZero[i+1]-2)*(c+1));
            }
            res = min(res,(prefixOne[i]+suffixZero[i+1])*(c+1));
        }
        return res;
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

