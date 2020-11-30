package main.menurpg.fontmenu;

import main.menurpg.menagers.FileManager;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;

public class FontMenu {
    private static final FileManager fileManager = FileManager.getInstance();


    static public BaseComponent getText(int startline, int endliene, String menu, int cursor) {
        int z = 0;
        BaseComponent textcopy = new TextComponent("");

        FileConfiguration file = fileManager.getFile(menu).getFile();
        List<String> list = new ArrayList<String>();
        for (String s : file.getConfigurationSection("scrolls").getKeys(false)) {
            z++;
            if (z >= startline && z <= endliene) {
                list.add(file.getString("scrolls." + s + ".name"));
                if (z == endliene) {
                    break;
                }
            }
        }
        textcopy.addExtra(Negative_Space.getStartSpace());

        for (int i = 0; i < endliene - startline + 1; i++) {
            BaseComponent text = new TextComponent();
            char y;
            if (cursor == i + 1) {
                y = '\uE902';
            } else {
                y = '\uE901';
            }
            text.addExtra(y + "");
            text.setFont("menu:level" + (i + 1));
            textcopy.addExtra(text);
            textcopy.addExtra(Negative_Space.getMenuLength(-1));
            text = new TextComponent("");
            text.addExtra(list.get(i));
            text.setFont("menu:level" + (i + 1));
            textcopy.addExtra(text);
            if (!list.get(i).isEmpty()) {
                textcopy.addExtra(Negative_Space.getCharLength(list.get(i).length() + 1));
            }
        }
        return textcopy;
    }
}

