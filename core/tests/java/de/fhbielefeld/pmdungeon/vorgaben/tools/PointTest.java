package de.fhbielefeld.pmdungeon.vorgaben.tools;

import de.fhbielefeld.pmdungeon.vorgaben.dungeonCreator.dungeonconverter.Coordinate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void constructPointFromFloats(){
        Point test = new Point(0.5f, 1.5f);

        assertEquals(test.x, 0.5f);
        assertEquals(test.y, 1.5f);
    }

    @Test
    void constructPointWithNullCoordinate(){

        Coordinate in = null;
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Point(in));


    }

    @Test
    void constructPointFromCoordinate(){
        Coordinate in = new Coordinate(1,2);
        Point test = new Point(in);

        assertEquals(test.x, 1);
        assertEquals(test.y, 2);
    }

    @Test
    void constructPointFromPoint(){
        Point in = new Point(1.0f,2.0f);
        Point test = new Point(in);

        assertEquals(test.x, 1);
        assertEquals(test.y, 2);
    }

    @Test
    void constructPointFromNullPoint(){
        Point in = null;
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Point(in));
    }

}