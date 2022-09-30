import java.util.*;
 public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long[] arr = new long[(int)n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
        }
        Arrays.sort(arr);

        for (int i = 0; i <= n-3; i++) {
            if(arr[i]+arr[i+1]> arr[i+2]){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");

    }
}