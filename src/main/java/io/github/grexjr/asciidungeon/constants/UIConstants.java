package io.github.grexjr.asciidungeon.constants;

/// Collects in one place useful and necessary ANSI codes for displaying
public class UIConstants {

    // Utility ANSI Codes
    public static final String ESC = "\u001b[";
    public static final String PREFIX = ESC;
    public static final String SUFFIX = "m";
    public static final String RESET = PREFIX + "0" + SUFFIX;
    public static final String DELIMITER = ";";

    private static final String HOME = "H";

    private static final String MOVE = "%d;%dH";
    private static final String UP = "%dA";
    private static final String DOWN = "%dB";
    private static final String RIGHT = "%dC";
    private static final String LEFT = "%dD";

    private static final String CLEAR = "2J";
    private static final String LINE = "2K";

    private static final String CURS_SHOW = "?25h";
    private static final String CURS_HIDE = "?25l";


    // Foreground Colors
    public static final String BLACKFG = "30";
    public static final String REDFG = "31";
    public static final String GREENFG = "32";
    public static final String YELLOWFG = "33";
    public static final String BLUEFG = "34";
    public static final String PURPLEFG = "35";
    public static final String CYANFG = "36";
    public static final String WHITEFG = "37";

    // High Intensity Foreground
    public static final String BLACKHFG = "90";
    public static final String REDHFG = "91";
    public static final String GREENHFG = "92";
    public static final String YELLOWHFG = "93";
    public static final String BLUEHFG = "94";
    public static final String PURPLEHFG = "95";
    public static final String CYANHFG = "96";
    public static final String WHITEHFG = "97";

    // Background colors
    public static final String BLACKBG = "40";
    public static final String REDBG = "41";
    public static final String GREENBG = "42";
    public static final String YELLOWBG = "43";
    public static final String BLUEBG = "44";
    public static final String PURPLEBG = "45";
    public static final String CYANBG = "46";
    public static final String WHITEBG = "47";

    // High Intensity Background
    public static final String BLACKHBG = "100";
    public static final String REDHBG = "101";
    public static final String GREENHBG = "102";
    public static final String YELLOWHBG = "103";
    public static final String BLUEHBG = "104";
    public static final String PURPLEHBG = "105";
    public static final String CYANHBG = "106";
    public static final String WHITEHBG = "107";

    // Styles
    public static final String BOLD = "1";
    public static final String DIM = "2";
    public static final String ITALIC = "3";
    public static final String UNDERLINE = "4";
    public static final String BLINK = "5";
    public static final String BLINKR = "6";
    public static final String INVERT = "7";
    public static final String STRIKETHROUGH = "9";





    /// Doesn't make sense to instantiate this class
    private UIConstants() {throw new AssertionError("Class UIConstants Cannot be instantiated!");}
}
