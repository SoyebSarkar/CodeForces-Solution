
import static java.lang.Math.*;

import java.lang.management.MonitorInfo;
import java.util.*;
import java.io.*;

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
                long n = in.nextLong();
                long aliceW = 0;
                long aliceB = 0;
                long bobW = 0;
                long bobB = 0;
                boolean turn = true;
                long a = 1;
                long b = 2;
                while (n>0){

                    long halfAOne = a/2;
                    long halfATwo = a-halfAOne;
                    long halfBOne = b/2;
                    long halfBTwo = b-halfBOne;
                    if (turn){

                        if (a>n){
                            if (n%2==0){
                                aliceW+=n/2;
                                aliceB+=n/2;
                            }
                            else {
                                aliceW+=n-(n/2);
                                aliceB+=n/2;
                            }
                            break;
                        }
                        else {
                            aliceW+=max(halfAOne,halfATwo);
                            aliceB+=min(halfAOne,halfATwo);
                        }
                        n-=a;
                        if (b>n){
                            if (n%2==0){
                                bobB+=n/2;
                                bobW+=n/2;
                            }
                            else {
                                bobB+=n-n/2;
                                bobW+=n/2;
                            }
                            break;
                        }
                        else {
                            bobB+=max(halfBOne,halfBTwo);
                            bobW+=min(halfBTwo,halfBOne);
                        }
                        n-=b;
                    }
                    else {
                        if (a>n){
                            if (n%2==0){
                                bobB+=n/2;
                                bobW+=n/2;
                            }
                            else {
                                bobB+=n-n/2;
                                bobW+=n/2;
                            }
                            break;
                        }
                        else {
                            bobB+=max(halfAOne,halfATwo);
                            bobW+=min(halfAOne,halfATwo);
                        }
                        n-=a;
                        if (b>n){
                            if (n%2==0){
                                aliceW+=n/2;
                                aliceB+=n/2;
                            }
                            else {
                                aliceW+=n-n/2;
                                aliceB+=n/2;
                            }
                            break;
                        }
                        else {
                            aliceW+=max(halfBOne,halfBTwo);
                            aliceB+=min(halfBTwo,halfBOne);
                        }
                        n-=b;
                    }
                    a+=2;
                    b+=2;
                    turn = !turn;
                }

                out.println(aliceW+" "+aliceB+" "+bobW+" "+bobB);


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