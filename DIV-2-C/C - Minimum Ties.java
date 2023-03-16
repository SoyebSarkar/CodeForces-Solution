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
                int[][] ar = new int[n][n];
                int winPer = ((n*(n-1))/2)/n;
                map = new HashMap<>();

                if (n%2==1){
                    for (int i = 0; i<n ; i++) {
                        int win = (n-1)/2;
                        for (int j = i+1; j < n; j++) {
                            if (win>0){
                                out.print(1+" ");
                                win--;
                            }
                            else out.print(-1+" ");
                        }

                    }
                }
                else {
                    for (int i = 0; i < n; i++) {
                        map.put(i,new Pair((n-2)/2,(n-2)/2));
                    }
                    for (int i = 0; i < n; i++) {
                        for (int j = i+1; j < n; j++) {
                            if (i%2==0 && j==i+1){
                                out.print(0+" ");
                                continue;
                            }
                            if (map.get(i).fe>0 && map.get(j).se>0){
                                map.get(i).fe--;
                                map.get(j).se--;
                                out.print(1+" ");
                            }
                            else {
                                map.get(j).fe--;
                                map.get(i).se--;
                                out.print(-1+" ");
                            }
                        }
                    }


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