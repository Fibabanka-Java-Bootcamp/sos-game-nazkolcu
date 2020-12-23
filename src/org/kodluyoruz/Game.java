package org.kodluyoruz;


public class Game {

    private int matrixReal[][];
    private int matrixN;
    private int matrixLine;
    private int matrixColumn;

    private int playerMePoint;
    private int PlayerPcPoint;

    private int PlayerTurn;
    private int PlayerLetter;

    public void setPlayerLetter(int PlayerLetter) {
        this.PlayerLetter = PlayerLetter;
    }

    public void setPlayerTurn(int PlayerMove) {
        this.PlayerTurn = PlayerMove;
    }
    public int getPlayerTurn() {
        return PlayerTurn;
    }

    public int getPlayerLetter() {
        return PlayerLetter;
    }



    public int getMatrixRealAtIndex(int i, int j) {
        return matrixReal[i][j];
    }

    public int[][] getMatrixReal() {
        return matrixReal;
    }

    public int getMatrixN() {
        return matrixN;
    }

    public int setMatrixN(int matrixN) {
        if (matrixN >= 3 && matrixN <= 7) {
            this.matrixN = matrixN;
            this.matrixReal = new int[matrixN][matrixN];


            return 1;
        } else {
            System.out.println("Out of range! Pls try again");
            return 0;
        }

    }

    public void setMatrixLine(int matrixLine) {
        this.matrixLine = matrixLine;
    }

    public void setMatrixColumn(int matrixColumn) {
        this.matrixColumn = matrixColumn;
    }
}