package io.github.grexjr.asciidungeon.model.ai;

import io.github.grexjr.asciidungeon.model.Being;
import io.github.grexjr.asciidungeon.model.Map;
import io.github.grexjr.asciidungeon.model.Tile;

public interface MovementBehavior {
    /**
     * The 'thinking' method of a being's movement.
     * @param self The being that is moving.
     * @param map The range in which the being can move.
     */
    void move(Being self, Map map);

    /**
     * The executing method of the move.
     * @param self The moving being.
     * @param map The moveable area.
     * @param nextRow The row of the tile to move to.
     * @param nextCol The column of the tile to move to.
     */
    default void attemptMove(Being self, Map map, int nextRow, int nextCol){
        Tile target = map.getTile(nextRow,nextCol);

        if(checkValidMove(target)){
            // Leave old tile
            map.getTile(self.getRow(),self.getCol()).setOccupant(null);

            // Update being
            self.setRow(nextRow);
            self.setCol(nextCol);

            // Move to new tile
            target.setOccupant(self);
        }
    }

    /**
     * The validation for moving to a tile. Checks if the tile is passable and if it is free OR if the occupant is not
     * blocking the way.
     * @param moveTo The tile to move to.
     * @return True if valid move, false if invalid move.
     */
    default boolean checkValidMove(Tile moveTo){
        // TODO null check safety
        return (moveTo.isPassable() && (moveTo.getOccupant() == null || !moveTo.getOccupant().isBlocking()));
    }

    static MovementBehavior get(AIType type){
        return switch(type){
            case WANDER -> new WanderAI();
            default -> null;
        };
    }
}
