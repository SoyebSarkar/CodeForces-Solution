import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        long n = in.nextLong();
        long k = in.nextLong();

        if(n==1){
            System.out.println(1);
            return;
        }
       long end = 3;
        for (long i = 1; i < n-1; i++) {
            end*=2;
            end++;
        }
        long start = 1;
        while (start<=end){
            long mid = start + (end-start)/2;
            if(k==mid){
                System.out.println(n);
                return;
            }
            else if(k>mid){
                start = mid+1;
            }
            else end = mid -1;
            n--;


        }





    }

}

