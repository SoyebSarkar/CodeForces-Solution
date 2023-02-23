import static java.lang.Math.*;

import java.lang.management.MonitorInfo;
import java.security.Key;
import java.util.*;
import java.io.*;

import static java.lang.System.console;
import static java.lang.System.out;

public class Main {

    static long mod = 1000000007;

    public static void main(String[] args) throws IOException {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();


            int testcases = in.nextInt();
//                             int testcases = 1;

            while (testcases-- > 0) {
                //---------------------------------------------------------
                int n = in.nextInt();
                int m = in.nextInt();
                int[][] given = new int[n][m];
                int[][] have = new int[n][m];
                for (int i = 0; i < n; i++) {
                    String s = in.next();
                    for (int j = 0; j < m; j++) {
                        given[i][j] = Character.getNumericValue(s.charAt(j));
                    }
                }
                boolean No = false;
                StringBuilder str = new StringBuilder();
                int count = 0;
                for (int i = n-1; i >=0; i--) {
                    for (int j = m-1; j >=0; j--) {
                        if (given[i][j] != have[i][j]){
                            if (given[i][j]==1){
                                boolean top =(i>0 && have[i-1][j]==0);
                                boolean left = (j>0 && have[i][j-1]==0);
                                if (!top && !left){
                                    No = true;
                                    break;
                                }
                                count++;
                                if (top){
                                    str.append((i)+" "+(j+1)+" "+(i+1)+" "+(j+1)+'\n');
                                }
                                else {
                                    str.append((i+1)+" "+(j)+" "+(i+1)+" "+(j+1)+'\n');
                                }
                                have[i][j] = 1;
                            }
                            else {
                                boolean right = j<m-1;
                                boolean down = i<n-1;
                                if (!right && !down){
                                    No = true;
                                    break;
                                }
                                count++;
                                if (right){
                                    have[i][j+1]=1;
                                    str.append((i+1)+" "+(j+1)+" "+(i+1)+" "+(j+2)+'\n');
                                }
                                else {
                                    have[i+1][j] = 1;
                                    str.append((i+1)+" "+(j+1)+" "+(i+2)+" "+(j+1)+"/n");
                                }
                                have[i][j] = 1;
                            }

                        }
                    }
                    if (No)break;

                }
                if (str.length()!=0)str.deleteCharAt(str.length()-1);

                if (No)out.println(-1);
                else {
                    out.println(count);
                    out.println(str.toString());


                }
                // ---------------------------------------------------
            }
            out.close();
        } catch (Exception e) {
            out.println(e);
            return;
        }
    }

    /*---------------------------------------------------------------------------------------
                                Extra Methods
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
    private static int upper_bound(long[] arr,int low, int high, long target){
        int n = arr.length;
        int mid = 0;
//        int low = 0;
//        int high = n;
        while (low < high && low != n) {
            mid = low + (high - low) / 2;

            if (target >= arr[mid]) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return low;

    }
    static int lower_bound(long arr[],int low, int high, long key)
    {

        int mid;

        while (low < high) {

            mid = low + (high - low) / 2;
            if (key <= arr[mid]) {
                high = mid;
            }

            else {

                low = mid + 1;
            }
        }

        if (low < arr.length && arr[low] < key) {
            low++;
        }

        return low;
    }
//    Only Use this for floor value
//    private static long sqrt(long num) {
//        long l = 0;
//        long h = Integer.MAX_VALUE;
//        long mid;
//        while (h - l > 1) {
//            mid = (h + l)/2;
//
//            if (mid*mid <= num) {
//                l = mid;
//            }else {
//                h = mid;
//            }
//        }
//        return l;
//    }

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
                                        - End -
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