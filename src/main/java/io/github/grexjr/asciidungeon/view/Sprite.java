package io.github.grexjr.asciidungeon.view;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import static io.github.grexjr.asciidungeon.constants.UIConstants.*;

public class Sprite {

    private final SpriteType type;
    private char symbol;
    private final Set<String> decorations = new LinkedHashSet<>();


    /// Constructor that takes in the type to create the formatted symbol
    public Sprite(SpriteType type){
        this.type = type;
        this.symbol = type.getSymbol();
        addDecoration(SpriteLibrary.getDefaultDecoration(type));
    }

    public SpriteType getType() {
        return type;
    }

    public char getSymbol() { return symbol; }

    public void addDecoration(String attributeToAdd){
        if(attributeToAdd == null) return;
        // Makes sure that if it is multiple attributes together, they are split up and added as normal
        Collections.addAll(decorations, attributeToAdd.split(";"));
    }

    public String getFullDecoration(){
        return String.join(DELIMITER, decorations);
    }

    public void resetDecoration(){
        clearDecoration();
        decorations.add(SpriteLibrary.getDefaultDecoration(type));
    }

    public void clearDecoration(){
        decorations.clear();
    }

}
