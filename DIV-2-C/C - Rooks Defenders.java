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


//            int testcases = in.nextInt();
            int testcases = 1;
            while (testcases-- > 0) {
                //---------------------------------------------------------
                int N = in.nextInt();
                int q = in.nextInt();
                BIT rows = new BIT(N);
                BIT cols = new BIT(N);
                int[] r = new int[N+1];
                int[] c = new int[N+1];
                for (int i = 0; i < q; i++) {
                    int type = in.nextInt();
                    int x = in.nextInt();
                    int y = in.nextInt();
                    if (type==1){
                        r[x]++;
                        c[y]++;
                       if (r[x]==1)rows.update(x,1);
                       if (c[y]==1)cols.update(y,1);
                    }
                    else if (type==2){
                        r[x]--;
                        c[y]--;
                        if (r[x]==0)rows.update(x,-1);
                        if (c[y]==0)cols.update(y,-1);
                    }else {
                        int x2 = in.nextInt();
                        int y2 = in.nextInt();

                        if (rows.get(x,x2)==(x2-x)+1 || cols.get(y,y2)==(y2-y)+1){
                            out.println("YES");
                        }
                        else out.println("NO");
                    }
                }
                // ---------------------------------------------------
            }
            out.close();
        } catch (Exception e) {
            out.println(e);
            return;
        }
    }


        static class BIT {
            int[] val;

            BIT(int n) {
                val = new int[n + 1];
            }

            void update(int i, int x) {
                while (i < val.length) {
                    val[i] += x;
                    i += i & -i;
                }
            }

            int get(int i) {
                int sum = 0;
                while (i > 0) {
                    sum += val[i];
                    i -= i & -i;
                }
                return sum;
            }

            int get(int l, int r) {// sum of [l , r]
                return get(r) - get(l - 1);
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

