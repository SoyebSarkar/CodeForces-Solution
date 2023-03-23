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
                char[] ar2 = in.next().toCharArray();
                boolean ok = true;
                for (int i = n-1; i >=0; i--) {
                    if (ar[i]==ar2[i])continue;
                    if (ar2[i]=='a' && ar[i]=='b'){
                        int j = i;
                        while (j>=0 && ar[j]=='b'){
                            j--;
                        }
                        if (j==-1 || ar[j]!='a'){
                            ok = false;
                            break;
                        }
                        ar[j] = 'b';
                        continue;
                    }
                    if (ar2[i]=='b' && ar[i]=='c'){
                        int j = i;
                        while (j>=0 && ar[j]=='c'){
                            j--;
                        }
                        if (j==-1 || ar[j]!='b'){
                            ok = false;
                            break;
                        }
                        ar[j] = 'c';
                        continue;
                    }
                    ok = false;
                    break;
                }
                out.println(ok?"YES":"NO");
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

