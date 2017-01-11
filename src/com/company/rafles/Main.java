package com.company.rafles;

import model.Board;
import model.Brick;
import model.Point;

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

        System.out.println(bd);
        System.out.println(bd.placeBrick(b));
    }
}
