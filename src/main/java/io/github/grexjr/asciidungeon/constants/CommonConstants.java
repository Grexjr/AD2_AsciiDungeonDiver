package io.github.grexjr.asciidungeon.constants;

import java.util.Random;

public class CommonConstants {

    public static final Random RAND = new Random();

    public static final int MAP_WIDTH = 100;
    public static final int MAP_HEIGHT = 30;




    ///  Doesn't make sense to instantiate this class
    private CommonConstants(){throw new AssertionError("Class cannot be instantiated!");}



}
