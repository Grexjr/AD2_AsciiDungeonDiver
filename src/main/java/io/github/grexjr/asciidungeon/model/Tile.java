package io.github.grexjr.asciidungeon.model;

import io.github.grexjr.asciidungeon.constants.CommonConstants;
import io.github.grexjr.asciidungeon.view.Sprite;

import static io.github.grexjr.asciidungeon.constants.UIConstants.*;
import static io.github.grexjr.asciidungeon.constants.UIConstants.RESET;

public class Tile {
    private final Sprite sprite;
    private final TileType type;

    private boolean isExplored = false;

    ///  Pass in the type, and all information is received from the type enum.
    public Tile(Sprite sprite, TileType type) {
        this.sprite = sprite;
        this.type = type;
    }

    public TileType getType() { return type; }

    public Sprite getSprite() { return sprite; }

    public boolean isPassable() {
        return type.isPassable();
    }

    public String getDescription() {
        return type.getDescription();
    }

    public boolean isExplored() {
        return isExplored;
    }

    public void setExplored(boolean explored) {
        isExplored = explored;
    }

    public void addDecoration(String ansiCode){
        sprite.addDecoration(ansiCode);
    }

    public void resetDecoration() { sprite.resetDecoration();}
}
