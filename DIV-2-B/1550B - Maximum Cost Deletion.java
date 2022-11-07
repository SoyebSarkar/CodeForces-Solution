
import java.io.InputStreamReader;

import static java.lang.Math.*;
import static java.lang.System.*;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
import java.math.*;

public class Main {


    public static void main(String[] args) {
        FastReader sc = new FastReader(new BufferedInputStream(System.in));
        /* For Multiple Test Cases  */
        int times = sc.nextInt();
        //        For single Test Case
//        int times = 1;
        while (times-- > 0){
            solve(sc);

        }



    }
    public static void solve(FastReader sc) {
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        char[] arr = sc.next().toCharArray();
        int zero = 0;
        int one = 0;
        int countZero = 0;
        int countOne = 0;
        ArrayList<Integer> zeroL = new ArrayList<>();
        ArrayList<Integer> oneL = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i]=='0'){
                countZero++;
                zero++;
                if (one>0) oneL.add(one);
                one = 0;
            }
            else {
                countOne++;
                one++;
                if(zero>0) zeroL.add(zero);
                zero=0;
            }
        }
        if (one>0) oneL.add(one);
        if(zero>0) zeroL.add(zero);
        long cost1 = Integer.MIN_VALUE,cost2=Integer.MIN_VALUE,cost3 =Integer.MIN_VALUE;

            cost1 = 0;
            for(Integer val: oneL){
                cost1+= ((long) a *val) +b;
            }
            if (countZero!=0)
            cost1+=((long) countZero *a)+b;


            cost2=0;
            for(Integer val: zeroL){
                cost2+= ((long) a *val) +b;
            }
            if (countOne!=0)
            cost2+=((long) countOne *a)+b;

        cost3 = ((long) n *a) + ((long) n *b);
        out.println(max(cost1,max(cost2,cost3)));

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
    static int gcd(int a, int b)
    {
        if (b == 0)
            return a;

        else
            return gcd(b, a % b);
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