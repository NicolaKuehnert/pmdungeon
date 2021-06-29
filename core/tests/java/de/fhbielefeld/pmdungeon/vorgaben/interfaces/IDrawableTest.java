package de.fhbielefeld.pmdungeon.vorgaben.interfaces;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class IDrawableTest {

    @Test
    void draw() {
        String path = "./tests/ressources/assets/textures/ui/ui_heart_full.png";
        File file = new File(path);
        FileHandle fh = new FileHandle(file);
        Texture tx = new Texture(fh);

        IDrawable elm = mock(IDrawable.class);
        when(elm.getTexture()).thenReturn(tx);
        elm.draw();
    }

    @Test
    void drawOffsetAndScaling() {
        String path = "./tests/ressources/assets/textures/ui/ui_heart_full.png";
        File file = new File(path);
        FileHandle fh = new FileHandle(file);
        Texture tx = new Texture(fh);

        IDrawable elm = mock(IDrawable.class);
        when(elm.getTexture()).thenReturn(tx);

        elm.draw(10.f, 10.f, 2.0f, 2.0f);

        //how do we get a test result here?
    }

    @Test
    void drawNegativeValues() {
        String path = "./tests/ressources/assets/textures/ui/ui_heart_full.png";
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