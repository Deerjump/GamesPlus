package io.github.deerjump.gamesplus.games.cards;

import org.bukkit.DyeColor;
import org.bukkit.block.banner.Pattern;
import java.util.ArrayList;
import java.util.List;

import static org.bukkit.DyeColor.WHITE;
import static org.bukkit.block.banner.PatternType.*;

public class BannerLetters {

    public static List<Pattern> ONE(DyeColor color) {
        List<Pattern> patterns = new ArrayList<>();
        patterns.add(new Pattern(WHITE, BASE));
        patterns.add(new Pattern(color, STRIPE_CENTER));
        patterns.add(new Pattern(color, SQUARE_TOP_LEFT));
        patterns.add(new Pattern(WHITE, CURLY_BORDER));
        patterns.add(new Pattern(color, STRIPE_BOTTOM));
        patterns.add(new Pattern(WHITE, BORDER));
        return patterns;
    }

    public static List<Pattern> TWO(DyeColor color) {
        List<Pattern> patterns = new ArrayList<>();
        patterns.add(new Pattern(WHITE, BASE));
        patterns.add(new Pattern(color, STRIPE_TOP));
        patterns.add(new Pattern(WHITE, RHOMBUS_MIDDLE));
        patterns.add(new Pattern(color, STRIPE_BOTTOM));
        patterns.add(new Pattern(color, STRIPE_DOWNLEFT));
        patterns.add(new Pattern(WHITE, BORDER));
        return patterns;
    }

    public static List<Pattern> THREE(DyeColor color) {
        List<Pattern> patterns = new ArrayList<>();
        patterns.add(new Pattern(WHITE, BASE));
        patterns.add(new Pattern(color, STRIPE_BOTTOM));
        patterns.add(new Pattern(color, STRIPE_MIDDLE));
        patterns.add(new Pattern(color, STRIPE_TOP));
        patterns.add(new Pattern(WHITE, CURLY_BORDER));
        patterns.add(new Pattern(color, STRIPE_RIGHT));
        patterns.add(new Pattern(WHITE, BORDER));
        return patterns;
    }

    public static List<Pattern> FOUR(DyeColor color) {
        List<Pattern> patterns = new ArrayList<>();
        patterns.add(new Pattern(WHITE, BASE));
        patterns.add(new Pattern(color, STRIPE_LEFT));
        patterns.add(new Pattern(WHITE, HALF_HORIZONTAL_MIRROR));
        patterns.add(new Pattern(color, STRIPE_RIGHT));
        patterns.add(new Pattern(color, STRIPE_MIDDLE));
        patterns.add(new Pattern(WHITE, BORDER));
        return patterns;
    }

    public static List<Pattern> FIVE(DyeColor color) {
        List<Pattern> patterns = new ArrayList<>();
        patterns.add(new Pattern(WHITE, BASE));
        patterns.add(new Pattern(color, STRIPE_BOTTOM));
        patterns.add(new Pattern(WHITE, RHOMBUS_MIDDLE));
        patterns.add(new Pattern(color, STRIPE_TOP));
        patterns.add(new Pattern(color, STRIPE_DOWNRIGHT));
        patterns.add(new Pattern(WHITE, BORDER));
        return patterns;
    }

    public static List<Pattern> SIX(DyeColor color) {
        List<Pattern> patterns = new ArrayList<>();
        patterns.add(new Pattern(WHITE, BASE));
        patterns.add(new Pattern(color, STRIPE_BOTTOM));
        patterns.add(new Pattern(color, STRIPE_RIGHT));
        patterns.add(new Pattern(WHITE, HALF_HORIZONTAL));
        patterns.add(new Pattern(color, STRIPE_MIDDLE));
        patterns.add(new Pattern(color, STRIPE_TOP));
        patterns.add(new Pattern(color, STRIPE_LEFT));
        patterns.add(new Pattern(WHITE, BORDER));
        return patterns;
    }

    public static List<Pattern> SEVEN(DyeColor color) {
        List<Pattern> patterns = new ArrayList<>();
        patterns.add(new Pattern(WHITE, BASE));
        patterns.add(new Pattern(color, STRIPE_DOWNLEFT));
        patterns.add(new Pattern(color, STRIPE_TOP));
        patterns.add(new Pattern(WHITE, BORDER));
        return patterns;
    }

    public static List<Pattern> EIGHT(DyeColor color) {
        List<Pattern> patterns = new ArrayList<>();
        patterns.add(new Pattern(WHITE, BASE));
        patterns.add(new Pattern(color, STRIPE_TOP));
        patterns.add(new Pattern(color, STRIPE_LEFT));
        patterns.add(new Pattern(color, STRIPE_MIDDLE));
        patterns.add(new Pattern(color, STRIPE_BOTTOM));
        patterns.add(new Pattern(color, STRIPE_RIGHT));
        patterns.add(new Pattern(WHITE, BORDER));
        return patterns;
    }

    public static List<Pattern> NINE(DyeColor color) {
        List<Pattern> patterns = new ArrayList<>();
        patterns.add(new Pattern(WHITE, BASE));
        patterns.add(new Pattern(color, STRIPE_LEFT));
        patterns.add(new Pattern(WHITE, HALF_HORIZONTAL_MIRROR));
        patterns.add(new Pattern(color, STRIPE_TOP));
        patterns.add(new Pattern(color, STRIPE_RIGHT));
        patterns.add(new Pattern(color, STRIPE_MIDDLE));
        patterns.add(new Pattern(WHITE, BORDER));
        return patterns;
    }

    // actually a ZERO
    public static List<Pattern> ZERO(DyeColor color) {
        List<Pattern> patterns = new ArrayList<>();
        patterns.add(new Pattern(WHITE, BASE));
        patterns.add(new Pattern(color, STRIPE_BOTTOM));
        patterns.add(new Pattern(color, STRIPE_LEFT));
        patterns.add(new Pattern(color, STRIPE_TOP));
        patterns.add(new Pattern(color, STRIPE_RIGHT));
        patterns.add(new Pattern(color, STRIPE_DOWNLEFT));
        patterns.add(new Pattern(WHITE, BORDER));
        return patterns;
    }

    public static List<Pattern> JACK(DyeColor color) {
        List<Pattern> patterns = new ArrayList<>();
        patterns.add(new Pattern(WHITE, BASE));
        patterns.add(new Pattern(color, STRIPE_LEFT));
        patterns.add(new Pattern(WHITE, HALF_HORIZONTAL));
        patterns.add(new Pattern(color, STRIPE_BOTTOM));
        patterns.add(new Pattern(color, STRIPE_RIGHT));
        patterns.add(new Pattern(WHITE, BORDER));
        return patterns;
    }

    public static List<Pattern> QUEEN(DyeColor color) {
        List<Pattern> patterns = new ArrayList<>();
        patterns.add(new Pattern(color, BASE));
        patterns.add(new Pattern(WHITE, RHOMBUS_MIDDLE));
        patterns.add(new Pattern(color, STRIPE_RIGHT));
        patterns.add(new Pattern(color, STRIPE_LEFT));
        patterns.add(new Pattern(color, SQUARE_BOTTOM_RIGHT));
        patterns.add(new Pattern(WHITE, BORDER));
        return patterns;
    }

    public static List<Pattern> KING(DyeColor color) {
        List<Pattern> patterns = new ArrayList<>();
        patterns.add(new Pattern(WHITE, BASE));
        patterns.add(new Pattern(color, STRIPE_DOWNRIGHT));
        patterns.add(new Pattern(WHITE, HALF_HORIZONTAL));
        patterns.add(new Pattern(color, STRIPE_DOWNLEFT));
        patterns.add(new Pattern(color, STRIPE_LEFT));
        patterns.add(new Pattern(WHITE, BORDER));
        return patterns;
    }
}

