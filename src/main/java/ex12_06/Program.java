package ex12_06;
import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many random numbers should be printed?");
        int howMany = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < howMany; i++){
            System.out.println(randomNumbers(10));
        }


    }

    public static int randomNumbers(int bound){
        Random random = new Random();
        return random.nextInt(0,bound);
    }

}