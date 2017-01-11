package model;

/**
 * Created by rwozn on 05.01.2017.
 */
public class Board {
    private int[][] board;
    private int dimension;

    public Board(int[][] board) {
        this.board = board;
        this.dimension = board.length;
    }
    public Board(int dimension) {
        this.board = new int[dimension][dimension];
        for(int i = 0; i<dimension;i++) {
            for(int j = 0; j<dimension;j++) {
                this.board[i][j] = 0;
            }
        }
        this.dimension = dimension;
    }
    public int[][] getBoard() {
        return board;
    }
    public int getDimension() {
        return dimension;
    }
    private boolean checkPosition(Point p) {
        if (p.getX() >= getDimension() || p.getY() >= getDimension()) throw new IllegalArgumentException("Punkt jest poza plansza");
        if (this.board[p.getY()][p.getX()] == 0) {
            return true;
        } else {
            return false;
        }
    }

    private void setPosition(Point p) {
        if (checkPosition(p)) {
            this.board[p.getY()][p.getX()] = 1;
        }
    }
    public boolean placeBrick(Brick b) {
        if (checkPosition(b.getFirst()) && checkPosition(b.getSecond())) {
            return true;
        } else {
            return false;
        }
    }
    public void setBrick(Brick b) {
        if (placeBrick(b)) {
            setPosition(b.getFirst());
            setPosition(b.getSecond());
        }
    }
    @Override
    public String toString() {
        StringBuilder answer = new StringBuilder();
        answer.append("Board{");
        answer.append('\n');
        for(int i = 0; i<dimension;i++) {
            for(int j = 0; j<dimension;j++) {
                answer.append(this.board[i][j]);
            }
            answer.append('\n');
        }
        answer.append('}');
        return answer.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        int[][] secboard = new int[this.dimension][this.dimension];
        for(int i=0;i<this.dimension;i++){
            for (int j=0;j<this.dimension;j++) {
                secboard[i][j] = this.board[i][j];
            }
        }
        return new Board(secboard);
    }
}
