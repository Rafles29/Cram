package model;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Function;

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
    public boolean setPosition(Point p) {
            if (this.board[p.getY()][p.getX()] == 0) {
                this.board[p.getY()][p.getX()] = 1;
                return true;
            } else {
                throw new IllegalArgumentException("Nie można zmienić stanu już ustawionego punktu");
            }
    }
    public void setBrick(Brick b) {
        try {
            setPosition(b.getFirst());
            setPosition(b.getSecond());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
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
}
