package com.company.rafles;

import model.Board;
import model.Brick;
import model.Point;

public class Main {

    public static void main(String[] args) {

        Board bd = new Board(5);
        Point p1 = new Point(0,0);
        Point p2 = new Point(1,0);
        Brick b = new Brick(p1,p2);

        bd.setBrick(b);

        System.out.println(bd);
    }
}
