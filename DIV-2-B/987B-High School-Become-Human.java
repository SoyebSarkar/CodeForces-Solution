import java.util.*;
 class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        long x = in.nextLong();
        long y = in.nextLong();


        if(x==y){
            System.out.println('=');
        }
         else if(x==1){
            System.out.println('<');
        }
        else if(y==1){
            System.out.println('>');
        }

        else if(x+y==6){
            System.out.println('=');
        }
        else if(x==3){
            System.out.println('>');
        }
        else if(y==3){
            System.out.println('<');
        }
        else if(x>y){
            System.out.println('<');
        }
        else {
            System.out.println('>');
        }


    }
}
