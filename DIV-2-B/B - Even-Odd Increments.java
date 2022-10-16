
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
        int q = sc.nextInt();
        long sum = 0;
        int odd = 0;
        int even = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (x%2==0)even++;
            else odd++;
            sum+=x;
        }
        for (int i = 0; i < q; i++) {
            int Q = sc.nextInt();
            int num = sc.nextInt();
            if (Q==0){
                sum+= (long) num *even;
                if (num%2==1){
                    odd+=even;
                    even = 0;
                }
                out.println(sum);
            }
            else{
                sum+= (long) num *odd;
                if (num%2==1){
                    even+=odd;
                    odd=0;
                }
                out.println(sum);

            }
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
