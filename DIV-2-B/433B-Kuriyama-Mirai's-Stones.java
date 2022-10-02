import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
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

    public static void main(String[] args) {
        FastReader sc = new FastReader(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        ArrayList<Long> arr = new ArrayList<>();
        ArrayList<Long> arrSort = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long x =sc.nextLong();
            arr.add(x);
            arrSort.add(x);

        }

        Collections.sort(arrSort);
        for (int i = 1; i < n; i++) {
            arr.set(i,arr.get(i)+arr.get(i-1));
            arrSort.set(i,arrSort.get(i)+arrSort.get(i-1));
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int q = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();
            long a;
            long b;
            if(q==1) {
                a = arr.get(r-1);
                b = (l == 1) ? 0 : arr.get(l-2);
            }
            else {
                a = arrSort.get(r-1);
                b = (l == 1) ? 0 : arrSort.get(l-2);
            }
            System.out.println(a - b);
        }


    }



}