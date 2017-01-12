package model;

import java.util.ArrayList;

/**
 * Created by rwozn on 11.01.2017.
 */
public class State {
    private int name;
    private ArrayList<Integer> fathers;
    private ArrayList<Integer> sons;
    private Board board;
    private Player player;
    private boolean winner = false;

    public State(ArrayList<Integer> fathers, ArrayList<Integer> sons, Board board, Player player) {
        this.fathers = fathers;
        this.sons = sons;
        this.board = board;
        this.player = player;
    }

    public State(Board board, Player player) {
        this.board = board;
        this.player = player;
        this.fathers = new ArrayList<>();
        this.sons = new ArrayList<>();
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public ArrayList<Integer> getFathers() {
        return fathers;
    }

    public void setFathers(ArrayList<Integer> fathers) {
        this.fathers = fathers;
    }
    public void addFather(Integer father) {
        this.fathers.add(father);
    }

    public ArrayList<Integer> getSons() {
        return sons;
    }

    public void setSons(ArrayList<Integer> sons) {
        this.sons = sons;
    }
    public void addSon(Integer son) {
        this.sons.add(son);
    }

    public Board getBoard() {
        return board;
    }

    public Player getPlayer() {
        return player;
    }
    public boolean isWinner() {
        return winner;
    }
    public void setWinner(boolean winner) {
        this.winner = winner;
    }
    public int freePostions() {
        return this.board.freePositions();
    }
    public boolean isTerminal() {
        return board.isTerminal();
    }
    @Override
    public String toString() {
        return "State{" + '\n' +
                "name=" + name + '\n' +
                "fathers=" + fathers + '\n' +
                ",sons=" + sons + '\n' +
                ",board=" + board + '\n' +
                ",player=" + player + '\n' +
                ",winner=" + winner + '\n' +
                '}' +'\n';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        State state = (State) o;

        return getBoard() != null ? getBoard().equals(state.getBoard()) : state.getBoard() == null;

    }

    @Override
    public int hashCode() {
        return getBoard() != null ? getBoard().hashCode() : 0;
    }
}
