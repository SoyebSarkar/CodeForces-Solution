import java.util.*;
 class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long k = in.nextInt();
 
        long s =0,e=n;
        while (s<=n){
            long mid = s+(e-s)/2;
 
            long l = ((n - mid) * (n - mid + 1) / 2) - mid;
            if(l ==k){
                System.out.println(mid);
                return;
            }
            else if(l > k){
                s=mid+1;
            }
            else e=mid-1;
        }
 
    }
 
   
}