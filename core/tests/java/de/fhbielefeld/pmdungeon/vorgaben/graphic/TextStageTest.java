package de.fhbielefeld.pmdungeon.vorgaben.graphic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import com.badlogic.gdx.graphics.Texture;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

class TextStageTest {

    @Test 
    void createTextStage() {
        SpriteBatch sb = new SpriteBatch();

        TextStage ts = new TextStage(sb);
    }

    @Test 
    void drawText() {
        SpriteBatch sb = new SpriteBatch();
        TextStage ts = new TextStage(sb);

        String text = "Test";
        String fontPath = "assets/Asdonuts.ttf";
        Color color = Color.RED;
        int size = 30;
        int width = 50;
        int height = 50;
        int x = 30;
        int y = 400;

        Label label = ts.drawText(text, fontPath, color, size, width, height, x, y);

        assertEquals(label.getText(), text);
    }

    @Test 
    void removeText() {
        SpriteBatch sb = new SpriteBatch();
        TextStage ts = new TextStage(sb);

        String text = "Test";
        String fontPath = "assets/Asdonuts.ttf";
        Color color = Color.RED;
        int size = 30;
        int width = 50;
        int height = 50;
        int x = 30;
        int y = 400;

        Label label = ts.drawText(text, fontPath, color, size, width, height, x, y);

        ts.removeText(label);
    }

    @Test 
    void removeTextWithNoAddedText() {
        SpriteBatch sb = new SpriteBatch();
        TextStage ts = new TextStage(sb);

        Label label = mock(Label.class);
        ts.removeText(label);
    }
}