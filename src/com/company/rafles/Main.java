package com.company.rafles;

import model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static Board board;
    private static int size;

    public static void main(String[] args) {

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        String ping = null;
        try {
            ping = stdin.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert ping != null;
        if ("PING".equals(ping.toUpperCase())) {
            System.out.println("Pong");
        } else {
            System.out.println("Ping");
        }

        try {
            size = Integer.parseInt(stdin.readLine());
            board = new Board(size);

        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            String inp = null;
            try {
                inp = stdin.readLine();
            } catch (IOException e) {
            }
            if (inp != null && !("START".equals(inp.toUpperCase()))) {
                String[] elements = inp.trim().split(" ");
                int[] coords = new int[4];
                int i = 0;
                for (String e : elements) {
                    coords[i++] = (Integer.parseInt(e)) - 1;
                }
                Point pa = new Point(coords[0],coords[1]);
                Point pb = new Point(coords[2],coords[3]);
                Brick brick = new Brick(pa,pb);
                board.setBrick(brick);
            }
            if(GenerateGraph.itsTime(board)) {
                Graph gp = GenerateGraph.generateRecursive(board,Player.Me);
                System.out.println(gp);
                DecisionMaker dc = new DecisionMaker();
                Brick answer = dc.decide(gp);
                board.placeBrick(answer);
                System.out.println(answer);
            } else {
                Brick answer = RandomMaker.nextMove(board);
                System.out.println(answer);
            }

        }

       /* Point p1 = new Point(0,0);
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
        //bd.setBrick(b2);
        //bd.setBrick(b3);
        //bd.setBrick(b4);

        if(GenerateGraph.itsTime(bd)) {
            Graph gp = GenerateGraph.generateRecursive(bd,Player.Me);
            System.out.println(gp);
            DecisionMaker dc = new DecisionMaker();
            System.out.println(dc.decide(gp));
        }
        //System.out.println(RandomMaker.nextMove(bd));*/

    }
}
