import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static int MAX_CHANCES = 10;

    public static int generateRandomNumber(int mode){
        int limit = 0;

        if(mode == 1)
            limit = 100;
        if(mode == 2)
            limit = 1000;

        Random r = new Random();

        return r.nextInt(limit)+1;
    }

    public static void welcomeScreen(){
        System.out.println("\n\nWelcome!\n");

        System.out.println("|--------------------------|");
        System.out.println("|     Guess the number     |");
        System.out.println("|--------------------------|");
    }

    public static void noviceGame(Scanner sc){
        System.out.println("\nWe have chosen a random number between 1 to 100 (both included).");
        System.out.println("You have to guess it in 10 chances.");

        int numberToGuess = generateRandomNumber(1);

        int chances = 0;
        boolean winFlag = false;

        do{
            System.out.print("\nGuess: ");

            int guess = sc.nextInt();
            chances++;

            if(guess == numberToGuess){
                winFlag = true;
                break;
            }
            if(guess < numberToGuess)
                System.out.println("Too Low!");
            if (guess > numberToGuess)
                System.out.println("Too High!");

        }while (chances < MAX_CHANCES);

        endScreen(winFlag, numberToGuess);
    }

    public static void expertGame(Scanner sc){
        System.out.println("\nWe have chosen a random number between 1 to 1000 (both included).");
        System.out.println("You have to guess it in 10 chances.");

        int numberToGuess = generateRandomNumber(2);

        int chances = 0;
        boolean winFlag = false;

        do {
            System.out.print("\nGuess: ");

            int guess = sc.nextInt();
            chances++;

            if(guess == numberToGuess){
                winFlag = true;
                break;
            }
            if(guess < numberToGuess)
                System.out.println("Too Low!");
            if (guess > numberToGuess)
                System.out.println("Too High!");

        } while (chances < MAX_CHANCES);

        endScreen(winFlag, numberToGuess);
    }

    public static void youWin(){
        System.out.println("\n|---------------------|");
        System.out.println("|--     You Win     --|");
        System.out.println("|---------------------|\n");
    }

    public static void youLose(int numberToGuess){
        System.out.println("\nYou have run out of chances.");
        System.out.println("Number was: " + numberToGuess);
        System.out.println("\n|---------------------|");
        System.out.println("|--     You Lose    --|");
        System.out.println("|---------------------|\n");
    }

    public static void endScreen(boolean winFlag, int numberToGuess){
        if (winFlag) {
            youWin();
        } else {
            youLose(numberToGuess);
        }
    }

    public static void main(String[] args) {

        try {

            welcomeScreen();

            int mode;

            Scanner sc = new Scanner(System.in);

            do {
                System.out.println("\nSelect difficulty: \n1. Novice\n2. Expert");

                mode = sc.nextInt();

                if (mode != 1 && mode != 2)
                    System.out.println("\nPlease select valid option!");
            } while (mode != 1 && mode != 2);


            if (mode == 1) {
                noviceGame(sc);
            }

            if (mode == 2) {
                expertGame(sc);
            }

        }
        catch (InputMismatchException e){
            System.out.println("\nFatal error! Please enter valid values.\n");
        }

    }
}