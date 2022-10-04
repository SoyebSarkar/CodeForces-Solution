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
        long[] arr = new long[n+1];
        for(int i=1;i<=n;i++)arr[i] = sc.nextLong();
        if (n==1){
            System.out.println(0);
            return;
        }
        System.out.println(n-1);
        System.out.println(1+" "+n);
        if(arr[1]+arr[n]%2==0){
            arr[1] = arr[n];
        }
        else {
            arr[n] = arr[1];
        }

        for(int i=2;i<n;i++)
        {
            if((arr[i]+arr[1])%2==0)
            {
                System.out.println((i)+" "+n);
            }
            else
            {
                System.out.println((1)+" "+(i));
            }
        }

    }


}