package memory.Main;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MemoryGame {
    static boolean playing = true;
    static Integer[][] cards = {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {6, 7, 8, 9, 10}};
    static boolean[][] cardState = new boolean[4][5];
    static int notMatchedCount = 0;
    static int matchedCount = 0;
    static int score = 0;
    static int allowedMismatch = 10;

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void setupGame() {
        clearScreen();
        notMatchedCount = 0;
        matchedCount = 0;
        score = 0;
        cardState = new boolean[4][5];
        shuffleCards();
        printBoard();
        playGame();

    }

    public static void addBonus() {
        score += (10 - notMatchedCount) * 3;
    }

    public static void promptUser() {
        Scanner contInput = new Scanner(System.in);
        System.out.println("\nContinue (y/n)");
        while (contInput.hasNextLine()) {
            char c = contInput.next().charAt(0);
            if (c == 'y') {
                playing = true;
                setupGame();
                break;
            } else if (c == 'n') {
                playing = false;
                return;
            } else {
                System.out.println("Provide a valid response");
            }
        }

    }

    public static void checkStatus() {
        boolean isFinished = true;
        for (int i = 0; i < cards.length; i++) {
            for (boolean b : cardState[i]) if (!b) isFinished = false;
        }
        if (isFinished) {
            playing = false;
            System.out.println("\nYou win\n");
            addBonus();
            System.out.printf("\nYour score is %s\n", score);
            promptUser();
        }
        if (notMatchedCount == allowedMismatch) {
            playing = false;
            System.out.println("\nYou mismatched 10 times\nGame over");
            System.out.printf("\nYour score is %s\n", score);
            promptUser();
        }

    }

    static void shuffleCards() {
        for (Integer[] card : cards) {
            List<Integer> list = Arrays.asList(card);
            Collections.shuffle(list);
            list.toArray(card);
        }
    }

    public static void playGame() {
        Scanner playerInput = new Scanner(System.in);
        while (playing) {
            System.out.println("\nEnter Card position 1 (Row Column ex 11)");
            String poscard1 = playerInput.nextLine();
            int card1col = Integer.parseInt(String.valueOf(poscard1.charAt(0))) - 1;
            int card1row = Integer.parseInt(String.valueOf(poscard1.charAt(1))) - 1;
            cardState[card1col][card1row] = true;
            printBoard();
            System.out.println("\nEnter Card position 2 (Row Column ex 11)");
            String poscard2 = playerInput.nextLine();
            int card2col = Integer.parseInt(String.valueOf(poscard2.charAt(0))) - 1;
            int card2row = Integer.parseInt(String.valueOf(poscard2.charAt(1))) - 1;
            if (cardState[card1col][card1row] && cardState[card2col][card2row]) {
                System.out.println("Card already selected please try again");
                cardState[card2col][card2row] = false;
                cardState[card1col][card1row] = false;
                continue;
            }
            if (cards[card1col][card1row].equals(cards[card2col][card2row])) {
                cardState[card2col][card2row] = true;
                cardState[card1col][card1row] = true;
                matchedCount++;
                score += 2;
                System.out.println("\nMatch found\n");
            } else {
                cardState[card2col][card2row] = false;
                cardState[card1col][card1row] = false;
                notMatchedCount++;
                clearScreen();
                System.out.println("\nNo Match found\n");
            }
            checkStatus();
            if (playing) printBoard();
        }
    }

    public static void printBoard() {
        System.out.println(Arrays.deepToString(cards));
//        System.out.println();
        System.out.printf("\nMismatched: %s\nMatched: %s\nScore: %s\n", notMatchedCount, matchedCount, score);
        System.out.println("Col   | 1 | 2 | 3 | 4 | 5 |");
        System.out.println("---------------------------");
        for (int i = 0; i < cards.length; i++) {
            System.out.print("Row " + (i + 1) + " |");
            for (int a = 0; a < cards[i].length; a++) {
                if (cardState[i][a]) {
                    System.out.printf(cards[i][a] >= 10 ? "%s|" : " %s |", cards[i][a]);
                } else {
                    System.out.print(" * |");
                }
            }
            System.out.println();
        }
    }
}
