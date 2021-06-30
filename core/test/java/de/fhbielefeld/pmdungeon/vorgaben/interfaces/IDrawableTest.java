package de.fhbielefeld.pmdungeon.vorgaben.interfaces;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import de.fhbielefeld.pmdungeon.vorgaben.game.GameSetup;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Text;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IDrawableTest {

    @Test
    void draw() {
        String path = "./test/resources/assets/textures/ui/ui_heart_full.png";
        File file = new File(path);
        FileHandle fh = new FileHandle(file);
        Texture tx = new Texture(fh);

        IDrawable elm = mock(IDrawable.class);
        when(elm.getTexture()).thenReturn(tx);
        elm.draw();
    }

    @Test
    void drawOffsetAndScaling() {
        Texture tx = mock(Texture.class);

        IDrawable elm = mock(IDrawable.class);
        when(elm.getTexture()).thenReturn(tx);
        SpriteBatch spyBatch = spy(GameSetup.batch);

        elm.draw(10.f, 10.f, 2.0f, 2.0f);

        //spy on GameSetup.batch to see if something happens
    }

    @Test
    void drawNegativeValues() {
        String path = "./test/resources/assets/textures/ui/ui_heart_full.png";
        File file = new File(path);
        FileHandle fh = new FileHandle(file);
        Texture tx = new Texture(fh);

        IDrawable elm = mock(IDrawable.class);
        when(elm.getTexture()).thenReturn(tx);

        elm.draw(-10.f, 10.f, -2.0f, 2.0f);
    }

    @Test
    void drawNull() {
        IDrawable elm = mock(IDrawable.class);
        when(elm.getTexture()).thenReturn(null);

        elm.draw(10.f, 10.f, 2.0f, 2.0f);
    }
}