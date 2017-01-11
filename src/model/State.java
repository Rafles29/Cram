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

    public State(int name, ArrayList<Integer> fathers, ArrayList<Integer> sons, Board board, Player player) {
        this.name = name;
        this.fathers = fathers;
        this.sons = sons;
        this.board = board;
        this.player = player;
    }

    public State(int name, Board board, Player player) {
        this.name = name;
        this.board = board;
        this.player = player;
        this.fathers = new ArrayList<>();
        this.sons = new ArrayList<>();
    }

    public int getName() {
        return name;
    }

    public ArrayList<Integer> getFathers() {
        return fathers;
    }

    public void setFathers(ArrayList<Integer> fathers) {
        this.fathers = fathers;
    }

    public ArrayList<Integer> getSons() {
        return sons;
    }

    public void setSons(ArrayList<Integer> sons) {
        this.sons = sons;
    }

    public Board getBoard() {
        return board;
    }

    public Player getPlayer() {
        return player;
    }

}
