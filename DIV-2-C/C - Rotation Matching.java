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
                int n = in.nextInt();
                HashMap<Integer,Integer> map = new HashMap<>();
                for (int i = 1; i <=n ; i++) {
                    int x = in.nextInt();
                    map.put(x,i);
                }
                HashMap<Integer,Integer> rightMap = new HashMap<>();
                HashMap<Integer,Integer> leftMap = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    int x = in.nextInt();
                    int prevIdx = map.get(x);
                    int curIdx = i+1;
                    int right = (prevIdx>=curIdx)?prevIdx-curIdx:(n-curIdx)+prevIdx;
                    int left = (curIdx>prevIdx)?curIdx-prevIdx:curIdx+(n-prevIdx);
                    rightMap.put(right,rightMap.getOrDefault(right,0)+1);
                    leftMap.put(left,leftMap.getOrDefault(left,0)+1);

                }
                int max = 1;
                for(Integer val:rightMap.values())max = max(max,val);
                for(Integer val: leftMap.values())max = max(max,val);
                out.println(max);



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