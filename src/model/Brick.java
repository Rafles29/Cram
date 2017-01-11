package model;

/**
 * Created by rwozn on 05.01.2017.
 */
public class Brick {
    private Point first;
    private Point second;

    public Brick(Point first, Point second) {

        if (check(first,second)){
            this.first = first;
            this.second = second;
        }
        else throw new IllegalArgumentException("Punkty muszą być obok siebie");
    }
    private boolean check(Point first, Point second) {
        if (first.equals(second)) return false;
        if (Math.abs(first.getX() - second.getX()) == 1 && Math.abs(first.getY() - second.getY()) == 0) return true;
        if (Math.abs(first.getX() - second.getX()) == 0 && Math.abs(first.getY() - second.getY()) == 1) return true;
        return false;
    }

    public Point getFirst() {
        return first;
    }
    public Point getSecond() {
        return second;
    }

    public Point[] getPoints() {
        Point[] points = new Point[2];
        points[0] = getFirst();
        points[1] = getSecond();

        return points;
    }
    public int[] getPosition() {
        int[] position = new int[4];
        position[0] = getFirst().getX();
        position[1] = getFirst().getY();
        position[2] = getSecond().getX();
        position[3] = getSecond().getY();

        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Brick brick = (Brick) o;

        if (getFirst() != null ? !getFirst().equals(brick.getFirst()) : brick.getFirst() != null) return false;
        return getSecond() != null ? getSecond().equals(brick.getSecond()) : brick.getSecond() == null;

    }

    @Override
    public int hashCode() {
        int result = getFirst() != null ? getFirst().hashCode() : 0;
        result = 31 * result + (getSecond() != null ? getSecond().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Brick{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
