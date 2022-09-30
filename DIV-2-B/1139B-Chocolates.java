import java.util.*;
 public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long[] arr = new long[(int)n];
  
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
        }
        long pre = Integer.MAX_VALUE;
        long count =0;
        for (int i = (int)n-1; i >=0 && pre>1 ; i--) {
            if (arr[i]>= pre){
                pre--;
                count+=pre;
            }
            else {
                count+= arr[i];
                pre = arr[i];
            }
        }
        System.out.println(count);
    }
}