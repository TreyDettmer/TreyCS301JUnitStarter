package up.edu.dimcalc;

import android.graphics.Point;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoPointsTest {

    /** when created, getPoint() should show both points at the origin */

    @Test

    public void getPoint() throws Exception {

        TwoPoints testPoints = new TwoPoints();

        Point p1 = testPoints.getPoint(0);

        Point p2 = testPoints.getPoint(1);

        //changing the 0 on the next line to 1 results in an AssertianError. The assertion expected a 1 but got a 0.
        assertEquals(1, p1.x);

        assertEquals(0, p1.y);

        assertEquals(0, p2.x);

        assertEquals(0, p2.y);

    }



    /** verify that arbitrary values are properly stored via setPoint() */

    @Test

    public void setPoint() throws Exception {

        TwoPoints testPoints = new TwoPoints();

        testPoints.setPoint(0, 5, -3);

        testPoints.setPoint(1, -3, 5);

        Point p1 = testPoints.getPoint(0);

        Point p2 = testPoints.getPoint(1);

        assertEquals(5, p1.x);

        assertEquals(-3, p1.y);

        assertEquals(-3, p2.x);

        assertEquals(5, p2.y);

    }


    @Test
    public void randomValue() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.randomValue(0);
        assertTrue(testPoints.getPoint(0).x >= -10 && testPoints.getPoint(0).x < 10);
        assertTrue(testPoints.getPoint(0).y >= -10 && testPoints.getPoint(0).y < 10);
    }

    @Test
    public void setOrigin() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setOrigin(1);
        assertEquals(0,testPoints.getPoint(1).x);
        assertEquals(0,testPoints.getPoint(1).y);
    }

    @Test
    public void copy() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0,5,4);
        testPoints.copy(0,1);
        assertEquals(testPoints.getPoint(0).x,testPoints.getPoint(1).x);
        assertEquals(testPoints.getPoint(0).y,testPoints.getPoint(1).y);
    }

    @Test
    public void distance() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.randomValue(0);
        testPoints.randomValue(1);
        int xDiff = testPoints.getPoint(0).x - testPoints.getPoint(1).x;
        int yDiff = testPoints.getPoint(0).y - testPoints.getPoint(1).y;
        double distance = (int)Math.sqrt(Math.pow(xDiff,2) + Math.pow(yDiff,2));

        assertEquals(distance,testPoints.distance(),.01);
    }

    @Test
    public void slope() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.randomValue(0);
        testPoints.randomValue(1);
        int yDiff = testPoints.getPoint(0).y - testPoints.getPoint(1).y;
        int xDiff = testPoints.getPoint(0).x - testPoints.getPoint(1).x;
        double slope = ((double)yDiff)/xDiff;
        assertEquals(slope,testPoints.slope(),.01);
    }
}