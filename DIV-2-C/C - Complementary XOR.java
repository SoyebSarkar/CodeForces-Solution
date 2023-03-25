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
                char[] a = in.next().toCharArray();
                char[] b = in.next().toCharArray();
                boolean isEqual = false;
                if (a[0]==b[0])isEqual= true;
                boolean notPossible = false;
                for (int i = 0; i < n; i++) {
                    if ((a[i]==b[i] && !isEqual) || (a[i]!=b[i] && isEqual)){
                        notPossible = true;
                        break;
                    }
                }
                if (notPossible){
                    out.println("NO");
                    continue;
                }
                StringBuilder str = new StringBuilder();
                int op = 0;
                for (int i = 0; i < n; i++) {
                    if (a[i]=='1'){
                        str.append(i+1).append(" ").append(i+1).append("\n");
                        op++;
                        isEqual = !isEqual;
                    }
                }
                if (!isEqual){
                    str.append(1).append(" ").append(1).append("\n");
                    str.append(2).append(" ").append(n).append("\n");
                    str.append(1).append(" ").append(n).append("\n");
                    op+=3;
                }
                out.println("YES");
                out.println(op);
                out.print(str.toString());
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

