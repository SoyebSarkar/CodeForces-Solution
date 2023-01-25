import static java.lang.Math.*;
import static java.lang.System.*;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

import static java.lang.System.out;

public class Main {

    static long mod = (long) 1e9 + 7;


    public static void main(String[] args) {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();

//          Author: Soyeb Sarkar

            int testcases = in.nextInt();
//             int testcases = 1;
            while (testcases-- > 0) {
//---------------------------------------------------------
               int n = in.nextInt();
               int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                }
                sort(arr);
                int move = Integer.MAX_VALUE;
                int j = 1;
                for (int i = 0; i < n-1; i++) {
                    if (arr[i]==0)continue;
                    if (arr[i]==1 && arr[i+1]==1){
                        move = min(move,j+(n-(i+2)));
                        i++;
                    }
                    else break;
                    j++;
                }
                out.println(min(move,n));


//// ---------------------------------------------------
            }

            out.close();
        } catch (Exception e) {
            out.println(e);
            return;
        }
    }

    static long factorial(long n)
    {
        long res = 1, i;
        for (i=2; i<=n; i++)
            res = (res*i)%mod;
        return res%mod;
    }


/*---------------------------------------------------------------------------------------
                            Template Credit - MagentaCobra
--------------------------------------------------------------------------------------- */

    public static void sort(int[] arr) {
        //because Arrays.sort() uses quicksort which is dumb
        //Collections.sort() uses merge sort
        ArrayList<Integer> ls = new ArrayList<Integer>();
        for (int x : arr)
            ls.add(x);
        Collections.sort(ls);
        for (int i = 0; i < arr.length; i++)
            arr[i] = ls.get(i);
    }

    public static void sort(long[] arr) {
        //because Arrays.sort() uses quicksort which is dumb
        //Collections.sort() uses merge sort
        ArrayList<Long> ls = new ArrayList<Long>();
        for (long x : arr)
            ls.add(x);
        Collections.sort(ls);
        for (int i = 0; i < arr.length; i++)
            arr[i] = ls.get(i);
    }

    public static void print(int[] arr) {
        //for debugging only
        for (int x : arr)
            out.print(x + " ");
        out.println();
    }

    static long gcd(long a, long b) {
        if (b == 0)
            return a;

        else
            return gcd(b, a % b);
    }

    /*-----------------------------------------------------------------------------------------------
            End for MagentaCobra's Template
    ------------------------------------------------------------------------------------------------        */


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

class Pair {
    //    long f;
//    long s;
//    Pair(long h, long s){
//        this.f = h;
//        this.s = s;
//    }
    int cost;
    boolean b;

    Pair(int c, boolean bool) {
        cost = c;
        b = bool;
    }
}