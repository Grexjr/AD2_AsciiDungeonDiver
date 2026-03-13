package io.github.grexjr.asciidungeon.model;

public enum TileType {

    WALL(false,"WALL"),
    FLOOR(true,"FLOOR"),

    TEST(false,"TEST")







    ;

    private final boolean isPassable;
    private final String description;

    TileType(boolean isPassable,String description){
        this.isPassable =isPassable;
        this.description = description;
    }

    public boolean isPassable() {
        return isPassable;
    }

    public String getDescription() {
        return description;
    }
}
