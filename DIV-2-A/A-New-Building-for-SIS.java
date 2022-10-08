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

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
import java.math.*;

public class Main {


    public static void main(String[] args) {
        FastReader sc = new FastReader(new BufferedInputStream(System.in));
        /* For Multiple Test Cases  */
//        int times = sc.nextInt();
        //        For single Test Case
        int times = 1;
        while (times-- > 0){
            solve(sc);

        }



    }
    public static void solve(FastReader sc) {
        int n = sc.nextInt();
        int h = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            int ta = sc.nextInt();
            int fa = sc.nextInt();
            int tb = sc.nextInt();
            int fb = sc.nextInt();
            int total=0;
            if(ta==tb)
            {
                out.println(abs(fa-fb));
                continue;
            }
            if(fa>b)
            {
                total+=fa-b;
                fa=b;
            }

            else if(fa<a)
            {
                total+=a-fa;
                fa=a;
            }
            total+=abs(ta-tb)+abs(fa-fb);
            out.println(total);
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

/*-----------------------------------------------------------------------------------------------
        End for MagentaCobra's Template
------------------------------------------------------------------------------------------------        */
static long maxSubArraySum(Deque<Long> a)
{
    long size = a.size();
    long tempMax = Integer.MIN_VALUE, maxEnd
            = 0;

    for (int i = 0; i < size; i++) {
        maxEnd = maxEnd + a.pollFirst();
        if (tempMax < maxEnd)
            tempMax = maxEnd;
        if (maxEnd < 0)
            maxEnd = 0;
    }
    return tempMax;
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
