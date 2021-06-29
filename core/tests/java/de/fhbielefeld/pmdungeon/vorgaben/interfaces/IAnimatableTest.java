package de.fhbielefeld.pmdungeon.vorgaben.interfaces;

import com.badlogic.gdx.graphics.Texture;
import de.fhbielefeld.pmdungeon.vorgaben.graphic.Animation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IAnimatableTest {

    @Test
    void getTexturePositive() {
        Texture il1 = new Texture("./tests/ressources/assets/textures/characters/hero/il0.png");
        Texture il2 = new Texture("./tests/ressources/assets/textures/characters/hero/il1.png");
        List<Texture> idleLeftTextures = new ArrayList<>();
        idleLeftTextures.add(il1);
        idleLeftTextures.add(il2);

        Animation anim = new Animation(idleLeftTextures, 1);

        IAnimatable elm = mock(IAnimatable.class);
        when(elm.getActiveAnimation()).thenReturn(anim);

        assertEquals(elm.getTexture(), anim.getNextAnimationTexture());
    }

    @Test
    void getTextureNegative() {
        System.out.println("Working Dir: " + System.getProperty("user.dir"));
        Texture il1 = new Texture("./tests/ressources/assets/textures/characters/hero/il0.png");
        Texture il2 = new Texture("./tests/ressources/assets/textures/characters/hero/il1.png");
        List<Texture> idleLeftTextures = new ArrayList<>();
        idleLeftTextures.add(il1);
        idleLeftTextures.add(il2);

        Animation anim = new Animation(idleLeftTextures, 1);

        IAnimatable elmIA = mock(IAnimatable.class);
        when(elmIA.getActiveAnimation()).thenReturn(anim);


        Animation elmA = mock(Animation.class);
        when(elmA.getNextAnimationTexture()).thenReturn(il2);

        assertNotEquals(elmA.getNextAnimationTexture(), elmIA.getTexture());


    }
}