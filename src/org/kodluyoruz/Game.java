package org.kodluyoruz;


import static java.lang.System.out;

public class Game {

    private String matrixReal[][];
    private int matrixN;

    private int letterI;
    private int letterJ;

    private int playerMePoint;
    private int PlayerPcPoint;

    private int PlayerTurn;
    private String letter;

    public void setMatrixReal(String[][] matrixReal) {
        this.matrixReal = matrixReal;
    }

    public String[][] getMatrixReal() {
        return matrixReal;
    }


    public int setMatrixN(int matrixN) {
        if (matrixN >= 3 && matrixN <= 7) {
            this.matrixN = matrixN;
            this.matrixReal = new String[matrixN + 1][matrixN + 1];

            for (int i = 0; i < this.matrixN + 1; i++) {
                for (int j = 0; j < this.matrixN + 1; j++) {
                    this.matrixReal[i][j] = ".";
                }

            }

            return 1;
        } else {
            System.out.println("İstenilen aralıkta giriniz!");
            return 0;
        }

    }

    public int getMatrixN() {
        return this.matrixN;
    }


    public void setMatrixRealIndex(int letterI, int letterJ, String letter) {
        if (this.matrixReal[letterI][letterJ].equals("."))
            this.matrixReal[letterI][letterJ] = letter;
    }

    public String getMatrixRealAtIndex(int letterI, int letterJ) {
        return matrixReal[letterI][letterJ];
    }


    public void setLetterI(int letterI) {
        this.letterI = letterI;
    }

    public int getLetterI() {
        return letterI;
    }


    public void setLetterJ(int letterJ) {
        this.letterJ = letterJ;
    }

    public int getLetterJ() {
        return letterJ;
    }


    public void setPlayerMePoint(int playerMePoint) {
        this.playerMePoint = playerMePoint;
    }

    public int getPlayerMePoint() {
        return playerMePoint;
    }

    public void setPlayerPcPoint(int playerPcPoint) {
        PlayerPcPoint = playerPcPoint;
    }

    public int getPlayerPcPoint() {
        return PlayerPcPoint;
    }


    public void setPlayerTurn(int PlayerTurn) {
        this.PlayerTurn = PlayerTurn;
    }

    public int getPlayerTurn() {
        return PlayerTurn;
    }


    public void setLetter(int letter) {
        if (letter == 6)
            this.letter = "O";
        else
            this.letter = "S";
    }

    public String getLetter() {
        return letter;
    }


}