package de.fhbielefeld.pmdungeon.vorgaben.graphic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import com.badlogic.gdx.graphics.Texture;
import java.util.ArrayList;
import java.util.List;

@RunWith(JUnitPlatform.class)
class AnimationTest {

    @Test 
    void createAnimationObject() {
        List<Texture> t = new ArrayList<>();

        Texture t1 = mock(Texture.class);
        Texture t2 = mock(Texture.class);
        Texture t3 = mock(Texture.class);

        t.add(t1);
        t.add(t2);
        t.add(t3);

        Animation a = new Animation(t, 3);

        assertNotNull(a);
    }

    @Test 
    void createAnimationObjectWithEmptyList() {
        List<Texture> t = new ArrayList<>();

        assertThrows(IllegalArgumentException, new Animation(t, 3));
    }

    @Test 
    void createAnimationObjectWithNegativeFrameTime() {
        List<Texture> t = new ArrayList<>();

        Texture t1 = mock(Texture.class);
        Texture t2 = mock(Texture.class);
        Texture t3 = mock(Texture.class);

        t.add(t1);
        t.add(t2);
        t.add(t3);

        assertThrows(IllegalArgumentException, new Animation(t, -2));
    }

    @Test 
    void checkNextTexture() {
        List<Texture> t = new ArrayList<>();
        Texture t1 = mock(Texture.class);
        Texture t2 = mock(Texture.class);
        Texture t3 = mock(Texture.class);
        t.add(t1);
        t.add(t2);
        t.add(t3);
        Animation a = new Animation(t, 2);

        assertEquals(a.getNextAnimationTexture(), t1);
        assertEquals(a.getNextAnimationTexture(), t1);
        assertEquals(a.getNextAnimationTexture(), t2);
        a.getNextAnimationTexture();
        assertEquals(a.getNextAnimationTexture(), t3);
        a.getNextAnimationTexture();
        assertEquals(a.getNextAnimationTexture(), t1);

    }

}