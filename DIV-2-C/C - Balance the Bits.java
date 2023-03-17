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
                if (ar[0]=='0' || ar[n-1]=='0'){
                    out.println("NO");
                    continue;
                }
                int zero = 0;
                for (int i = 0; i < n; i++) {
                    if (ar[i]=='0')zero++;
                }
                if (zero%2==1){
                    out.println("NO");
                    continue;
                }

                StringBuilder a = new StringBuilder();
                StringBuilder b = new StringBuilder();

                a.append('(');
                b.append('(');
                boolean O = true;
                boolean Z = true;
                for (int i = 1; i < n-1; i++) {
                    if (ar[i]=='1'){
                        if (O){
                            a.append('(');
                            b.append('(');
                        }
                        else {
                            a.append(')');
                            b.append(')');
                        }
                        O= !O;
                    }
                    else {
                        if (Z){
                            a.append('(');
                            b.append(')');
                        }
                        else {
                            a.append(')');
                            b.append('(');
                        }
                        Z= !Z;
                    }
                }
                a.append(')');
                b.append(')');
                out.println("YES");
                out.println(a.toString());
                out.println(b.toString());


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