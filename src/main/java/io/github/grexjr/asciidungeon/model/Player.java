package io.github.grexjr.asciidungeon.model;

import io.github.grexjr.asciidungeon.constants.SpriteConstants;
import io.github.grexjr.asciidungeon.constants.UIConstants;

import static io.github.grexjr.asciidungeon.constants.UIConstants.*;

public class Player {
    private static final String DEFAULT_DECOR = BOLD + DELIMITER + CYANHFG;

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
        return ESC + decoration + SUFFIX + symbol + RESET;
    }

    public String getDecoration() {
        return decoration;
    }

    public void addDecoration(String ansiCode){
        if(this.decoration.isBlank()){
            this.decoration = ansiCode;
        } else {
            this.decoration += DELIMITER + ansiCode;
        }

    }

    public void resetDecoration(){
        decoration = DEFAULT_DECOR;
    }
}
