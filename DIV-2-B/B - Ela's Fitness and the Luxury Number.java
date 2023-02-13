
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
//                             int testcases = 1;

            while (testcases-- > 0) {
                //---------------------------------------------------------
                long l = in.nextLong();
                long r = in.nextLong();
                long count = 0;
                long sqrtL = (long) floor(sqrt(l));
                for (long i =0; i < 3; i++) {
                    long val = (sqrtL+i)*(sqrtL);
                    if (val>=l && val<=r)count++;
                }
                long sqrtR = (long) floor(sqrt(r));
                if (sqrtR!=sqrtL){
                    for (long i =0; i < 3; i++) {
                        long val = (sqrtR+i)*(sqrtR);
                        if (val>=l && val<=r)count++;
                    }
                }
                count+= 3*max(0,sqrtR-sqrtL-1);
                out.println(count);

                // ---------------------------------------------------
            }
            out.close();
        } catch (Exception e) {
            out.println(e);
            return;
        }
    }
    private static boolean help(char[][] ar,int i, int j, int B, int count){
        if (count+1 ==B)return true;
        if (ar[i][j]=='B'){
            if (i==0){
                if (ar[1][j]=='W' && (j==ar[0].length-1 || ar[0][j+1]=='W')){
                    return count + 1 == B;
                }
            }
            else {
                if (ar[0][j]=='W' && (j==ar[0].length-1 || ar[1][j+1]=='W')) return count+1 ==B;
            }
        }
        boolean ans = false;
        if (i==0 && ar[1][j]=='B') {
            if (j==ar[0].length-1 || ar[1][j+1]=='W') ans =ans|| (count + 2 == B);
            else ans = ans||help(ar,1,j+1,B,count+2);
        }
        else if (i==0 && ar[0][j+1]=='B') ans = ans || help(ar,i,j+1,B,count+1);
        if (i==1 && ar[0][j]=='B') {
            if (j==ar[0].length-1 || ar[0][j+1]=='W') ans =ans|| (count + 2 == B);
            else ans = ans||help(ar,0,j+1,B,count+2);
        }
        else if (i==1 && ar[1][j+1]=='B') ans = ans || help(ar,i,j+1,B,count+1);
        return ans;

    }

    private static long sumDigit(long l) {
        long sum = 0;
        while (l > 0) {
            sum += (l % 10);
            l /= 10;
        }
        return sum;
    }

    private static int SubArraySize3(int n){
        int numOfSubArr = ((n*(n+1)))/2;
        return numOfSubArr- (2*n)+1;
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
    private static long sqrt(long num) {
        long l = 0;
        long h = Integer.MAX_VALUE;
        long mid;
        while (h - l > 1) {
            mid = (h + l)/2;

            if (mid*mid <= num) {
                l = mid;
            }else {
                h = mid;
            }
        }
        return l;
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

    static int fact(int n) {
        if (n == 0)
            return 1;
        int res = 1;
        for (int i = 2; i <= n; i++)
            res = res * i;
        return res;
    }

    static int nCr(int n, int r) {
        return fact(n) / (fact(r) *
                fact(n - r));
    }

    static long power(long a, long n) {
        long res = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                res = (res * a) % mod;
                n--;
            } else {
                a = (a * a) % mod;
                n /= 2;
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

    Pair(long h, long s) {
        this.f = h;
        this.s = s;
    }
}