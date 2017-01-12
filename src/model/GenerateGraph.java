package model;

import java.util.ArrayList;

/**
 * Created by rwozn on 11.01.2017.
 */
public class GenerateGraph {
    //generuje pełen graf od danego stanu
    public static Graph generate(Board board, Player player){
        Graph gp = new Graph();
        gp.addState(board,player);
        gp.getState(0).setName(gp.getStates()-1);

        makeKids(gp,gp.getState(0));
        makeKids(gp,gp.getState(1));
        makeKids(gp,gp.getState(2));
        makeKids(gp,gp.getState(3));
        makeKids(gp,gp.getState(4));
        return gp;
    }
    //rekurencyjnie tworzy pełen graf od danego stanu
    public static Graph generateRecursive(Board board, Player player){
        Graph gp = new Graph();
        gp.addState(board,player);
        gp.getState(0).setName(gp.getStates()-1);

        genRecursive(gp,gp.getState(0));
        return gp;
    }
    //rekurencyjnie tworzy graf na podstawie dostarczonego ojca
    private static void genRecursive(Graph graf, State state) {
        if(!state.isTerminal()){
            int before = graf.getStates();
            makeKids(graf,state);
            int after = graf.getStates();
            for (int i=0;i<after-before;i++){
                genRecursive(graf,graf.getState(before+i));
            }
            ArrayList<Integer> sons = state.getSons();
            for (int son: sons){
                if(graf.getState(son).isWinner()) {
                    state.setWinner(true);
                }
            }

        }else if(state.getPlayer() == Player.Opponent){
            state.setWinner(true);

        }else{
            state.setWinner(false);
        }
    }
    // Wytwarza wszystkie możliwe dzieci i łączy je z ojcem
    private static void makeKids(Graph graph,State father){
        ArrayList<State> kids = generateKids(father);
        for (int i=0; i<kids.size();i++) {
            int name =graph.getStates();
            kids.get(i).setName(name);
            if(graph.addState(kids.get(i))) {
                graph.getState(father.getName()).addSon(name);
            }else {
                int index = graph.indexOf(kids.get(i));
                graph.getState(index).addFather(father.getName());
                graph.getState(father.getName()).addSon(index);
            }
        }
    }
    //generuje liste wszystkich dzeci
    private static ArrayList<State> generateKids(State state) {
        Board bd = state.getBoard();
        ArrayList<State> answer = new ArrayList<>();
        addKid(answer,bd,state,1,0);
        addKid(answer,bd,state,0,1);

        return new ArrayList<>(answer);

    }

    //zmienia gracza
    private static Player changePlayer(Player player){
        if (player == Player.Me) return Player.Opponent;
        else return Player.Me;
    }
    //dodaje do listy answer wszyskie mozliwe to utworzenia dzieci (pionowo lub poziomo)
    private static void addKid(ArrayList<State> answer,Board bd, State state, int offI, int offJ) {
        try {
            for (int i=0;i<bd.getDimension()-offI;i++) {
                for (int j=0;j<bd.getDimension()-offJ;j++) {
                    Brick br = new Brick(new Point(i,j), new Point(i+offI,j+offJ));
                    if (bd.placeBrick(br)) {
                        Board tempBD = bd.clone();
                        tempBD.setBrick(br);
                        State tempState = new State(tempBD,changePlayer(state.getPlayer()));
                        tempState.addFather(state.getName());
                        answer.add(tempState);
                    }
                }
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
