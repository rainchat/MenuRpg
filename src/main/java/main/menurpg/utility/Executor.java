package main.menurpg.utility;

import main.menurpg.events.actionbar;
import main.menurpg.fontmenu.FontMenu;
import main.menurpg.main;
import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.block.data.type.Switch;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import java.util.List;

public class Executor {
    private FontMenu FM = new FontMenu();
    private actionbar Abar = new actionbar();
    private List<String> cmd;
    private Player p;

    public Executor(List<String> command, Player p) {
        this.cmd = command;
        this.p = p;
        start();
    }

    public void start(){

        for (String s : cmd){
            s = color.parseHexString(s);
            s = PlaceholderAPI.setPlaceholders(p, s);
            String[] result = s.split(" ", 2);
            action(result[0],result[1]);

        }
    }

    public void action(String s, String action){
        switch (s){
            case "tell:":
                p.sendMessage(action);
                break;
            case "console:":
                main.getPlugin(main.class).getServer().dispatchCommand(main.getPlugin(main.class).getServer().getConsoleSender(), action);;
                break;
            case "player:":
                p.performCommand(action);
                break;
            case "closemenu:":
                FM.removePlayer(p);
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(""));
                break;
            case "openmenu:":
                FM.addPlayer(p,action);
                Abar.start();
        }
    }
}
