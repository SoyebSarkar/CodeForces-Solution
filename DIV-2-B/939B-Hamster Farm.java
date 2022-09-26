import java.util.*;
 class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long k = in.nextLong();
        long[] arr = new long[(int)k];
        for (int i = 0; i < k; i++) {
            arr[i] = in.nextLong();
        }
        long minLeft = n;
        long index = 0;
        long boxTime =0;

        for (int i = 0; i < k; i++) {
            long rem = n%arr[i];
            if(arr[i]<=n &&  rem<minLeft){
                minLeft = rem;
                index = i;
                boxTime = n/arr[i];

            }
        }
        System.out.println(index+1+" "+boxTime);
    }
}