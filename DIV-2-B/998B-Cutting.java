
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

 class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int btc = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int even=0,odd=0;

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(arr[i]%2==0)even++;
            else odd++;
            if(even==odd && i<n-1 && btc>0){
                int cost = Math.abs(arr[i]-arr[i+1]);
                list.add(cost);
            }
        }
        int count=0;
        Collections.sort(list);
        for (int i = 0; i < list.size() && btc>0; i++) {
            int cost = list.get(i);
            if(cost<=btc){
                count++;
                btc-=cost;
            }
        }
        System.out.println(count);


    }

}
