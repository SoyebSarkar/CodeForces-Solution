import java.util.*;
 public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int[] arr = new int[4];
        int[] mis = new int[4];
        int r=0,b=0,y=0,g=0;
        HashMap<Integer,Character> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='R'){
                map.put((i)%4,'R');
                r++;
            }
            else if(str.charAt(i)=='B'){
                map.put((i)%4,'B');
                b++;
            }
            else if(str.charAt(i)=='Y'){
                map.put((i)%4,'Y');
                y++;
            }
            else if(str.charAt(i)=='G'){
                map.put((i)%4,'G');
                g++;
            }
            else {

                char ch = (map.get(i%4)!=null)? map.get(i%4):'A';
                if(ch=='R')mis[0] = mis[0]+1;
                if(ch=='B')mis[1] = mis[1]+1;
                if(ch=='Y')mis[2] = mis[2]+1;
                if(ch=='G')mis[3] = mis[3]+1;
            }
            if((i+1)%4==0){
                if(r==0)arr[0]=arr[0]+1;
                if(b==0)arr[1]=arr[1]+1;
                if(y==0)arr[2]=arr[2]+1;
                if(g==0)arr[3]=arr[3]+1;
                for (int j = 0; j < 4; j++) {
                    mis[j] = (mis[j]==0)?0:mis[j]-1;
                }
                r=0;
                b=0;
                g=0;
                y=0;
            }
        }

        for (int i = 0; i < 4; i++) {
            arr[i]+=mis[i];
        }
        for (int i = 0; i < 4; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
