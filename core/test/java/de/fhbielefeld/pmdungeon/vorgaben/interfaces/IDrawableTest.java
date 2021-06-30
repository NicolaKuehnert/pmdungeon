package de.fhbielefeld.pmdungeon.vorgaben.interfaces;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import de.fhbielefeld.pmdungeon.vorgaben.game.GameSetup;
import de.fhbielefeld.pmdungeon.vorgaben.tools.Point;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IDrawableTest {

    @BeforeAll
    static void setup(){
        GameSetup.batch = new SpriteBatch();
    }

    @Test
    void draw() {
        Texture tx = mock(Texture.class);

        IDrawable elm = new IDrawable() {
            @Override
            public Point getPosition() {
                return null;
            }

            @Override
            public Texture getTexture() {
                return tx;
            }
        };
        elm.draw();

        //how do we check this again?
    }

    @Test
    void drawOffsetAndScaling() {
        Texture tx = mock(Texture.class);

        IDrawable elm = new IDrawable() {
            @Override
            public Point getPosition() {
                return null;
            }

            @Override
            public Texture getTexture() {
                return tx;
            }
        };
        SpriteBatch spyBatch = spy(GameSetup.batch);

        elm.draw(10.f, 10.f, 2.0f, 2.0f);

        //spy on GameSetup.batch to see if something happens
    }

    @Test
    void drawNegativeValues() {
        Texture tx = mock(Texture.class);

        IDrawable elm = new IDrawable() {
            @Override
            public Point getPosition() {
                return null;
            }

            @Override
            public Texture getTexture() {
                return tx;
            }
        };

        elm.draw(-10.f, 10.f, -2.0f, 2.0f);
    }

    @Test
    void drawNull() {
        IDrawable elm = mock(IDrawable.class);
        when(elm.getTexture()).thenReturn(null);

        elm.draw(10.f, 10.f, 2.0f, 2.0f);
    }
}