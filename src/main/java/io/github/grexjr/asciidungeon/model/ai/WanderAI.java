package io.github.grexjr.asciidungeon.model.ai;

import io.github.grexjr.asciidungeon.constants.CommonConstants;
import io.github.grexjr.asciidungeon.model.Being;
import io.github.grexjr.asciidungeon.model.Map;

import static io.github.grexjr.asciidungeon.constants.CommonConstants.RAND;

public class WanderAI implements MovementBehavior{

    @Override
    public void move(Being self, Map map){
        int dr = 0, dc = 0;

        // Row versus column movement; true is row, false is column
        if(RAND.nextBoolean()){
            // Math.random() gets between 0.0 and 1.0, * 3 = 0.0-2.999, -1 = -1.0-1.999, truncate to int =
            // [-1,0,1] as possibilities
            dr = (int)(Math.random()*3)-1;
        } else {
            dc = (int)(Math.random()*3)-1;
        }

        // Attempt the movement if it can
        attemptMove(self,map,self.getRow()+dr,self.getCol()+dc);
    }


}
