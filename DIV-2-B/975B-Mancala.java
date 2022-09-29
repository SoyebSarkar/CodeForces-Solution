import java.util.*;
 class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        long[] arr = new long[14];

        for (int i = 0; i < 14; i++) {
            arr[i] = in.nextInt();

        }
        long maxAns =0;
        for (int i = 0; i <14; i++) {
            long[] temp = Arrays.copyOfRange(arr,0,14);

            long num = temp[i];
            temp[i] = 0;
            long perBlock = num/14;
            long left = num%14;
            int next = i+1;
            if (perBlock!=0)
            for (int j = next; j <=next+13; j++) {
                int index = j%14;
                temp[index]+=perBlock;
            }
            next+=14;
            while (left!=0){
                int index = next%14;
                temp[index]+=1;
                left--;
                next++;
            }
            long ans = 0;
            for (int j = 0; j < 14; j++) {
                if(temp[j]%2==0){
                    ans+=temp[j];
                }
            }

            maxAns = Math.max(ans,maxAns);

        }

        System.out.println(maxAns);


    }
}
