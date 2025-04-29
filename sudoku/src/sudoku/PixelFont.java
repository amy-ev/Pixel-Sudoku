package sudoku;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PixelFont {
    public Font FONT;
    public PixelFont(){

        try {
            FONT = Font.createFont(Font.TRUETYPE_FONT, new File("number.ttf")).deriveFont(24f);
            GraphicsEnvironment GE = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GE.registerFont(FONT);

        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

    }
    public Font getFont() {
        return FONT;
    }

}
