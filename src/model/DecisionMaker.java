package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by rwozn on 12.01.2017.
 */
public class DecisionMaker {



    public Brick decide(Graph graph){
        ArrayList<Integer> winners= choseWinners(graph);
        System.out.println(winners);
        if(winners.size() == 0) throw new UnsupportedOperationException("Przegraliśmy");
        int myWinner = choseState(winners);
        System.out.println(myWinner);

        return differnce(graph.getState(0),graph.getState(myWinner));
    }
    private ArrayList<Integer> choseWinners(Graph graph) {
        ArrayList<Integer> siblings = graph.getState(0).getSons();
        ArrayList<Integer> winners = new ArrayList<>();
        for (int index: siblings){
            if (graph.getState(index).isWinner()) {
                winners.add(index);
            }
        }
        return new ArrayList<>(winners);
    }
    private int choseState(ArrayList<Integer> winners){
        int size = winners.size();
            Random random = new Random();
            System.out.println("Moj wybor"+size);
            int choice = random.nextInt(size);
            return winners.get(choice);
    }
    private Brick differnce(State father, State son){
        Point p1 = new Point();
        Point p2 = new Point();
        int dim = father.getBoard().getDimension();
        for (int i=0;i<dim;i++) {
            for (int j=0;j<dim;j++) {
                p1.setX(j);
                p1.setY(i);
                if ((father.getBoard().checkPosition(p1)) &&  !(son.getBoard().checkPosition(p1))){
                    p2 = findSecond(p1,father,son);
                    return new Brick(p1, p2);
                }
            }

        }
        return new Brick(p1, p2);
    }
    private Point findSecond(Point point, State father, State son){
        int dim = father.getBoard().getDimension();
        Point p = new Point(point.getX(),point.getY());
        p.setX(point.getX()-1);
        if (p.getX() >= 0){
            if ((father.getBoard().checkPosition(p)) &&  !(son.getBoard().checkPosition(p))){
                return p;
            }
        }
        p.setX(point.getX()+1);
        if (p.getX() < dim){
            if ((father.getBoard().checkPosition(p)) &&  !(son.getBoard().checkPosition(p))){
                return p;
            }
        }
        p.setX(point.getX());
        p.setY(point.getX()-1);
        if (p.getY() >= 0){
            if ((father.getBoard().checkPosition(p)) &&  !(son.getBoard().checkPosition(p))){
                return p;
            }
        }
        p.setY(point.getY()+1);
        if (p.getY() < dim){
            if ((father.getBoard().checkPosition(p)) &&  !(son.getBoard().checkPosition(p))){
                return p;
            }
        }
        return new Point(0,0);
    }
}
