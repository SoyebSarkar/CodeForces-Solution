

import static java.lang.Math.*;
import static java.lang.System.*;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
import java.math.*;

import static java.lang.System.out;

public class Main {

    static ArrayList<Integer> prime = new ArrayList<>();
    static long mod = 1000000007;
    public static void main(String[] args) {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();


            int testcases = in.nextInt();
//             int testcases = 1;

            while ( testcases -- > 0 ) {
//---------------------------------------------------------
               char[] arr = in.next().toCharArray();
               int[] have = new int[10];
               int[] store = new int[10];
                for (char ch:arr) {
                    have[ch -'0']++;
                }
                int i = 0;
                int minStore = 9;
                StringBuilder ans = new StringBuilder();
                for (char ch:arr){
                    while (i < 10 && have[i]==0)i++;
                    if (ch-'0' ==i ){
                        while (i>minStore && minStore<=9){
                            ans.append(minStore);
                            store[minStore]--;
                            while (minStore<10 && store[minStore]==0)minStore++;
//                            minStore = min(minStore,9);
                        }
                        ans.append(ch);
                        have[ch-'0']--;
                    }
                    else {
                        have[ch-'0']--;
                        int index = min(9,(ch-'0')+1);
                        store[index]++;
                        minStore = min(minStore,index);
                    }
                }
                for (int j = 0; j < 10; j++) {
                    while (store[j]!=0){
                        ans.append(j);
                        store[j]--;
                    }
                }

                out.println(ans.toString());
            }


// ---------------------------------------------------
            out.close();
        } catch (Exception e) {
            out.println(e);
            return;
        }
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
    long h ;
    long p;
    Pair(long h, long p){
        this.h = h;
        this.p = p;
    }
}