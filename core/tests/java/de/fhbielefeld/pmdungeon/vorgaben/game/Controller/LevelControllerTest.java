package de.fhbielefeld.pmdungeon.vorgaben.game.Controller;

import de.fhbielefeld.pmdungeon.vorgaben.dungeonCreator.DungeonWorld;
import de.fhbielefeld.pmdungeon.vorgaben.dungeonCreator.tiles.Tile;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LevelControllerTest {

    /**TODO
     * Create LevelInstance
     * Create MainController?
     * **/
    LevelController lc;
    @BeforeAll
    public void init() {
        MockitoAnnotations.initMocks(this);
        Method m1 = Mockito.mock(Method.class);
        Object klass = Mockito.mock(Object.class);
        Object[] args = Mockito.mock(Object[].class);
        LevelController lc = new LevelController(m1,klass, args);
    }

    
    @Test
    void loadDungeonWithDungeon() throws InvocationTargetException, IllegalAccessException {

        //MOckito von dungeonWorld ??
        DungeonWorld dw = Mockito.mock(DungeonWorld.class);
        Tile tl = Mockito.mock(Tile.class);

        lc.loadDungeon(dw);

        assertEquals(dw.getConnections(tl), true);
    }

/*    @Test
    void loadDungeonWithNull() throws InvocationTargetException, IllegalAccessException {

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, lc.loadDungeon(null));
    }*/

/*    @Test
    void loadDungeonWithOtherObject() {

        Object mh = new Object();

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, lc.loadDungeon(mh));
    }*/

    @Test
    void updateStageNichtÄndern() {

        lc.update();
    }

    @Test
    void updateStageÄndern() {
        lc.triggerNextStage();
        lc.update();
    }

    @Test
    void checkForTriggerWithTriggerField() {
    }

    @Test
    void checkForTriggerWithNotATriggerField() {
    }

    @Test
    void checkForTriggerWithNull() {
    }
}