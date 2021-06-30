package de.fhbielefeld.pmdungeon.vorgaben.graphic;

import de.fhbielefeld.pmdungeon.vorgaben.tools.Point;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import com.badlogic.gdx.graphics.Texture;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import de.fhbielefeld.pmdungeon.vorgaben.interfaces.IHUDElement;

class HUDTest {

    @Test 
    void createHUDObject() {
        HUD hud = new HUD();
        assertNotNull(hud);
    }

    @Test 
    void usePixelSystemThrowsNoException() {
        HUD hud = new HUD();
        hud.usePixelSystem(true);
        hud.usePixelSystem(false);
    }

    @Test 
    void addHudElementThrowsNoException() {
        HUD hud = new HUD();
        IHUDElement element = mock(IHUDElement.class);
        hud.addHudElement(element);
    }

    @Test 
    void removeHudElementThrowsNoException() {
        HUD hud = new HUD();
        IHUDElement element = mock(IHUDElement.class);
        hud.addHudElement(element);

        hud.removeHudElement(element);
    }

    @Test 
    void removeHudElementThrowsNoExceptionWithoutAddedObject() {
        HUD hud = new HUD();
        IHUDElement element = mock(IHUDElement.class);

        hud.removeHudElement(element);
    }

    @Test 
    void drawThrowsNoException() {
        HUD hud = new HUD();

        IHUDElement element = mock(IHUDElement.class);        
        Texture texture = mock(Texture.class);
        Point p = new Point(20,20);

        when(element.getTexture()).thenReturn(texture);
        when(element.getWidth()).thenReturn(4.0F);
        when(element.getHeight()).thenReturn(4.0F);
        when(element.getPosition()).thenReturn(p);

        when(texture.getWidth()).thenReturn(4);

        hud.usePixelSystem(false);
        hud.draw();
        hud.usePixelSystem(true);
        hud.draw();
    }

    @Test 
    void drawThrowsNoExceptionWithNoHUDElements() {
        HUD hud = new HUD();
        hud.usePixelSystem(false);
        hud.draw();
        hud.usePixelSystem(true);
        hud.draw();
    }

    @Test 
    void resizeThrowsNoException() {
        HUD hud = new HUD();
        hud.usePixelSystem(true);
        hud.resize();
        hud.usePixelSystem(false);
        hud.resize();
    }

}