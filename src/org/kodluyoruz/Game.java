package org.kodluyoruz;


public class Game {

    private int matrixReal[][];

    public int getMatrixLine() {
        return matrixLine;
    }

    public void setMatrixRealIndex(int matrixLine, int matrixColumn, int PlayerLetter) {
        if (this.matrixReal[matrixLine][matrixColumn] == 0)
            this.matrixReal[matrixLine][matrixColumn] = PlayerLetter;
    }

    public int getMatrixColumn() {
        return matrixColumn;
    }

    private int matrixN;
    private int matrixLine;
    private int matrixColumn;

    private int playerMePoint;
    private int PlayerPcPoint;

    private int PlayerTurn;
    private int PlayerLetter;

    public int getPlayerMePoint() {
        return playerMePoint;
    }

    public void setPlayerMePoint(int playerMePoint) {
        this.playerMePoint = playerMePoint;
    }

    public int getPlayerPcPoint() {
        return PlayerPcPoint;
    }

    public void setPlayerPcPoint(int playerPcPoint) {
        PlayerPcPoint = playerPcPoint;
    }


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


    public int getMatrixRealAtIndex(int matrixLine, int matrixColumn) {
        return matrixReal[matrixLine][matrixColumn];
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
            this.matrixReal = new int[matrixN + 1][matrixN + 1];


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