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
                int x = in.nextInt();

                int n = ar.length;
                int[] given = new int[n];
                for (int i = 0; i < n; i++) {
                    given[i] = ar[i]-'0';
                }
                int[] ans = new int[n];
                boolean possible = true;
                for (int i = 0; i < n; i++) {
                    int left = i-x;
                    int right = i+x;
                    if (given[i]==1){
                        if (left>=0 && ans[left]!=2)ans[left] = 1;
                        if (right<n && ans[right]!=2)ans[right] =1;
                    }
                    else {
                        if (left>=0)ans[left] = 2;
                        if (right<n)ans[right] = 2;
                    }
                }
                for (int i = 0; i < n; i++) {
                    int left = i-x;
                    int right = i+x;
                    boolean l = true;
                    boolean r = true;
                    if (given[i]==1){
                        l=false;
                        r=false;
                        if (left>=0)l = ans[left]==1;
                        if (right<n)r= ans[right]==1;
                        if (!(l||r))possible = false;
                    }
                    else {
                        if (left>=0)l = ans[left]==2;
                        if (right<n)r= ans[right]==2;
                        if (!(l&&r))possible = false;
                    }

                }
                if (!possible)out.println(-1);
                else {
                    for (int ch:ans) {
                        int num = (ch==1)?1:0;
                        out.print(num);
                    }
                    out.println("");
                }


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