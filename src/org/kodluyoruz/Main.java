package org.kodluyoruz;

import java.util.Scanner;
import java.util.Random;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {

        Game SOS = new Game();

        configGame(SOS);

        guessFirstMove(SOS);

        wholeGame(SOS);

    }

    public static void configGame(Game SOS) {

        out.println("SOS Oyununa Hoş Geldiniz!");

        int matrixNcontrol;

        do {
            Scanner scanner = new Scanner(System.in);
            out.println("Matris büyüklüğü olarak bir N sayısı giriniz (NxN/3-7):");

            int matrixN = scanner.nextInt();

            matrixNcontrol = SOS.setMatrixN(matrixN);

        } while (matrixNcontrol == 0);
    }


    public static void guessFirstMove(Game SOS) {
        int PlayerTurn;
        int playerLetter;

        Random random = new Random();

        // turn:1-me, 2-pc
        PlayerTurn = random.nextInt(2) + 1;

        //letter:5-S, 6-O
        playerLetter = 5 + random.nextInt(6 - 5 + 1);


        SOS.setPlayerTurn(PlayerTurn);
        SOS.setLetter(playerLetter);
    }


    public static void printMatrix(Game SOS) {

        for (int i = 0; i < SOS.getMatrixReal().length; i++) {

            for (int j = 0; j < SOS.getMatrixReal().length; j++) {
                if (i == 0 && j == 0) {
                    out.print("\t");
                } else if (i == 0) {
                    out.print(j + "\t");
                } else if (j == 0) {
                    out.print(i + "\t");
                } else {
                    if (SOS.getMatrixRealAtIndex(i, j).equals(".")) out.print("_" + "\t");
                    else
                        out.print(SOS.getMatrixRealAtIndex(i, j) + "\t");
                }
            }
            out.println();
        }
    }

    public static void letterControl(Game SOS) {

        String[][] matrix = SOS.getMatrixReal();
        String PlayerLetter = SOS.getLetter();

        int turnControl = 0;
        int matrixN = SOS.getMatrixN();
        int LetterI = SOS.getLetterI();
        int LetterJ = SOS.getLetterJ();

        if (PlayerLetter.equals("O")) {
            if ((LetterI == 1 & LetterJ == 1) || (LetterI == matrixN & LetterJ == 1) || (LetterI == 1 & LetterJ == matrixN) || (LetterI == matrixN & LetterJ == matrixN)) {

            } else if ((LetterJ == 1 || LetterJ == matrixN) && (LetterI == 1 || LetterI == matrixN)) {
                if (LetterI == 1 || LetterI == matrixN) {
                    if (matrix[1][LetterJ - 1].equals("O") && matrix[1][LetterJ + 1].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    } else if (matrix[matrixN][LetterJ - 1].equals("S") && matrix[matrixN][LetterJ + 1].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterJ == 1 || LetterJ == matrixN) {
                    if (matrix[LetterI - 1][1].equals("S") && matrix[LetterI + 1][1].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                    if (matrix[LetterI - 1][matrixN].equals("S") && matrix[LetterI + 1][matrixN].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }

                }


            } else {
                if (LetterI + 1 <= matrixN && LetterI - 1 <= matrixN && LetterJ + 1 <= matrixN && LetterJ - 1 <= matrixN) {
                    if (matrix[LetterI - 1][LetterJ - 1].equals("S") && matrix[LetterI + 1][LetterJ + 1].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterI - 1 <= matrixN && LetterJ + 1 <= matrixN && LetterJ - 1 <= matrixN && LetterI + 1 <= matrixN) {

                    if (matrix[LetterI + 1][LetterJ - 1].equals("S") && matrix[LetterI - 1][LetterJ + 1].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterI + 1 <= matrixN && LetterI - 1 <= matrixN) {
                    if (matrix[LetterI - 1][LetterJ].equals("S") && matrix[LetterI + 1][LetterJ].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterJ + 1 <= matrixN && LetterJ - 1 <= matrixN) {
                    if (matrix[LetterI][LetterJ - 1].equals("S") && matrix[LetterI][LetterJ + 1].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
            }

        } else {

            //sKose basladı
            if (LetterI == 1 && LetterJ == 1) {
                if ((matrix[LetterI][LetterJ + 1].equals("O")) && matrix[LetterI][LetterJ + 2].equals("S")) {
                    addPoint(SOS);
                    turnControl = turnControl + 1;
                }
                if ((matrix[LetterI + 1][LetterJ + 1].equals("O")) && matrix[LetterI + 2][LetterJ + 2].equals("S")) {
                    addPoint(SOS);
                    turnControl = turnControl + 1;
                }
                if ((matrix[LetterI + 1][LetterJ].equals("O")) && matrix[LetterI + 2][LetterJ].equals("S")) {
                    addPoint(SOS);
                    turnControl = turnControl + 1;
                }
            } else if (LetterI == matrixN && LetterJ == 1) {

                if ((matrix[LetterI - 1][LetterJ].equals("O")) && matrix[LetterI - 2][LetterJ].equals("S")) {
                    addPoint(SOS);
                    turnControl = turnControl + 1;
                }
                if ((matrix[LetterI - 1][LetterJ + 1].equals("O")) && matrix[LetterI - 2][LetterJ + 2].equals("S")) {
                    addPoint(SOS);
                    turnControl = turnControl + 1;
                }
                if ((matrix[LetterI][LetterJ + 1].equals("O")) && matrix[LetterI][LetterJ + 2].equals("S")) {
                    addPoint(SOS);
                    turnControl = turnControl + 1;
                }
            } else if (LetterI == 1 && LetterJ == matrixN) {
                if ((matrix[LetterI][LetterJ - 1].equals("O")) && matrix[LetterI][LetterJ - 2].equals("S")) {
                    addPoint(SOS);
                    turnControl = turnControl + 1;
                }
                if ((matrix[LetterI + 1][LetterJ - 1].equals("O")) && matrix[LetterI + 2][LetterJ - 2].equals("S")) {
                    addPoint(SOS);
                    turnControl = turnControl + 1;
                }
                if ((matrix[LetterI + 1][LetterJ].equals("O")) && matrix[LetterI + 2][LetterJ].equals("S")) {
                    addPoint(SOS);
                    turnControl = turnControl + 1;
                }
            } else if (LetterI == matrixN && LetterJ == matrixN) {
                if ((matrix[LetterI][LetterJ - 1].equals("O")) && matrix[LetterI][LetterJ - 2].equals("S")) {
                    addPoint(SOS);
                    turnControl = turnControl + 1;
                }
                if ((matrix[LetterI - 1][LetterJ - 1].equals("O")) && matrix[LetterI - 2][LetterJ - 2].equals("S")) {
                    addPoint(SOS);
                    turnControl = turnControl + 1;
                }
                if ((matrix[LetterI - 1][LetterJ].equals("O")) && matrix[LetterI - 2][LetterJ].equals("S")) {
                    addPoint(SOS);
                    turnControl = turnControl + 1;
                }
            }
            //sKose bitti
//sKenar

            //
            else if (LetterJ == 1 && LetterI == 2) {
                if (LetterJ + 2 <= matrixN) {
                    if ((matrix[LetterI][LetterJ + 1].equals("O")) && matrix[LetterI][LetterJ + 2].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterI + 2 <= matrixN && LetterJ + 2 <= matrixN) {
                    if ((matrix[LetterI + 1][LetterJ + 1].equals("O")) && matrix[LetterI + 2][LetterJ + 2].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterI + 2 <= matrixN) {
                    if ((matrix[LetterI + 1][LetterJ].equals("O")) && matrix[LetterI + 2][LetterJ].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
            }
            //
            else if (LetterJ == 1 && LetterI == matrixN - 1) {
                if (LetterI - 2 <= matrixN) {
                    if ((matrix[LetterI - 1][LetterJ].equals("O")) && matrix[LetterI - 2][LetterJ].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterI - 2 <= matrixN && LetterJ + 2 <= matrixN) {
                    if ((matrix[LetterI - 1][LetterJ + 1].equals("O")) && matrix[LetterI - 2][LetterJ + 2].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterJ + 2 <= matrixN) {
                    if ((matrix[LetterI][LetterJ + 1].equals("O")) && matrix[LetterI][LetterJ + 2].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
            }
            //
            else if (LetterJ == 1 && 2 < LetterI && LetterI < matrixN - 1) {
                if (LetterI - 2 <= matrixN) {
                    if ((matrix[LetterI - 1][LetterJ].equals("O")) && matrix[LetterI - 2][LetterJ].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterJ + 2 <= matrixN) {
                    if ((matrix[LetterI][LetterJ + 1].equals("O")) && matrix[LetterI][LetterJ + 2].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterI + 2 <= matrixN) {
                    if ((matrix[LetterI + 1][LetterJ].equals("O")) && matrix[LetterI + 2][LetterJ].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
            } else if (LetterJ == matrixN && LetterI == 2) {
                if (LetterJ - 2 <= matrixN) {
                    if ((matrix[LetterI][LetterJ - 1].equals("O")) && matrix[LetterI][LetterJ - 2].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterI - 2 <= matrixN && LetterJ - 2 <= matrixN) {
                    if ((matrix[LetterI - 1][LetterJ - 1].equals("O")) && matrix[LetterI - 2][LetterJ - 2].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterI - 2 <= matrixN) {
                    if ((matrix[LetterI - 1][LetterJ].equals("O")) && matrix[LetterI - 2][LetterJ].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
            } else if (LetterJ == matrixN && LetterI == matrixN - 1) {
                if (LetterI - 2 <= matrixN) {
                    if ((matrix[LetterI - 1][LetterJ].equals("O")) && matrix[LetterI - 2][LetterJ].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterI - 2 <= matrixN && LetterJ - 2 <= matrixN) {
                    if ((matrix[LetterI - 1][LetterJ - 1].equals("O")) && matrix[LetterI - 2][LetterJ - 2].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterJ - 2 <= matrixN) {
                    if ((matrix[LetterI][LetterJ - 1].equals("O")) && matrix[LetterI][LetterJ - 2].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
            } else if (LetterJ == matrixN && 2 < LetterI && LetterI < matrixN - 1) {
                if (LetterI - 2 <= matrixN) {
                    if ((matrix[LetterI - 1][LetterJ].equals("O")) && matrix[LetterI - 2][LetterJ].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterJ - 2 <= matrixN) {
                    if ((matrix[LetterI][LetterJ - 1].equals("O")) && matrix[LetterI][LetterJ - 2].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterI + 2 <= matrixN) {
                    if ((matrix[LetterI + 1][LetterJ].equals("O")) && matrix[LetterI + 2][LetterJ].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
            } else if (LetterI == matrixN && LetterJ == 2) {
                if (LetterI - 2 <= matrixN) {
                    if ((matrix[LetterI - 1][LetterJ].equals("O")) && matrix[LetterI - 2][LetterJ].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterJ + 2 <= matrixN && LetterI - 2 <= matrixN) {
                    if ((matrix[LetterI - 1][LetterJ + 1].equals("O")) && matrix[LetterI - 2][LetterJ + 2].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterJ + 2 <= matrixN) {
                    if ((matrix[LetterI][LetterJ + 1].equals("O")) && matrix[LetterI][LetterJ + 2].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
            } else if (LetterI == matrixN && LetterJ == matrixN - 1) {
                if (LetterI - 2 <= matrixN) {
                    if ((matrix[LetterI - 1][LetterJ].equals("O")) && matrix[LetterI - 2][LetterJ].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterI - 2 <= matrixN && LetterJ - 2 <= matrixN) {
                    if ((matrix[LetterI - 1][LetterJ - 1].equals("O")) && matrix[LetterI - 2][LetterJ - 2].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterJ - 2 <= matrixN) {
                    if ((matrix[LetterI][LetterJ - 1].equals("O")) && matrix[LetterI][LetterJ - 2].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
            } else if (LetterI == matrixN && 2 < LetterJ && LetterJ < matrixN - 1) {
                if (LetterJ - 2 <= matrixN) {
                    if ((matrix[LetterI][LetterJ - 1].equals("O")) && matrix[LetterI][LetterJ - 2].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterI - 2 <= matrixN) {
                    if ((matrix[LetterI - 1][LetterJ].equals("O")) && matrix[LetterI - 2][LetterJ].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterJ + 2 <= matrixN) {
                    if ((matrix[LetterI][LetterJ + 1].equals("O")) && matrix[LetterI][LetterJ + 2].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
            } else if (LetterI == 1 && LetterJ == 2) {
                if (LetterJ + 2 <= matrixN) {
                    if ((matrix[LetterI][LetterJ + 1].equals("O")) && matrix[LetterI][LetterJ + 2].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterI + 2 <= matrixN && LetterJ + 2 <= matrixN) {
                    if ((matrix[LetterI + 1][LetterJ + 1].equals("O")) && matrix[LetterI + 2][LetterJ + 2].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterI + 2 <= matrixN) {
                    if ((matrix[LetterI + 1][LetterJ].equals("O")) && matrix[LetterI + 2][LetterJ].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
            }
            //DOLDUR
            else if (LetterI == 1 && LetterJ == matrixN - 1) {
                if (LetterJ - 2 <= matrixN) {
                    if ((matrix[LetterI][LetterJ - 1].equals("O")) && matrix[LetterI][LetterJ - 2].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterI + 2 <= matrixN) {
                    if ((matrix[LetterI + 1][LetterJ].equals("O")) && matrix[LetterI + 2][LetterJ].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterJ + 2 <= matrixN) {
                    if ((matrix[LetterI][LetterJ + 1].equals("O")) && matrix[LetterI][LetterJ + 2].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
            } else if (LetterI == 1 && 2 < LetterJ && LetterJ < matrixN - 1) {
                if (LetterJ - 2 <= matrixN) {
                    if ((matrix[LetterI][LetterJ - 1].equals("O")) && matrix[LetterI][LetterJ - 2].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterI + 2 <= matrixN && LetterJ - 2 <= matrixN) {
                    if ((matrix[LetterI + 1][LetterJ - 1].equals("O")) && matrix[LetterI + 2][LetterJ - 2].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterI + 2 <= matrixN) {
                    if ((matrix[LetterI + 1][LetterJ].equals("O")) && matrix[LetterI + 2][LetterJ].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
            }
            //sKenar bitti
            else {
                if (LetterJ - 2 <= matrixN) {
                    if ((matrix[LetterI][LetterJ - 1].equals("O")) && matrix[LetterI][LetterJ - 2].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterJ + 2 <= matrixN) {
                    if ((matrix[LetterI][LetterJ + 1].equals("O")) && matrix[LetterI][LetterJ + 2].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterI - 2 <= matrixN) {
                    if ((matrix[LetterI - 1][LetterJ].equals("O")) && matrix[LetterI - 2][LetterJ].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterI + 2 <= matrixN) {
                    if ((matrix[LetterI + 1][LetterJ].equals("O")) && matrix[LetterI + 2][LetterJ].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterI - 2 <= matrixN && LetterJ - 2 <= matrixN) {
                    if ((matrix[LetterI - 1][LetterJ - 1].equals("O")) && matrix[LetterI - 2][LetterJ - 2].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterI + 2 <= matrixN && LetterJ + 2 <= matrixN) {
                    if ((matrix[LetterI + 1][LetterJ + 1].equals("O")) && matrix[LetterI + 2][LetterJ + 2].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterI - 2 <= matrixN && LetterJ + 2 <= matrixN) {
                    if ((matrix[LetterI - 1][LetterJ + 1].equals("O")) && matrix[LetterI - 2][LetterJ + 2].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
                if (LetterJ + 2 <= matrixN && LetterJ - 2 <= matrixN) {
                    if ((matrix[LetterI + 1][LetterJ - 1].equals("O")) && matrix[LetterI + 2][LetterJ - 2].equals("S")) {
                        addPoint(SOS);
                        turnControl = turnControl + 1;
                    }
                }
            }

        }
        if (turnControl == 0) {
            if (SOS.getPlayerTurn() == 1) {
                SOS.setPlayerTurn(2);
            } else if (SOS.getPlayerTurn() == 2) {
                SOS.setPlayerTurn(1);
            }

            if (SOS.getLetter().equals("O")) {
                SOS.setLetter(5);
            } else {
                SOS.setLetter(6);
            }
        }
    }


    public static void wholeGame(Game SOS) {

        int matrixN = SOS.getMatrixN();

        if (SOS.getPlayerTurn() == 1) {
            printMatrix(SOS);
            System.out.println("Tüm oyun boyunca oynayacağınız harf:" + SOS.getLetter());
        }
        for (int i = 0; i < matrixN * matrixN; i++) {

            getMatrixInput(SOS);

            letterControl(SOS);

            printMatrix(SOS);

            printPlayerPoints(SOS);

        }


        if (SOS.getPlayerMePoint() < SOS.getPlayerPcPoint())
            System.out.println("Bilgisayar kazandı!");
        else if (SOS.getPlayerMePoint() > SOS.getPlayerPcPoint())
            System.out.println("Siz kazandınız!");
        else
            System.out.println("Berabere!");
    }

    public static void addPoint(Game SOS) {
        if (SOS.getPlayerTurn() == 1) {
            SOS.setPlayerMePoint(SOS.getPlayerMePoint() + 1);

        } else {
            SOS.setPlayerPcPoint(SOS.getPlayerPcPoint() + 1);
        }
    }

    public static void printPlayerPoints(Game SOS) {
        out.println("You:" + SOS.getPlayerMePoint());
        out.println("PC:" + SOS.getPlayerPcPoint());
    }

    public static void getMatrixInput(Game SOS) {
        int matrixN = SOS.getMatrixN();
        int PlayerTurn = SOS.getPlayerTurn();
        String PlayerLetter = SOS.getLetter();
        int LetterJ, LetterI;

        Scanner scanner = new Scanner(System.in);

        if (PlayerTurn == 1) {
            do {
                do {
                    out.print("Hamlenizi girin(Yatay):");
                    LetterJ = scanner.nextInt();
                } while (LetterJ <= 0 || LetterJ > matrixN);

                do {
                    out.print("Hamlenizi girin(Düşey):");
                    LetterI = scanner.nextInt();
                } while (LetterI <= 0 || LetterI > matrixN);
            } while (checkMatrixIndex(LetterI, LetterJ, SOS));

            SOS.setLetterJ(LetterJ);
            SOS.setLetterI(LetterI);
            SOS.setMatrixRealIndex(LetterI, LetterJ, PlayerLetter);

        } else if (PlayerTurn == 2) {

            do {
                Random random = new Random();
                LetterJ = random.nextInt(matrixN) + 1;
                LetterI = random.nextInt(matrixN) + 1;

            } while (checkMatrixIndex(LetterI, LetterJ, SOS));
            System.out.println("Bilgisayarın hamlesi-> Y:" + LetterJ + " D:" + LetterI);
            SOS.setLetterJ(LetterJ);
            SOS.setLetterI(LetterI);
            SOS.setMatrixRealIndex(LetterI, LetterJ, PlayerLetter);
        }

    }

    //0 sütun ve 0 satır olmadığını kontrol et
    public static boolean checkMatrixIndex(int LetterI, int LetterJ, Game SOS) {
        if (SOS.getMatrixRealAtIndex(LetterI, LetterJ).equals("."))
            return false;
        else
            return true;
    }

}