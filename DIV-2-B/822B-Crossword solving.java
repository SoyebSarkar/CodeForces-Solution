import java.util.*;
 public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long m = in.nextLong();
        String str1 = in.next();
        String str2 = in.next();

        char[] s = str1.toCharArray();
        char[] t = str2.toCharArray();
        int finalCount =Integer.MAX_VALUE;
        ArrayList<Integer> list =new ArrayList<>();
        for (int i = 0; i <= m-n; i++) {

                ArrayList<Integer> temp = new ArrayList<>();
                int length = findLength(s,t,i, temp);
                if(length<finalCount){
                    finalCount = length;
                    list=temp;
                }
        }
        System.out.println(finalCount);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
    }

    private static int findLength(char[] first, char[] second, int index,ArrayList<Integer> temp) {

        int j = 0;
        int count=0;
        for (int i = index; i < second.length && j<first.length; i++) {
            if (first[j]!=second[i]){
                count++;
                temp.add(j+1);
            }
            j++;
        }
        return  count;
    }
}

