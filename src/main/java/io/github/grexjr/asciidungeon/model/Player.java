package io.github.grexjr.asciidungeon.model;

import io.github.grexjr.asciidungeon.model.ai.MovementBehavior;

import static io.github.grexjr.asciidungeon.model.BeingType.PLAYER;

public class Player extends Being {

    public Player(int row, int col){
        super(PLAYER,row,col);
    }

    public void move(Map map, int nextR, int nextC){
        MovementBehavior.attemptNoBrainMove(this,map,nextR,nextC);
    }

}
