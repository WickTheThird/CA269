public class Point implements Comparable, Order {
    private double x, y;

    public boolean lessThan(Order other){
        Point p = (Point) other;

        if (this.equals(p)) return false;

        return x <= p.x && y <= p.y;
    }

    public int compareTo(Object other) {
        Point p = (Point) other;

        if (this.equals(p)) {
            return 0;
        } if ( this.lessThan(p) ) {
            return -1;
        } else {
            return 1;
        }
    }

    public boolean equals(Point other) {
        Point p = (Point) other;

        if (x == p.x && y == p.y) {
            return true;
        } else {
            return false;
        }
    }

    public Point(double newX, double newY) {
        x = newX;
        y = newY;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
