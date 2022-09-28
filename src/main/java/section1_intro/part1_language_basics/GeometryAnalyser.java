package section1_intro.part1_language_basics;

import java.text.NumberFormat;
import java.util.Objects;

public class GeometryAnalyser {
    public static void main(String[] args) {
        String[] cmd = {"2", "5", "6", "2", "surf"};
        int x1 = Integer.parseInt(args[0]);
        int y1 = Integer.parseInt(args[1]);
        int x2 = Integer.parseInt(args[2]);
        int y2 = Integer.parseInt(args[3]);
        String method = args[4];

        Rectangle rectangle = new Rectangle();
        rectangle.upperLeft = new Point();
        rectangle.lowerRight = new Point();
        rectangle.upperLeft.x = x1;
        rectangle.upperLeft.y = y1;
        rectangle.lowerRight.x = x2;
        rectangle.lowerRight.y = y2;

        if (method.equals("surf")) {
            System.out.println(rectangle.getSurface());
        }
        else {
            NumberFormat numberFormat = NumberFormat.getNumberInstance();
            numberFormat.setMaximumFractionDigits(1);
            double answer = rectangle.upperLeft.euclideanDistanceTo(rectangle.lowerRight);
            System.out.println(numberFormat.format(answer));
        }
    }
}
