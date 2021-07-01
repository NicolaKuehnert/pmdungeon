package de.fhbielefeld.pmdungeon.vorgaben.interfaces;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Null;
import de.fhbielefeld.pmdungeon.desktop.DesktopLauncher;
import de.fhbielefeld.pmdungeon.vorgaben.game.Controller.MainController;
import de.fhbielefeld.pmdungeon.vorgaben.game.GameSetup;
import de.fhbielefeld.pmdungeon.vorgaben.tools.Point;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IDrawableTest {

    @BeforeAll
    static void setup(){
        MainController mc = new MainController();
        DesktopLauncher.run(mc);

    }

    @Test
    void draw() {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        Texture tx = new Texture("./test/resources/assets/textures/items/flask_big_green.png");


        IDrawable elm = spy(new IDrawable() {
            @Override
            public Point getPosition() {
                return null;
            }

            @Override
            public Texture getTexture() {
                return tx;
            }
        });
        elm.draw();

    }

    @Test
    void drawOffsetAndScaling() {
        Texture tx = new Texture("./test/resources/assets/textures/items/flask_big_green.png");

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
        Texture tx = new Texture("./test/resources/assets/textures/items/flask_big_green.png");

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
        IDrawable elm = new IDrawable() {
            @Override
            public Point getPosition() {
                return null;
            }

            @Override
            public Texture getTexture() {
                return null;
            }
        };

        NullPointerException ex = assertThrows(NullPointerException.class,() -> elm.draw(10.f, 10.f, 2.0f, 2.0f));
    }
}