
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
        int times = sc.nextInt();
        while (times-- > 0){
            solve(sc);
        }


    }
    public static void solve(FastReader sc){
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            list.add(x);

        }
        Collections.sort(list);
        long ans = Long.MIN_VALUE;
        int one,two,three,four,five;
        for (int i = 0; i < 5; i++) {
            one = (n-1+i)%n;
            two = (n-2+i)%n;
            three = (n-3+i)%n;
            four = (n-4+i)%n;
            five = (n-5+i)%n;
            long product = (long) list.get(one) *list.get(two)*list.get(three)*list.get(four)*list.get(five);
            ans = Math.max(ans,product);
        }


        System.out.println(ans);


    }



}