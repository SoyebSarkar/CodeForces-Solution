import java.util.*;
 public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        int ans = 0;
        while (n!=0){
            ans ++;
            if (sum(ans) == 10) n--;
        }

        System.out.println(ans);

    }

    public static long sum(long n){
        long temp = n;
        long sum=0;
        while (temp>0){
            sum+=temp%10;
            temp/=10;
        }
        return sum;
    }

   
}
