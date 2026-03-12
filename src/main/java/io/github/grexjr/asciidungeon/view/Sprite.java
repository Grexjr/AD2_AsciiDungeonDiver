package io.github.grexjr.asciidungeon.view;

import static io.github.grexjr.asciidungeon.constants.UIConstants.*;

public class Sprite {

    private final SpriteType type;
    private char symbol;
    private String decoration;


    /// Constructor that takes in the type to create the formatted symbol
    public Sprite(SpriteType type){
        this.type = type;
        this.symbol = type.getSymbol();
        this.decoration = SpriteLibrary.getDefaultDecoration(type);
    }

    public SpriteType getType() {
        return type;
    }

    public String getFormattedSymbol() {
        return ESC + decoration + SUFFIX + symbol;
    }

    public String getDecoration() { return decoration; }

    public char getSymbol() { return symbol; }

    public void addDecoration(String ansiCode){
        if(decoration.isBlank()){
            this.decoration = ansiCode;
        } else {
            this.decoration += DELIMITER + ansiCode;
        }
    }

    public void resetDecoration(){
        decoration = SpriteLibrary.getDefaultDecoration(type);
    }

}
