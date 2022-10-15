
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
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
           int x = sc.nextInt();
           arr[i] = x;
        }
        int i = 0;
        int j = n-1;
        int coount =0;
        while (i<j){
            if (arr[i]==1){
                while (j>i && arr[j]==1)j--;
                if (j>i)
                if (arr[j]==0) coount++;
                i++;
                j--;
            }
            while (i<j && arr[i]==0)i++;
        }
        out.println(coount);
    }
    public static boolean check(char[][] mat, int r, int c){
        boolean t1 = false,t2 = false;
        if (r==0){
            char ch = mat[r][c];
            for (int i = 0; i < 8 ; i++) {
                if (mat[i][c]==ch) t1 = true;
                if (mat[i][c] != ch) {

                    t1 = false;
                    break;
                }
            }
        }
        if (c==0){
            char ch = mat[r][c];
            for (int i = 0; i < 8; i++) {
                if (mat[r][i]==ch) t2 = true;
                if (mat[r][i] != ch) {

                    t2 = false;
                    break;
                }
            }
        }
        return t1 || t2;
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
