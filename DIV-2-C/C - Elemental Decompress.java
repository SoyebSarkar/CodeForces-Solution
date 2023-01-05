

import static java.lang.Math.*;

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
                int n = in.nextInt();
                ArrayList<List<Integer>> list = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    List<Integer> li = new ArrayList<>();
                    li.add(in.nextInt());
                    li.add(i);
                    list.add(li);
                }
                list.sort(Comparator.comparing(a->a.get(0)));
                HashSet<Integer> h1 = new HashSet<>();
                HashSet<Integer> h2 = new HashSet<>();
                int[] p = new int[n];
                int[] q = new int[n];
                int pMin = 1;
                int qMin = 1;
                boolean poss = true;
                for (int i = 0; i <list.size() ; i++) {
                    int val = list.get(i).get(0);
                    int ind = list.get(i).get(1);
                    if (!h1.contains(val)){
                        h1.add(val);
                        p[ind] = val;
                        while (h2.contains(qMin))qMin++;
                        if (max(val,qMin)!=val || qMin>n){
                            poss=false;
                            break;
                        }
                        q[ind] = qMin;
                        h2.add(qMin);
                        qMin++;

                    }
                    else if (!h2.contains(val)){
                        h2.add(val);
                        q[ind] = val;
                        while (h1.contains(pMin))pMin++;
                        if (max(val,pMin)!=val || pMin>n){
                            poss=false;
                            break;
                        }
                        p[ind] = pMin;
                        h1.add(pMin);
                        pMin++;
                    }
                    else {
                        poss = false;
                        break;
                    }
                }
                if (!poss){
                    out.println("NO");
                }
                else {
                    out.println("YES");
                    for (int x:p){
                        out.print(x+" ");
                    }
                    out.println("");
                    for (int x:q){
                        out.print(x+" ");
                    }
                    out.println("");
                }


// ---------------------------------------------------
        }
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
    long f;
    long s;
    Pair(long h, long s){
        this.f = h;
        this.s = s;
    }
}