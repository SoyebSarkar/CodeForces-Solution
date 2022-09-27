import java.util.*;
 class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        String str = in.next();
        char[] arr = str.toCharArray();
        Set<Character> hash_set = new HashSet<>();
        char pre = 'Z';
        int maxCount=0,count=0;
        for (int i = 0; i < n; i++) {
            if (arr[i]>='a' && arr[i]<='z' && pre!=arr[i] && !hash_set.contains(arr[i])){
                count++;
                hash_set.add(arr[i]);
            }
            else if(arr[i]>='A' && arr[i]<='Z'){

                hash_set = new HashSet<>();
                count=0;
            }
            maxCount = Math.max(maxCount,count);
        }
        System.out.println(maxCount);
    }
}