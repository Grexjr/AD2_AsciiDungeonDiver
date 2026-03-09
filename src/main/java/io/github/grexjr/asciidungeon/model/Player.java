package io.github.grexjr.asciidungeon.model;

import io.github.grexjr.asciidungeon.constants.CommonConstants;
import io.github.grexjr.asciidungeon.constants.SpriteConstants;

public class Player {
    private static final String DEFAULT_DECOR = "\033[1;97;49m";

    private int row,col;
    private final String symbol = Character.toString(SpriteConstants.PLAYER);
    private String decoration = DEFAULT_DECOR;

    /// Default constructor
    public Player(){
        row = 2;
        col = 2;
    }

    /// Constructor to put player wherever
    public Player(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getFormattedSymbol(){
        return decoration + symbol + CommonConstants.RESET;
    }

    public String getDecoration() {
        return decoration;
    }

    public void addDecoration(String ansiCode){
        decoration += ansiCode;
    }

    public void resetDecoration(){
        decoration = DEFAULT_DECOR;
    }
}
