package main.menurpg.utility;

import main.menurpg.menagers.ActionbarManager;
import main.menurpg.MenuRPGPlugin;
import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Executor {
    private final List<String> cmd;
    private final Player p;

    public Executor(List<String> command, Player p) {
        this.cmd = command;
        this.p = p;
        start();
    }

    private static final Pattern ACTION_PATTERN = Pattern.compile("(?iu)(tell|console|player|closemenu|openmenu)([:])(.*)");

    public void start() {
        boolean papi = Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI");

        for (String s : cmd) {
            s = Color.parseHexString(s);
            if (papi) {
                s = PlaceholderAPI.setPlaceholders(p, s);
            }
            Matcher result = ACTION_PATTERN.matcher(s);
            result.find();
            action(result.group(1), result.group(3));
        }
    }

    public void action(String s, String action) {
        switch (s.toLowerCase()) {
            case "tell":
                p.sendMessage(action);
                break;
            case "console":
                MenuRPGPlugin.INSTANCE.getServer().dispatchCommand(MenuRPGPlugin.INSTANCE.getServer().getConsoleSender(), action);
                break;
            case "player":
                p.performCommand(action);
                break;
            case "closemenu":
                ActionbarManager.removePlayer(p);
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(""));
                break;
            case "openmenu":
                ActionbarManager.addPlayer(p, action);
        }
    }
}
