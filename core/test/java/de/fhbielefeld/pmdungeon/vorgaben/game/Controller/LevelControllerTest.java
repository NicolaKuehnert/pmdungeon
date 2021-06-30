package de.fhbielefeld.pmdungeon.vorgaben.game.Controller;

import de.fhbielefeld.pmdungeon.vorgaben.dungeonCreator.DungeonWorld;
import de.fhbielefeld.pmdungeon.vorgaben.dungeonCreator.dungeonconverter.DungeonConverter;
import de.fhbielefeld.pmdungeon.vorgaben.dungeonCreator.tiles.Tile;
import de.fhbielefeld.pmdungeon.vorgaben.tools.Point;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(JUnitPlatform.class)
class LevelControllerTest {

    /**TODO
     * Create LevelInstance
     * Create MainController?
     * **/
    LevelController lc;

    public void onLevelLoad() {
    }
    @BeforeEach
    public void init() throws NoSuchMethodException {
        MockitoAnnotations.initMocks(this);
        Method functionToPass = this.getClass().getMethod("onLevelLoad");
        Object[] arguments = new Object[0];
        lc = new LevelController(functionToPass,this, arguments);
    }


    
    @Test
    void loadDungeonWithDungeon() throws InvocationTargetException, IllegalAccessException {

        DungeonWorld dungeon = mock(DungeonWorld.class);
        DungeonWorld dungeon2 = mock(DungeonWorld.class);
        lc.loadDungeon(dungeon);
        assertEquals(dungeon, lc.getDungeon());
    }

    @Test
    void loadDungeonWithNull() throws InvocationTargetException, IllegalAccessException {

        assertThrows(NullPointerException.class, () -> lc.loadDungeon(null));
    }

    // nicht möglich
/*    @Test
    void loadDungeonWithOtherObject() {

        Object mh = new Object();

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, ()->lc.loadDungeon(mh));
    }*/

    @Test
    void updateStageNotChangeStage() throws InvocationTargetException, IllegalAccessException {
        DungeonWorld dungeon = mock(DungeonWorld.class);
        lc.loadDungeon(dungeon);
        lc.update();
        assertEquals(dungeon, lc.getDungeon());
    }

    @Test
    void updateStageChangeStage() throws InvocationTargetException, IllegalAccessException {
        DungeonWorld dungeonWorld = mock(DungeonWorld.class);
        lc.loadDungeon(dungeonWorld);
        lc.triggerNextStage();
        lc.update();
        assertNotEquals(dungeonWorld, lc.getDungeon());
    }

    @Test
    void checkForTriggerWithTriggerField() {

        DungeonWorld dungeon = mock(DungeonWorld.class);
        Tile tile = mock(Tile.class);

        when(tile.getX()).thenReturn(10);
        when(tile.getY()).thenReturn(20);

        when(dungeon.getNextLevelTrigger()).thenReturn(tile);

        try {
            lc.loadDungeon(dungeon);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Point p = new Point(10, 20);

        assertEquals(true,lc.checkForTrigger(p));
    }

    @Test
    void checkForTriggerWithNotATriggerField() {

        DungeonWorld dungeon = mock(DungeonWorld.class);
        Tile tile = mock(Tile.class);

        when(tile.getX()).thenReturn(10);
        when(tile.getY()).thenReturn(20);

        when(dungeon.getNextLevelTrigger()).thenReturn(tile);

        try {
            lc.loadDungeon(dungeon);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Point p = new Point(10, 30);

        assertEquals(false,lc.checkForTrigger(p));
    }

    @Test
    void checkForTriggerWithNull() {

        assertThrows(NullPointerException.class,() ->lc.checkForTrigger(null));

    }
}