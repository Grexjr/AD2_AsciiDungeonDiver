package io.github.grexjr.asciidungeon.model;

import io.github.grexjr.asciidungeon.constants.CommonConstants;

import static io.github.grexjr.asciidungeon.constants.UIConstants.*;
import static io.github.grexjr.asciidungeon.constants.UIConstants.RESET;

public class Tile {
    private static final String RESET = "\033[0m";

    private final TileType type;

    private String decorations = ""; // Default format
    private boolean isExplored = false;

    ///  Pass in the type, and all information is received from the type enum.
    public Tile(TileType type){
        this.type = type;
    }

    public String getFormattedSymbol() {
        return ESC + decorations + SUFFIX + type.getSymbol() + RESET;
    }

    public boolean isPassable() {
        return type.isPassable();
    }

    public String getDescription() {
        return type.getDescription();
    }

    public boolean isExplored() {
        return isExplored;
    }

    public String getDecorations(){return this.decorations;}

    public void setExplored(boolean explored) {
        isExplored = explored;
    }

    public void addDecoration(String ansiCode){
        if(this.decorations.isBlank()){
            this.decorations = ansiCode;
        } else {
            this.decorations += DELIMITER + ansiCode;
        }

    }

    public void clearDecorations() { decorations = "";}
}
