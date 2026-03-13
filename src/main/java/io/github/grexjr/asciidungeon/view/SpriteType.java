package io.github.grexjr.asciidungeon.view;

public enum SpriteType {

    // Beings
    PLAYER('@'),
    WANDERER('w'),

    // Tiles
    WALL('#'),
    FLOOR(' '),

    // Util
    TEST('\u259E')






    ;


    private char symbol;

    SpriteType(char symbol){
        this.symbol = symbol;
    }

    public char getSymbol() { return symbol; }



}
