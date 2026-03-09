package io.github.grexjr.asciidungeon.model;

import io.github.grexjr.asciidungeon.constants.CommonConstants;

public class Map {

    private int rows, cols;
    private Tile[][] tiles;

    ///  Default constructor
    public Map(){
        this.rows = CommonConstants.MAP_HEIGHT;
        this.cols = CommonConstants.MAP_WIDTH;
        this.tiles = new Tile[this.rows][this.cols];
    }

    /// Custom height and width if needed
    public Map(int height, int width){
        this.rows = height;
        this.cols = width;
    }

    /**
     * @return The map object which places tiles by [row][column]
     */
    public Tile[][] getTiles(){return tiles;}

    public int getRows(){return rows;}
    public int getCols(){return cols;}




}
