package de.fhbielefeld.pmdungeon.vorgaben.interfaces;

import com.badlogic.gdx.graphics.Texture;
import de.fhbielefeld.pmdungeon.vorgaben.tools.Point;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;


class IHUDElementTest  {

    @Test
    void getWidth() {
        IHUDElement elm = new IHUDElement() {
            @Override
            public Point getPosition() {
                return null;
            }

            @Override
            public Texture getTexture() {
                return null;
            }
        };
        assertEquals(elm.getWidth(), 0.5f);

    }

    @Test
    void getHeight() {
        Texture tx = mock(Texture.class);
        when(tx.getHeight()).thenReturn(4);

        IHUDElement elm = new IHUDElement() {
            @Override
            public Point getPosition() {
                return null;
            }

            @Override
            public Texture getTexture() {
                return tx;
            }
        };

        float height = tx.getHeight();

        assertEquals(elm.getHeight(), height/2);
    }
}