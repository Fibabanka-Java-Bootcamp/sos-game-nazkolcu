package org.kodluyoruz;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Game SOS = new Game();

        startGame(SOS);


        guessFirstMove(SOS);
        // System.out.println("-" + SOS.getPlayerTurn() + "-" + SOS.getPlayerLetter() + "-" + SOS.getMatrixN());
        // SOS.getPlayerTurn()
        // SOS.getPlayerLetter()
        int matrixN = SOS.getMatrixN() - 1;


        //tüm alanlar dolana kadar devam et!
        for (int i = 0; i < matrixN * matrixN; i++) {

            // checkTurnAndLetter();

            System.out.println("slm");


        }


        //makeMove;
        printMatrix(SOS);

        System.out.println("-------");

        //indis üzerinden çağırma
       for (int i = 0; i < SOS.getMatrixN(); i++) {
            for (int j = 0; j < SOS.getMatrixN(); j++) {
                System.out.print(SOS.getMatrixReal()[i][j] + "\t");
            }
            System.out.println();
        }

    }

public static void startGame(Game SOS) {
        int matrixNreturn = 0;
        do {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Matris büyüklüğü olarak bir N sayısı giriniz (NxN/3-7):");
        int matrixN = scanner.nextInt();
        matrixNreturn = SOS.setMatrixN(matrixN + 1);
        } while (matrixNreturn == 0);
        }

public static void guessFirstMove(Game SOS) {
        int PlayerTurn = 0, PlayerLetter = 0;
        Random random = new Random();
        PlayerTurn = random.nextInt(2) + 1;
        PlayerLetter = 5 + random.nextInt(6 - 5 + 1);

        SOS.setPlayerTurn(PlayerTurn);
        SOS.setPlayerLetter(PlayerLetter);
        }


public static void printMatrix(Game SOS) {
        for (int i = 0; i < SOS.getMatrixN(); i++) {

        for (int j = 0; j < SOS.getMatrixN(); j++) {
        if (i == 0 && j == 0) {
        System.out.print("\t");
        } else if (i == 0) {
        System.out.print(j + "\t");
        } else if (j == 0) {
        System.out.print(i + "\t");
        } else {
        System.out.print(SOS.getMatrixRealAtIndex(i, j) + "\t");
        }
        }
        System.out.println();
        }
        }

        }