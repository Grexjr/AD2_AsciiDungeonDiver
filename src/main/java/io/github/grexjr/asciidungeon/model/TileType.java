package io.github.grexjr.asciidungeon.model;

import io.github.grexjr.asciidungeon.constants.SpriteConstants;

public enum TileType {

    WALL(SpriteConstants.WALL,false,"WALL"),
    FLOOR(SpriteConstants.FLOOR,true,"FLOOR");


    private final char symbol;
    private final boolean isPassable;
    private final String description;

    TileType(char symbol,boolean isPassable,String description){
        this.symbol = symbol;
        this.isPassable =isPassable;
        this.description = description;
    }

    public char getSymbol() {
        return symbol;
    }

    public boolean isPassable() {
        return isPassable;
    }

    public String getDescription() {
        return description;
    }
}
