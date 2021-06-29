package de.fhbielefeld.pmdungeon.vorgaben.interfaces;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import de.fhbielefeld.pmdungeon.vorgaben.tools.Point;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.File;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;


class IHUDElementTest  {

    @Test
    void getWidth() {
        IHUDElement elm = mock(IHUDElement.class);
        assertEquals(elm.getWidth(), 0.5f);

    }

    @Test
    void getHeight() {
        System.out.println("Working Dir: " + System.getProperty("user.dir"));
        String path = "./tests/ressources/assets/textures/ui/ui_heart_full.png";
        File file = new File(path);
        FileHandle fh = new FileHandle(file);

        boolean b = fh.file().exists();
        System.out.println("File Exists: " + b);

        //Texture tx = new Texture(fh);

        //IHUDElement elm = mock(IHUDElement.class);
        //when(elm.getTexture()).thenReturn(tx);

        //float height = elm.getTexture().getHeight();

        //assertEquals(elm.getHeight(), height/2);
    }
}