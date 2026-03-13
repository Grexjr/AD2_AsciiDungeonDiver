package io.github.grexjr.asciidungeon.model.ai;

import io.github.grexjr.asciidungeon.constants.CommonConstants;
import io.github.grexjr.asciidungeon.model.Being;
import io.github.grexjr.asciidungeon.model.Map;

public class WanderAI implements MovementBehavior{



    @Override
    public void move(Being self, Map map){
        switch(CommonConstants.RAND.nextInt(0,4)){
            case 0 -> {
                if(map.getTiles()[self.getRow()+1][self.getCol()].isPassable()) self.setRow(self.getRow()+1);
            }
            case 1 -> {
                if(map.getTiles()[self.getRow()-1][self.getCol()].isPassable()) self.setRow(self.getRow()-1);
            }
            case 2 -> {
                if(map.getTiles()[self.getRow()][self.getCol()+1].isPassable()) self.setCol(self.getCol()+1);
            }
            case 3 -> {
                if(map.getTiles()[self.getRow()][self.getCol()-1].isPassable()) self.setCol(self.getCol()-1);
            }
        }
    }


}
