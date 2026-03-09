package io.github.grexjr.asciidungeon.ui;

import io.github.grexjr.asciidungeon.constants.CommonConstants;

public class Formatter {

    //TODO: Is constructor needed here?

    private static final String ESC = CommonConstants.ESC;

    private static final String RESET = ESC + "0m";

    private static final String BOLD = "1m";
    private static final String DIM = "2m";
    private static final String UNDERLINE = "4m";
    private static final String BLINK = "5m";
    private static final String INVERT = "7m";

    private static final String COLOR = "%dm";

    /**
     * Colors a character the specific inputted color. Resets color after character is printed.
     * @param s String to color
     * @param color Color of the character, 30s for foreground, 40s for background
     * @return The string to be used elsewhere
     */
    public String colorString(String s, int color){
        return ESC + String.format(COLOR,color) + s + RESET;
    }

    /**
     * Bolds a given character
     * @param s String to bold
     * @return The string of bold ANSI sequence
     */
    public String boldString(String s){
        return ESC + BOLD + s + RESET;
    }

    /**
     * Dims a given character
     * @param s The String to dim
     * @return The string of dim ANSI sequence
     */
    public String dimString(String s){
        return ESC + DIM + s + RESET;
    }

    /**
     * Underlines a given character
     * @param s The String to underline
     * @return The string of underlined ANSI sequence
     */
    public String underlineString(String s){
        return ESC + UNDERLINE + s + RESET;
    }

    /**
     * Blinks a given character
     * @param s The String to blink
     * @return The string of blink ANSI sequence
     */
    public String blinkString(String s){
        return ESC + BLINK + s + RESET;
    }

    /**
     * Inverts a given character
     * @param s The String to invert
     * @return The string of invert ANSI sequence
     */
    public String invertString(String s){
        return ESC + INVERT + s + RESET;
    }


}
