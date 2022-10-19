
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
        StringBuilder str = new StringBuilder(sc.next());
        int num = sc.nextInt();
        char[] arr = str.toString().toCharArray();
        int sum = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int j=1;
        for (int i = 97; i <= 122; i++) {

            map.put((char)i,j);
            j++;
        }
        HashMap<Character, Integer> mapCount = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            mapCount.put(arr[i],mapCount.getOrDefault(arr[i],0)+1);
            sum+=map.get(arr[i]);
        }
        for (int i = 122; i >=97 && sum>num ; i--) {
            char ch = (char) i;
            if (mapCount.containsKey(ch)){
                while (mapCount.get(ch)>0 && sum>num){
                    sum-=map.get(ch);
                    mapCount.put(ch,mapCount.get(ch)-1);
                }
            }

        }


        for (int i = 0; i < str.length(); i++) {
            if (mapCount.get(arr[i])>0){
                out.print(arr[i]);
                mapCount.put(arr[i], mapCount.get(arr[i])-1);
            }
        }
        out.println();





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
