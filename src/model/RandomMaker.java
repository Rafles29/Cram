package model;

/**
 * Created by rwozn on 12.01.2017.
 */
public class RandomMaker {


    public static Brick nextMove(Board board){
        int offI=1;
        int offJ=1;
        for (int i=0;i<board.getDimension()-offI;i++) {
            for (int j=0;j<board.getDimension();j++) {
                Brick br = new Brick(new Point(i,j), new Point(i+offI,j));
                if (board.placeBrick(br)) return br;
            }
        }

        for (int i=0;i<board.getDimension();i++) {
            for (int j=0;j<board.getDimension()-offJ;j++) {
                Brick br = new Brick(new Point(i,j), new Point(i,j+offJ));
                if (board.placeBrick(br)) return br;
            }
        }
        throw  new UnsupportedOperationException("Koniec");
    }
}
