
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
long[] arr = new long[1000001];

long pile =1;
int index =1;
while (n>0){
    long worm = sc.nextLong();
    for (int i = 0; i < worm; i++) {
        arr[index] = pile;
        index++;
    }
    pile++;
    n--;
}
int p = sc.nextInt();
while (p>0){
    System.out.println(arr[sc.nextInt()]);
    p--;
}
}
}