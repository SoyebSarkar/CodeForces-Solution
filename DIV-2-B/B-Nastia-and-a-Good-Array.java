

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
        int minPOS = 0;
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
            if(min>arr[i]){
                min = arr[i];
                minPOS = i;
            }
        }
        out.println(n-1);
        for (int i = 0; i < n; i++) {
            if(i==minPOS)continue;
            out.println((minPOS+1)+" "+(i+1)+" "+(min)+" "+(min+abs(i-minPOS)));
        }

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
    public static void print(int[] arr)
    {
        //for debugging only
        for(int x: arr)
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