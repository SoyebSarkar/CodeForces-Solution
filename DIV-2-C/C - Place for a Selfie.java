import static java.lang.Math.*;
import static java.lang.System.*;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;


public class Main {

    static long mod = 1000000007;
    static long Inf = (long) 1E15;


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
                TreeSet<Integer> treeSet = new TreeSet<>();
                for (int i = 0; i < n; i++) {
                    int x = in.nextInt();
                    treeSet.add(x);
                }
                for (int i = 0; i < m; i++) {
                    long a = in.nextLong();
                    long b = in.nextLong();
                    long c = in.nextLong();

                    boolean ok = true;
                    Integer val = treeSet.ceiling((int) b);
                    if (val!=null){
                        long bb = b-val;
                        if (bb * bb < 4 * a * c){
                            out.println("YES");
                            out.println(val);
                            ok = false;
                        }
                    }
                    if (ok){
                        val = treeSet.floor((int) b);
                        if (val!=null){
                            long bb = b-val;
                            if (bb * bb < 4 * a * c){
                                out.println("YES");
                                out.println(val);
                                ok = false;
                            }
                        }
                    }
                    if (ok)out.println("NO");

                }


                // ---------------------------------------------------
            }
            out.close();
        } catch (Exception e) {
            out.println(e);
            return;
        }
    }
    private static int bSearch(int[] ar, int target){

        return -1;
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

