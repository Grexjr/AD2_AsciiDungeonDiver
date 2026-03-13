package io.github.grexjr.asciidungeon.model;

import io.github.grexjr.asciidungeon.model.ai.AIType;
import io.github.grexjr.asciidungeon.view.Sprite;
import io.github.grexjr.asciidungeon.view.SpriteType;

public enum BeingType {

    PLAYER(SpriteType.PLAYER,AIType.PLAYER),
    WANDERER(SpriteType.WANDERER,AIType.WANDER)






    ;


    private final SpriteType spriteType;
    private final AIType ai;

    BeingType(SpriteType spriteType, AIType ai){
        this.spriteType = spriteType;
        this.ai = ai;
    }

    public SpriteType getSpriteType() { return spriteType; }
    public AIType getAI() { return ai; }

}
