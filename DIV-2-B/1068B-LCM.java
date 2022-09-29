import java.util.*;
 class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long count=0;
        for (long i = 1; i*i<=n ; i++) {

            if(n%i==0){
                if(i*i==n)count++;
                else count+=2;

            }
        }
        System.out.println(count);

    }
}
