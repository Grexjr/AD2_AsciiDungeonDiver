package io.github.grexjr.asciidungeon;

import io.github.grexjr.asciidungeon.controller.Demo;

public class Driver {

    public static void main(String[] args){
        try {
            Demo demo = new Demo();

            demo.registerShutdown();

            demo.start();
            demo.run();
        } catch (Exception e){
            System.err.println("FATAL ERROR ON STARTUP: " + e.getMessage());
            e.printStackTrace();
        }
    }



}
