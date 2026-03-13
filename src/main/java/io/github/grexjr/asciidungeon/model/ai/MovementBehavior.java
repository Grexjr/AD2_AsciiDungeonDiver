package io.github.grexjr.asciidungeon.model.ai;

import io.github.grexjr.asciidungeon.model.Being;
import io.github.grexjr.asciidungeon.model.Map;

public interface MovementBehavior {
    void move(Being self, Map map);

    static MovementBehavior get(AIType type){
        return switch(type){
            case WANDER -> new WanderAI();
            default -> null;
        };
    }
}
