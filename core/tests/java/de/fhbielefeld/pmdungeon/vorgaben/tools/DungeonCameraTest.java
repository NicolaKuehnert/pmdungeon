package de.fhbielefeld.pmdungeon.vorgaben.tools;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import de.fhbielefeld.pmdungeon.vorgaben.interfaces.IDrawable;

class DungeonCameraTest {

    @Test 
    void createDungeonCamera() {
        IDrawable follows = mock(IDrawable.class);
        DungeonCamera dc = new DungeonCamera(follows, 5.0f, 9.0f);
    }

    @Test 
    void follow() {
        IDrawable follows = mock(IDrawable.class);
        DungeonCamera dc = new DungeonCamera(follows, 5.0f, 9.0f);

        IDrawable follows2 = mock(IDrawable.class);

        assertEquals(dc.getFollowedObject(), follows);
        dc.follow(follows2);
        assertEquals(dc.getFollowedObject(), follows2);
        dc.follow(follows2);
        assertEquals(dc.getFollowedObject(), follows2);
        dc.follow(follows);
        assertEquals(dc.getFollowedObject(), follows);
        dc.follow(follows2);
        assertEquals(dc.getFollowedObject(), follows2);

    }

    @Test 
    void setFocusPointThrowsNoException() {
        IDrawable follows = mock(IDrawable.class);
        DungeonCamera dc = new DungeonCamera(follows, 5.0f, 9.0f);
        Point p = new Point(4,2);

        dc.setFocusPoint(p);
    }

    @Test 
    void updateThrowsNoException() {
        IDrawable follows = mock(IDrawable.class);
        DungeonCamera dc = new DungeonCamera(follows, 5.0f, 9.0f);

        dc.update();

        dc.setFocusPoint(null);
        dc.follo(null);

        dc.update();
    }

}