package com.company.rafles;

import model.*;

public class Main {

    public static void main(String[] args) {

        Point p1 = new Point(0,0);
        Point p2 = new Point(1,0);
        Point p3 = new Point(2,2);
        Point p4 = new Point(1,2);
        Point p5 = new Point(2,0);
        Point p6 = new Point(2,1);
        Point p7 = new Point(0,1);
        Point p8 = new Point(0,2);

        Brick b = new Brick(p1,p2);
        Brick b2 = new Brick(p3,p4);
        Brick b3 = new Brick(p5,p6);
        Brick b4 = new Brick(p7,p8);

        Board bd = new Board(3);
        bd.setBrick(b);
        bd.setBrick(b2);
        bd.setBrick(b3);
        //bd.setBrick(b4);

        State st = new State(bd, Player.Me);
        //Graph gpGen = GenerateGraph.generate(bd,Player.Me);
        //System.out.println(gpGen);
       // System.out.println(st);
        //System.out.println(st.isTerminal());
        Graph gp = GenerateGraph.generateRecursive(bd,Player.Me);
        System.out.println(gp);
    }
}
