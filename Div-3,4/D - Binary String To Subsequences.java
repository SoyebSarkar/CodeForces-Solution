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
                char[] ar = in.next().toCharArray();

                int one = 0;
                PriorityQueue<Integer> pqOne = new PriorityQueue<>();
                int zero = 0;
                PriorityQueue<Integer> pqZero = new PriorityQueue<>();
                int[] subs = new int[n];
                subs[0] = 1;
                int tot = 2;
                for (int i = 1; i < n; i++) {
                    if (ar[i]!=ar[i-1]) {
                        subs[i] = 1;
                        continue;
                    }
                    if (ar[i]=='1'){
                        if (zero>0){
                            int count = pqZero.remove();
                            subs[i] = count;
                            pqOne.add(count);
                            zero--;
                        }else {
                            pqOne.add(tot);
                            subs[i] = tot;
                            tot++;
                        }
                        one++;
                    }
                    else {
                        if (one>0) {
                            int count = pqOne.remove();
                            subs[i] = count;
                            pqZero.add(count);
                            one--;
                        }
                        else {
                            pqZero.add(tot);
                            subs[i] = tot;
                            tot++;
                        }
                        zero++;
                    }
                }
                out.println(one+zero+1);
                for (Integer x:subs){
                    out.print(x+" ");
                }
                out.println("");


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