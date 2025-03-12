package org.example.repactoring;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DebuggingTest {

    @Test
    public void moveAllPointsRightBy() {
        List<Point> points =
                Arrays.asList(Point.createPoint(5, 5), Point.createPoint(10, 5));
        List<Point> expectedPoints =
                Arrays.asList(Point.createPoint(15, 5), Point.createPoint(20, 5));

        List<Point> newPoints = Debugging.moveAllPointsRightBy(points, 10);

        int sum1 = expectedPoints.stream().mapToInt(Point::getX).sum();
        int sum2 = newPoints.stream().mapToInt(Point::getX).sum();

        assertEquals(sum1, sum2);
    }
}