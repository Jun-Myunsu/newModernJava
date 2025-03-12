package org.example.repactoring;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.example.repactoring.Point;

public class Debugging {

    public static void main(String[] args) {
        List<Point> points = Arrays.asList(Point.createPoint(12, 2), null);
        points.stream().map(p -> p.getX()).forEach(System.out::println);
    }

    public static List<Point> moveAllPointsRightBy(List<Point> points, int x) {
        return points.stream().map(p -> Point.createPoint(p.getX() + x, p.getY()))
                .collect(Collectors.toList());
    }
}
