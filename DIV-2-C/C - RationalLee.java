import static java.lang.Math.*;
import static java.lang.System.*;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {

        static long mod = 1000000007;
        static int[] parent;
        static HashMap<Pair,Long> map;



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
                int k = in.nextInt();
                long[] ar = new long[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = in.nextLong();
                }
                int[] cnt = new int[k];
                for (int i = 0; i < k; i++) {
                    cnt[i] = in.nextInt();
                }
                sort(ar);
                sort(cnt);
                long sum = 0;
                int endStart = n-k;
                int start = 0;
                for (int i = k-1; i >=0 ; i--) {
                    int numOfGifts = cnt[i];
                    long max = ar[endStart];
                    endStart++;
                    long min  = max;
                    for (int j = 1; j <=numOfGifts-1; j++) {
                        min = min(min,ar[start]);
                        start++;
                    }
                    sum+=min+max;
                }
                out.println(sum);

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
    //          Author: Soyeb Sarkar

    public static class sortByOrder implements Comparator<Pair> {
        // This will use only in ArrayList Sorting (Comparator)
        @Override
        public int compare(Pair o1, Pair o2) {
            if (o1.fe==o2.fe)return Integer.compare(o2.se, o1.se);

            return Integer.compare(o1.fe, o2.fe);
        }
    }

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
        // This will work same as upper_bound in C++
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
        // This will work same as lower_bound in C++
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
    private static long sqrt(long num) {
        //    Only Use this for floor value
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



    static long gcd(long a, long b) {
        if (b == 0)
            return a;

        else
            return gcd(b, a % b);
    }

    static long fact(long n) {
        if (n == 0)
            return 1;
        long res = 1;
        for (int i = 2; i <= n; i++)
            res = (res * i)%mod;
        return res;
    }

    static long nCr(long n, long r) {
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

class Pair{
    int fe;
    int se;
    Pair(int f, int s){
        this.fe = f;
        this.se = s;
    }
}