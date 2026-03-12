package io.github.grexjr.asciidungeon.model;

import io.github.grexjr.asciidungeon.view.Sprite;

public interface Renderable {

    Sprite getSprite();

    default char getSymbol() { return getSprite().getSymbol(); }

    default String getFullDecoration() { return getSprite().getFullDecoration(); }

    default void addDecoration(String attribute) { getSprite().addDecoration(attribute); }

    default void clearDecoration() { getSprite().clearDecoration(); }

    default void resetDecoration() { getSprite().resetDecoration(); }

}
