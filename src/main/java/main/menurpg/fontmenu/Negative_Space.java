package main.menurpg.fontmenu;

import main.menurpg.filemenager.FileManager;

import java.util.Objects;

public class Negative_Space {

    private static final FileManager fileManager = FileManager.getInstance();

    /*
\uF801 to \uF808: -1 to -8 pixels
\uF809 to \uF80F: -16, -32, -64, -128, -256, -512 and -1024 pixels

\uF821 to \uF828: 1 to 8 pixels
\uF829 to \uF82F: 16, 32, 64, 128, 256, 512 and 1024 pixels

\uF800 and \uF820: -max and max, maximally negative and positive
     */

    static public String getSpace(int light) {
        if (light == 0) {
            return null;
        }
        char x = '1';
        StringBuilder space = new StringBuilder();


        while (light != 0) {
            if (light >= 1024) {
                light -= 1024;
                x = '\uF80F';
                space.append(x);
            } else if (light >= 256) {
                light -= 256;
                x = '\uF80D';
                space.append(x);
            } else if (light >= 64) {
                light -= 64;
                x = '\uF80B';
                space.append(x);
            } else if (light >= 16) {
                light -= 16;
                x = '\uF809';
                space.append(x);
            } else if (light >= 4) {
                light -= 4;
                x = '\uF804';
                space.append(x);
            } else if (light >= 1) {
                light -= 1;
                x = '\uF801';
                space.append(x);
            } else if (light <= -256) {
                light += 256;
                x = '\uF82D';
                space.append(x);
            } else if (light <= -64) {
                light += 64;
                x = '\uF82B';
                space.append(x);
            } else if (light <= -16) {
                light += 16;
                x = '\uF829';
                space.append(x);
            } else if (light <= -4) {
                light += 4;
                x = '\uF824';
                space.append(x);
            } else if (light < -1) {
                light += 1;
                x = '\uF821';
                space.append(x);
            }


        }

        return space.toString();
    }

    static public String getStartSpace() {
        String text = "";
        if (FileManager.Files.CONFIG.getFile().getString("settings.charlength").isEmpty()) {
            char y;
            y = '\uf82E';
            text = text + y;
            y = '\uf82C';
            text = y + "";
            text = text + y;
            return text;
        }
        return getSpace(Integer.parseInt(FileManager.Files.CONFIG.getFile().getString("settings.menupos")));
    }

    static public String getMenuLength(int x) {
        if (FileManager.Files.CONFIG.getFile().getString("settings.charlength").isEmpty()) {
            return getSpace(120 - x);
        }
        return getSpace(Integer.parseInt(FileManager.Files.CONFIG.getFile().getString("settings.menulength")) +
                Integer.parseInt(FileManager.Files.CONFIG.getFile().getString("settings.charlength")) * x);
    }

    static public String getCharLength(int x) {
        if (FileManager.Files.CONFIG.getFile().getString("settings.charlength").isEmpty()) {
            return getSpace(9 * x);
        }
        return getSpace(Integer.parseInt(Objects.requireNonNull(FileManager.Files.CONFIG.getFile().getString("settings.charlength"))) * x);
    }
}
