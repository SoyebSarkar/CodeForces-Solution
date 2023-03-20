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
                int m = in.nextInt();
                HashMap<Integer, List<Integer>> need = new HashMap<>();
                HashMap<Integer,Integer> have = new HashMap<>();
                int[] ar = new int[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = in.nextInt();
                }
                for (int i = 0; i < n; i++) {
                    int x = in.nextInt();
                    if (ar[i]==x){
                        have.put(x,i+1);
                    }
                    else {
                        if (!need.containsKey(x))need.put(x,new ArrayList<>());
                        need.get(x).add(i+1);
                    }
                }
                StringBuilder res = new StringBuilder();
                int wrong = 0;
                for (int i = 0; i < m; i++) {
                    int x = in.nextInt();
                    if (need.containsKey(x)){

                        List<Integer> ll = need.get(x);
                        while (wrong>0){
                            res.append(ll.get(0)).append(" ");
                            wrong--;
                        }
                        res.append(ll.get(0)).append(" ");
                        have.put(x,ll.get(0));

                        ll.remove(0);
                        if (ll.size()==0)need.remove(x);
                    }
                    else if (have.containsKey(x)){
                        while (wrong>0){
                            res.append(have.get(x)).append(" ");
                            wrong--;
                        }
                        res.append(have.get(x)).append(" ");

                    }
                    else {
                       wrong++;
                    }
                }
                if (wrong>0 || need.size()>0){
                    out.println("NO");
                    continue;
                }
                out.println("YES");
                out.println(res.toString());
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