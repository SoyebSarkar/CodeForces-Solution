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
                StringBuilder str = new StringBuilder(in.next());
                StringBuilder a = new StringBuilder();
                StringBuilder b = new StringBuilder();
                boolean bigNum = true;
                for (int i = 0; i < n; i++) {
                    int dig = str.charAt(i)-'0';
                    if ((dig==1 && i==0) || (dig==0 && i==0)){
                        int num1 = 2;
                        int num2 = dig==0?1:2;
                        a.append(num1);
                        b.append(num2);
                        if (num1!=num2)bigNum = false;
                    }
                    else if (dig==1){
                        if (bigNum){
                            a.append(1);
                            b.append(0);
                            bigNum = false;
                        }
                        else {
                            a.append(0);
                            b.append(1);
                        }
                    }
                    else if (dig==2){
                        if (bigNum){
                            a.append(1);
                            b.append(1);
                        }
                        else {
                            a.append(0);
                            b.append(2);
                        }

                    }
                    else {
                        a.append(0);
                        b.append(0);
                    }
                }
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