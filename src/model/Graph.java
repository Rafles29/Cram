package model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by rwozn on 11.01.2017.
 */
public class Graph {
    private ArrayList<State> graph;
    private  int states = 0;

    public Graph() {
        this.graph = new ArrayList<>();
    }
    public Graph(ArrayList<State> graph) {
        this.graph = graph;
    }

    public int getStates() {
        return this.states;
    }

    public boolean addState(State state) {
        if (!this.graph.contains(state)) {
            this.graph.add(state);
            this.states++;
            return true;
        } else
            return false;
    }
    public boolean addState(Board board, Player player){
        State s = new State(board,player);
        if (!this.graph.contains(s)) {
            this.graph.add(new State(board, player));
            this.states++;
            return true;
        }else
            return false;
    }
    public int indexOf(State state){
        return graph.indexOf(state);
    }
    public State getState(int state) {
        return this.graph.get(state);
    }

    @Override
    public String toString() {
        return "Graph{" +
                "graph=" + graph +
                '}';
    }
}
