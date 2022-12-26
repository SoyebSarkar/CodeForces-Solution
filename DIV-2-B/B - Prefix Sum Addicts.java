

import static java.lang.Math.*;
import static java.lang.System.*;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
import java.math.*;
import static java.lang.System.out;

public class Main {

    static ArrayList<Integer> prime = new ArrayList<>();
    static long mod = 1000000007;

    public static void main(String[] args) {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();


            int testcases = in.nextInt();
//             int testcases = 1;

            while ( testcases -- > 0 ) {
//---------------------------------------------------------
                int n = in.nextInt();
                int k = in.nextInt();
                long[] arr = new long[k];
                for (int i = 0; i < k; i++) {
                    arr[i] = in.nextLong();
                }
                long max = Long.MIN_VALUE;
                if (n==k){
                    max = arr[0];
                }
                else {
                    int left = (n-k)+1;
                    long per = (long) ceil((1.0*arr[0])/left);
                    max  = per;
                }
                boolean flag = false;
                for (int i = 0; i < k-1; i++) {
                    long next = arr[i+1] - arr[i];
                    if (max > next){
                        flag = true;
                        break;
                    }
                    max = max(max,next);
                }
                if (flag){
                    System.out.println("No");
                }
                else {
                    System.out.println("Yes");
                }


            }


// ---------------------------------------------------
            out.close();
        } catch (Exception e) {
            out.println(e);
            return;
        }
    }



/*---------------------------------------------------------------------------------------
                            Template Credit - MagentaCobra
--------------------------------------------------------------------------------------- */

    public static void sort(int[] arr)
    {
        //because Arrays.sort() uses quicksort which is dumb
        //Collections.sort() uses merge sort
        ArrayList<Integer> ls = new ArrayList<Integer>();
        for(int x: arr)
            ls.add(x);
        Collections.sort(ls);
        for(int i=0; i < arr.length; i++)
            arr[i] = ls.get(i);
    }
    public static void sort(long[] arr)
    {
        //because Arrays.sort() uses quicksort which is dumb
        //Collections.sort() uses merge sort
        ArrayList<Long> ls = new ArrayList<Long>();
        for(long x: arr)
            ls.add(x);
        Collections.sort(ls);
        for(int i=0; i < arr.length; i++)
            arr[i] = ls.get(i);
    }
    public static void print(int[] arr)
    {
        //for debugging only
        for(int x: arr)
            out.print(x+" ");
        out.println();
    }
    static long gcd(long a, long b)
    {
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