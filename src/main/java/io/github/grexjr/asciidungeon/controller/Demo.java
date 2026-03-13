package io.github.grexjr.asciidungeon.controller;

import io.github.grexjr.asciidungeon.model.*;
import io.github.grexjr.asciidungeon.ui.Printer;
import io.github.grexjr.asciidungeon.view.Sprite;
import io.github.grexjr.asciidungeon.view.SpriteType;

import java.io.IOException;

import static io.github.grexjr.asciidungeon.constants.UIConstants.*;
import static io.github.grexjr.asciidungeon.model.BeingType.*;

public class Demo {

    private final InputHandler input = new InputHandler();
    private final Printer printer = new Printer();
    private final Map map;
    private final Player player;
    private final Being wanderer;

    private boolean running = true;

    public Demo() throws IOException {
        this.map = setupDemoWorld();
        this.player = new Player(map.getRows()/2,map.getCols()/2);
        this.wanderer = new Being(WANDERER,10,15);
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
        printer.clearScreen();
        printer.hideCursor();
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
        // Load all things into the buffer
        for(int r = 0; r < map.getRows(); r++){
            for(int c = 0; c < map.getCols(); c++){
                printer.drawAt(r,c,map.getTiles()[r][c].getSprite());
            }
        }
        printer.drawAt(player.getRow(),player.getCol(),player.getSprite());
        printer.drawAt(wanderer.getRow(), wanderer.getCol(), wanderer.getSprite());

        printer.render();
    }

    private void input() throws IOException{
        int key = input.getRawKeyPress();

        if(key == 'q' || key == 'Q') {
            end();
            running = false;
        }
        if(key == 'w' || key == 'W'){
            player.move(map,player.getRow()-1,player.getCol());
        } else if(key == 'd' || key == 'D'){
            player.move(map,player.getRow(),player.getCol()+1);
        } else if(key == 's' || key == 'S'){
            player.move(map,player.getRow()+1,player.getCol());
        } else if(key == 'a' || key == 'A'){
            player.move(map,player.getRow(),player.getCol()-1);
        } else if(key == 'p' || key == 'P'){
            player.getSprite().resetDecoration();
        }
    }

    private void logic(){
        wanderer.runAI(map);
    }

    public void end(){
        printer.clearBuffer();
        printer.clearScreen();
        printer.showCursor();
    }

    private Map setupDemoWorld(){
        Map map = new Map();
        for(int r = 0; r < map.getRows(); r++){
            for(int c = 0; c < map.getCols(); c++){
                if(r == 0 || r == map.getRows()-1) {
                    map.getTiles()[r][c] = new Tile(new Sprite(SpriteType.WALL), TileType.WALL);
                }
                else if(c == 0 || c == map.getCols()-1){
                    map.getTiles()[r][c] = new Tile(new Sprite(SpriteType.WALL), TileType.WALL);
                } else if(r == 10 && c == 5){
                    map.getTiles()[r][c] = new Tile(new Sprite(SpriteType.TEST),TileType.TEST);
                }
                else {
                    map.getTiles()[r][c] = new Tile(new Sprite(SpriteType.FLOOR), TileType.FLOOR);
                }
            }
        }
        return map;
    }

    private void setupCharacter(){

    }


}
