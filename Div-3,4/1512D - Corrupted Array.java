
import static java.lang.Math.*;

import java.lang.management.MonitorInfo;
import java.util.*;
import java.io.*;

import static java.lang.System.console;
import static java.lang.System.out;

public class Main {

    static ArrayList<Integer> prime = new ArrayList<>();
    static long mod = 1000000007;
    public static void main(String[] args) throws IOException {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();


            int testcases = in.nextInt();
            //             int testcases = 1;

            while (testcases-- > 0) {
                //---------------------------------------------------------
                int n = in.nextInt();
                n+=2;
                HashMap<Long,Integer> map = new HashMap<>();
                long[] ar = new long[n];
                long sum = 0;
                for (int i = 0; i < n; i++) {
                    ar[i] = in.nextLong();
                    map.put(ar[i],i);
                    sum+=ar[i];
                }
                int sumIndex = -1;
                int ithIndex = -1;
                for (int i = 0; i < n; i++) {
                    long x = sum-ar[i];
                    if (x%2==1)continue;
                    if (map.containsKey(x/2)){
                        if (map.get((x+1)/2)==i)continue;
                        sumIndex = map.get((x+1)/2);
                        ithIndex = i;
                        break;
                    }
                }
                if (sumIndex==-1 && ithIndex==-1){
                    out.println(-1);
                    continue;
                }
                for (int i = 0; i < n; i++) {
                    if (i==sumIndex || i==ithIndex)continue;
                    out.print(ar[i]+" ");
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

    private static long sumDigit(long l) {
        long sum = 0;
        while (l>0){
            sum+=(l%10);
            l/=10;
        }
        return sum;
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
    static int fact(int n)
    {
        if(n==0)
            return 1;
        int res = 1;
        for (int i = 2; i <= n; i++)
            res = res * i;
        return res;
    }
    static int nCr(int n, int r)
    {
        return fact(n) / (fact(r) *
                fact(n - r));
    }
    static long power(long a, long n){
        long res = 1;
        while (n>0){
            if (n%2==1){
                res = (res*a)%mod;
                n--;
            }
            else {
                a = (a * a) % mod;
                n/=2;
            }
        }
        return res;
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
    long f;
    long s;
    Pair(long h, long s){
        this.f = h;
        this.s = s;
    }
}