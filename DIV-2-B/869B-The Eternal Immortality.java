import java.util.*;
 class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        long val = 1;
        if(b-a>=10){
            System.out.println(0);
            return;
        }
        for (long i = a+1; i <=b ; i++) {
            val*=i%10;
            val = val% 10;
        }
        System.out.println(val%10);
    }
}

