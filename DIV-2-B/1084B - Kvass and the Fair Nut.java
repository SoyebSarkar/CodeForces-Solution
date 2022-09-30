import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long n = in.nextLong();
        long s = in.nextLong();
        long[] arr = new long[(int)n];
        long total = 0;
        long least = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            total+=arr[i];
            least = Math.min(least,arr[i]);
        }
        if(total<s){
            System.out.println(-1);
            return;
        }
        long comp=0;
        int i=0;
        for (int j = 0; j < n; j++) {
            if (arr[j]>least){
                comp+=arr[j]-least;
                arr[j] = least;
            }
        }
        if(comp>=s){
            System.out.println(least);
            return;
        }
        long req = s-comp;
        double reqSub = 1.0*req/n;
        least-=Math.ceil(reqSub);
        System.out.println(least);

    }
}
