package main.sudoku;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class PixelFont {
    public static Font FONT;
    public PixelFont(){

        try {
            InputStream input = this.getClass().getClassLoader().getResourceAsStream("number.ttf");
            assert input != null;
            FONT = Font.createFont(Font.TRUETYPE_FONT, input).deriveFont((float) GridConstants.CELL_SIZE/2);
            GraphicsEnvironment GE = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GE.registerFont(FONT);

        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

    }
    public Font getFont() {
        return FONT;
    }

    public static void setPixelFont(Component component, Font font) {
        component.setFont(font);
        if (component instanceof Container) {
            for (Component c : ((Container) component).getComponents()) {
                setPixelFont(c, font);
            }
        }
    }

}
