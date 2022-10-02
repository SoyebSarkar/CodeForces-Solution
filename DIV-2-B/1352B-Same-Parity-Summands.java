
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
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
int t = sc.nextInt();
while (t-->0){
    solve(sc);

}


}
public static void solve(FastReader sc){
int n = sc.nextInt();
int k = sc.nextInt();
if(n-(k-1)>0 && (n-(k-1))%2==1){
    System.out.println("YES");
    for (int i = 0; i < k-1; i++) {
        System.out.print(1+" ");
    }
    System.out.println(n-(k-1));
    return;
}
if(n-2*(k-1)>0 && (n-2*(k-1))%2==0){
    System.out.println("YES");
    for (int i = 0; i < k-1; i++) {
        System.out.print(2+" ");
    }
    System.out.println(n-2*(k-1));
    return;
}

System.out.println("NO");
}
}
