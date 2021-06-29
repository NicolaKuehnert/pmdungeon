package de.fhbielefeld.pmdungeon.vorgaben.game.Controller;

import de.fhbielefeld.pmdungeon.vorgaben.dungeonCreator.DungeonWorld;
import de.fhbielefeld.pmdungeon.vorgaben.dungeonCreator.tiles.Tile;
import de.fhbielefeld.pmdungeon.vorgaben.tools.Point;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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

        //MOckito von dungeonWorld ??
/*        DungeonWorld dw = Mockito.mock(DungeonWorld.class);
        Tile tl = Mockito.mock(Tile.class);

        lc.loadDungeon(dw);

        assertEquals(dw.getConnections(tl), true);*/

        //when(dungeon.makeConnections()).thenReturn();
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
    void updateStageNotChangeStage() {

        lc.update();
    }

    @Test
    void updateStageChangeStage() {
        lc.triggerNextStage();
        lc.update();
    }

    @Test
    void checkForTriggerWithTriggerField() {

        DungeonWorld dungeon = mock(DungeonWorld.class);

       // when(dungeon.getNextLevelTrigger().getX()).thenReturn(10);
        when(dungeon.getNextLevelTrigger().getX()).thenReturn(20);
        try {
            lc.loadDungeon(dungeon);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Point p = new Point(10, 20);

        lc.checkForTrigger(p);
    }

    @Test
    void checkForTriggerWithNotATriggerField() {
    }

    @Test
    void checkForTriggerWithNull() {

        assertThrows(NullPointerException.class,() ->lc.checkForTrigger(null));

    }
}