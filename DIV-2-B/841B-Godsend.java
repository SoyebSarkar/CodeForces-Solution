
import java.util.*;
 public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int odd=0;
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            if(x%2==1){
                odd++;
        }
        }
        if(odd>0){
            System.out.println("First");
        }
        else{
            System.out.println("Second");
        }
    }
}