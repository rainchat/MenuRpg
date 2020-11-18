package main.menurpg.utility;

import net.md_5.bungee.api.ChatColor;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.awt.Color;
import java.util.List;

public class color {
    private static final Pattern HEX_PATTERN = Pattern.compile("<(#[a-fA-F0-9]{6})>");


    public static boolean serverSupportsHex() {
        try {
            ChatColor.of(Color.BLACK);
            return true;
        } catch (NoSuchMethodError ignore) {
            return false;
        }
    }

    public static String parseHexString(@NotNull String text, @NotNull Pattern hexPattern) {
        Matcher hexColorMatcher = hexPattern.matcher(text);

        if (serverSupportsHex()) {
            while (hexColorMatcher.find()) {
                String hex = hexColorMatcher.group(1);
                ChatColor color = ChatColor.of(hex);


                String before = text.substring(0, hexColorMatcher.start());
                String after = text.substring(hexColorMatcher.end());
                text = before + color + after;
                hexColorMatcher = hexPattern.matcher(text);

            }
        }

        return org.bukkit.ChatColor.translateAlternateColorCodes('&',text);
    }

    public static String parseHexString(@NotNull String text) {
        return parseHexString(text, color.HEX_PATTERN);
    }
}
