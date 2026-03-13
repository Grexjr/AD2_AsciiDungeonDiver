package io.github.grexjr.asciidungeon.model;

import io.github.grexjr.asciidungeon.model.ai.MovementBehavior;
import io.github.grexjr.asciidungeon.view.Sprite;

public class Being implements Renderable {
    private final Sprite sprite;
    private final MovementBehavior brain;

    private int row, col;
    private boolean isBlocking = true;

    public Being(BeingType type, int row, int col){
        sprite = new Sprite(type.getSpriteType());
        brain = MovementBehavior.get(type.getAI());

        this.row = row;
        this.col = col;
    }

    @Override
    public Sprite getSprite() { return sprite; }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public boolean isBlocking() { return isBlocking; }

    public void setBlocking(boolean blocking) { isBlocking = blocking; }

    public void setCol(int col) {
        this.col = col;
    }

    public void runAI(Map moveableArea){
        if(brain != null){
            brain.move(this, moveableArea);
        }
    }

    public void teleport(Map map, int nextR, int nextC){
        brain.attemptMove(this,map,nextR,nextC);
    }

}
