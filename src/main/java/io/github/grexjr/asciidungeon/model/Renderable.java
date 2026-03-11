package io.github.grexjr.asciidungeon.model;

import io.github.grexjr.asciidungeon.view.Sprite;

public interface Renderable {

    Sprite getSprite();

    /**
     * Adds a decoration to an object's sprite.
     * @param decoration The ANSI decorator to add
     */
    default void addDecoration(String decoration){
        getSprite().addDecoration(decoration);
    }

    /**
     * Resets decorations to their defaults.
     */
    default void resetDecoration(){
        getSprite().resetDecoration();
    }


}
