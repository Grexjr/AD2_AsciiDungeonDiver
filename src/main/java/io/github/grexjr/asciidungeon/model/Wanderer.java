package io.github.grexjr.asciidungeon.model;

import io.github.grexjr.asciidungeon.view.Sprite;
import io.github.grexjr.asciidungeon.view.SpriteType;

import java.util.Random;

public class Wanderer implements Renderable{
    private final Sprite sprite = new Sprite(SpriteType.WANDERER);

    private int row,col;

    public Wanderer(int row, int col){
        this.row = row;
        this.col = col;
    }

    @Override
    public Sprite getSprite() { return this.sprite; }

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

    public void randomWander(Map wanderingSpace){
        switch(new Random().nextInt(1,5)){
            case 1 -> {
                if(wanderingSpace.getTiles()[row+1][col].isPassable()) row += 1;
            }
            case 2 -> {
                if(wanderingSpace.getTiles()[row-1][col].isPassable()) row -= 1;
            }
            case 3 -> {
                if(wanderingSpace.getTiles()[row][col+1].isPassable()) col += 1;
            }
            case 4 -> {
                if(wanderingSpace.getTiles()[row][col-1].isPassable()) col -= 1;
            }
        }
    }


}
