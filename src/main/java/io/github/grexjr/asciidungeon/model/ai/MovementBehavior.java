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

        if(checkValidMove(self,target)){
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
     * blocking the way. Also checks if the occupant is self to prevent self blocking.
     * @param moveTo The tile to move to.
     * @return True if valid move, false if invalid move.
     */
    default boolean checkValidMove(Being self, Tile moveTo){
        if(moveTo == null) return false; // Null safety; cannot move into null tiles
        if(!moveTo.isPassable()) return false; // If not passable, cannot move

        Being occupant = moveTo.getOccupant();

        // Valid if no occupant, occupant is self, or occupant is not blocking
        return (moveTo.getOccupant() == null || occupant == self || !moveTo.getOccupant().isBlocking());
    }

    /**
     * Static helper method to run the logic when no brain is present, like for player movement.
     * @param self The being to move without a brain.
     * @param map The moveable area.
     * @param nextR The row to move to.
     * @param nextC The column to move to.
     */
    static void attemptNoBrainMove(Being self, Map map, int nextR, int nextC){
        // Dummy instance using lambda
        ((MovementBehavior) (s, m) -> {
        }).attemptMove(self,map,nextR,nextC);
    }

    /**
     * Gets the movement behavior based on the type.
     * @param type Type to retrieve behavior from.
     * @return The behavior.
     */
    static MovementBehavior get(AIType type){
        return switch(type){
            case WANDER -> new WanderAI();
            default -> null;
        };
    }
}
