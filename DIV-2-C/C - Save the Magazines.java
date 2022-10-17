
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
        StringBuilder str = new StringBuilder(sc.next());
        char[] lids = str.toString().toCharArray();
        int[] books = new  int[n];
        boolean[] track = new boolean[n];
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            books[i] = sc.nextInt();
            if (lids[i]=='1'){
                list.add(books[i]);
                set.add(books[i]);
            }
        }
        if (list.size()>1)Collections.sort(list);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (lids[i]=='0' && list.size()>0 && books[i] > list.get(0) && !track[i]){
                int book = books[i];
                long tempSum = 0;
                i++;
                while (i<n && lids[i]!='0'){
                    tempSum+=books[i];
                    track[i] = true;
                    if (book>books[i])break;
                    i++;
                }
                if (i<n && book>books[i] && lids[i]=='1'){
                    sum+=(tempSum-books[i])+book;
                    lids[i] = '0';
                    track[i] = false;
                    i--;
                    if (set.contains(books[i]) && list.get(0)==books[i])list.remove(0);
                }
                else  {
                    sum+=tempSum;
                    i--;
                }
            }
            else if (lids[i]=='1'){
                sum+=books[i];
            }
        }


        out.println(sum);



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
