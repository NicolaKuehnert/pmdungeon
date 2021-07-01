package de.fhbielefeld.pmdungeon.vorgaben.interfaces;

import com.badlogic.gdx.graphics.Texture;
import de.fhbielefeld.pmdungeon.vorgaben.graphic.Animation;
import de.fhbielefeld.pmdungeon.vorgaben.tools.Point;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IAnimatableTest {

    @Test
    void getTexturePositive() {
        Texture il1 = mock(Texture.class);
        Texture il2 = mock(Texture.class);
        List<Texture> idleLeftTextures = new ArrayList<>();
        idleLeftTextures.add(il1);
        idleLeftTextures.add(il2);

        Animation anim = new Animation(idleLeftTextures, 1);

        IAnimatable elm = new IAnimatable() {
            @Override
            public Animation getActiveAnimation() {
                return anim;

            }

            @Override
            public Point getPosition() {
                return null;
            }
        };


        assertEquals(elm.getTexture(), anim.getNextAnimationTexture());
    }

    @Test
    void getTextureNegative() {
        Texture il1 = mock(Texture.class);
        Texture il2 = mock(Texture.class);

        IAnimatable elmIA = mock(IAnimatable.class);
        when(elmIA.getTexture()).thenReturn(il1);


        Animation elmA = mock(Animation.class);
        when(elmA.getNextAnimationTexture()).thenReturn(il2);

        assertNotEquals(elmA.getNextAnimationTexture(), elmIA.getTexture());
    }
}