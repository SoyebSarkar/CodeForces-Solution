import java.util.*;
 class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int h = in.nextInt();

        int[] frontView = new int[m];
        int[] leftView = new int[n];
        int[][] topView = new int[n][m];

        for (int i = 0; i < m; i++) {
            frontView[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            leftView[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                topView[i][j] = in.nextInt();
            }
        }

        for (int i = n-1; i >=0 ; i--) {
            for (int j = m-1; j >=0 ; j--) {

                if(topView[i][j]==1 && leftView[i]>=frontView[j]){
                    topView[i][j] = frontView[j];
                }else if(topView[i][j]==1 && leftView[i]<frontView[j]){
                    topView[i][j] = leftView[i];
                }

            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(topView[i][j]+" ");
            }
            System.out.println();
        }



    }


}

