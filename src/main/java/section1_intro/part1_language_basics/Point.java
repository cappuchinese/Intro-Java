package section1_intro.part1_language_basics;


public class Point {
    int x;
    int y;

    /**
     * Create an instance of class point that is located at the same coordinates as the current object, but in the
     * diagonally opposing quadrant of coordinate space.
     * So, when the current point is at (4, 4), this method will return Point(-4, -4)
     * and when the current point is at (2, -5) it will return Point(-2, 5).
     * @return inverse Point
     */
    Point createInversePoint() {
        Point inverse = new Point();
        inverse.x = x * -1;
        inverse.y = y * -1;
        return inverse;
    }

    /**
     * This method returns the Euclidean distance of the current point (this) to the given point (otherPoint).
     * GIYF if you forgot what Euclidean distance is and how it is calculated.
     * @param otherPoint
     * @return euclidean distance
     */
    double euclideanDistanceTo(Point otherPoint) {
        double lengthX = Math.abs(otherPoint.x - x);
        double lengthY = Math.abs(otherPoint.y - y);
        return Math.hypot(lengthX, lengthY);
    }

    public static void main(String[] args) {
        Point current = new Point();
        current.x = 5;
        current.y = -3;
        Point z = current.createInversePoint();
        System.out.printf("Inverse point: (%d,%d)%n", z.x, z.y);
        Point other = new Point();
        other.x = 2;
        other.y = 9;
        System.out.printf("Distance: %,.2f", current.euclideanDistanceTo(other));
    }
}
