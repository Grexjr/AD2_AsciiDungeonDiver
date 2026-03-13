package io.github.grexjr.asciidungeon.model.ai;

import io.github.grexjr.asciidungeon.model.Being;
import io.github.grexjr.asciidungeon.model.Map;

public class PlayerBehavior implements MovementBehavior {

    /// Does nothing -- but only exposed to player class, so fine
    public void move(Being self, Map map){
        return;
    }

}
