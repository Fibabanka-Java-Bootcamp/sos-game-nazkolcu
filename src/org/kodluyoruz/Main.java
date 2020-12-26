package org.kodluyoruz;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Game SOS = new Game();

        configGame(SOS);


        guessFirstMove(SOS);
        System.out.println("-" + SOS.getPlayerTurn() + "-" + SOS.getPlayerLetter() + "-" + SOS.getMatrixN());
        // SOS.getPlayerTurn()
        // SOS.getPlayerLetter()


        wholeGame(SOS);
        //tüm alanlar dolana kadar devam et!


        //makeMove;


        System.out.println("-------");

        //indis üzerinden çağırma
        for (int i = 0; i < SOS.getMatrixN(); i++) {
            for (int j = 0; j < SOS.getMatrixN(); j++) {
                System.out.print(SOS.getMatrixReal()[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("-------");

        //indis üzerinden çağırma
        for (int i = 0; i < SOS.getMatrixReal().length; i++) {
            for (int j = 0; j < SOS.getMatrixReal().length; j++) {
                System.out.print(SOS.getMatrixReal()[i][j] + "\t");
            }
            System.out.println();
        }

    }

    public static void configGame(Game SOS) {
        System.out.println("SOS Oyununa Hoş Geldiniz!");
        int matrixNcontrol;

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Matris büyüklüğü olarak bir N sayısı giriniz (NxN/3-7):");
            int matrixN = scanner.nextInt();
            matrixNcontrol = SOS.setMatrixN(matrixN);

        } while (matrixNcontrol == 0);
    }

    // turn:2pc,1me
    //letter:5S,6O
    public static void guessFirstMove(Game SOS) {
        int PlayerTurn, PlayerLetter;
        Random random = new Random();
        PlayerTurn = 1;
        //random.nextInt(2) + 1;
        PlayerLetter = 5 + random.nextInt(6 - 5 + 1);

        SOS.setPlayerTurn(PlayerTurn);
        SOS.setPlayerLetter(PlayerLetter);
    }


    public static void printMatrix(Game SOS) {
        for (int i = 0; i < SOS.getMatrixReal().length; i++) {

            for (int j = 0; j < SOS.getMatrixReal().length; j++) {
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

    public static void wholeGame(Game SOS) {
        int matrixN = SOS.getMatrixN();
        for (int i = 0; i < matrixN * matrixN; i++) {
            System.out.println("1");
            getMatrixInput(SOS);
            //checkTurnAndLetter();
            //// sırayı sonrakine vermeyi unutma
            //System.out.println("slm");

            //     printPlayerPoints(SOS);
            printMatrix(SOS);

        }
    }


    public static void printPlayerPoints(Game SOS) {
        System.out.println("You:" + SOS.getPlayerMePoint());
        System.out.println("PC:" + SOS.getPlayerPcPoint());
    }

    public static void getMatrixInput(Game SOS) {
        int matrixN = SOS.getMatrixN();
        int PlayerTurn = SOS.getPlayerTurn();
        int PlayerLetter = SOS.getPlayerLetter();
        int matrixColumn;
        int matrixLine;
        Scanner scanner = new Scanner(System.in);


        if (PlayerTurn == 1) {
            do {
                do {

                    System.out.print("Hamlenizi girin(Yatay):");
                    matrixColumn = scanner.nextInt();


                } while (matrixColumn <= 0 || matrixColumn > matrixN);

                do {
                    System.out.print("Hamlenizi girin(Düşey):");
                    matrixLine = scanner.nextInt();


                } while (matrixLine <= 0 || matrixLine > matrixN);
            } while (checkMatrixIndex(matrixLine, matrixColumn, SOS));
            System.out.println(matrixColumn + "-" + matrixLine);
            SOS.setMatrixColumn(matrixColumn);
            SOS.setMatrixLine(matrixLine);
            SOS.setMatrixRealIndex(matrixLine, matrixColumn, PlayerLetter);

        } else if (PlayerTurn == 2) {

            do {
                Random random = new Random();
                matrixColumn = random.nextInt(matrixN) + 1;
                matrixLine = random.nextInt(matrixN) + 1;


            } while (checkMatrixIndex(matrixLine, matrixColumn, SOS));
            System.out.println(matrixColumn + "-" + matrixLine);
            SOS.setMatrixColumn(matrixColumn);
            SOS.setMatrixLine(matrixLine);
            SOS.setMatrixRealIndex(matrixLine, matrixColumn, PlayerLetter);
        }

    }

    public static boolean checkMatrixIndex(int matrixLine, int matrixColumn, Game SOS) {
        if (SOS.getMatrixRealAtIndex(matrixLine, matrixColumn) == 0)
            return false;
        else

            return true;
    }

}