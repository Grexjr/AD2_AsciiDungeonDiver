package io.github.grexjr.asciidungeon.model;

import io.github.grexjr.asciidungeon.constants.CommonConstants;
import io.github.grexjr.asciidungeon.view.Sprite;

import static io.github.grexjr.asciidungeon.constants.UIConstants.*;
import static io.github.grexjr.asciidungeon.constants.UIConstants.RESET;

public class Tile implements Renderable{
    private final Sprite sprite;
    private final TileType type;

    private Being occupant = null;
    private boolean isExplored = false;

    ///  Pass in the type, and all information is received from the type enum.
    public Tile(Sprite sprite, TileType type) {
        this.sprite = sprite;
        this.type = type;
    }

    @Override
    public Sprite getSprite() { return sprite; }

    public TileType getType() { return type; }

    public Being getOccupant() { return occupant; }

    public boolean isPassable() { return type.isPassable(); }

    public String getDescription() { return type.getDescription(); }

    public boolean isExplored() { return isExplored; }

    public void setOccupant(Being occupier) { occupant = occupier; }

    public void setExplored(boolean explored) { isExplored = explored; }

}
