package main.menurpg.menagers;

import main.menurpg.MenuRPGPlugin;
import main.menurpg.menagers.FileManager;
import main.menurpg.menagers.PlayerData;
import main.menurpg.fontmenu.FontMenu;
import main.menurpg.utility.Executor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.*;

public class ActionbarManager {
    static private int tusk;
    static private HashMap<Player, PlayerData> PlayerDate = new HashMap<>();
    private static final FileManager fileManager = FileManager.getInstance();

    static public void open() {
        if (tusk != -1) {
            Bukkit.getScheduler().cancelTask(tusk);
        }

        tusk = Bukkit.getScheduler().scheduleAsyncRepeatingTask(MenuRPGPlugin.INSTANCE, () -> {
            for (Map.Entry<Player, PlayerData> s : PlayerDate.entrySet()) {
                int start = PlayerDate.get(s.getKey()).getStartLine();
                int end = PlayerDate.get(s.getKey()).getEndline();
                String menu = PlayerDate.get(s.getKey()).getMenu();
                int cursor = PlayerDate.get(s.getKey()).getCursor();
                Bukkit.getPlayer(s.getKey().getName()).spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(FontMenu.getText(start, end, menu, cursor)));
            }
        }, 0, 40);
    }

    static public void close() {
        Bukkit.getScheduler().cancelTask(tusk);
    }

    static public void changePos(int operator, Player player) {
        PlayerDate.get(player).setCursor(operator);
    }

    static public void update(Player player) {
        int start = PlayerDate.get(player).getStartLine();
        int end = PlayerDate.get(player).getEndline();
        String menu = PlayerDate.get(player).getMenu();
        int cursor = PlayerDate.get(player).getCursor();


        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(FontMenu.getText(start, end, menu, cursor)));


    }

    static public void addPlayer(Player player, String menu) {

        FileConfiguration file = fileManager.getFile(menu).getFile();
        List<String> list = new ArrayList<String>(file.getConfigurationSection("scrolls").getKeys(false));
        int number = file.getInt("settings.menu-lines");
        PlayerDate.put(player, new PlayerData(number, menu, list.size()));

        if (PlayerDate.size() == 1) {
            open();
        } else {
            update(player);
        }
    }

    static public boolean containsPlayer(Player player) {
        return PlayerDate.containsKey(player);
    }

    public static void removePlayer(Player p) {
        PlayerDate.remove(p);
    }

    static public void runcommand(Player player) {
        int x = PlayerDate.get(player).getLine();
        int z = 0;
        FileConfiguration file = fileManager.getFile(PlayerDate.get(player).getMenu()).getFile();
        for (String s : file.getConfigurationSection("scrolls").getKeys(false)) {
            z++;
            if (z == x) {
                List<String> command = new ArrayList<>();
                command = file.getStringList("scrolls." + s + ".actions");

                Executor commands = new Executor(command, player);
                return;
            }

        }
    }
}
