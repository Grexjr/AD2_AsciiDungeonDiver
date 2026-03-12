package io.github.grexjr.asciidungeon.ui;

import io.github.grexjr.asciidungeon.constants.CommonConstants;
import io.github.grexjr.asciidungeon.constants.UIConstants;
import io.github.grexjr.asciidungeon.view.Sprite;

import static io.github.grexjr.asciidungeon.constants.UIConstants.*;

public class Printer {

    private static final int HEIGHT = CommonConstants.MAP_HEIGHT;
    private static final int WIDTH = CommonConstants.MAP_WIDTH;

    //TODO: Is constructor needed here?

    private final Formatter formatter = new Formatter();

    private Sprite[][] screenBuffer = new Sprite[CommonConstants.MAP_HEIGHT][CommonConstants.MAP_WIDTH];

    public Formatter getFormatter(){return formatter;}

    // ======================= ACTIONS =======================
    // The void actions of the game. Drawing, moving cursor, etc.
    /**
     *
     */
    public void drawAt(int row, int col, Sprite sprite){
        if(row >= 0 && row < HEIGHT && col >= 0 && col < WIDTH){
            screenBuffer[row][col] = sprite;
        }
    }

    /**
     * Clears the screen
     */
    public void clearScreen(){
        System.out.print(getClearString());
    }

    /**
     * Shows the cursor using the ANSI cursor sequence
     */
    public void showCursor(){
        System.out.print(getShowCursorString());
    }

    /**
     * Hides the cursor using the ANSI cursor sequence
     */
    public void hideCursor(){
        System.out.print(getHideCursorString());
    }

    /**
     * Clears the buffer using System.out.flush()
     */
    public void clearBuffer(){
        System.out.flush();
    }


    // ====================== COMMANDS ======================
    // The commands that retrieve ANSI sequence commands to be used by the actions.
    // All include an ANSI escape sequence in front, so act as individual units.

    // For example, move to is \u001b[%d;%dH, and they can be chained.

    private String getShowCursorString(){
        return ESC + CURS_SHOW;
    }

    private String getHideCursorString(){
        return ESC + CURS_HIDE;
    }

    private String getClearString(){
        return ESC + CLEAR;
    }

    private String getEraseLineString(){
        return ESC + LINE;
    }

    /**
     *
     */
    public void render(){
        StringBuilder frame = new StringBuilder();

        // move cursor to home
        frame.append(ESC).append("0m").append(ESC).append(HOME);

        // Loop through the entire 2d array of sprites to draw them
        for(int r = 0; r < HEIGHT; r++){
            for(int c = 0; c < WIDTH; c++){
                Sprite s = screenBuffer[r][c];

                // Atomic instruction to draw the sprite
                if(s != null){
                    // Pre-reset append
                    frame.append(ESC+"0;22m")
                            // Movement append
                            .append(ESC).append(r + 1).append(DELIMITER).append(c + 1).append(HOME)
                            // Decoration append, including formatting and color
                            .append(ESC).append(s.getFullDecoration()).append(SUFFIX)
                            // Append the symbol
                            .append(s.getSymbol());
                }
            }
        }

        frame.append(ESC).append(END); // Final reset
        System.out.print(frame);
        clearBuffer();
    }



}
