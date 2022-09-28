import java.util.*;
 class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {

            solve(in);

        }
    }

    public static void solve(Scanner in){

        String s1 = in.next();
        String s2 = in.next();
        char[] word1 = s1.toCharArray();
        char[] word2 = s2.toCharArray();
        int i=0,j=0;
        for ( i = 0; i < word1.length && j<word2.length; i++) {
            if (word1[i]==word2[j]) j++;
            else if(i>0 && word1[i]!=word2[j] && word1[i-1]==word2[j]){
                while (j<word2.length && word1[i-1]==word2[j]){
                    j++;
                }
                i--;

            }
            else if(word1[i]!=word2[j]){
                System.out.println("NO");
                return;
            }

        }
        while (j<word2.length && word1[word1.length-1]==word2[j])j++;
        if(i>=word1.length && j>=word2.length){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }

    }


}

