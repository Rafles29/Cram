package com.company.rafles;

import model.*;

public class Main {

    public static void main(String[] args) {

        Board bd = new Board(5);
        Point p1 = new Point(0,0);
        Point p2 = new Point(1,0);
        Point p3 = new Point(4,2);
        Point p4 = new Point(3,2);
        Brick b = new Brick(p1,p2);
        Brick b2 = new Brick(p3,p4);

        bd.setBrick(b);
        bd.setBrick(b2);
        State st = new State(bd, Player.Me);
        System.out.println(st);
        Graph gp = new Graph();
        gp.addState(st);
        System.out.println(gp);
    }
}
