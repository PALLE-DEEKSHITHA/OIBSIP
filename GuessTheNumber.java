import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
   
    public static void main(String args[]){
        Random r_num=new Random();
        int r_guess=r_num.nextInt(100);
        int rounds=0;
        Scanner s=new Scanner(System.in);
        System.out.println("guess the number ranging from 0 to 100,you will have 10 chances to guess");
        int guess;
        int i=0;
        boolean win=false;
        while(win!=true){
          guess=s.nextInt();
          rounds++;
          if(guess==r_guess){
              win=true;
          }
          else if(i>8)
          {
              System.out.println("lost!the right guess is"+r_guess);
              return;
          }
          else if(guess<r_guess){
              i++;
              System.out.println("guess is lower than the number!!chances left:"+(10-i));
          }
          else if(guess>r_guess){
              i++;
              System.out.println("guess is higher than the number!!chances left:"+(10-i));
          }
        }
        System.out.println("win!!");
        System.out.println("the random number is "+r_guess);
        System.out.println("chances used is "+rounds+" for guessing the number ");
        System.out.println("Score is "+((11-rounds)*10)+" out of 100");
}

}