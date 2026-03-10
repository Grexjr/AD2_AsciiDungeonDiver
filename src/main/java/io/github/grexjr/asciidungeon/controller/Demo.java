package io.github.grexjr.asciidungeon.controller;

import io.github.grexjr.asciidungeon.constants.UIConstants;
import io.github.grexjr.asciidungeon.model.Map;
import io.github.grexjr.asciidungeon.model.Player;
import io.github.grexjr.asciidungeon.model.Tile;
import io.github.grexjr.asciidungeon.model.TileType;
import io.github.grexjr.asciidungeon.ui.Printer;

import java.io.IOException;

public class Demo {

    private final InputHandler input = new InputHandler();
    private final Printer printer = new Printer();
    private final Map map;
    private final Player player;

    private boolean running = true;

    public Demo() throws IOException {
        this.map = new Map();
        this.player = new Player(map.getRows()/2,map.getCols()/2);
    }

    // Handle crash, do nothing in shutdown loop to prevent anything crazy
    public void registerShutdown(){
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                if(input != null){
                    input.close();
                }
            } catch (Exception e){
                System.err.println("BAD TERMINAL SHUTDOWN: Closing...");
            }
        }));
    }

    public void start(){
        printer.hideCursor();
        setupDemoWorld();
        setupCharacter();
    }

    public void run(){
        while(running){
            try {
                draw();
                input();
                logic();
            } catch (IOException e) {
                System.err.println("FATAL ERROR: Demo line 39");
            }
        }
    }

    private void draw(){
        for(int i = 0; i < map.getRows(); i++){
            for(int j = 0; j < map.getCols(); j++){
                printer.drawAt(
                        i,
                        j,
                        map.getTiles()[i][j].getFormattedSymbol()
                );
            }
        }
        printer.clearBuffer();
        printer.drawAt(player.getRow(),player.getCol(),player.getFormattedSymbol());
    }

    private void input() throws IOException{
        int key = input.getRawKeyPress();

        if(key == 'q' || key == 'Q') {
            end();
            running = false;
        }
        if(key == 'w' || key == 'W'){
            int newRow = player.getRow() - 1;
            if(map.getTiles()[newRow][player.getCol()].isPassable())
                player.setRow(newRow);
        } else if(key == 'd' || key == 'D'){
            int newCol = player.getCol() + 1;
            if(map.getTiles()[player.getRow()][newCol].isPassable())
                player.setCol(newCol);
        } else if(key == 's' || key == 'S'){
            int newRow = player.getRow() + 1;
            if(map.getTiles()[newRow][player.getCol()].isPassable())
                player.setRow(newRow);
        } else if(key == 'a' || key == 'A'){
            int newCol = player.getCol() - 1;
            if(map.getTiles()[player.getRow()][newCol].isPassable())
                player.setCol(newCol);
            for(int i = 0; i < map.getRows(); i++){
                for(int j = 0; j < map.getCols(); j++){
                    map.getTiles()[i][j].addDecoration(UIConstants.DIM);
                }
            }
        }
    }

    private void logic(){

    }

    public void end(){
        printer.clearBuffer();
        printer.clearScreen();
        printer.showCursor();
    }

    private void setupDemoWorld(){
        printer.clearScreen();
        printer.moveToHome();
        for(int row = 0; row < map.getRows(); row++){
            for(int col = 0; col < map.getCols(); col++){
                // Draw walls
                if(row == 0 || row == map.getRows()-1 || col == 0 || col == map.getCols()-1) {
                    map.getTiles()[row][col] = new Tile(TileType.WALL);
                }
                else{
                    map.getTiles()[row][col] = new Tile(TileType.FLOOR);
                }
            }
        }
    }

    private void setupCharacter(){

    }


}
