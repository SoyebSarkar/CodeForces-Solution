import java.util.*;
 public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long[] arr = new long[(int)n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
            sum+=arr[i];
        }

        if((1.0)*sum/n>=4.5){
            System.out.println(0);
            return;
        }
        long req = Math.round((4.5*n)-sum);
        Arrays.sort(arr);
        long count=0;
        for (int i = 0; i < n && req>0; i++) {
            long workLeft = 5-arr[i];
            if (workLeft==0)continue;
            if(workLeft>=req){
                req-=req;

            }
            else {
                req-=workLeft;
            }
            count++;
        }
        System.out.println(count);
    }
}
