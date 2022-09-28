import java.util.*;
 class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        if(n>36){
            System.out.println(-1);
            return;
        }
        else if(n==1){
            System.out.println(6);
            return;
        }
        long digitEight = n/2;
        long zero = n%2;
        long num =0;
        for (int i = 0; i < digitEight; i++) {
            num = (num*10)+8;
        }
        for (int i = 0; i < zero; i++) {
            num*=10;
        }

        System.out.println(num);

    }


}

