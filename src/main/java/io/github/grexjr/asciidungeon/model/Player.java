package io.github.grexjr.asciidungeon.model;

import io.github.grexjr.asciidungeon.constants.SpriteConstants;
import io.github.grexjr.asciidungeon.constants.UIConstants;
import io.github.grexjr.asciidungeon.view.Sprite;
import io.github.grexjr.asciidungeon.view.SpriteType;

import static io.github.grexjr.asciidungeon.constants.UIConstants.*;

public class Player {
    private final Sprite sprite = new Sprite(SpriteType.PLAYER);

    private int row,col;

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

    public Sprite getSprite() { return this.sprite; }

    public void addDecoration(String ansiCode){
        sprite.addDecoration(ansiCode);
    }

    public void resetDecoration(){
        sprite.resetDecoration();
    }
}
