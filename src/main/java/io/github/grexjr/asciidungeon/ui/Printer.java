package io.github.grexjr.asciidungeon.ui;

import io.github.grexjr.asciidungeon.constants.CommonConstants;

public class Printer {

    //TODO: Is constructor needed here?

    private static final String ESC = CommonConstants.ESC;

    private static final String HOME = "H";

    private static final String MOVE = "%d;%dH";
    private static final String UP = "%dA";
    private static final String DOWN = "%dB";
    private static final String RIGHT = "%dC";
    private static final String LEFT = "%dD";

    private static final String CLEAR = "2J";
    private static final String LINE = "2K";

    private static final String CURS_SHOW = "?25h";
    private static final String CURS_HIDE = "?25l";

    private final Formatter formatter = new Formatter();

    public Formatter getFormatter(){return formatter;}

    // ======================= ACTIONS =======================
    // The void actions of the game. Drawing, moving cursor, etc.
    /**
     * Draws a string (can be formatted) at a specific location. The main method of drawing things to the terminal
     * in the game.
     * Terminal indexed at 1,1, so add one to row and column values.
     * @param row The row to draw at. Assumed to be zero-index
     * @param col The column to draw at. Assumed to be zero-index
     * @param string The ANSI sequence to draw
     */
    public void drawAt(int row, int col, String string){
        render(getMoveToString(row+1,col+1) + string);
    }

    /**
     * Draws where the cursor currently is without any input as to where the cursor should go.
     * TODO: might not work
     * @param string The ANSI sequence to draw
     */
    public void draw(String string){
        render(string);
    }

    /**
     * Moves the cursor to a spot on the screen without printing anything.
     * @param row The row to move to
     * @param col The column to move to
     */
    public void moveTo(int row, int col){
        render(getMoveToString(row,col));
    }

    /**
     * Moves the cursor to the top left of the terminal
     */
    public void moveToHome(){
        render(getMoveToHomeString());
    }

    /**
     * Moves the cursor up by the given number of lines
     * @param lines The lines to move the cursor up by
     */
    public void moveUp(int lines){
        render(getMoveUpString(lines));
    }

    /**
     * Moves the cursor down by the given number of lines
     * @param lines The lines to move the cursor down by
     */
    public void moveDown(int lines){
        render(getMoveDownString(lines));
    }

    /**
     * Moves the cursor right a given number of lines
     * @param lines The lines to move the cursor right
     */
    public void moveRight(int lines){
        render(getMoveRightString(lines));
    }

    /**
     * Moves the cursor left a given number of lines
     * @param lines The lines to move the cursor left
     */
    public void moveLeft(int lines){
        render(getMoveLeftString(lines));
    }

    /**
     * Clears the screen
     */
    public void clearScreen(){
        render(getClearString());
    }

    /**
     * Clears the line the cursor is on
     */
    public void clearLine(){
        render(getEraseLineString());
    }

    /**
     * Resets the canvas by moving the cursor to START and clearing the screen
     */
    public void resetCanvas(){
        render(getMoveToHomeString()+getClearString());
    }

    /**
     * Shows the cursor using the ANSI cursor sequence
     */
    public void showCursor(){
        render(getShowCursorString());
    }

    /**
     * Hides the cursor using the ANSI cursor sequence
     */
    public void hideCursor(){
        render(getHideCursorString());
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

    private String getMoveToString(int row, int col){
        return ESC + String.format(MOVE,row,col);
    }

    private String getMoveToHomeString(){
        return ESC + String.format(MOVE,1,1);
    }

    private String getMoveUpString(int lines){
        return ESC + String.format(UP,lines);
    }

    private String getMoveDownString(int lines){
        return ESC + String.format(DOWN,lines);
    }

    private String getMoveRightString(int lines){
        return ESC + String.format(RIGHT,lines);
    }

    private String getMoveLeftString(int lines){
        return ESC + String.format(LEFT,lines);
    }

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
     * Processes text and ANSI commands using ANSI escape sequence
     * @param s The command string
     */
    private void render(String s){
        System.out.print(s);
        clearBuffer();
    }



}
