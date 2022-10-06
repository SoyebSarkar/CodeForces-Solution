
/*
    Yoo, Just a guy who wants to do CP
    for Fun
    Author: Soyeb Sarkar
    CF : soyebsarkar
    CC : soyeb_sarkar
 */

import java.io.InputStreamReader;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;
import static java.lang.System.out;
import java.util.*;
import java.io.*;
import java.math.*;

public class Main {


    public static void main(String[] args) {
        FastReader sc = new FastReader(new BufferedInputStream(System.in));
        /* For Multiple Test Cases  */
        int times = sc.nextInt();
        while (times-- > 0){
            solve(sc);

        }
//        For single Test Case
//        solve(sc);


    }

    public static void solve(FastReader sc) {

        int n = sc.nextInt();
        long[] arr = new long[n];
        long[] arr2 = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        long k = -1;
        boolean no = false;
        boolean start = true;
        for (int i = 0; i < n; i++) {
            long x = sc.nextLong();
            arr2[i] = x;
            if(no) continue;
            if(start) {
                if (x == arr[i]) continue;
                if (x < arr[i]) {
                    no = true;
                } else {
                    k = x - arr[i];
                    arr[i] = x;
                    start = false;

                }
            }
            else {
                if (arr[i]==x) no = true;
                if (k + arr[i] != x) {
                    no = true;
                }else {
                    arr[i]+=k;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if(arr[i]!=arr2[i]){
                out.println("NO");
                return;
            }
        }

        out.println("YES");


    }

/*---------------------------------------------------------------------------------------
        This part was copied from MagentaCobra 's  Template
                    CodeForces ID - MagentaCobra
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
    public static void print(long[] arr)
    {
        //for debugging only
        for(long x: arr)
            out.print(x+" ");
        out.println();
    }
    public static long gcd(long a, long b)
    {
        if(a > b)
            a = (a+b)-(b=a);
        if(a == 0L)
            return b;
        return gcd(b%a, a);
    }
/*-----------------------------------------------------------------------------------------------
        End for MagentaCobra's Template
------------------------------------------------------------------------------------------------        */
public static int[] arrayFill(int n, FastReader sc){
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
    }
    return arr;
}
    /*-----------------------------------------------------------------------------------------------
                This part was found randomly on Codeforces forgot to note author's Name  :(
                                          Class For Fast I/O
    ------------------------------------------------------------------------------------------------        */
    private static class FastReader {
        public BufferedReader br;
        public StringTokenizer st;

        public FastReader(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
            st = null;
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }





}