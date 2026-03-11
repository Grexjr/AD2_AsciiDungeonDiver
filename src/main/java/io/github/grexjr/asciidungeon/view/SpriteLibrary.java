package io.github.grexjr.asciidungeon.view;

import java.util.HashMap;

import static io.github.grexjr.asciidungeon.constants.UIConstants.*;

public class SpriteLibrary {

    private static final HashMap<SpriteType,String> styles  = new HashMap<>();


    static {
        // Build all the default decor once at startup
        styles.put(SpriteType.PLAYER,build(BOLD,CYANHFG));

        styles.put(SpriteType.WALL,build());
        styles.put(SpriteType.FLOOR,build());

        styles.put(SpriteType.TEST,build(PURPLEFG,BLACKBG));
    }

    /**
     * Method to join together ANSI codes into a single decoration string
     * @param codes
     * @return
     */
    private static String build(String... codes){
        // Join together with delimiter
        return String.join(DELIMITER,codes);
    }

    /**
     * Get the formatted and decorated character that represents a sprite from the sprite library.
     * @param type The sprite type to retrieve.
     * @return The full ANSI string that builds this character and its formatting
     */
    public static String getDefaultDecoration(SpriteType type){
        return styles.getOrDefault(type,"");
    }



}
