package model;

import java.util.ArrayList;

/**
 * Created by rwozn on 11.01.2017.
 */
public class GenerateGraph {
    public static Graph generate(Board board, Player player){
        Graph gp = new Graph();
        gp.addState(board,player);
        ArrayList<State> kids = generateKids(gp.getState(0));
        for (int i=0; i<kids.size();i++) {
            gp.addState(kids.get(i));
        }
        return gp;
    }
    private static ArrayList<State> generateKids(State state) {
        Board bd = state.getBoard();
        ArrayList<State> answer = new ArrayList<>();
        addKid(answer,bd,state,1,0);
        addKid(answer,bd,state,0,1);

        return new ArrayList<>(answer);

    }
    private static Player changePlayer(Player player){
        if (player == Player.Me) return Player.Opponent;
        else return Player.Me;
    }
    private static void addKid(ArrayList<State> answer,Board bd, State state, int offI, int offJ) {
        try {
            for (int i=0;i<bd.getDimension()-offI;i++) {
                for (int j=0;j<bd.getDimension()-offJ;j++) {
                    Brick br = new Brick(new Point(i,j), new Point(i+offI,j+offJ));
                    if (bd.placeBrick(br)) {
                        Board tempBD = bd.clone();
                        tempBD.setBrick(br);
                        State tempState = new State(tempBD,changePlayer(state.getPlayer()));
                        answer.add(tempState);
                    }
                }
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
